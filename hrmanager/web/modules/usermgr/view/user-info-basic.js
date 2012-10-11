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
    'backbone.syphon',
    'confirm-view',
    'text!modules-path/usermgr/tpl/user-info-basic.html'
], function($, _, Backbone, BackboneSyphon, ConfirmView, UserDetailFormFormTpl){

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

        template: _.template(UserDetailFormFormTpl),

        initialize: function(){
            this.model.on('del:success', this.remove, this);
        },

        render: function(){
            $(this.el).append(this.template({
                model:this.model.toJSON(),
                orgModel: this.options.orgModel.toJSON()
            }));
            this.$('#dp-birthday').attr('data-date','2012-12-02');
            this.$('#dp-graduateDate').attr('data-date','2012-12-03');
            this.$('#dp-birthday').datepicker();
            this.$('#dp-graduateDate').datepicker();

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
            var confirmView = new ConfirmView({model: new Backbone.Model({title: '确认要删除“'+ this.model.get('name') +'”员工?', message: ''})}).render();
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