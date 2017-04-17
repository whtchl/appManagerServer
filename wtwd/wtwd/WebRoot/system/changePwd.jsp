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
	<s:form action="changePwd" method="post">	
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">
			<tr>
				<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
					<span class="td_title" style="TEXT-ALIGN: center">修改密码</span>
					<s:actionmessage/>
				</th>
			</tr>
			<tr class="tdbg">
				<td width='16%' align='left' class="td2">
					<u>旧密码</u>
				</td>
				<td width='84%' class="td2">
					<span class="td1"> 
						<s:password  name="userInfo.pwd"></s:password>
						<s:fielderror fieldName="oldError"></s:fielderror>
					</span>
				</td>
			</tr>
			<tr class='tdbg2'>
				<td width='16%' align='left' class="td1">
					<u>新密码</u>
				</td>
				<td width='84%' class="td1">
					<s:password  name="userInfo.oldPwd"></s:password><s:fielderror fieldName="newError"></s:fielderror>
				</td>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>确认新密码</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:password  name="userInfo.newPwd"></s:password><s:fielderror fieldName="newError2"></s:fielderror>
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
