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
    './org-tree-layer',
    './../event/org-tree-event'
], function($, _, Backbone, OrgTreeLayerViewExport, OrgTreeEvent){

    return Backbone.View.extend({

        tagName: 'ol',

        className: 'tree',

        initialize: function(){

        },

        render: function(){
            new OrgTreeLayerViewExport.OrgTreeLayerView({el: this.el, className: 'tree'}).render();
            return this;
        }
    });
});