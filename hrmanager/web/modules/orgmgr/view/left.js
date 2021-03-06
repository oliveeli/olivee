/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午3:29
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './org-tree'
], function($, _, Backbone, OrgTreeView){
    return Backbone.View.extend({

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

        selectOrg: function(nodeView){
            this.trigger('selectOrg', nodeView.model);
        },

        selectRoot: function(nodeView){
            this.trigger('selectRoot', nodeView.model);
        }
    });
});