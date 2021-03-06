/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午3:47
 *
 */

define([
    'jquery',
    'underscore',
    'backbone',
    './../model/organization',
    './org-tree-node',
    './org-tree-layer'
], function($, _, Backbone, OrgTreeNodeModel, OrgTreeNodeView, OrgTreeLayerViewExport){

    return Backbone.View.extend({

        tagName: 'ol',

        className: 'tree',

        initialize: function(){
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'selectedNode', 'selectedRoot');
        },

        render: function(){
            var root = new OrgTreeNodeView({
                model: new OrgTreeNodeModel({name: '组织机构树', id: '', isRoot: true})
            }).render();

        	$(this.el).append($(root.el));

            root.on('selected', this.selectedRoot);
            root.on('selectedNode', this.selectedNode);
            return this;
        },

        selectedNode: function(nodeView){
            if(this.selectedView){
                this.selectedView.removeSelectedClass();
            }
            this.selectedView = nodeView;
            this.selectedView.addSelectedClass();
            this.trigger('selectedNode', nodeView);
        },

        selectedRoot: function(nodeView){
            if(this.selectedView){
                this.selectedView.removeSelectedClass();
            }
            this.selectedView = nodeView;
            this.selectedView.addSelectedClass();
            this.trigger('selectedRoot', nodeView);
        }

    });
});