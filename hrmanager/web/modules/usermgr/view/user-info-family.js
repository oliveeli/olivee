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
    './../model/family',
    './../collection/familys',
    './user-info-family-item',
    'text!modules-path/usermgr/tpl/user-info-family.html'
], function($, _, Backbone, FamilyModel, FamilyCollection, FamilyItemView, ViewTemplate){

    return Backbone.View.extend({

        template:_.template(ViewTemplate),

        events: {
            'click #add':'addNew'

        },

        initialize: function(){},

        render: function(){
            $(this.el).html(this.template(this.model.toJSON()));
            this.Familys = new FamilyCollection({userId: this.model.id});
            this.Familys.on('reset', this.addAll, this);
            this.Familys.on('add', this.addOne, this);
            if(!this.model.isNew()){
                this.Familys.fetch();
            }
            return this;
        },

        addAll: function(){
            this.Familys.each(this.addOne, this);
        },

        addOne: function(FamilyModel){
            var itemView = new FamilyItemView({model: FamilyModel}).render();
            this.$('.info-list-body').append($(itemView.el));
        },

        addNew: function(){
            this.addOne(
                new FamilyModel({employeeid: this.model.id})
            );
        }

    });

});