/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:14
 *
 */
define(
    [
        "jquery",
        "underscore",
        "backbone",
        "router",
        './view/nav',
        './../modules/usermgr/view/main',
        './../modules/orgmgr/view/main'
    ],
    function($, _, Backbone, Router, NavigationView, UserManagerView, OrgManagerView) {

        var nav = function(action){
            switch (action){
                case 'user':
                    new UserManagerView().render();
                    break;
                case 'org':
                    new OrgManagerView().render();
                    break;
                default :
                    break;
            }
        };

        return {
            initialize: function(){
                $('#menu').append($(new NavigationView().render().el));
                var app_router = Router.initialize();
                app_router.on('router', nav);
            }
        };
    }
);