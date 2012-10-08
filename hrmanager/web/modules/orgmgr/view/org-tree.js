/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午3:47
 * 远方软件有限公司
 */

define([
    'jquery',
    'underscore',
    'backbone',
    './../model/organization',
    './org-tree-node',
    './org-tree-layer',
    './../event/org-tree-event'
], function($, _, Backbone, OrgTreeNodeModel, OrgTreeNodeView, OrgTreeLayerViewExport, OrgTreeEvent){

    return Backbone.View.extend({

        tagName: 'ol',

        className: 'tree',

        initialize: function(){
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'selectedNode', 'selectedRoot');
        },

        render: function(){
            var root = new OrgTreeNodeView({
                model: new OrgTreeNodeModel({name: 'Organization Tree', id: '', isRoot: true})
            }).render();

        	$(this.el).append($(root.el));

            root.on('selected', this.selectedRoot);
            root.on('selectedNode', this.selectedNode);
            return this;
        },

        selectedNode: function(orgModel){
            this.trigger('selectedNode', orgModel);
        },

        selectedRoot: function(nodeView){
            this.trigger('selectedRoot', nodeView.model);
        }

    });
});