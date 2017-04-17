PersonInfoFormPanel = new Ext.extend(Ext.form.FormPanel, {
	constructor:function(){
		PersonInfoFormPanel.superclass.constructor.call(this, {
			labelWidth:55,
			width:300,
			frame:true,
			defaultType:"textfield",
			baseCls:"x-plain",			
			items:[{
				fieldLabel:"姓名",
				name:"name",
				allowBlank:false,
				blankText:"姓名不能为空"
			},{
				fieldLabel:"年龄",
				name:"age"
				//vtype:"age"
			},{
				fieldLabel:"手机号码",
				name:"mobile"
			},{
				xtype:"datefield",
				fieldLabel:"生日",
				name:"birthday",
				format:"Y-m-d",
				editable:false
			}]
		});
	},
	getValues:function(){
		if(this.getForm().isValid())
			return new Ext.data.Record(this.getForm().getValues());
		else
			throw Error("表单验证未通过");
	},
	setValues:function(_r){
		this.getForm().loadRecord(_r);
	},
	reset:function(){
		this.getForm().reset();
	}
});


/**************************************************************************************/

PersonInfoWindow = Ext.extend(Ext.Window, {
	form:null,
	constructor:function(){
		this.form = new PersonInfoFormPanel();
		PersonInfoWindow.superclass.constructor.call(this, {
			plain:true,
			width:300,
			items:this.form,			
			resizable:false,
			bodyStyle:"padding:6px",
			modal:true,  //背景灰色不可用
			closeAction:"hide",   //点击关闭时隐藏，而不是从当前html中清除所有对象
			buttons:[{
				text:"确定",
				handler:this.onSubmitClick,
				scope:this
			},{
				text:"重置",
				handler:this.onCancelClick,
				scope:this
			}]
		});
		this.addEvents("submit");
	},
	close:function(){
		this.hide();
	},
	onSubmitClick:function(){
		try{
			this.fireEvent("submit", this, this.form.getValues());
		}catch(_err){
			return;
		}
		this.close();
		//alert(Ext.util.JSON.encode(this.form.getValues().data));
	},
	onCancelClick:function(){
		this.form.reset();
		//this.close();
	}
});

/**************************************************************************************/

InsertPersonInfoWindow = Ext.extend(PersonInfoWindow,{
	title:"添加人员"
});

/**************************************************************************************/

UpdatePersonInfoWindow = Ext.extend(PersonInfoWindow,{
	title:"修改人员",
	load:function(_r){
		this.form.setValues(_r);
	}
});

/**************************************************************************************/

PersonListGridPanel = Ext.extend(Ext.grid.GridPanel, {
	insertWin : new InsertPersonInfoWindow(),
	updateWin : new UpdatePersonInfoWindow,
	constructor:function(){		
		PersonListGridPanel.superclass.constructor.call(this, {
			renderTo:Ext.getBody(),					
			width:600,
			height:500,
			id:"view_grid",
			enableDragDrop:true,
			tbar:[{
				text:"添加人员",
				handler:function(){					
					this.insertWin.show();					
				},
				scope:this
			},"-",{
				text:"修改人员",
				handler:function(){
					this.updateWin.show();//组件呈现在show之后，所以，这里要先show
					try{
						this.updateWin.load(this.getSelected());
					}catch(_err){
						Ext.Msg.alert("系统提示", _err.description);
						this.updateWin.close();
					}
				},
				scope:this
			},"-",{
				text:"删除人员",
				handler:function(){
					Ext.Msg.confirm("系统提示", "确认要删除吗？", this.onRemovePerson, this);					
				},
				scope:this
			}],
			colModel:new Ext.grid.ColumnModel([{
				header:"手机号",
				menuDisabled:true,
				align:"center",
				dataIndex:"mobile"  //与数据列绑定
			},{
				header:"姓名",
				dataIndex:"name"
			},{
				header:"年龄",
				dataIndex:"age"
			},{
				header:"生日",
				dataIndex:"birthday"
			},{
				header:"号码归属地",
				dataIndex:"province"
			}]),
			store:new Ext.data.JsonStore({
				autoLoad:true,
				url:PersonListGridPanel.STORE_URL,
				fields:["mobile", "name", "birthday", "province"]
			}),
			selModel:new Ext.grid.RowSelectionModel({
				singleSelect:true,//单选
				listeners:{
					"rowselect":{
						fn:this.onRowSelect,
						scope:this
					}
				}
			})
		});
		this.insertWin.on("submit", this.onInsertWinSubmit, this);
		this.updateWin.on("submit", this.onUpdateWinSubimt, this);
		this.addEvents("rowselect");
	},
	insert:function(_r){
		this.getStore().add(_r);
	},
	update:function(_r){
		try{
			var _sr = this.getSelected();
			var _data = _sr.data;
			for(var _i in _data){
				_sr.set(_i, _r.get(_i));
			}
			_sr.commit();
			this.fireEvent("rowselect", _sr);  //修改之后触发rowselect事件
		}catch(_err){
			
		}
	},
	remove:function(){
		try{
			this.getStore().remove(this.getSelected());
			
			//删除之后，触发rowselect事件，清空下方显示表单值。
			this.fireEvent("rowselect", new Ext.data.Record({
				name:"",
				mobile:"",
				age:"",
				birthday:""
			}));
		}catch(_err){
			Ext.Msg.alert("系统提示", _err.description);
		}
	},
	onUpdateWinSubimt:function(_win, _r){
		this.update(_r);
	},
	onInsertWinSubmit:function(_win, _r){
		this.insert(_r);
	},
	onRemovePerson:function(_btn){
		if(_btn == "yes")
			this.remove();
	},
	getSelected:function(){
		var _sm = this.getSelectionModel();
		if(_sm.getCount() == 0)
			throw Error("你尚示选择记录");		
		return _sm.getSelected();
	},
	onRowSelect:function(_sel, _index, _r){
		this.fireEvent("rowselect", _r);
	}
});

PersonListGridPanel.STORE_URL = "/pbjson.jsp";


/*****************************************************************************************/



