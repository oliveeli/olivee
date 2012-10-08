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
        'text!modules-path/orgmgr/tpl/org-tree-node.html',
        'require'
    ],
    function($, _, Backbone, OrgTreeNodeTpl, require){

        var nodeView = Backbone.View.extend({

            tagName: 'li',

            template: _.template(OrgTreeNodeTpl),

            events: {
                'click': 'onSelected',
                'click input': 'onSelectedCheckbox'
            },

            initialize: function(){
                _.extend(this, Backbone.Events);
                _.bindAll(this, 'onSelected', 'onSelectedCheckbox', 'selectedSubNode');
            },

            render: function(){
                $(this.el).append(this.template(this.model.toJSON()));
                return this;
            },

            onSelected: function(event){
                if('INPUT'!==event.target.nodeName){
                    event.preventDefault();
                    event.stopPropagation();
                } else {
                    return;
                }
                this.$('>label').addClass('selected');
                this.trigger('selected', this);
            },

            onSelectedCheckbox: function(event){
                if(event.target.checked && !this.childLoaded){
                    this.loadChild();
                }
            },

            loadChild: function(){
                var OrgTreeLayerView = require('./org-tree-layer').OrgTreeLayerView;
                var layer = new OrgTreeLayerView({parentId: this.model.id, el: this.$('input+ol')}).render();
                layer.bind('selectedNode', this.selectedSubNode);
                this.childLoaded = true;
            },

            selectedSubNode: function(orgModel){
                this.trigger('selectedNode', orgModel);
            }

        });

        return nodeView;

    }
);