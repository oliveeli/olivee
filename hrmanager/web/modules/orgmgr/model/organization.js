/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午4:09
 *
 */
define(
    [
        'jquery',
        'underscore',
        'backbone'
    ], function($, _, Backbone){

        return Backbone.Model.extend({

            methodToURL: {
                'read': 'action/organization/get',
                'create': 'action/organization/create',
                'update': 'action/organization/update',
                'delete': 'action/organization/remove'
            },

            sync: function(method, model, options) {
                options = options || {};
                options.url = model.methodToURL[method.toLowerCase()];
                if(method==='delete'){
                    if(model.get('id')){
                        options.data = JSON.stringify(model);
                        options.contentType = 'application/json; charset=UTF-8';
                    } else {
                        return;
                    }
                }
                Backbone.sync(method, model, options);
            }
        });

    }
);