/*************************************************************************************************************/
/**************************************常用信息*****************************************************************/
CommonForm = Ext.extend(Ext.Panel,{
	constructor:function(){
		CommonForm.superclass.constructor.call(this, {
			waitMsgTarget:true,   //载入时的消息提示框定位在本身，不建议使用			
			frame:true,			
			plain:true,			
			baseCls:"x-plain",			
			labelWidth:55,
			buttonAlign:"right",
			closeAction:"hide",   //点击关闭时隐藏，而不是从当前html中清除所有对象			
			layout:"form",
			items:[{
				baseCls:"x-plain",
				layout:"column",						
				items:[{
					labelWidth:55,							
					baseCls:"x-plain",
					columnWidth:.5,
					layout:"form",
					defaultType:"textfield",
					defaults:{width:152},
					items:[{
						fieldLabel:"姓名",
						name:"info.name",
						allowBlank:false,
						blankText:"出错啦,姓名必须填写",
						emptyText:"姓名必须填写"
					},{
						xtype:"combo",
						editable:false,
						fieldLabel:"性别",
						displayField:"_sex",
						mode:"local",
						triggerAction:"all",
						value:"1",
						hiddenName:"info.sex",
						valueField:"id",
						store:new Ext.data.JsonStore({
							fields:["id","_sex"],
							data:[{id:"1", _sex:"男"},{id:"0",_sex:"女"}]
						})
					},{
						fieldLabel:"常用手机",
						allowBlank:false,
						emptyText:"手机必须填写",
						blankText:"出错啦,手机号码不能为空",
						name:"info.mobile"
					},{
						fieldLabel:"备用手机",
						name:"info.mobile2"
					},{
						fieldLabel:"QQ",
						name:"info.QQ"
					},{
						fieldLabel:"MSN",
						name:"info.msn"
					},{
						fieldLabel:"电子邮件",
						name:"info.email",						
						vtype:"email"  //邮箱格式验证
					}]
				},{
					columnWidth:.5,							
					baseCls:"x-plain",
					layout:"form",
					labelWidth:55,					
					items:{
						xtype:"textfield",
						fieldLabel:"当前头像",
						inputType:"image",
						width:155,
						height:170
					}					
				}]
			},{						
				xtype:"textfield",
				fieldLabel:"微博地址",						
				width:400,
				name:"info.tblog"
			},{						
				xtype:"textfield",
				fieldLabel:"常住地址",						
				width:400,
				name:"info.address"
			},{						
				xtype:"panel",
				layout:"column",
				baseCls:"x-plain",   //这里连续加了两次处理底色
				defaults:{baseCls:"x-plain"},  //还加了一个这个defaults，两个一起处理才ok
				items:[{
					columnWidth:.4,
					layout:"form",
					labelWidth:55,
					items:{						
						xtype:"combo",								
						fieldLabel:"分组",						
						anchor:"100%",
						displayField:"text",
						editable:false,
						triggerAction:"all",
						hiddenName:"info.pgroup",
						value:"1",
						valueField:"id",						
						listeners:{
							select:function(_combo, _record, _index){
								_combo["selectItem"] = _record;
							}
						},
						store:new Ext.data.JsonStore({
							fields:["id","text"],
							autoLoad:"true",								
							url:"/combGroupList"
						})
					}						
				}]
			}]				
		});
	}
});

/*************************************************************************************************************/
/**************************************个人信息FormPanel*******************************************************/
PrivateForm = Ext.extend(Ext.Panel, {
	constructor:function(){
		PrivateForm.superclass.constructor.call(this, {
			frame:true,			
			plain:true,			
			baseCls:"x-plain",			
			labelWidth:55,
			buttonAlign:"right",
			closeAction:"hide", 
			defaultType:"textfield",
			defaults:{width:160},
			layout:"form",
			items:[{
				fieldLabel:"昵称",
				name:"info.nickName"
			},{
				fieldLabel:"语言",
				name:"info.language"
			},{
				xtype:"datefield",
				fieldLabel:"生日",
				format:"Y-m-d",
				editable:false,
				name:"info.birthday"
			},{
				fieldLabel:"星座",
				xtype:"combo",				
				hiddenName:"info.constellation",
				editable:false,
				displayField:"value",
				triggerAction:"all",
				mode:"local",
				value:"1",
				valueField:"id",
				store:new Ext.data.JsonStore({					
					fields:["id", "value"],					
					data:[{
						id:"1", value:"白羊座"
					},{
						id:"2", value:"金牛座"
					},{
						id:"3", value:"双子座"
					},{
						id:"4", value:"巨蟹座"
					},{
						id:"5", value:"狮子座"
					},{
						id:"6", value:"处女座"
					},{
						id:"7", value:"天枰座"
					},{
						id:"8", value:"天蝎座"
					},{
						id:"9", value:"射手座"
					},{
						id:"10", value:"摩羯座"
					},{
						id:"11", value:"水瓶座"
					},{
						id:"12", value:"双鱼座"
					}]
				})
			},{
				fieldLabel:"血型",
				xtype:"combo",
				name:"info.blood",
				displayField:"blood",
				mode:"local",
				editable:false,
				triggerAction:"all",
				value:"A",
				store:new Ext.data.SimpleStore({					
					fields:["blood"],
					data:[["A"],["B"],["O"],["AB"],["H"]]
				})
			},{
				fieldLabel:"SkypeID",
				name:"info.SkypeID"
			},{
				fieldLabel:"个人商城",
				name:"info.shopeSpace",
				width:400
			},{
				fieldLabel:"个人主页",
				name:"info.blog",
				width:400
			}]
		});
	}
});


/*************************************************************************************************************/
/**************************************家庭信息FormPanel*******************************************************/
FamilyForm = Ext.extend(Ext.Panel, {
	constructor:function(){
		FamilyForm.superclass.constructor.call(this, {
			frame:true,			
			plain:true,			
			baseCls:"x-plain",			
			labelWidth:55,
			buttonAlign:"right",
			closeAction:"hide", 
			defaultType:"textfield",
			defaults:{width:160},
			layout:"form",
			items:[{
				fieldLabel:"家庭固话",
				name:"info.homeTel"
			},{
				fieldLabel:"家庭传真",
				name:"info.homeFox"
			},{
				fieldLabel:"家庭邮箱",
				name:"info.homeEmail"
			},{
				fieldLabel:"家庭邮编",
				name:"info.homePostCode"
			},{
				fieldLabel:"家庭地址",
				name:"info.homeStree",
				width:400
			}]
		});
	}
});

/*************************************************************************************************************/
/**************************************公司信息FormPanel*******************************************************/
CompanyForm = Ext.extend(Ext.Panel, {
	constructor:function(){
		CompanyForm.superclass.constructor.call(this, {
			frame:true,			
			plain:true,			
			baseCls:"x-plain",			
			labelWidth:55,
			buttonAlign:"right",
			closeAction:"hide", 
			defaultType:"textfield",
			defaults:{width:160},
			layout:"form",
			items:[{
				fieldLabel:"行业",
				name:"info.calling"
			},{
				fieldLabel:"公司名称",
				name:"info.companyName"
			},{
				fieldLabel:"部门",
				name:"info.department"
			},{
				fieldLabel:"职务",
				name:"info.job"
			},{
				fieldLabel:"公司电话",
				name:"info.companyTel"
			},{
				fieldLabel:"公司邮箱",
				name:"info.companyEmail"
			},{
				fieldLabel:"公司传真",
				name:"info.companyFox"
			},{
				fieldLabel:"公司邮编",
				name:"info.companyPostCode"
			},{
				fieldLabel:"公司主页",
				name:"info.companyWeb",
				width:400
			},{
				fieldLabel:"公司地址",
				name:"info.companyStreet",
				width:400
			}]
		});
	}
});


/*************************************************************************************************************/
/**************************************主TabPanel*************************************************************/
UserTabPanel = Ext.extend(Ext.TabPanel, {
	_commonForm:null,
	_privateForm:null,
	_familyForm:null,
	_companyForm:null,
	constructor:function(){
		this._commonForm = new CommonForm();
		this._privateForm = new PrivateForm();
		this._familyForm = new FamilyForm();
		this._companyForm = new CompanyForm();
		UserTabPanel.superclass.constructor.call(this, {
			width:460,
			height:290,
			frame:true,
			plain:true,
			baseCls:"x-plain",
			activeTab:0,
			defaults:{baseCls:"x-plain"},
			lazyLoad:false,			
			items:[{
				title:"常用信息",
				items:this._commonForm,
				listeners:{
					"activate":{
						fn:this.updateUserFace,
						scope:this
					}
				}
			},{
				title:"个人信息",
				items:this._privateForm
			},{
				title:"公司信息",
				items:this._companyForm
			},{
				title:"家庭信息",
				items:this._familyForm
			},{
				title:"编辑头像",
				autoShow:true,
				html:"<iframe id='faceIframe' width='100%' height='100%' frameborder=0 src='/getFace?info.id=0' scrolling='auto'></iframe>",
				listeners:{
					"activate":{
						fn:this.updateFace,
						scope:this
					}
				}
			}]
		});
	},	
	updateFace:function(){		
		var _uid = 0;		
		if(this["_id"] != null){
			_uid = this["_id"];			
			var _html = "<iframe id='faceIframe' width='100%' height='100%' frameborder=0 src='/getFace?info.id=" + _uid + "' scrolling='auto'></iframe>";			
			this.getActiveTab().update(_html);
		}		
	},
	updateUserFace:function(){		
		var _commonForm = this._commonForm;
		if(this["_id"] != null){
			Ext.Ajax.request({
				url:"printFace",
				params:{"info.id":this["_id"]},
				success:function(response, opts){
					_commonForm.findByType("textfield")[7].getEl().dom.src = response.responseText;					
				}
			});
		}else{
			_commonForm.findByType("textfield")[7].getEl().dom.src = "/face/d.jpg";
		}
	}
});


/*************************************************************************************************************/
/**************************************人员信息FormPanel*******************************************************/
UserForm = Ext.extend(Ext.form.FormPanel, {
	_userTabPanel:null,
	constructor:function(){
		this._userTabPanel = new UserTabPanel();
		UserForm.superclass.constructor.call(this, {					
			baseCls:"x-plain",
			reader:new Ext.data.JsonReader({
				root:"data",
				fields:[
				/**************常用信息*****************/
				{name:"info.name", mapping:"name"},
				{name:"info.sex", mapping:"sex"},
				{name:"info.mobile", mapping:"mobile"},
				{name:"info.mobile2", mapping:"mobile2"},
				{name:"info.QQ", mapping:"QQ"},
				{name:"info.msn", mapping:"msn"},
				{name:"info.address", mapping:"address"},
				{name:"info.email", mapping:"email"},
				{name:"info.tblog", mapping:"tblog"},
				{name:"info.pgroup", mapping:"pgroup"},
				{name:"info.face", mapping:"face"},
				{name:"info.id", mapping:"id"},				
				
				/*************个人信息******************/
				{name:"info.nickName", mapping:"nickName"},
				{name:"info.language", mapping:"language"},
				{name:"info.birthday", mapping:"birthday"},
				{name:"info.constellation", mapping:"constellation"},
				{name:"info.blood", mapping:"blood"},
				{name:"info.SkypeID", mapping:"skypeID"},
				{name:"info.shopeSpace", mapping:"shopeSpace"},
				{name:"info.blog", mapping:"blog"},
				
				/*************公司信息******************/
				{name:"info.calling", mapping:"calling"},
				{name:"info.companyName", mapping:"companyName"},
				{name:"info.department", mapping:"department"},
				{name:"info.job", mapping:"job"},
				{name:"info.companyTel", mapping:"companyTel"},
				{name:"info.companyEmail", mapping:"companyEmail"},
				{name:"info.companyFox", mapping:"companyFox"},
				{name:"info.companyWeb", mapping:"companyWeb"},
				{name:"info.companyStreet", mapping:"companyStreet"},
				{name:"info.companyPostCode", mapping:"companyPostCode"},
				
				/*************家庭信息******************/
				{name:"info.homeTel", mapping:"homeTel"},
				{name:"info.homeFox", mapping:"homeFox"},
				{name:"info.homeEmail", mapping:"homeEmail"},
				{name:"info.homePostCode", mapping:"homePostCode"},
				{name:"info.homeStreet", mapping:"homeStreet"}]
			}),
			items:this._userTabPanel
		});	
	}	
});


/*************************************************************************************************************/
/**************************************人员信息Window***********************************************************/

UserWindow = Ext.extend(Ext.Window,{
	_userForm:null,
	constructor:function(){
		this._userForm = new UserForm();
		UserWindow.superclass.constructor.call(this, {
			width:490,
			height:365,
			frame:true,
			plain:true,
			modal:true,
			bodyStyle:"padding:6px",			
			items:[this._userForm],
			closeAction:"hide",
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
	},
	close:function(){
		this.hide();
	},
	onSubmitClick:function(){
		try{
			this.fireEvent("submit", this, this._userForm);
		}catch(_err){
			alert(_err);
			return;
		}
		//this.close();
	},
	onCancelClick:function(){
		this._userForm.getForm().reset();
	}	
});


/*************************************************************************************************************/
/**************************************修改人员信息*************************************************************/
UpdateUserWindow = Ext.extend(UserWindow, {
	title:"修改人员",	
	onLoad:function(){		
		this._userForm.getForm().load({
			url:"/linkManInfo",
			method:"post",
			params:{id:this["_id"]}
		});		
	}
});

/*************************************************************************************************************/
/**************************************创建人员窗口************************************************************/
CreateUserWindow = Ext.extend(UserWindow, {
	title:"添加人员"	
});


/*************************************************************************************************************/
/*******************************************组别右键菜单一********************************************************/
GroupMenu = Ext.extend(Ext.menu.Menu, {
	constructor:function(){
		GroupMenu.superclass.constructor.call(this, {
			items:[{
				text:"添加分组",
				iconCls:"add",				
				handler:this.onInsertGroup,
				scope:this
			},{
				text:"删除组别",
				iconCls:"del",
				handler:this.onDeleteGroup,
				scope:this
			}]
		});
	},
	onInsertGroup:function(){
		this.fireEvent("insertGroup", this);
	},
	onDeleteGroup:function(){
		this.fireEvent("deleteGroup", this);
	}
});

/*************************************************************************************************************/
/*******************************************组别右键菜单二*******************************************************/
GroupMenu2 = Ext.extend(Ext.menu.Menu, {
	constructor:function(){
		GroupMenu2.superclass.constructor.call(this, {
			items:[{
				text:"添加分组",
				iconCls:"add",				
				handler:this.onInsertGroup,
				scope:this
			},{
				text:"删除组别",
				iconCls:"del",
				disabled:true
			}]
		});
	},
	onInsertGroup:function(){
		this.fireEvent("insertGroup", this);
	}
});


/*************************************************************************************************************/
/*******************************************人员右键菜单********************************************************/
UserMenu = Ext.extend(Ext.menu.Menu, {
	constructor:function(){
		UserMenu.superclass.constructor.call(this, {
			items:[{
				text:"删除人员",
				handler:this.onDeleteUser,
				iconCls:"del",
				scope:this
			},{
				text:"编辑人员",
				handler:this.onUpdateUser,
				iconCls:"edit",
				scope:this
			},{
				text:"添加人员",
				iconCls:"add",
				handler:this.onCreateUser,
				scope:this
			}]
		});
	},
	onDeleteUser:function(){
		this.fireEvent("deleteUser", this);
	},
	onUpdateUser:function(){
		this.fireEvent("updateUser", this);
	},
	onCreateUser:function(){
		this.fireEvent("createUser", this);
	}
});

/*************************************************************************************************************/
/**************************************联系人列表树panel********************************************************/
SimpleTreePanel = Ext.extend(Ext.tree.TreePanel, {
	_groupMenu:null,
	_groupMenu2:null,
	_userMenu:null,
	_createWindow:null,
	_updateWindow:null,
	constructor:function(){
		this._createWindow = new CreateUserWindow();
		this._updateWindow = new UpdateUserWindow();		
		this._userMenu = new UserMenu();
		this._groupMenu = new GroupMenu();
		this._groupMenu2 = new GroupMenu2();		
		SimpleTreePanel.superclass.constructor.call(this, {			
			anchor:"100%",
			rootVisible: false,
			animate:true,
			lines:false,			
			useArrows:true,
			frame:true,			
			autoScroll:true,
			baseCls:"x-plain",
			enableDD:true,
			//singleClickExpand:true,
			tbar:[ ' ',
			new Ext.form.TextField({
				width: 140,
				emptyText:'查找联系人',
                enableKeyEvents: true,
				listeners:{
					render: function(f){
                    	this.filter = new Ext.tree.TreeFilter(this, {
                    		clearBlank: true,
                    		autoClear: true
                    	});
					},
                    keydown: {
                        fn: this.filterTree,
                        buffer: 350,
                        scope: this
                    },
                    scope: this
				}
			}), ' ', ' ',
			{
                iconCls: 'icon-expand-all',
				tooltip: '全部展开',
                handler: function(){ this.root.expand(true); },
                scope: this
            }, '-', {
                iconCls: 'icon-collapse-all',
                tooltip: '全部收起',
                handler: function(){ this.root.collapse(true); },
                scope: this
            }],
			
			loader:new Ext.tree.TreeLoader({
				preloadChildren:true,
				dataUrl:"/linkManList"				
			}),
			root:new Ext.tree.AsyncTreeNode({
				singleClickExpand:true,				
				text:"我的脉客",
				id:"0"
			}),			
			listeners:{
				"contextmenu":{
					fn:this.onContextmenu,
					scope:this
				},
				"dblclick":{
					fn:this.onUpdateUser,
					scope:this
				},
				"click":function(_node, _e){
					this._userMenu["currentNode"] = _node;
					if(_node.parentNode.id != 0){
						var nodeArray = _node.parentNode.childNodes;						
						for(var i = 0; i < nodeArray.length; i++){							
							if(nodeArray[i].id == _node.id){
								_node.getUI().getIconEl().style.height = 40;
								_node.getUI().getIconEl().style.width = 40;
							}else{
								nodeArray[i].getUI().getIconEl().style.height = 22;
								nodeArray[i].getUI().getIconEl().style.width = 22;
							}
						}					
					}
				},
				"movenode":{
					fn:this.moveLinkMan,
					scope:this
				}
			}
		});		
		this.hiddenPkgs = [];
		this._updateWindow.on("submit", this.updateLinkMan, this);
		this._createWindow.on("submit", this.insertLinkMan, this);
		this._groupMenu.on("insertGroup", this.onInsertGroup, this);		
		this._groupMenu.on("deleteGroup", this.onDeleteGroup, this);
		this._groupMenu2.on("insertGroup", this.onInsertGroup, this);
		this._userMenu.on("createUser", this.onCreateUser, this);
		this._userMenu.on("updateUser", this.onUpdateUser, this);
		this._userMenu.on("deleteUser", this.onDeleteUser, this);		
	},
	filterTree: function(t, e){
		var text = t.getValue();		
		Ext.each(this.hiddenPkgs, function(n){
			n.ui.show();
		});
		if(!text){
			this.filter.clear();
			return;
		}
		this.expandAll();
		
		var re = new RegExp('^' + Ext.escapeRe(text), 'i');
		this.filter.filterBy(function(n){
			return !n.attributes.isClass || re.test(n.text);
		});		
		
		this.hiddenPkgs = [];
                var me = this;
		this.root.cascade(function(n){
			if(!n.attributes.isClass && n.ui.ctNode.offsetHeight < 3 && !re.test(n.text)){
				n.ui.hide();
				me.hiddenPkgs.push(n);
			}
		});
	},
	moveLinkMan:function(_tree, _node, _oldParent, _newParent, _index){		
		//原组别人数-1.				
		var nodeName = _oldParent.text;				
		var users = parseInt(nodeName.substring(nodeName.indexOf("(") + 1, nodeName.length - 1)) - 1;
		nodeName = nodeName.substring(0, nodeName.indexOf("("));
		_oldParent.setText(nodeName + "(" + users + ")");		
		
		//新组别人数+1					
		nodeName = _newParent.text;
		users = parseInt(nodeName.substring(nodeName.indexOf("(") + 1, nodeName.length - 1)) + 1;
		nodeName = nodeName.substring(0, nodeName.indexOf("("));
		_newParent.setText(nodeName + "(" + users + ")");
		if(_newParent.id != 0){
			Ext.Ajax.request({
				url:"updateUserGroup",
				params:{
					"info.id":_node.id,
					"info.pgroup":_newParent.id
				}
			});
		}
	},
	insertLinkMan:function(_win, _userForm){		
		if(_userForm.getForm().isValid()){
			var _selectGroupId = _userForm.findByType("combo")[1].value;
			var groups = this.getRootNode().childNodes;
			var _node;
			for(var i = 0; i < groups.length; i++){			
				if(groups[i].id == _selectGroupId){
					_node = groups[i];
					break;
				}
			}
			var _groupName = _node.text;			
			var users = parseInt(_groupName.substring(_groupName.indexOf("(") + 1, _groupName.length - 1)) + 1;		
			_groupName = _groupName.substring(0, _groupName.indexOf("("));
			_node.setText(_groupName + "(" + users + ")");
			_userForm.getForm().submit({
				url: '/create',
				method:"post",
				waitMsg:"数据提交中...",
				success:function(_form, action) {					
			       	Ext.Msg.alert('系统提示!', action.result.msg);
			    },
			    failure:function(_form, action){
			    	Ext.Msg.alert("系统提示!", action.result.msg);
			    }
			});
			_win.close();	
		}
	},
	updateLinkMan:function(_win, _userForm){
		var _node = this._userMenu["currentNode"];
		if(_userForm.getForm().isValid()){			
			_node.setText(_userForm.findByType("textfield")[0].getValue());   //联系人名称始终取最新值						
			_userForm.getForm().submit({				
				url: '/update',
				method:"post",				
				waitMsg:"数据提交中...",
				params:{"info.id":_win["_id"]},
				success:function(_form, action) {					
			       	Ext.Msg.alert('系统提示!', action.result.msg);
			    },
			    failure:function(_form, action){
			    	Ext.Msg.alert("系统提示!", action.result.msg);
			    }
			});			
			_win.close();			
		}
		Ext.Ajax.request({
			url:"/printFace",
			params:{"info.id":_node.id},
			success:function(response, opt){
				_node.getUI().getIconEl().src = response.responseText;
			}
		});		
	},
	onUpdateUser:function(){		
		var _node = this._userMenu["currentNode"];
		if(_node != null && _node.parentNode != null && _node.parentNode.id != 0){			
			this._updateWindow["_id"] = _node.id;
			this._updateWindow._userForm._userTabPanel["_id"] = _node.id;
			this._updateWindow.show();
			this._updateWindow.onLoad();
			var _updateWindow = this._updateWindow;			
			var activeTab = this._updateWindow._userForm._userTabPanel.getActiveTab();
			//这里将来考虑取消，这里请求一次，tabPanel中再请求一次，初始化时会请求两次。
			if(activeTab.title == "常用信息"){
				Ext.Ajax.request({
					url:"printFace",
					params:{"info.id":_updateWindow["_id"]},
					success:function(response, opts){
						_updateWindow.findByType("textfield")[7].getEl().dom.src = response.responseText;
					}
				});	
			}
			
			//如果编辑头像默认选择中，不加此处代码，则头像不会重新加载。			
			if(activeTab.title == "编辑头像"){
				var _html = "<iframe id='faceIframe' width='100%' height='100%' frameborder=0 src='/getFace?info.id=" + _updateWindow["_id"] + "' scrolling='auto'></iframe>";
				activeTab.update(_html);			
			}			
		}
	},
	onContextmenu:function(_node, _e){
		this._userMenu["currentNode"] = _node;		
		var rootNodeId = _node.parentNode.id;		
		if(rootNodeId == 0){
			if(_node.id > 3){				
				this._groupMenu.showAt(_e.getXY());
			}else{
				this._groupMenu2.showAt(_e.getXY());
			}						
		}else{
			this._userMenu.showAt(_e.getXY());
		}		
	},	
	onDeleteGroup:function(){
		var _node = this._userMenu["currentNode"];
		Ext.Msg.confirm("系统提示", "你确认要删除 [" + _node.text + "] 吗？该组别联系人将只在所有组别中可见.", this.onDeleteGroupConfirm, this);
	},
	onDeleteGroupConfirm:function(_btn){
		if(_btn == "yes"){
			var _id = this._userMenu["currentNode"].id;
			this._userMenu["currentNode"].remove();
			Ext.Ajax.request({
				url:"/delGroup",
				params:{"groupInfo.id":_id}
			});
		}
	},
	onDeleteUser:function(){
		var _node = this._userMenu["currentNode"];
		if(_node != null && _node.parentNode != null && _node.parentNode.id != 0){
			var _userName = _node.text;
			Ext.Msg.confirm("系统提示", "你确认要删除 [" + _userName + "] 吗？", this.onDeleteUserConfirm, this);
		}else{
			Ext.Msg.alert("系统提示", "你尚未选择任何联系人!");
		}
	},
	onDeleteUserConfirm:function(_btn){
		if(_btn == "yes"){
			var _node = this._userMenu["currentNode"];
			var _id = _node.id;
			var _groupName = _node.parentNode.text;
			var users = _groupName.substring(_groupName.indexOf("(") + 1, _groupName.length - 1);
			if(users > 0){
				users = users - 1;
				_groupName = _groupName.substring(0, _groupName.indexOf("("));
				_node.parentNode.setText(_groupName + "(" + users + ")");
			}
			_node.remove();
			Ext.Ajax.request({
				url:"/delete",
				params:{id:_id}
			});
		}
	},
	onInsertGroup:function(){
		Ext.Msg.prompt("新建组别", "请输入组别名称", this.onInsertGroupNode, this);
	},
	onInsertGroupNode:function(_btn, _text){
		if(_btn == "ok"){
			var _node = this.getRootNode();
			Ext.Ajax.request({
				url:"/createGroup",
				params:{"groupInfo.name":_text},
				success:function(response, opts){
					var _groupId = response.responseText;					
					_node.insertBefore(new Ext.tree.AsyncTreeNode({
						text:_text + "(0)",
						id:_groupId
					}), _node.lastChild);					
				},
				failure:function(response, opts){
					Ext.Msg.alert("系统提示", "Sorry!新增组别失败...");
				}
			});			
		}
	},
	onCreateUser:function(){
		this._createWindow.show();	
	}
});

/*************************************************************************************************************/
/****************************************上传文件Form***********************************************************/
UploadFileForm = Ext.extend(Ext.form.FormPanel, {
	constructor:function(){
		UploadFileForm.superclass.constructor.call(this, {
			fileUpload:true,
			baseCls:"x-plain",
			bodyStyle:"padding:6px",
			labelWidth:40,
			items:[{
				baseCls:"x-plain",
				html:"<center><b>目前仅支持excel格式,请将数据按以下样例整理后上传</b><br/><br/><img src='/uukeep/images/example.jpg' /><br/><br/></center>"
			},{
				xtype:'textfield',
				fieldLabel:'文件',
				name:'file',
				width:300,
				inputType:'file',
				allowBlank:false,
				blankText:"请选择excel文件"				
			}]
		});
	}
});

/*************************************************************************************************************/
/**************************************上传文件Window**********************************************************/
UploadFileWindow = Ext.extend(Ext.Window, {
	_form:null,
	constructor:function(){
		this._form = new UploadFileForm();
		UploadFileWindow.superclass.constructor.call(this, {
			title:"文件上传",
			layout:"form",
			width:400,
			height:310,
			plain:true,
			closeAction:"hide",
			modal:true,
			items:[this._form],
			buttons:[{
				text:"确定",
				handler:this.importFile,
				scope:this
			},{
				text:"取消",
				handler:this.closeWindow,
				scope:this
			}]
		});
	},
	closeWindow:function(){
		this.hide();
	},
	importFile:function(){
		this.fireEvent("import", this, this._form);		
	}
});

/*************************************************************************************************************/
/**************************************联系人列表窗口***********************************************************/

UUkeepTree = Ext.extend(Ext.form.FormPanel, {
	_tree:null,
	_uploadFile:null,
	_treeEditor:null,
	_treeFilter:null,
	constructor:function(){
		this._tree = new SimpleTreePanel();
		this._uploadFile = new UploadFileWindow();
		this._treeEditor = new Ext.tree.TreeEditor(this._tree, {
			allowBlank:false
		});
		this._treeFilter = new Ext.tree.TreeFilter(this._tree, {
			clearBlank: true,
 			autoClear: true			
		});
		UUkeepTree.superclass.constructor.call(this, {
			tbar:[{
				text:"添加人员",
				iconCls:"add",
				handler:function(){					
					this._tree._createWindow.show();
				},
				scope:this
			},"-",{
				text:"添加分组",
				iconCls:"add",
				handler:function(){
					this._tree.onInsertGroup();
				},
				scope:this
			}],
			fbar:[{
				text:"导入",
				iconCls:"import",
				id:"impo"
			},{				
				iconCls:"export",
				text:"导出",
				handler:function(){					
					window.location = "/export";					
				}
			}],
			buttonAlign:"left",
			renderTo:"cncoman",
			closable:false,				
			title:"我的脉客",
			width:215,
			height:560,
			plain:true,
			layout:"fit",
			bodyStyle:"background:transparent;padding:2px",
			items:[this._tree]
		});
		var uf = this._uploadFile;
		Ext.get('impo').on("click", function(){
			uf.show(this);
		});
		this._uploadFile.on("import", this.importFile, this);
		this._treeEditor.on("beforeshow", this.beforeUpdateGroup);
		this._treeEditor.on("complete", this.updateGroup);
		this._tree.hiddenPkgs = [];
	},
	beforeUpdateGroup:function(_treeEditor){
		var _node = _treeEditor.editNode;
		if(!_node.isLeaf()){
			var value = _node.text;
			_treeEditor.setValue(value.substring(0, value.indexOf("(")));
		}else{
			return false;
		}
	},
	updateGroup:function(_treeEditor, _newValue, _oldValue){		
		
		var _node = _treeEditor.editNode;		
		if(!_node.isLeaf()){
			var users = _oldValue.substring(_oldValue.indexOf("("), _oldValue.length);			
			var currValue = _newValue + users;
			_node.setText(currValue);	

			if(currValue == _oldValue)   //如果没有修改，原样返回
				return;
				
			Ext.Ajax.request({
				url:"/updateGroup",
				params:{"groupInfo.id":_node.id,"groupInfo.name":_newValue}				
			});
		}else{
			return false;
		}
	},
	importFile:function(_win, _form){
		var _node = this._tree.getNodeById(1);
		if(_form.getForm().isValid()){
			_form.getForm().submit({
				url:"/import",
				success: function(form, action) {					
			        Ext.Msg.alert('Success', action.result.msg);
			        _win.closeWindow();
			        var _text = _node.text;
			        var users = parseInt(_text.substring(_text.indexOf("(") + 1, _text.length - 1)) + action.result.count;
			        _node.setText("未分组" + "(" + users + ")");
			    },
			    failure: function(form, action) {
			        Ext.Msg.alert('Success', action.result.msg);
			    }	
			});
		}
	}
});

/*
Ext.Ajax.defaultHeaders = {   
      'Request-By': 'Ext' //标识ajax请求   
};   
       
    // ajax回调函数处理系统退出         
Ext.Ajax.on('requestcomplete',checkSessionStatus, this);            
function checkSessionStatus(conn,response,options){   
   	var json = Ext.decode(response.responseText);   
    if(typeof json == 'object' && !json.success && json.timeout){
        Ext.Msg.alert("系统信息", "你长时间没有进行操作,系统将自动跳转到登陆页面!");
        top.window.location.href = json.redirectUri;                               
    }
}
*/