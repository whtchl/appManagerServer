<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<META http-equiv=content-type content="text/html; charset=UTF-8">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>
		<SCRIPT src="../images/main82.js" type=text/javascript></SCRIPT>

		<SCRIPT src="../images/admin.js" type=text/javascript></SCRIPT>

		<SCRIPT language=javascript type=text/javascript>var boardxml='';var ISAPI_ReWrite=0;</SCRIPT>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
	</HEAD>
	<BODY>
		<s:form action="saveRoleMos" method="post">
			<table cellspacing="1" cellpadding="3" width="100%" align="center"
				border="0">
				<tr>
					<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
						<span class="td_title" style="TEXT-ALIGN: center">创建Mos新角色</span>
					</th>
				</tr>
				<tr class="tdbg">
					<td width='16%' align='left' class="td2">
						<u>角色名称</u>
					</td>
					<td width='84%' class="td2">
						<span class="td1"> <s:textfield name="roleInfo.name"></s:textfield>
						</span>
					</td>
				</tr>
				<tr class='tdbg2'>
					<td width='16%' align='left' class="td1">
						<u>备注</u>
					</td>
					<td width='84%' class="td1">
						<s:textfield name="roleInfo.remark"></s:textfield>
					</td>
				</tr>
				<tr class="tdbg">
					<td width='16%' align='left' class="td2">
						<u>作用域</u>
					</td>
					<td width='84%' class="td2">
						<span class="td1"><s:radio list="#{1:'test1.com.cn',2:'test2..cn公用'}" name="roleInfo.isPublic" value="1"></s:radio>
						</span>
					</td>
				</tr>
				<tr class="tdbg">
					<td align='left' class="td2">
						<u>权限</u>
					</td>
					<td class="td2">
						<s:iterator value="resourceList" id="r1" status="i">
							<s:if test="grade == 1">
								<div id="first<s:property value='#i.index'/>">
									<img alt="展开" src="/images/openup.gif" onclick="dis('ficon', <s:property value='#i.index'/>, 'second')" id="ficon<s:property value='#i.index'/>"/>
									<s:checkboxlist list="r1" listKey="intId" listValue="name"
										name="roleInfo.resourceIds" value="roleInfo.resourceIds"
										onclick="sel(this, %{#i.index}, 'second');" />
									<br />
								</div>
								<div id="second<s:property value='#i.index'/>"
									style="MARGIN-left:2cm;MARGIN-right:4cm;display:none">
									<s:iterator value="resourceList" id="r2" status="i2">
										<s:if test='#r2.grade == 2 && #r2.parentId == #r1.intId'>
										
										<s:if test="#r2.hasChild == true">
											<img alt="展开" src="/images/openup.gif" onclick="dis('f2icon', <s:property value='#i2.index'/>, 'three')" id="f2icon<s:property value='#i2.index'/>"/>
										</s:if>
										<s:else>
											<img alt="没有子菜单" src="/images/closeup.gif"/>
										</s:else>
									<s:checkboxlist
												list="r2" listKey="intId" listValue="name"
												name="roleInfo.resourceIds" value="roleInfo.resourceIds"
												onclick="sel(this, %{#i2.index}, 'three')" />(<s:property
												value="remark" />)
								<br />

											<div id="three<s:property value='#i2.index'/>"
												style="MARGIN-left:2cm;MARGIN-right:8cm;display:none">
												<s:iterator value="resourceList" id="r3">
													<s:if test='#r3.grade == 3 && #r3.parentId == #r2.intId'>										
												
												<s:checkboxlist list="r3" listKey="intId" listValue="name"
															name="roleInfo.resourceIds" value="roleInfo.resourceIds" />
														<br />
													</s:if>
												</s:iterator>
											</div>
										</s:if>
									</s:iterator>
								</div>
							</s:if>
						</s:iterator>
					</td>
				</tr>
				
			</table>
			<table cellspacing="1" cellpadding="3" width="100%" align="center"
				border="0">
				<tr class="tdbg">
					<td align='center' class="td2">
						<input class=button type=submit value="确认并提交" name=Submit>
					</td>
				</tr>
			</table>
		</s:form>
		<script type="text/javascript">
			function dis(_id, _index, _div){
				var div = document.getElementById(_div + _index);
				if(div.style.display == "none")
					div.style.display = "";
				else
					div.style.display = "none";
					
				var icon = document.getElementById(_id + _index);
				if(icon.alt == "展开"){
					icon.alt = "收起";
					icon.src = "/images/closeup.gif";
				}else{
					icon.alt = "展开";
					icon.src = "/images/openup.gif";
				}				
			}
			function sel(obj, index, tarDiv){
				var div = document.getElementById(tarDiv + index);
				var list = div.childNodes;
				var childList;
				if(obj.checked == false){					
						for(var i = 0; i < list.length; i++){
							if(list[i].type == 'checkbox'){
								list[i].checked = false;
							}
							
							childList = list[i].childNodes;
							for(var j = 0; j < childList.length; j++){
								if(childList[j].type == 'checkbox'){
									childList[j].checked = false;
								}
							}
						}					
				}else{
					for(var i = 0; i < list.length; i++){
						if(list[i].type == 'checkbox'){
							list[i].checked = true;							
						}
						
						childList = list[i].childNodes;						
						for(var j = 0; j < childList.length; j++){
							if(childList[j].type == 'checkbox'){									
								childList[j].checked = true;
							}
						}
					}	
				}
			}
			function disMac(){
				var macDIV = document.getElementById("macDIV");
				var obj = document.getElementsByName("roleInfo.isAllMac");
				var sel = true;
				for(var i = 0; i < obj.length; i++){
					if(obj[i].checked){
						sel = obj[i].value;
						break;
					}
				}				
				if(sel == 0){					
					macDIV.style.display = "none";
				}else{
					macDIV.style.display = "";
				}
			}
		</script>
	</BODY>
</HTML>
