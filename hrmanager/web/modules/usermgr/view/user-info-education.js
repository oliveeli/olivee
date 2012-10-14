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
    './../model/education',
    './../collection/educations',
    './user-info-education-item',
    'text!modules-path/usermgr/tpl/user-info-education.html'
], function($, _, Backbone, EducationModel, EducationCollection, EducationItemView, ViewTemplate){

    return Backbone.View.extend({

        template:_.template(ViewTemplate),

        events: {
            'click #add':'addNew'

        },

        initialize: function(){},

        render: function(){
            $(this.el).html(this.template(this.model.toJSON()));
            this.awards = new EducationCollection({userId: this.model.id});
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
            var itemView = new EducationItemView({model: awardModel}).render();
            this.$('.info-list-body').append($(itemView.el));
        },

        addNew: function(){
            this.addOne(
                new EducationModel({employeeid: this.model.id})
            );
        }

    });

});
