<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Test execution failed</title>
</head>
<body>
<div class="prepend-top span-24" id="content">
	<h1>We're sorry but test execution has failed</h1>

	<div>
		<c:out value="${exceptionMessage}"/>
	</div>
</div>
</body>
</html>
