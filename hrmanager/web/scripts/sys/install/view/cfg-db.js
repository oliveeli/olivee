/**
 * Author: 李军
 * Date: 12-10-22
 * Time: 下午1:37
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'backbone.syphon',
    'text!scripts/sys/install/tpl/cfg-db.html',
    'text!scripts/tpl/alert-error.html'
], function($, _, Backbone, BackboneSyphon, ViewTpl, AlertErrorTpl){

    return Backbone.View.extend({

        template:_.template(ViewTpl),

        initialize: function(){
            _.bindAll(this, 'validate');
            _.extend(this, Backbone.Events);
        },

        render: function(){
            $(this.el).html(this.template({model: {address: '127.0.0.1', port: '3306', instance: 'hrmanager', user: 'root', password: 'olivee'}}));
            return this;
        },

        renderError: function(message){
            if(message){
                var template = _.template(AlertErrorTpl);
                $(this.el).append(template({message: message}));
            }
            return this;
        },

        validate: function(){
            this.$('.alert').alert('close');
            var that = this;
            var data = Backbone.Syphon.serialize(this);
            $.ajax({
                url: 'install/db/config',
                type: 'post',
                dataType: 'json',
                data: JSON.stringify(data),
                contentType: 'application/json; charset=UTF-8',
                success: function(data, textStatus, jqXHR){
                    if(data.type==='ERROR'){
                        that.trigger('error', data.data);
                        that.renderError(data.data);
                    } else {
                        that.trigger('success');
                    }
                },
                error: function(jqXHR, textStatus, errorThrown){
                    that.trigger('error', textStatus);
                    that.renderError(textStatus);
                }
            });
        }

    });
});