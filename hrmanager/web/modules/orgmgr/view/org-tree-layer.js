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
                _.bindAll(this, 'addTreeNode');
            },

            render: function(){
                this.orgs = new OrganizationCollection();
                this.orgs.each(this.addTreeNode);
                return this;
            },

            addTreeNode: function(orgModel){
                $(this.el).append($(new OrgTreeNodeView({model: orgModel}).render().el));
            }
        });

        exports.OrgTreeLayerView = layerView;

    }
);






