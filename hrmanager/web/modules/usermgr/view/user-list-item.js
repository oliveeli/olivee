/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:58
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!modules-path/usermgr/tpl/user-list-item.html'
], function($, _, Backbone,  UserListItemTpl){

    return Backbone.View.extend({

        tagName: 'tr',

        template:_.template(UserListItemTpl),

        events: {
            'click':'click',
            'click #edit': 'edit',
            'click #delete': 'delete'
        },

        initialize: function(){
            _.extend(this, Backbone.Events);
        },

        render: function(){
            $(this.el).html(this.template({index: this.options.index,model: this.model.toJSON()}));
            return this;
        },

        click: function(){
            this.trigger('selected', this);
        },

        addSelectClass: function(){
            $(this.el).addClass('selected');
        },

        removeSelectClass: function(){
            $(this.el).removeClass('selected');
        },

        edit: function(event){
            event.stopPropagation();
            this.trigger('edit', this.model);
        },

        delete: function(event){
            event.stopPropagation();
        }


    });

});