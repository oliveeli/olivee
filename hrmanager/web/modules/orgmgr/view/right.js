/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午3:29
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './../model/organization',
    './org-detail-form',
    'text!modules-path/orgmgr/tpl/right.html'
], function($, _, Backbone, OrganizationModel, OrgDetailFormView, RightTpl){

    return Backbone.View.extend({

        template:_.template(RightTpl),

        events: {'click #create':'createOrg'},

        initialize: function(options){
            _.bindAll(this,'createOrg', 'saveSuccess');
            this.isRoot = this.model.get('isRoot');
            this.model.on('del:success', this.remove, this);
        },

        render: function(){
            $(this.el).append(this.template());

            if(!this.isRoot){
                this.$('#org-detail').html(
                    $(new OrgDetailFormView({
                        model: this.model
                    }).render().el)
                );
            }
            return this;
        },

        createOrg: function(){
            var newModel = new OrganizationModel({superid: this.isRoot?'':this.model.id});
            this.$('#org-detail').html(
                $(new OrgDetailFormView({
                    model: newModel
                }).render().el)
            );
            newModel.on('save:success', this.saveSuccess);
            this.model.trigger('createOrg');
        },

        saveSuccess: function(newModel){
            this.model.trigger('addChildSuccess', newModel);
        }

    });

});