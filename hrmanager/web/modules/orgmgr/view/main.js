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
    './left',
    './right'
], function($, _, Backbone, LeftView, RightView){

    return Backbone.View.extend({

        el: $("#page"),

        initialize: function(){
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'selectOrg', 'selectRoot');
        },

        render: function(){
            $(this.el).html('');
            var leftView = new LeftView().render();
            $(this.el).append($(leftView.el));
            leftView.on('selectOrg', this.selectOrg);
            leftView.on('selectRoot', this.selectRoot);

            return this;
        },

        selectOrg: function(orgModel){
            if(this.rightView){
                this.rightView.remove();
            }
            this.rightView = new RightView({model: orgModel}).render();
            $(this.el).append($(this.rightView.el));
        },

        selectRoot: function(rootModel){
            if(this.rightView){
                this.rightView.remove();
            }
            this.rightView = new RightView({model: rootModel}).render();
            $(this.el).append($(this.rightView.el));
        }

    });
});
