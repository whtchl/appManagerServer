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
	<s:form action="saveAgent" method="post">
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">
			<tr>
				<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
					<span class="td_title" style="TEXT-ALIGN: center">创建代理商</span>
				</th>
			</tr>			
			<tr class='tdbg2'>
				<td width='16%' align='left' class="td1">
					<u>所属角色</u>
				</td>
				<td width='84%' class="td1">
					<s:select list="roleList" listKey="intId" listValue="name" name="userInfo.role.intId"></s:select>
				</td>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>登陆ID</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:textfield name="userInfo.loginId"></s:textfield>
					</span>
				</td>
			</tr>
			<tr class="td1">
				<td width='16%' align='left' class="td1">
					<u>初始密码</u>
				</td>
				<td width='84%' class="td1">
					<s:textfield name="userInfo.pwd"></s:textfield>					
				</td>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>姓名</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:textfield name="userInfo.name"></s:textfield>
					</span>
				</td>
			</tr>			
			
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>备注说明</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:textarea name="userInfo.remark" cols="78" rows="3"></s:textarea>					
					</span>
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
	</BODY>
</HTML>
