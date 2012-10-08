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
    './../model/organization',
    './org-detail-form',
    'text!modules-path/orgmgr/tpl/right.html'
], function($, _, Backbone, OrganizationModel, OrgDetailFormView, RightTpl){

    return Backbone.View.extend({

        className: 'split-right',

        template:_.template(RightTpl),

        events: {'click #create':'createOrg'},

        initialize: function(options){
            _.bindAll(this,'createOrg');
            this.isRoot = options.isRoot;
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
            this.$('#org-detail').html(
                $(new OrgDetailFormView({
                    model: new OrganizationModel({parentId: this.isRoot?'':this.model.id})
                }).render().el)
            );
        }

    });

});