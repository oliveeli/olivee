/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:40
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'two-column-view',
    './left',
    './right'
], function($, _, Backbone, TwoColumnView, LeftView, RightView){

    return Backbone.View.extend({

        el: $("#page"),

        initialize: function(){
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'selectOrg', 'selectRoot');
        },

        render: function(){
            this.twoColumnView = new TwoColumnView().render();
            $(this.el).html($(this.twoColumnView.el));

            var leftView = new LeftView().render();
            this.twoColumnView.setLeftView(leftView);

            leftView.on('selectOrg', this.selectOrg);
            leftView.on('selectRoot', this.selectRoot);

            return this;
        },

        selectOrg: function(orgModel){
            if(this.rightView){
                this.rightView.remove();
            }
            this.rightView = new RightView({orgModel: orgModel}).render();
            this.twoColumnView.setRightView(this.rightView);
        },

        selectRoot: function(rootModel){
            if(this.rightView){
                this.rightView.remove();
            }
            this.rightView = new RightView({orgModel: rootModel}).render();
            this.twoColumnView.setRightView(this.rightView);
        }

    });
});