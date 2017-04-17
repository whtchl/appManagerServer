////////////////////树形框///////////////////////////////
BrandTreePanel = Ext.extend(Ext.tree.TreePanel, {
	brandMenu:null,
	constructor:function(){
		this.brandMenu = new BrandMenu();
		BrandTreePanel.superclass.constructor.call(this, {
			anchor:"100%",
			rootVisible:true,
			animate:false,
			lines:true,
			useArrows:true,
			frame:true,
			width:"260",
			height:"500",
			autoScroll:true,
			enableDD:true,			
			tbar:[' ',
				new Ext.form.TextField({
					width:240,
					emptyText:'查找机型',
					enableKeyEvents:true,
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
				}), ' ', ' ', ' ', '', ''],				
				root:new Ext.tree.AsyncTreeNode({
					singleClickExpand:true,
					text:"品牌管理",
					id:"-1"
				}),
				loader:new Ext.tree.TreeLoader({
					preloadChildren:true,
					dataUrl:"/BrandTree"
				}),
				listeners:{					
					"movenode":{						
						fn:this.moveMachine,
						scope:this
					},
					"click":function(_node, _e){
						this.brandMenu["curNode"] = _node;
					},
					"contextmenu":{
						fn:this.onContextmenu,
						scope:this
					}
				}
		});
		this.brandMenu.on("insertBrand", this.onInsertBrand, this);		
		this.brandMenu.on("deleteBrand", this.onDeleteBrand, this);
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
	moveMachine:function(_tree, _node, _oldParent, _newParent, _index){		
		if(_newParent.id != -1){
			Ext.Ajax.request({
				url:"classify",
				params:{
					"machineId":_node.id,
					"brandId":_newParent.id
				}
			});
		}
	},
	onContextmenu:function(_node, _e){
		this.brandMenu["curNode"] = _node;
		if(_node.id != -1){
			var rootNodeId = _node.parentNode.id;
			if(rootNodeId == -1){
				this.brandMenu.showAt(_e.getXY());
			}
		}else{
			this.brandMenu.showAt(_e.getXY());
		}
	},	
	onDeleteBrand:function(){
		var _node = this.brandMenu["curNode"];
		if(_node.id <= 0){
			Ext.Msg.alert("系统提示", "系统默认目录不能删除！");
		}else{
			Ext.Msg.confirm("系统提示", "你确认要删除 [" + _node.text + "] 品牌吗？", this.onDeleteBrandConfirm, this);
		}
	},
	onDeleteBrandConfirm:function(_btn){
		if(_btn == "yes"){
			var _id = this.brandMenu["curNode"].id;
			this.brandMenu["curNode"].remove();
			Ext.Ajax.request({
				url:"deleteBrand",
				params:{"brandInfo.intId":_id}
			});
		}
	},
	onInsertBrand:function(){
		Ext.Msg.prompt("添加品牌", "请输入品牌名称", this.onInsertBrandNode, this);
	},
	onInsertBrandNode:function(_btn, _text){
		if(_btn == "ok"){
			var _node = this.getRootNode();
			Ext.Ajax.request({
				url:"saveBrand",
				params:{"brandInfo.name":_text},
				success:function(response, opts){
					var _groupId = response.responseText;					
					_node.insertBefore(new Ext.tree.AsyncTreeNode({
						text:_text,
						id:_groupId
					}), _node.lastChild);
				},
				failure:function(response, opts){
					Ext.Msg.alert("系统提示", "Sorry!新增组别失败...");
				}
			});			
		}
	}
});

////////////////////右键菜单///////////////////////////
BrandMenu = Ext.extend(Ext.menu.Menu, {
	constructor:function(){
		BrandMenu.superclass.constructor.call(this, {
			items:[{
				text:"添加品牌",
				iconCls:"add",				
				handler:this.onInsertBrand,
				scope:this
			},{
				text:"删除品牌",
				iconCls:"del",
				handler:this.onDeleteBrand,
				scope:this
			}]
		});
	},
	onInsertBrand:function(){
		this.fireEvent("insertBrand", this);
	},
	onDeleteBrand:function(){
		this.fireEvent("deleteBrand", this);
	}
});

//////////////////////Tree容器/////////////////
BrandTree = Ext.extend(Ext.form.FormPanel, {
	tree:null,	
	treeEditor:null,	
	constructor:function(){
		this.tree = new BrandTreePanel();		
		this.treeEditor = new Ext.tree.TreeEditor(this.tree, {
			allowBlank:false
		});		
		BrandTree.superclass.constructor.call(this, {
			width:"260",
			height:"500",		
			renderTo:"cncoman",
			closable:false,				
			layout:"fit",
			//title:"品牌管理",
			items:[this.tree]
		});		
		this.treeEditor.on("beforeshow", this.beforeUpdateBrand);
		this.treeEditor.on("complete", this.updateBrand);
		this.tree.hiddenPkgs = [];
	},
	beforeUpdateBrand:function(_treeEditor){
		var _node = _treeEditor.editNode;
		if(!_node.isLeaf()){
			var value = _node.text;
			_treeEditor.setValue(value);
		}else{
			return false;
		}
	},
	updateBrand:function(_treeEditor, _newValue, _oldValue){		
		var _node = _treeEditor.editNode;		
		if(!_node.isLeaf()){			
			_node.setText(_newValue);	

			if(_newValue == _oldValue)   //如果没有修改，原样返回
				return;
				
			Ext.Ajax.request({
				url:"updateBrand",
				params:{"brandInfo.intId":_node.id,"brandInfo.name":_newValue}				
			});
		}else{
			return false;
		}		
	}
});