/**
 * Author: 李军
 * Date: 12-10-22
 * Time: 下午1:37
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!modules-path/sys/install/tpl/cfg-admin.html'
], function($, _, Backbone,  ViewTpl){

    return Backbone.View.extend({

        template:_.template(ViewTpl),

        initialize: function(){
            _.bindAll(this, 'validate');
        },

        render: function(){
            $(this.el).html(this.template());
            return this;
        },

        validate: function(){
            return true;
        }

    });
});