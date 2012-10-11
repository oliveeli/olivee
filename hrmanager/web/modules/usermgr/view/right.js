/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:41
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './../model/user',
    './user-list',
    './user-info-tab',
    'text!modules-path/usermgr/tpl/right.html'
], function($, _, Backbone, UserModel, UserListView, UserInfoTabView, RightTpl){

    return Backbone.View.extend({

        events: {
            'click #create': 'createUser'
        },

        initialize: function(){
            _.extend(this, Backbone.Events);
        },

        render: function(){
            $(this.el).html(RightTpl);
            this.renderUserList();
            return this;
        },

        onSelectedUser: function(userModel){

        },

        renderUserList: function(){
            var userListView = new UserListView({organizationId: this.options.orgModel.id}).render();
            this.$('.split-right-body').html($(userListView.el));
            userListView.on('selectedUser', this.onSelectedUser, this);
            userListView.on('edit', this.edit, this);
        },

        createUser: function(){
            if(this.userInfoView){
                this.userInfoView.remove();
            }
            this.userInfoView = new UserInfoTabView({
                model: new UserModel({orgid: this.options.orgModel.id}),
                orgModel: this.options.orgModel
            }).render();
            this.$('.split-right-body').html($(this.userInfoView.el));
        },

        edit: function(model){
            if(this.userInfoView){
                this.userInfoView.remove();
            }
            this.userInfoView = new UserInfoTabView({
                model: model,
                orgModel: this.options.orgModel
            }).render();
            this.$('.split-right-body').html($(this.userInfoView.el));
        }


        /*
        createUser: function(){
            var userDetailForm = new UserDetailForm({
                model: new UserModel({orgid: this.options.orgModel.id}),
                orgModel: this.options.orgModel
            }).render();
            this.$('.split-right-body').html($(userDetailForm.el));
        },

        edit: function(model){
            var userDetailForm = new UserDetailForm({
                model: model,
                orgModel: this.options.orgModel
            }).render();
            this.$('.split-right-body').html($(userDetailForm.el));
        }
        */


    });

});