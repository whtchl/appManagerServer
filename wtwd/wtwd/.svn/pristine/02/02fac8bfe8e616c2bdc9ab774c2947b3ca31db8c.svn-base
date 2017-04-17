
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
		<script type="text/javascript">
			function havePic(){
				var advType = document.getElementById("advType").value;
				if(advType == 1){
					document.getElementById("uploadPic").style.display = "";
				}else{
					document.getElementById("uploadPic").style.display = "none";
				}
			}
			
			function selectMachs(){
				var manuCodes = document.all.manuCode;
				for(var i = 0; i < manuCodes.length; i++){
					if(manuCodes[i].checked){
						document.getElementById('mach' + manuCodes[i].value).style.display = "";
					}else{
						document.getElementById('mach' + manuCodes[i].value).style.display = "none";
						var machCode = document.all.machCode;
						for(var j = 0; j < machCode.length; j++){
							machCode[j].checked = false;
						}
					}
				}
			}
		</script>
	</HEAD>
	<BODY>
		<s:form action="/updateCompanyVersion" method="post" enctype="multipart/form-data">
			<s:hidden name="vm.id" value="%{vm.id}"></s:hidden>
			<table cellspacing="1" cellpadding="3" width="937" align="center"
				border="0" height="263">
				<tr>
					<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
						<span class="td_title" style="TEXT-ALIGN: center">修改厂家升级版本信息</span>
						<s:actionmessage/>
					</th>
				</tr>
                <tr class='tdbg2'>
					<td width='16%' align='left' class="td1"> 
						名称</td>
					<td width='84%' class="td1">
						<s:textfield name="vm.name"></s:textfield><s:actionerror/>
					</td>
				</tr>
				<tr class='tdbg2'>
					<td width='16%' align='left' class="td1"> 
						版本号</td>
					<td width='84%' class="td1">
						<s:property value="vm.verInfo.ver"/>
					</td>
				</tr>
				<tr class='tdbg2'>
					<td width='16%' align='left' class="td1"> 
						发布状态</td>
					<td width='84%' class="td1">
						<s:select list="#{'0':'否','1':'是'}" name="vm.issue"></s:select>
					</td>
				</tr>
				<tr class='tdbg2'>
					<td width='16%' align='left' class="td1"> 
						机型</td>
					<td width='84%' class="td1">
						<s:property value="vm.company.name"/><br/>
						
						
						<s:iterator value="vm.company.machList">							
							&nbsp;&nbsp;&nbsp;&nbsp;
							
							<input type="checkbox" name="machCode" value="<s:property value='code'/>" id="machCode"/>
							<s:property value='code'/>
							<br/>
						</s:iterator>
					</td>
				</tr>				
				<tr class="td1">
					<td width='16%' align='left' class="td1">
						备注
					</td>
					<td width='84%' class="td1">
						<label>
						<s:textarea name="vm.remark" cols="60" rows="6"></s:textarea>
						</label>
						
						
				  </td>
				</tr>
				<table cellspacing="1" cellpadding="3" width="100%" align="center"
					border="0">
					<tr class="tdbg">
						<td align='center' class="td2">
							<input class=button type=submit value="确认并提交" name=Submit>
							<input class=button type=button value="返     回" name=return onclick="javascript:history.back()" />
						</td>
					</tr>
				</table>
	</table>
	</s:form>
	</BODY>
</HTML>
