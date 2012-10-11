/**
 * Author: 李军
 * Date: 12-10-11
 * Time: 下午3:58
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './user-info-basic',
    './user-info-family',
    './user-info-education',
    './user-info-award',
    './user-info-vocational-certificate',
    './user-info-work-experience',
    'text!modules-path/usermgr/tpl/user-info-tab.html'
], function($, _, Backbone, UserInfoBasicView, UserInfoFamilyView,
            UserInfoEducationView, UserInfoAward, UserInfoVocationalCertificateView,
            UserInfoWorkExperienceView, ViewTemplate){

    return Backbone.View.extend({

        tagName: 'div',


        events: {
            'click #user-info-basic-link'                   :'showBasic',
            'click #user-info-award-link'                   :'showAward',
            'click #user-info-education-link'               :'showEducation',
            'click #user-info-family-link'                  :'showFamily',
            'click #user-info-vocational-certificate-link'  :'showVocationalCertificate',
            'click #user-info-work-experience-link'         :'showWorkExperience'
        },

        template:_.template(ViewTemplate),

        initialize: function(){

        },

        render: function(){
            $(this.el).html(this.template(this.model.toJSON()));
            this.renderBasic();
            return this;
        },

        renderBasic: function(){
            var userInfoBasicView = new UserInfoBasicView({
                model: this.model,
                orgModel: this.options.orgModel
            }).render();
            this.$('#user-info-basic').html($(userInfoBasicView.el));
        },

        showBasic: function(){
            $('#user-info-basic-link').tab('show');
        },

        showAward: function(){
            $('#user-info-award-link').tab('show');
        },

        showEducation: function(){
            $('#user-info-education-link').tab('show');
        },

        showFamily: function(){
            $('#user-info-family-link').tab('show');
        },

        showVocationalCertificate: function(){
            $('#user-info-vocational-certificate-link').tab('show');
        },

        showWorkExperience: function(){
            $('#user-info-work-experience-link').tab('show');
        }

    });

});
