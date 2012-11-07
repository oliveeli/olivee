/**
 * Author: 李军
 * Date: 12-10-17
 * Time: 上午9:08
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
                'read': 'action/sys/image/get',
                'create': 'action/sys/image/create'
            },

            sync: function(method, model, options) {
                options = options || {};
                options.url = model.methodToURL[method.toLowerCase()];
                if(method==='delete' || method==='read'){
                    options.url += '?id=' + model.get('id');
                    options.contentType = 'application/json; charset=UTF-8';
                }
                Backbone.sync(method, model, options);
            }
        });

    }
);