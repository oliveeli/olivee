/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:13
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './../modules/usermgr/view/main',
    './../modules/orgmgr/view/main'
],
function($, _, Backbone, UserManagerView, OrgManagerView ){
        var AppRouter = Backbone.Router.extend({

            routes: {
                'app/:appId':'showApp'
            },

            initialize: function(){
                _.extend(this, Backbone.Events);
            },

            showApp: function(appId){
                this.trigger('router', appId);
            }
        });

        var initialize = function(){
            var app_router = new AppRouter;
            Backbone.history.start();
            return app_router;
        };

        return {
            initialize: initialize
        };
});