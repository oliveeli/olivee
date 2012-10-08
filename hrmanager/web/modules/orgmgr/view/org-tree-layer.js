/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午3:47
 * 远方软件有限公司
 */

define(
    [
        'jquery',
        'underscore',
        'backbone',
        './org-tree-node',
        './../collection/organizations',
        'text!modules-path/orgmgr/tpl/org-tree-layer.html',
        'exports'
    ],
    function($, _, Backbone, OrgTreeNodeView, OrganizationCollection,  OrgTreeLayerTpl, exports){

        var layerView = Backbone.View.extend({

            tagName: 'ol',

            template: _.template(OrgTreeLayerTpl),

            initialize: function(){
                _.extend(this, Backbone.Events);
                _.bindAll(this, 'addAll', 'addTreeNode', 'selectedNode');
            },

            render: function(){
                this.orgs = new OrganizationCollection({parentId: this.options.parentId});
                this.orgs.bind('reset',   this.addAll);
                this.orgs.fetch();
                return this;
            },

            addAll: function(){
                this.orgs.each(this.addTreeNode);
            },

            addTreeNode: function(orgModel){
                var node = new OrgTreeNodeView({model: orgModel}).render();
                node.bind('selected', this.selectedNode);
                $(this.el).append($(node.el));
            },

            selectedNode: function(nodeView){
                this.trigger('selectedNode', nodeView.model);
            }
        });

        exports.OrgTreeLayerView = layerView;

    }
);






