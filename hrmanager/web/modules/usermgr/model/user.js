/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:44
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
                'read': 'user/get',
                'create': 'user/create',
                'update': 'user/update',
                'delete': 'user/remove'
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