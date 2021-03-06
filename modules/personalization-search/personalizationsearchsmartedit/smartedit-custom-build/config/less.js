/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
module.exports = function() {
    return {
        targets: [
            'dev'
        ],
        config: function(data, conf) {
            return {
                dev: {
                    files: [{
                        expand: true,
                        cwd: 'web/styling',
                        src: 'style.less',
                        dest: 'web/webroot/css/',
                        ext: '.css'
                    }]
                },
            };
        }
    };
};
