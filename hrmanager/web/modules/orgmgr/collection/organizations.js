/**
 * Author: 李军
 * Date: 12-9-25
 * Time: 下午4:10
 * 远方软件有限公司
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

            initialize: function(){
                for(var i=0;i<100;i++){
                    this.add(new OrganizationModel({name: 'test'+ i, id: ''+ i}))
                }
            }


        });
    }
);