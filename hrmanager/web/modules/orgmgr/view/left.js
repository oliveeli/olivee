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
    './org-tree'
], function($, _, Backbone, OrgTreeView){
    return Backbone.View.extend({

        className: 'split-left',

        initialize: function(){

        },

        render: function(){
            $(this.el).append($(new OrgTreeView().render().el));
            return this;
        }
    });
});