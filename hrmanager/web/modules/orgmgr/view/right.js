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
    'text!modules-path/orgmgr/tpl/right.html'
], function($, _, Backbone, RightTpl){
    return Backbone.View.extend({

        className: 'split-right',

        template:_.template(RightTpl),

        initialize: function(){

        },
        render: function(){
            $(this.el).append(this.template());
            return this;
        }
    });
});