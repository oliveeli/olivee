/**
 * Author: 李军
 * Date: 12-10-22
 * Time: 下午1:36
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './cfg-db',
    './cfg-admin',
    'text!modules-path/sys/install/tpl/main.html'
], function($, _, Backbone, ConfigDbView, ConfigAdminView, MainTpl){

    return Backbone.View.extend({


        el: $("#page"),

        steps: [
            ConfigDbView,
            ConfigAdminView
        ],

        events: {
            'click #previous':'previous',
            'click #next':'next',
            'click #cancel': 'cancel'
        },

        template:_.template(MainTpl),

        initialize: function(){
            _.extend(this, Backbone.Events);
            this.currentStepIndex = 0;
        },

        render: function(){
            $(this.el).html(this.template());
            this.$('#main-model').modal({backdrop: 'static'});
            this.$('#main-model').modal('show');

            this.renderCurrentStepView();
            return this;
        },

        renderCurrentStepView: function(){
            if(this.currentStepIndex===0){
                this.$('#previous').addClass('disabled');
            } else {
                this.$('#previous').removeClass('disabled');
            }

            this.currentStepView = new this.steps[this.currentStepIndex]({el: this.$('.modal-body')}).render();
        },

        cancel: function(){
            this.$('#main-model').modal('hide');
            this.$('#main-model').remove();
        },

        previous: function(event){
            if($(event.target).hasClass('disabled')){
                return;
            }
            if(this.currentStepIndex - 1 > -1){
                this.currentStepIndex--;
                this.renderCurrentStepView();
            }
        },

        next: function(event){
            if($(event.target).hasClass('disabled')){
                return;
            }
            if(this.currentStepIndex + 1 < this.steps.length){
                if(this.currentStepView && !this.currentStepView.validate()){
                    return;
                }
                this.currentStepIndex++;
                this.renderCurrentStepView();
            } else if(this.currentStepIndex + 1 === this.steps.length){
                this.currentStepIndex++;
                this.$('.modal-body').html('<h1>Configuration Complete! You need to restart server!</h1>');
                this.$('.modal-body').append('<a class="btn btn-large btn-success" href="#" id="restart">Restart Server Now!</a>');
                this.$('#previous').hide();
                this.$('#next').hide();
                this.$('#cancel').hide();
            }
        }


    });
});