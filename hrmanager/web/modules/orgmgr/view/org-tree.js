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
    './org-tree-node',
    './../collection/organizations'
], function($, _, Backbone, TreeNodeView, OrganizationCollection){
    return new Backbone.View.extend({

        tagName: 'ol',

        className: 'tree',

        initialize: function(){
            _.bindAll(this, 'addTreeNode');
        },

        render: function(){
            this.orgs = new OrganizationCollection();
            this.orgs.each(this.addTreeNode);
            return this;
        },

        addTreeNode: function(orgModel){
            this.el.append($(new TreeNodeView({model: orgModel}).render().el));
        }
    });
});