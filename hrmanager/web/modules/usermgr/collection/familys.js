/**
 * Author: 李军
 * Date: 12-10-12
 * Time: 上午10:20
 *
 */
define(
    [
        'jquery',
        'underscore',
        'backbone',
        '../model/award'
    ], function($, _, Backbone, AwardModel){
        return Backbone.Collection.extend({

            model: AwardModel,

            initialize: function(options){
                this.url = 'user/family/list?userId=' + options.userId;
            }

        });
    }
);