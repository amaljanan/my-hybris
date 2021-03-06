/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.odata2webservicesfeaturetests;

import static de.hybris.platform.integrationservices.util.JsonBuilder.json;
import static de.hybris.platform.odata2services.odata.content.ODataBatchBuilder.BATCH_BOUNDARY;
import static de.hybris.platform.odata2services.odata.content.ODataBatchBuilder.batchBuilder;
import static de.hybris.platform.odata2services.odata.content.ODataChangeSetBuilder.changeSetBuilder;
import static de.hybris.platform.odata2webservicesfeaturetests.useraccess.UserAccessTestUtils.givenUserExistsWithUidAndGroups;
import static de.hybris.platform.odata2webservicesfeaturetests.ws.InboundChannelConfigurationBuilder.inboundChannelConfigurationBuilder;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.inboundservices.enums.AuthenticationType;
import de.hybris.platform.inboundservices.model.InboundChannelConfigurationModel;
import de.hybris.platform.inboundservices.util.InboundMonitoringRule;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.integrationservices.util.IntegrationTestUtil;
import de.hybris.platform.integrationservices.util.JsonObject;
import de.hybris.platform.integrationservices.util.XmlObject;
import de.hybris.platform.odata2services.odata.content.ODataBatchBuilder;
import de.hybris.platform.odata2webservices.constants.Odata2webservicesConstants;
import de.hybris.platform.odata2webservicesfeaturetests.ws.BasicAuthRequestBuilder;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.webservicescommons.testsupport.server.NeedsEmbeddedServer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.MultipartStream;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Lists;

@NeedsEmbeddedServer(webExtensions = { Odata2webservicesConstants.EXTENSIONNAME })
@IntegrationTest
public class ODataProcessorIntegrationTest extends ServicelayerTest
{
	private static final String SERVICE_NAME = "TestProduct";
	private static final String NON_INBOUND_SERVICE_NAME = "TestOutboundProduct";
	private static final String BATCH_URI = "$batch";
	private static final String PRODUCTS = "AProducts";
	private static final String UNITS_QUERY = "AUnits";

	private static final String WEBROOT = "/odata2webservices_junit/";
	private static final String UTF_8 = "UTF-8";

	private static final String TEST_ADMIN = "integrationtestadmin";
	private static final String PASSWORD = "password";
	private static final String PRODUCTS_URI = WEBROOT + SERVICE_NAME + "/" + PRODUCTS;

	private static final String TEST_UNIT = "testUnit";
	private static final String UNIT_NAME = "unit name -- S????igkeit";
	private static final String UNIT_TYPE = "unit type";
	private static final String ERROR_CODE_PATH = "error.code";
	private static final String ERROR_MESSAGE_PATH = "error.message.value";
	private static final String PRODUCT_CODE = "a_product";
	private static final String PRODUCT_NAME = "a_product_name";
	private static final String PRODUCT_NAME_ENGLISH = "the name [EN]";
	private static final String PRODUCT_NAME_GERMAN = "der Name [DE]";
	private static final String ODATA_ERROR_CODE = "odata_error";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String MULTIPART_MIXED = "multipart/mixed";
	private static final String HTTP_CREATED = "HTTP/1.1 201 Created";
	private static final String PRODUCT_LOCATION = "Location: https://localhost:8002/odata2webservices_junit/TestProduct/AProducts";

	@Rule
	public InboundMonitoringRule monitoringRule = InboundMonitoringRule.disabled();

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		createDefaultCatalog();

		/* For the integrationadmingroup (from odata2services) */
		importCsv("/impex/essentialdata-odata2services.impex", UTF_8);
		importCsv("/test/product-odata2webservicesfeaturetests.impex", UTF_8);

		givenUserExistsWithUidAndGroups(TEST_ADMIN, PASSWORD, "integrationadmingroup");
		inboundChannelConfigurationBuilder()
				.withCode(SERVICE_NAME)
				.withAuthType(AuthenticationType.BASIC)
				.build();
		inboundChannelConfigurationBuilder()
				.withCode(NON_INBOUND_SERVICE_NAME)
				.withAuthType(AuthenticationType.BASIC)
				.build();
	}

	@After
	public void cleanUp()
	{
		IntegrationTestUtil.removeAll(InboundChannelConfigurationModel.class);
		IntegrationTestUtil.removeAll(IntegrationObjectModel.class);
		IntegrationTestUtil.removeAll(ProductModel.class);
		IntegrationTestUtil.removeSafely(EmployeeModel.class, e -> e.getUid().equals("integrationtestadmin"));
	}

	@Test
	public void testNonInboundIntegrationObjectIsNotSupported()
	{
		final Response response = basicAuthRequest()
				.path(NON_INBOUND_SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity(getJsonProductBody(PRODUCT_CODE, PRODUCT_NAME)));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_NOT_FOUND);
	}

	@Test
	public void testSuccessfulRequest_POST()
	{
		final Response response = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity(getJsonProductBody(PRODUCT_CODE, PRODUCT_NAME)));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_CREATED);
		final JsonObject json = getJson(response);
		assertThat(json.getString("d.prodcode")).isEqualTo(PRODUCT_CODE);
		assertThat(json.getString("d.prodname")).isEqualTo(PRODUCT_NAME);
		assertThat(json.getString("d.cv.__deferred.uri")).endsWith("('Staged%7CDefault%7Ca_product')/cv");
		assertThat(json.getString("d.produnit.__deferred.uri")).endsWith("('Staged%7CDefault%7Ca_product')/produnit");
	}

	@Test
	public void testSuccessfulRequest_RoundTrip()
	{
		final String productName =
				"a roundtrip product -- having special characters -- ??and?? -- ??uf -- S????igkeiten -- ??????????????????";
		final Response post = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity(getJsonProductBody("a_roundtrip_product", productName)));

		assertThat(post.getStatus()).isEqualTo(HttpStatus.SC_CREATED);

		final String productURL = PRODUCTS + "('Staged%7CDefault%7Ca_roundtrip_product')";
		final Response prodGet = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(productURL)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.get();

		assertThat(prodGet.getStatus()).isEqualTo(HttpStatus.SC_OK);
		final JsonObject prodJson = getJson(prodGet);
		assertThat(prodJson.getString("d.prodcode")).isEqualTo("a_roundtrip_product");
		assertThat(prodJson.getString("d.prodname")).isEqualTo(productName);

		final String catalogVersionURL = PRODUCTS + "('Staged%7CDefault%7Ca_roundtrip_product')/cv";
		final Response cvGet = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(catalogVersionURL)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.get();

		assertThat(cvGet.getStatus()).isEqualTo(HttpStatus.SC_OK);
		final JsonObject cvJson = getJson(cvGet);
		assertThat(cvJson.getString("d.aversion")).isEqualTo("Staged");
		assertThat(cvJson.getBoolean("d.isactive")).isTrue();
	}

	@Test
	public void testSuccessfulRequest_AtomContent_RoundTrip()
	{
		final Response post = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(UNITS_QUERY)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asXmlEntity(getAtomUnit(TEST_UNIT, UNIT_NAME, UNIT_TYPE)));

		assertThat(post.getStatus()).isEqualTo(HttpStatus.SC_CREATED);

		final String unitUrl = UNITS_QUERY + "('" + TEST_UNIT + "')";
		final Response get = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(unitUrl)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_ATOM_XML)
				.get();

		assertThat(get.getStatus()).isEqualTo(HttpStatus.SC_OK);
		final XmlObject xml = getXml(get);
		assertThat(xml.get("/entry/content/properties/unitCode")).isEqualTo(TEST_UNIT);
		assertThat(xml.get("/entry/content/properties/unitName")).isEqualTo(UNIT_NAME);
		assertThat(xml.get("/entry/content/properties/unitType")).isEqualTo(UNIT_TYPE);
		assertThat(xml.get("/entry/content/properties/integrationKey")).isEqualTo(TEST_UNIT);
	}

	@Test
	public void testMissingNavPropRequest_POST()
	{
		final Response response = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity(getJsonProductBodyNotExistingNavProperty("some_product", "some_product")));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isEqualTo("missing_nav_property");
	}

	@Test
	public void testMissingKeyPropRequest_POST()
	{
		final String payload = json()
				.withField("cv", json()
						.withField("aversion", "Staged")
						.withField("acatalog", json()
								.withField("catalogId", "Default")))
				.build();
		final Response response = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity(payload));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isEqualTo("missing_key");
		assertThat(json.getString(ERROR_MESSAGE_PATH)).containsSequence("prodcode", "AProduct");
	}

	@Test
	public void testMissingKeyNavPropRequest_POST()
	{
		final Response response = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity("{\"@odata.context\": \"$metadata#AProduct/$entity\", \"prodcode\": \"10001\" }"));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isEqualTo("missing_key");
		assertThat(json.getString(ERROR_MESSAGE_PATH)).containsSequence("cv", "AProduct");
	}

	@Test
	public void testMalformedfieldJSON_POST()
	{
		final javax.ws.rs.core.Response response = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity("{code\": {} }"));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isEqualTo(ODATA_ERROR_CODE);
		assertThat(json.getString(ERROR_MESSAGE_PATH)).isNotEmpty();
	}

	@Test
	public void testMalformedvalueJSON_POST()
	{
		final Response response = basicAuthRequest()
				.path(SERVICE_NAME)
				.path(PRODUCTS)
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity("{\"@odata.context\": \"$metadata#AProduct/$entity\", \"prodcode\": \"value }"));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isEqualTo(ODATA_ERROR_CODE);
		assertThat(json.getString(ERROR_MESSAGE_PATH)).isNotEmpty();
	}

	@Test
	public void testRequestedResourceNotFound_POST()
	{
		final Response response = basicAuthRequest()
				.path(SERVICE_NAME)
				.path("Invalids")
				.credentials(TEST_ADMIN, PASSWORD)
				.build()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.post(asJsonEntity("{\"@odata.context\": \"$metadata#Invalid/$entity\", \"prodcode\": \"10000007\" " +
						"}"));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_NOT_FOUND);
		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isNullOrEmpty();
		assertThat(json.getString(ERROR_MESSAGE_PATH)).isEqualTo("Could not find an entity set or function import for " +
				"'Invalids'.");
	}

	@Test
	public void testBatchReturnsMultipleStatusCodes_OnePerChangeSetPart() throws IOException
	{
		final ODataBatchBuilder batch = batchBuilder()
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p1", PRODUCT_NAME_ENGLISH))
						.withPart(Locale.GERMAN, getJsonProductBody("p1", PRODUCT_NAME_GERMAN)));

		final Response response = basicAuthRequest()
				.credentials(TEST_ADMIN, PASSWORD)
				.path(SERVICE_NAME)
				.path(BATCH_URI)
				.build()
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(asEntity(batch));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_ACCEPTED);
		assertThat(response.getHeaderString(CONTENT_TYPE)).startsWith(MULTIPART_MIXED);

		final List<String> responseParts = getResponseParts(response);
		assertThat(responseParts).hasSize(1);
		assertThat(responseParts.get(0))
				.containsSequence(HTTP_CREATED, PRODUCT_LOCATION, HTTP_CREATED, PRODUCT_LOCATION);
	}

	@Test
	public void testBatchReturnsOnlyOneStatusCodePerChangeSet_inCaseOfError() throws IOException
	{
		final ODataBatchBuilder batch = batchBuilder()
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p1", PRODUCT_NAME_ENGLISH))
						.withPart(Locale.GERMAN, getJsonProductBodyNotExistingNavProperty("p1", PRODUCT_NAME_GERMAN)));

		final Response response = basicAuthRequest()
				.credentials(TEST_ADMIN, PASSWORD)
				.path(SERVICE_NAME)
				.path(BATCH_URI)
				.build()
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(asEntity(batch));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_ACCEPTED);
		assertThat(response.getHeaderString(CONTENT_TYPE)).startsWith(MULTIPART_MIXED);

		final List<String> responseParts = getResponseParts(response);
		assertThat(responseParts).hasSize(1);
		assertThat(responseParts.get(0))
				.containsSequence("HTTP/1.1 400 Bad Request")
				.containsSequence("{\"error\":{\"code\":\"missing_nav_property\",\"message\":{\"lang\":\"en\",\"value\":")
				.containsSequence("\"MissingVersion|Default|p1\"");
	}

	@Test
	public void testBulkReturnsMultipleStatusCodes() throws IOException
	{
		final ODataBatchBuilder batch = batchBuilder()
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p1", PRODUCT_NAME_ENGLISH))
						.withPart(Locale.GERMAN, getJsonProductBody("p1", PRODUCT_NAME_GERMAN)))
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p3", "the name [en]"))
						.withPart(Locale.GERMAN, getJsonProductBodyNotExistingNavProperty("p3", PRODUCT_NAME_GERMAN)))
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p2", PRODUCT_NAME_ENGLISH))
						.withPart(Locale.GERMAN, getJsonProductBody("p2", PRODUCT_NAME_GERMAN)));

		final Response response = basicAuthRequest()
				.credentials(TEST_ADMIN, PASSWORD)
				.path(SERVICE_NAME)
				.path(BATCH_URI)
				.build()
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(asEntity(batch));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_ACCEPTED);
		assertThat(response.getHeaderString(CONTENT_TYPE)).startsWith(MULTIPART_MIXED);

		final List<String> responseParts = getResponseParts(response);
		assertThat(responseParts).hasSize(3);
		assertThat(responseParts.get(0)).containsSequence(HTTP_CREATED, PRODUCT_LOCATION, HTTP_CREATED, PRODUCT_LOCATION);
		assertThat(responseParts.get(1)).containsSequence(
				"HTTP/1.1 400 Bad Request",
				"\"code\":\"missing_nav_property\"",
				"\"message\":{\"lang\":\"en\"",
				"\"innererror\":\"MissingVersion|Default|p3\"");
		assertThat(responseParts.get(2)).containsSequence(HTTP_CREATED, PRODUCT_LOCATION, HTTP_CREATED, PRODUCT_LOCATION);
	}

	@Test
	public void testBatchReturnsError_malformedChangeSet() throws IOException
	{
		final ODataBatchBuilder batch = batchBuilder()
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p1", PRODUCT_NAME_ENGLISH).replace("\"Staged\",",
								"")));

		final Response response = basicAuthRequest()
				.credentials(TEST_ADMIN, PASSWORD)
				.path(SERVICE_NAME)
				.path(BATCH_URI)
				.build()
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(asEntity(batch));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_ACCEPTED);
		assertThat(response.getHeaderString(CONTENT_TYPE)).startsWith(MULTIPART_MIXED);

		final List<String> responseParts = getResponseParts(response);
		assertThat(responseParts).hasSize(1);
		assertThat(responseParts.get(0)).containsSequence("HTTP/1.1 400 Bad Request",
				ODATA_ERROR_CODE);
	}

	@Test
	public void testBatchReturnsError_malformedMultipart()
	{
		final ODataBatchBuilder batch = batchBuilder()
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p1", PRODUCT_NAME_ENGLISH)));

		final Response response = basicAuthRequest()
				.credentials(TEST_ADMIN, PASSWORD)
				.path(SERVICE_NAME)
				.path(BATCH_URI)
				.build()
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(asEntity(batch, "multipart/mixed; boundary=no-boundaries")); // NOT EXISTING BOUNDARY

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
		assertThat(response.getHeaderString(CONTENT_TYPE)).startsWith(MediaType.APPLICATION_JSON);

		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isEqualTo(ODATA_ERROR_CODE);
		assertThat(json.getString(ERROR_MESSAGE_PATH)).isNotEmpty();
	}

	@Test
	public void testBulkWithBatchLimit()
	{
		// BATCH_LIMIT is set to 3. (check tenant_junit.properties)

		final ODataBatchBuilder batch = batchBuilder()
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p1", PRODUCT_NAME_ENGLISH)))
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p2", PRODUCT_NAME_ENGLISH)))
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p3", PRODUCT_NAME_ENGLISH)))
				.withChangeSet(changeSetBuilder()
						.withUri(PRODUCTS_URI)
						.withPart(Locale.ENGLISH, getJsonProductBody("p4", PRODUCT_NAME_ENGLISH)));

		final Response response = basicAuthRequest()
				.credentials(TEST_ADMIN, PASSWORD)
				.path(SERVICE_NAME)
				.path(BATCH_URI)
				.build()
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(asEntity(batch));

		assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
		assertThat(response.getHeaderString(CONTENT_TYPE)).startsWith(MediaType.APPLICATION_JSON);

		final JsonObject json = getJson(response);
		assertThat(json.getString(ERROR_CODE_PATH)).isEqualTo("batch_limit_exceeded");
		assertThat(json.getString(ERROR_MESSAGE_PATH)).isEqualTo("The number of integration objects sent in the " +
				"request has exceeded the 'odata2services.batch.limit' setting currently set to 3");
	}

	private List<String> getResponseParts(final Response response) throws IOException
	{
		final String boundary = getBoundaryFrom(response.getHeaderString(CONTENT_TYPE));
		final int bufferSize = 4096;
		final MultipartStream multipartStream = new MultipartStream(
				(InputStream) response.getEntity(), boundary.getBytes(StandardCharsets.UTF_8), bufferSize, null);

		boolean nextPart = multipartStream.skipPreamble();
		final List<String> bodies = Lists.newArrayList();
		while (nextPart)
		{
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			multipartStream.readBodyData(baos);
			final String body = IOUtils.toString(baos.toByteArray(), "UTF-8");
			bodies.add(body);
			nextPart = multipartStream.readBoundary();
		}
		return bodies;
	}

	private String getBoundaryFrom(final String contentTypeHeader)
	{
		// multipart/mixed; boundary=...; charset=...
		return contentTypeHeader.split(";")[1].split("=")[1];
	}

	private String getJsonProductBody(final String code, final String name)
	{
		return "{" +
				"\"@odata.context\": \"$metadata#AProduct/$entity\"," +
				"\"prodcode\": \"" + code + "\"," +
				"\"prodname\": \"" + name + "\"," +
				"\"cv\": {" +
				"   \"acatalog\": {" +
				"      \"catalogId\": \"Default\"" +
				"   }," +
				"   \"aversion\": \"Staged\"," +
				"   \"isactive\": true" +
				"}," +
				"\"produnit\": {\"unitCode\": \"pieces\"}" +
				"}";
	}

	private String getJsonProductBodyNotExistingNavProperty(final String code, final String name)
	{
		return getJsonProductBody(code, name).replace("Staged", "MissingVersion");
	}

	private String getAtomUnit(final String code, final String name, final String unitType)
	{
		return "<?xml version='1.0' encoding='utf-8'?>\n" +
				"<entry xmlns=\"http://www.w3.org/2005/Atom\" xmlns:m=\"http://schemas.microsoft" +
				".com/ado/2007/08/dataservices/metadata\" " +
				"xmlns:d=\"http://schemas.microsoft.com/ado/2007/08/dataservices\" " +
				"xml:base=\"https://localhost:9002/odata2webservices/TestProduct/\">\n" +
				"	<content type=\"application/xml\">\n" +
				"		<m:properties>\n" +
				"			<d:unitCode>" + code + "</d:unitCode>\n" +
				"			<d:unitName>" + name + "</d:unitName>\n" +
				"			<d:unitType>" + unitType + "</d:unitType>\n" +
				"		</m:properties>\n" +
				"	</content>\n" +
				"</entry>";
	}

	private BasicAuthRequestBuilder basicAuthRequest()
	{
		return new BasicAuthRequestBuilder()
				.extensionName(Odata2webservicesConstants.EXTENSIONNAME);
	}

	private Entity<String> asJsonEntity(final String body)
	{
		return Entity.entity(body, javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE);
	}

	private Entity<String> asEntity(final ODataBatchBuilder batch)
	{
		return asEntity(batch, "multipart/mixed; boundary=" + BATCH_BOUNDARY);
	}

	private Entity<String> asEntity(final ODataBatchBuilder batch, final String mediaType)
	{
		return Entity.entity(batch.build(), mediaType);
	}

	private Entity<String> asXmlEntity(final String body)
	{
		return Entity.entity(body, "application/atom+xml;charset=utf-8");
	}

	private JsonObject getJson(final Response response)
	{
		return JsonObject.createFrom((InputStream) response.getEntity());
	}

	private XmlObject getXml(final Response response)
	{
		return XmlObject.createFrom((InputStream) response.getEntity());
	}
}
