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
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'selectOrg', 'selectRoot');
        },

        render: function(){
            var treeView = new OrgTreeView().render();
            $(this.el).append($(treeView.el));
            treeView.on('selectedNode', this.selectOrg);
            treeView.on('selectedRoot', this.selectRoot);
            return this;
        },

        selectOrg: function(orgModel){
            this.trigger('selectOrg', orgModel);
        },

        selectRoot: function(){
            this.trigger('selectRoot');
        }
    });
});