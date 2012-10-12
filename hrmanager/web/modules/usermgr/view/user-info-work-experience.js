/**
 * Author: 李军
 * Date: 12-10-11
 * Time: 下午4:05
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './../model/work-experience',
    './../collection/work-experiences',
    './user-info-work-experience-item',
    'text!modules-path/usermgr/tpl/user-info-work-experience.html'
], function($, _, Backbone, WorkExperienceModel, WorkExperienceCollection, WorkExperienceItemView, ViewTemplate){

    return Backbone.View.extend({

        template:_.template(ViewTemplate),

        events: {
            'click #add':'addNew'

        },

        initialize: function(){},

        render: function(){
            $(this.el).html(this.template(this.model.toJSON()));
            this.awards = new WorkExperienceCollection({userId: this.model.id});
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
            var itemView = new WorkExperienceItemView({model: awardModel}).render();
            this.$('.info-list-body').append($(itemView.el));
        },

        addNew: function(){
            this.addOne(
                new WorkExperienceModel({employeeid: this.model.id})
            );
        }

    });

});