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
            UserInfoEducationView, UserInfoAwardView, UserInfoVocationalCertificateView,
            UserInfoWorkExperienceView, ViewTemplate){

    return Backbone.View.extend({

        tagName: 'div',

        className: 'split-right-body-inner',


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

        renderAward: function(){
            if(this.hasRenderAward){
                return;
            }
            var userInfoAwardView = new UserInfoAwardView({
                model: this.model
            }).render();
            this.$('#user-info-award').html($(userInfoAwardView.el));
            this.hasRenderAward = true;
        },

        renderEducation: function(){
            if(this.hasRenderEducation){
                return;
            }
            var userInfoEducationView = new UserInfoEducationView({
                model: this.model
            }).render();
            this.$('#user-info-education').html($(userInfoEducationView.el));
            this.hasRenderEducation = true;
        },

        renderFamily: function(){
            if(this.hasRenderFamily){
                return;
            }
            var userInfoFamilyView = new UserInfoFamilyView({
                model: this.model
            }).render();
            this.$('#user-info-family').html($(userInfoFamilyView.el));
            this.hasRenderFamily = true;
        },

        renderVocationalCertificate: function(){
            if(this.hasRenderVocationalCertificate){
                return;
            }
            var userInfoVocationalCertificateView = new UserInfoVocationalCertificateView({
                model: this.model
            }).render();
            this.$('#user-info-vocational-certificate').html($(userInfoVocationalCertificateView.el));
            this.hasRenderVocationalCertificate = true;
        },

        renderWorkExperience: function(){
            if(this.hasRenderWorkExperience){
                return;
            }
            var userInfoWorkExperienceView = new UserInfoWorkExperienceView({
                model: this.model
            }).render();
            this.$('#user-info-work-experience').html($(userInfoWorkExperienceView.el));
            this.hasRenderWorkExperience = true;
        },


        showBasic: function(){
            $('#user-info-basic-link').tab('show');
        },

        showAward: function(){
            if(this.model.isNew()){
            	alert('请先保存基本信息!');
                return;
            }
            this.renderAward();
            $('#user-info-award-link').tab('show');
        },

        showEducation: function(){
            if(this.model.isNew()){
            	alert('请先保存基本信息!');
                return;
            }
            this.renderEducation();
            $('#user-info-education-link').tab('show');
        },

        showFamily: function(){
            if(this.model.isNew()){
            	alert('请先保存基本信息!');
                return;
            }
            this.renderFamily();
            $('#user-info-family-link').tab('show');
        },

        showVocationalCertificate: function(){
            if(this.model.isNew()){
            	alert('请先保存基本信息!');
                return;
            }
            this.renderVocationalCertificate();
            $('#user-info-vocational-certificate-link').tab('show');
        },

        showWorkExperience: function(){
            if(this.model.isNew()){
            	alert('请先保存基本信息!');
                return;
            }
            this.renderWorkExperience();
            $('#user-info-work-experience-link').tab('show');
        }

    });

});
