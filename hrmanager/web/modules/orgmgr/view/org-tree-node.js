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
                _.bindAll(this, 'onSelected', 'onSelectedCheckbox', 'selectedSubNode', 'updateDisplay', 'destroyView', 'onCreateOrg');
                this.model.on('update:success', this.updateDisplay);
                this.model.on('del:success', this.destroyView);
                this.model.on('createOrg', this.onCreateOrg);

            },

            render: function(){
                $(this.el).append(this.template(this.model.toJSON()));
                return this;
            },

            updateDisplay: function(){
                this.$('>label').html(this.model.get('name'));
            },

            destroyView: function(){
                this.remove();
            },

            onSelected: function(event){
                if('INPUT'!==event.target.nodeName){
                    event.preventDefault();
                    event.stopPropagation();
                } else {
                    return;
                }
                this.trigger('selected', this);
            },

            onSelectedCheckbox: function(event){
                if((!event || event.target.checked) && !this.childLoaded){
                    this.loadChild();
                }
            },

            loadChild: function(){
                var OrgTreeLayerView = require('./org-tree-layer').OrgTreeLayerView;
                var layer = new OrgTreeLayerView({parentModel: this.model, el: this.$('input+ol')}).render();
                layer.bind('selectedNode', this.selectedSubNode);
                this.childLoaded = true;
            },

            onCreateOrg: function(){
                this.$('>input').attr('checked',true);
                this.onSelectedCheckbox();
            },

            selectedSubNode: function(nodeView){
                this.trigger('selectedNode', nodeView);
            },

            removeSelectedClass: function(){
                this.$('>label').removeClass('selected');
            },

            addSelectedClass: function(){
                this.$('>label').addClass('selected');
            }

        });

        return nodeView;

    }
);