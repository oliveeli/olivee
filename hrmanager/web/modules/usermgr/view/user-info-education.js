/**
 * Author: 李军
 * Date: 12-10-11
 * Time: 下午4:09
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!modules-path/usermgr/tpl/user-info-education.html'
], function($, _, Backbone, ViewTemplate){

    return Backbone.View.extend({

        template:_.template(ViewTemplate),

        initialize: function(){

        },

        render: function(){
            this.template(this.model.toJSON());
            return this;
        }

    });

});
