/**
 * Author: 李军
 * Date: 12-10-11
 * Time: 下午4:02
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!modules-path/usermgr/tpl/user-info-education-item.html',
    'backbone.syphon'
], function($, _, Backbone, ViewTemplate){

    return Backbone.View.extend({

        className: 'info-list-body-item',

        events: {
            'click #save':'save',
            'click #delete':'del'
        },

        template:_.template(ViewTemplate),

        initialize: function(){
            this.model.bind('del:success', this.remove, this);
        },

        render: function(){

            $(this.el).html(this.template({model: this.model.toJSON()}));

            this.$('#dp-beginDate').attr('data-date','2012-12-03');
            this.$('#dp-beginDate').datepicker();

            this.$('#dp-endDate').attr('data-date','2012-12-03');
            this.$('#dp-endDate').datepicker();

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

        del: function(){
            if(this.model.isNew()){
                this.model.trigger("del:success", this.model);
                return;
            }
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
