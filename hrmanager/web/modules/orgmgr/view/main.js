/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午3:29
 * 远方软件有限公司
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './left',
    './right'
], function($, _, Backbone, LeftView, RightView){
    return Backbone.View.extend({

        el: $("#page"),

        initialize: function(){

        },
        render: function(){
            $(this.el).html('');
            $(this.el).append($(new LeftView().render().el));
            $(this.el).append($(new RightView().render().el));

            return this;
        }
    });
});
