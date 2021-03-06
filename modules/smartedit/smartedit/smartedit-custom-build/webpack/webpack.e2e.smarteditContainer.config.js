/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
const {
    compose,
    webpack: { multiEntry }
} = require('../../smartedit-build/builders');

const {
    smarteditcontainer
} = require('../../smartedit-build/config/webpack/webpack.e2e.shared.config');

module.exports = compose(multiEntry('jsTarget', 'test/e2e/**/outer*.ts'))(smarteditcontainer);
