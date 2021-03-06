/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
const base = require('../../smartedit-build/config/webpack/webpack.ext.karma.smarteditContainer.config');

const { compose, unset } = require('../../smartedit-build/builders');

const { smarteditContainerKarma } = require('./webpack.shared.config');

module.exports = compose(
    smarteditContainerKarma(),
    unset('output.library')
)(base);
