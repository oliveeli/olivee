/**
 * Author: 李军
 * Date: 12-10-12
 * Time: 下午4:55
 *
 */
define([
    'jquery',
    'underscore',
    'backbone',
    './../model/sys-image',
    'text!modules-path/usermgr/tpl/upload-pic.html',
    'jquery.jcrop'
], function($, _, Backbone, SysImageModel, UploadPicTpl){

    return Backbone.View.extend({

        tagName: 'div',

        className: 'modal hide fade',

        events: {
            'click #confirm':'confirm',
            'click #cancel': 'cancel',
            'click #getData': 'getCropData'
        },

        template: _.template(UploadPicTpl),

        initialize: function(){
            _.extend(this, Backbone.Events);
            _.bindAll(this, 'confirm', 'cancel', 'loadFileSelect',  'setSelection', 'clearSelection', 'getCropData', 'uploadSuccess');
        },

        render: function(){
            var that = this;
            $(this.el).append(this.template());
            $(this.el).modal({backdrop: true});
            $(this.el).modal('show');
           
            var fileSelector = this.$('#file-selector');
            if ($.browser.msie)
            {
                fileSelector.click(function(event)
                {
                    setTimeout(function()
                    {
                        if(fileSelector.val().length > 0) {
                            that.loadFileSelect();
                        }
                    }, 0);
                });
            }
            else
            {
                fileSelector.change(this.loadFileSelect);
            }
            return this;
        },

        confirm: function(){
            var imgData = this.getCropData();
            if(!imgData){
                alert('请选择图片！');
                return;
            }
            var that = this;
            var model = new SysImageModel({data: imgData});
            model.save(model.toJSON(),{
                wait:true,
                success:function(model, resp, options){
                    that.uploadSuccess(model);
                },
                error: function(model, resp, options){
                    alert('保存图片失败！');
                }
            });
        },

        uploadSuccess: function(model){
            $(this.el).modal('hide');
            this.trigger('confirm', model);
            this.remove();
        },

        cancel: function(){
            $(this.el).modal('hide');
            this.trigger('cancel');
            this.remove();
        },
        
        loadFileSelect: function()
        {
            var that = this;
            if(that.jcropApi){
                that.jcropApi.destroy();
            }
            var fileSelector = this.$('#file-selector');
            var filesToUpload = fileSelector.get(0).files;
            var file = filesToUpload[0];

            this.img = this.$('img#crop-target').get(0);
            var reader = new FileReader();
            reader.onload = function(e) {
                that.img.src = e.target.result;
                that.jcropApi = that.$('#crop-target').Jcrop({
                    onChange:   that.setSelection,
                    onSelect:   that.setSelection,
                    onRelease:  that.clearSelection
                }).data('Jcrop');
            };
            reader.readAsDataURL(file);
        },

        setSelection: function(c){
            this.selection = c;
        },

        clearSelection: function(c){
            this.selection = null;
        },

        getCropData: function(){
            if(!this.selection){
                return '';
            }
            var temp_canvas1 = this.$('canvas').get(0);
            var temp_ctx1 = temp_canvas1.getContext('2d');
            temp_canvas1.width = this.selection.w;
            temp_canvas1.height = this.selection.h;
            temp_ctx1.drawImage(this.img, this.selection.x, this.selection.y, this.selection.w, this.selection.h, 0, 0, this.selection.w, this.selection.h);

            var temp_canvas = document.createElement('canvas');
            var temp_ctx = temp_canvas.getContext('2d');
            temp_canvas.width = this.selection.w;
            temp_canvas.height = this.selection.h;
            temp_ctx.drawImage(this.img, this.selection.x, this.selection.y, this.selection.w, this.selection.h, 0, 0, this.selection.w, this.selection.h);
            var vData = temp_canvas.toDataURL();
            return vData;
        }

    });

});