/**
 * Author: 李军
 * Date: 12-10-9
 * Time: 下午5:03
 * 远方软件有限公司
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!modules-path/orgmgr/tpl/confirm.html'
], function($, _, Backbone, ConfirmTpl){

    return Backbone.View.extend({

        tagName: 'div',

        className: 'modal hide fade',

        events: {
            'click #confirm':'confirm',
            'click #cancel': 'cancel'
        },

        template: _.template(ConfirmTpl),

        initialize: function(){
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'confirm', 'cancel');
        },

        render: function(){
            $(this.el).append(this.template({model: this.model?this.model.toJSON():{}}));
            $(this.el).modal({backdrop: true});
            $(this.el).modal('show');
            return this;
        },

        confirm: function(){
            this.trigger('confirm');
            this.remove();
        },

        cancel: function(){
            $(this.el).modal('hide');
            this.trigger('cancel');
            this.remove();

        }

    });

});