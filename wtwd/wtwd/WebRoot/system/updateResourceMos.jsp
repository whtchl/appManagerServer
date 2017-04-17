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
	<s:form action="updateResourceMos" method="post">
		<s:hidden value="%{resourceInfo.intId}" name="resourceInfo.intId"></s:hidden>
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">
			<tr>
				<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
					<span class="td_title" style="TEXT-ALIGN: center">修改Mos系统菜单</span>
				</th>
			</tr>			
			<tr class='tdbg2'>
				<td width='16%' align='left' class="td1">
					菜单名称
				</td>
				<td width='84%' class="td1">
					<s:textfield name="resourceInfo.name"></s:textfield>
				</td>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					url
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:textfield name="resourceInfo.url"></s:textfield>
					</span>
				</td>
			</tr>
			<tr class="td1">
				<td width='16%' align='left' class="td1">
					级别
				</td>
				<td width='84%' class="td1">
					<s:select list="#{1:'一级菜单',2:'二级菜单',3:'三级菜单'}" name="resourceInfo.grade"></s:select>
				</td>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					父菜单
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:select list="resourceList" name="resourceInfo.parentId" listKey="intId" listValue="name" headerKey="0" headerValue="---无---"></s:select>
					</span>
				</td>
			</tr>
			<tr class="td1">
				<td width='16%' align='left' class="td1">
					范围
				</td>
				<td width='84%' class="td1">
					<s:select list="#{0:'--公用--',1:'test1..com.cn',2:'test1.com'}" name="resourceInfo.domain"></s:select>
				</td>
			</tr>			
			
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>备注说明</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:textarea name="resourceInfo.remark" cols="78" rows="3"></s:textarea>	
					</span>
				</td>
			</tr>			
		</table>		
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">
			<tr class="tdbg">
				<td align='center' class="td2">
					<input class=button type=submit value="确认并提交" name=Submit>
					<input class=button type=button value="返　　　回" name=Submit3 onclick="history.back()">
				</td>
			</tr>
		</table>
		</s:form>
	</BODY>
</HTML>
