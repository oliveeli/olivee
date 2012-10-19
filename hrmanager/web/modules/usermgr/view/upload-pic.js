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
            _.bindAll(this, 'confirm', 'cancel', 'uploadFileSelect',  'loadUploadFile', 'setSelection', 'clearSelection', 'getCropData', 'uploadSuccess', 'refreshProgress', 'updateProgress');
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
                            that.uploadFileSelect();
                        }
                    }, 0);
                });
            }
            else
            {
                fileSelector.change(this.uploadFileSelect);
            }


            this.$('#file-form').ajaxForm({
                beforeSubmit: function(arr, $form, options){
                    that.tokenId = new Date().getTime();
                    this.url = "upload/tmp/image?tokenId=" + that.tokenId;
                },
                beforeSend: function(arr, $form, options){
                    setTimeout(_.bind(function(){
                        this.refreshProgress();
                    },that),1000);
                },
                uploadProgress: function(event, position, total, percentComplete) {
                },
                complete: function(xhr) {
                }
            });

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
            this.destoryed = true;
        },

        cancel: function(){
            $(this.el).modal('hide');
            this.trigger('cancel');
            this.remove();
            this.destoryed = true;
        },
        
        uploadFileSelect: function()
        {
            var that = this;
            if(that.jcropApi){
                that.jcropApi.destroy();
            }

            this.$('#file-form').submit();

        },

        refreshProgress : function(){
            if(this.destoryed){
                return;
            }
            var that = this;
            this.tryToGetUploadStatusCount = 0;
            $.ajax({
                type: "post",
                url: "upload/tmp/status",
                data: {tokenId: that.tokenId, t: '' + new Date().getTime()},
                dataType: "json",
                success: function (data) {
                    that.updateProgress(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {

                }
            });
        },

        updateProgress : function(uploadInfo)
        {
            var progress = this.$('.progress');
            var bar = this.$('.progress .bar');
            var messageText = this.$('#message-text');

            var progressPercent;
            if (uploadInfo.status==='progress')
            {
                progressPercent = Math.ceil((uploadInfo.bytesRead / uploadInfo.totalSize) * 100);
                bar.attr('style', 'width:' + progressPercent +'%');
                setTimeout(this.refreshProgress, 1000);
                progress.css('visibility','visible');
                return;
            }

            progress.css('visibility','hidden');

            if(uploadInfo.status === 'init'){
                //  try to get upload status 3 times
                if((++this.tryToGetUploadStatusCount)<3){
                    setTimeout(this.refreshProgress, 1000);
                    return;
                }
            }

            if (uploadInfo.status==='start'){
                setTimeout(this.refreshProgress, 1000);
                return;
            }

            if(uploadInfo.status === 'success'){
                progressPercent = 100;
                bar.attr('style', 'width:' + progressPercent +'%');
                this.loadUploadFile(uploadInfo.result.image);
            }
            else if(uploadInfo.errorMessage)
            {
                messageText.html(uploadInfo.errorMessage);
            }
        },

        loadUploadFile: function(imageUrl){
            this.$('img#crop-target').attr('src', imageUrl);
            this.img = this.$('img#crop-target').get(0);
            this.jcropApi = this.$('#crop-target').Jcrop({
                onChange:   this.setSelection,
                onSelect:   this.setSelection,
                onRelease:  this.clearSelection
            }).data('Jcrop');
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

            /*
            //test
            var temp_canvas1 = this.$('canvas').get(0);
            var temp_ctx1 = temp_canvas1.getContext('2d');
            temp_canvas1.width = this.selection.w;
            temp_canvas1.height = this.selection.h;
            temp_ctx1.drawImage(this.img, this.selection.x, this.selection.y, this.selection.w, this.selection.h, 0, 0, this.selection.w, this.selection.h);
            */

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