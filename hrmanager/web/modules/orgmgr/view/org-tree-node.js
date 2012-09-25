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
    'text!modules-path/orgmgr/tpl/org-tree-node.html'
], function($, _, Backbone, OrgTreeNodeTpl){
    return new Backbone.View.extend({

        tagName: 'li',

        template: _.template(OrgTreeNodeTpl),

        initialize: function(){

        },

        render: function(){
            this.el.append(this.template(this.model.toJSON()));
            return this;
        }

    });
});