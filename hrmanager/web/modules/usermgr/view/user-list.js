/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:43
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './../collection/users',
    './user-list-item',
    'text!modules-path/usermgr/tpl/user-list.html'
], function($, _, Backbone, UsersCollection, UserListItemView, UserListTpl){

    return Backbone.View.extend({

        tagName: 'table',

        className: 'table table-hover',

        initialize: function(){
            _.extend(this, Backbone.Events);
        },

        render: function(){

            $(this.el).html(UserListTpl);

            this.users = new UsersCollection({organizationId: this.options.organizationId});
            this.users.on('reset', this.addAll, this);
            this.users.on('add', this.addOne, this);
            this.users.fetch();

            return this;
        },

        addAll: function(){
            this.users.each(this.addOne, this);
        },

        addOne: function(model){
            var itemView = new UserListItemView({model: model});
            itemView.on('selected', this.selectOne, this);
            this.$('tbody').append($(itemView.el));
        },

        selectOne: function(userModel){
            this.trigger('selectedUser', userModel);
        }

    });

});