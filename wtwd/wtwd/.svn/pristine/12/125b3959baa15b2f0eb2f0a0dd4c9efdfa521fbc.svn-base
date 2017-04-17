HTMLEditor = Ext.extend(Ext.form.HtmlEditor, {     
    addImage : function() {  
        var editor = this;    
        var imgform = new Ext.FormPanel({    
            region : 'center',
            labelWidth : 55,
            frame : true,
            bodyStyle : 'padding:5px 5px 0', 
            border : false,  
            items : [
                  {
                        xtype : 'textfield',
                        fieldLabel : '选择文件',  
                        name : 'userfile',  
                        inputType : 'file',     
                        allowBlank : false,
                        blankText : '文件不能为空', 
                        height : 25, 
                        anchor : '90%'  
                    }],
            buttons : [{
                text : '上传',
                type : 'submit',
                handler: insertimag 
            }, {
                text : '关闭', 
                type : 'submit',
                handler: function(){
                   win.hide(); 
                }
            }]
        })
        var win = new Ext.Window({
                    title : "上传图片", 
                    width : 300,
                    height : 200,
                    border : false,
                    iconCls : 'insertpict',    
                    plain:true, 
                    layout : "fit",
                    items: imgform     
                }); 
         win.show();    
         editor.deferFocus();   
        //添加图片
        function insertimag(){ 
            var furl=""; 
            furl=imgform.form.findField('userfile').getValue();      
            var type=furl.substring(furl.length-3).toLowerCase();
            if (furl==""||furl==null) {return;}
            if(type!='jpg'&&type!='bmp'&&type!='gif'&&type!='png'){
              Ext.Msg.alert('提示','仅支持jpg、bmp、gif、png格式的图片');  
              return;
            }  
        //=============================================
          var msgTipe = Ext.MessageBox.show({
            title:'提示', 
            width: 250,
            msg:'正在保存请稍侯.......' 
         });
         Ext.Ajax.request({
            url:'../questionAction.do?method=uploadimg',       
            params: { 
                furl: furl 
            },
            method: 'POST',
            success: function(response,options){ 
              msgTipe.hide();  
              var str = response.responseText;   
              if(str.trim()!='null'){      
                  Ext.Msg.alert('上传','上传成功！');  
                  var element = document.createElement("img");      
                     element.src = str.trim();     
                     if(Ext.isIE) { 
                      editor.win.focus(); 
                      var r = editor.doc.selection.createRange();
                      if(r){
                         r.collapse(true);
                         r.pasteHTML(element.outerHTML);   
                         editor.syncValue(); 
                         editor.deferFocus();
                      } 
                       // editor.insertAtCursor(element.outerHTML);        
                     } 
                     else{ 
                        var selection = editor.win.getSelection();   
                        if (!selection.isCollapsed) {  
                             selection.deleteFromDocument();   
                        } 
                       selection.getRangeAt(0).insertNode(element); 
                     }
                     imgform.form.reset(); 
                     win.hide(); 
               }else{
                 Ext.Msg.alert('警告','上传失败！');      
                 return;  
              } 
            },
            failure: function(){
               msgTipe.hide(); 
               Ext.Msg.alert('提示','上传信息请求失败！'); 
            }
        }); 
         }
    },
    createToolbar : function(editor) {
      HTMLEditor.superclass.createToolbar.call(this, editor);  
      this.tb.insertButton(16, {    
        itemId: 'image',   
        iconCls: 'insertpict',  
        handler: this.addImage, 
        scope: this,
        clickEvent: 'mousedown',
        tooltip: { 
          title: 'insert img',
          text: '插入图片到编辑器',
          cls: 'x-html-editor-tip'  
        }
      });
    }  
});
Ext.reg('StarHtmleditor', HTMLEditor);