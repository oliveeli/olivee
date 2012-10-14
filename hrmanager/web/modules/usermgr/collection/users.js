/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:45
 *
 */
define(
    [
        'jquery',
        'underscore',
        'backbone',
        '../model/user'
    ], function($, _, Backbone, UserModel){
        return Backbone.Collection.extend({

            model: UserModel,

            initialize: function(options){
                this.url = 'user/list?organizationId=' + options.organizationId;
            }

        });
    }
);