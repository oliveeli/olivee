/**
 * Author: 李军
 * Date: 12-10-8
 * Time: 上午10:51
 * 远方软件有限公司
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'backbone.syphon',
    'text!modules-path/orgmgr/tpl/org-detail-form.html'
], function($, _, Backbone, BackboneSyphon, OrgDetailFormFormTpl){

    return Backbone.View.extend({

        tagName: 'form',

        className: 'form-horizontal',

        attributes: {
            'action': 'javascript:void(0);'
        },

        events: {
            'click #save':'save',
            'click #delete': 'delete'
        },

        template: _.template(OrgDetailFormFormTpl),

        initialize: function(){

        },

        render: function(){
            $(this.el).append(this.template(this.model.toJSON()));
            return this;
        },

         save: function(){
             var data = Backbone.Syphon.serialize(this);
             this.model.set(data);
             this.model.save(this.model.toJSON(),{
                 wait:true,
                 success:function(model, resp, options){
                     model.trigger("save:success");
                 },
                 error: function(model, resp, options){
                     model.trigger("save:fail");
                 }
             });
         },

         delete: function(){
            this.model.destroy();
         }

    });

});