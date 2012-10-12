/**
 * Author: 李军
 * Date: 12-10-11
 * Time: 下午4:02
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './../model/award',
    './../collection/awards',
    './user-info-award-item',
    'text!modules-path/usermgr/tpl/user-info-award.html'
], function($, _, Backbone, AwardModel, AwardCollection, AwardItemView, ViewTemplate){

    return Backbone.View.extend({

        template:_.template(ViewTemplate),

        events: {
            'click #add':'addNew'

        },

        initialize: function(){},

        render: function(){
            $(this.el).html(this.template(this.model.toJSON()));
            this.awards = new AwardCollection({userId: this.model.id});
            this.awards.on('reset', this.addAll, this);
            this.awards.on('add', this.addOne, this);
            if(!this.model.isNew()){
                this.awards.fetch();
            }
            return this;
        },

        addAll: function(){
            this.awards.each(this.addOne, this);
        },

        addOne: function(awardModel){
            var itemView = new AwardItemView({model: awardModel}).render();
            this.$('.info-list-body').append($(itemView.el));
        },

        addNew: function(){
            this.addOne(
                new AwardModel({employeeid: this.model.id})
            );
        }

    });

});
