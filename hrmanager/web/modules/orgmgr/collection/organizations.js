/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午4:10
 *
 */
define(
    [
        'jquery',
        'underscore',
        'backbone',
        '../model/organization'
    ], function($, _, Backbone, OrganizationModel){
        return Backbone.Collection.extend({

            model: OrganizationModel,

            initialize: function(options){
                this.url = 'action/organization/list?parentId=' + options.parentId;
            }


        });
    }
);