/**
 * Author: 李军
 * Date: 12-10-12
 * Time: 下午4:55
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!modules-path/usermgr/tpl/upload-pic.html',
    'jquery.jcrop'
], function($, _, Backbone, UploadPicTpl){

    return Backbone.View.extend({

        tagName: 'div',

        className: 'modal hide fade',

        events: {
            'click #confirm':'confirm',
            'click #cancel': 'cancel'
        },

        template: _.template(UploadPicTpl),

        initialize: function(){
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'confirm', 'cancel');
        },

        render: function(){
            $(this.el).append(this.template());
            $(this.el).modal({backdrop: true});
            $(this.el).modal('show');
            this.$('.crop-target').Jcrop();
            return this;
        },

        confirm: function(){
            $(this.el).modal('hide');
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