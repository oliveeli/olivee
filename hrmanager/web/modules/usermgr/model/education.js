/**
 * Author: 李军
 * Date: 12-10-12
 * Time: 上午10:20
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
                'read': 'user/education/get',
                'create': 'user/education/create',
                'update': 'user/education/update',
                'delete': 'user/education/remove'
            },

            sync: function(method, model, options) {
                options = options || {};
                options.url = model.methodToURL[method.toLowerCase()];
                if(method==='delete'){
                    options.data = JSON.stringify(model);
                    options.contentType = 'application/json; charset=UTF-8';
                }
                Backbone.sync(method, model, options);
            }
        });

    }
);