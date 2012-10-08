/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午4:09
 * 远方软件有限公司
 */
define(
    [
        'jquery',
        'underscore',
        'backbone'
    ], function($, _, Backbone){

        return Backbone.Model.extend({

            methodToURL: {
                'read': 'organization/get',
                'create': 'organization/create',
                'update': 'organization/update',
                'delete': 'organization/remove'
            },

            sync: function(method, model, options) {
                options = options || {};
                options.url = model.methodToURL[method.toLowerCase()];
                Backbone.sync(method, model, options);
            }
        });

    }
);