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
    './confirm',
    'text!modules-path/orgmgr/tpl/org-detail-form.html'
], function($, _, Backbone, BackboneSyphon, ConfirmView, OrgDetailFormFormTpl){

    return Backbone.View.extend({

        tagName: 'form',

        className: 'form-horizontal',

        attributes: {
            'action': 'javascript:void(0);'
        },

        events: {
            'click #save':'save',
            'click #delete': 'confirmDelete'
        },

        template: _.template(OrgDetailFormFormTpl),

        initialize: function(){
            this.model.on('del:success', this.remove, this);
        },

        render: function(){
            $(this.el).append(this.template({model:this.model.toJSON()}));
            return this;
        },

        save: function(){
            var data = Backbone.Syphon.serialize(this);
            this.model.set(data);
            var method = this.model.isNew()?'save':'update';
            this.model.save(this.model.toJSON(),{
                wait:true,
                success:function(model, resp, options){
                 model.trigger(method + ":success", model);
                },
                error: function(model, resp, options){
                 model.trigger(method+ ":fail", model);
                }
            });
        },

        confirmDelete: function(){
            var confirmView = new ConfirmView({model: new Backbone.Model({title: '确认要删除“'+ this.model.get('name') +'”组织机构?', message: '组织机构的下级机构及其人员将同时被删除?'})}).render();
            $(this.el).append($(confirmView.el));
            confirmView.bind('confirm', this.del, this);
        },

        del: function(){
            this.model.destroy({
                wait:true,
                success:function(model, resp, options){
                    model.trigger("del:success", model);
                },
                error: function(model, resp, options){
                    model.trigger("del:fail", model);
                }
            });
        }

    });

});