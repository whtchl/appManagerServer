<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0038)http://localhost/bbs/Admin/setting.asp -->
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<META http-equiv=content-type content="text/html; charset=utf-8">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>


		<SCRIPT language=javascript type=text/javascript>var boardxml='';var ISAPI_ReWrite=0;</SCRIPT>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
		<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
.STYLE2 {color: #000000}
-->
</style>
	</HEAD>
	<BODY>
		<s:form action="updatemacProd" method="post">
		<s:hidden value="%{explainben.intId}" name="explainben.intId"></s:hidden>
		<s:hidden value="%{machineInfo.intId}" name="machineInfo.intId"></s:hidden>
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">			
			<tbody>
				<tr>
					<th colspan="2" class="font2" style="TEXT-ALIGN:  left">
						【修改 合作项目】
					</th>
				</tr>
				 
				<tr>
					<td width="13%" align="right" class="td1">
						推送状态：					</td>
					<td width="87%" align="left" class="td1">
						<s:select list="#{1:'测试',2:'即时推送',3:'不推送',7:'3天后推送',4:'30天后推送',5:'60天后推送',6:'90天后推送'}" name="explainben.autoFeeStatus"></s:select>
				  </td>
				</tr>
				
				
				<tr>
					<td align="right" class="td1">
						屏蔽省份：
					</td>
					<td class="td1">
						<s:checkboxlist list="provinceList" listKey="intId" listValue="name" name="explainben.pids"></s:checkboxlist>
					</td>
				</tr>
			
				
				
				<tr>
					<td colspan="2" class="td_title2" style="TEXT-ALIGN: center">
						<input class=button type=submit value="确认，并提交！" name=Submit3>
						<input class=button type=button value="返　　　　　回" name=Submit3 onClick="history.back()">
					</td>
				</tr>
			</tbody>			
		</table>
		</s:form>
	</BODY>
</HTML>
