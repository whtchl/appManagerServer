<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0038)http://localhost/bbs/Admin/setting.asp -->
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<META http-equiv=content-type content="text/html; charset=gbk">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>


		<SCRIPT language=javascript type=text/javascript>var boardxml='';var ISAPI_ReWrite=0;</SCRIPT>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
	</HEAD>
	<BODY>
		<s:form action="updateCompany" method="post">
			<s:hidden value="%{companyInfo.intId}" name="companyInfo.intId"></s:hidden>
			<table cellspacing="1" cellpadding="3" width="100%" align="center"
				border="0">
				<tbody>
					<tr>
						<th colspan="2" class="td_title" style="TEXT-ALIGN: center">
							修改合作方
						</th>
					</tr>
					<TR>
						<TD width="19%" class="td2">
							<u>合作方名称</u>
						</TD>
						<TD width="81%" class="td2">
							<span class="td1"> 
								<s:textfield name="companyInfo.name"></s:textfield>
							</span>
						</TD>
					</TR>

					<TR class="td1">
						<TD height="36" class="td1">
							<u>合作方代码</u>
						</TD>
						<TD class="td1">
							<s:textfield name="companyInfo.code" size="10" maxlength="4"></s:textfield>
							请输入4位数值,请不要重复输入，需要验证唯一性<s:actionmessage/>
						</TD>
					</TR>
					<tr class="title">
						<td class="td2">
							<u class="td1">商务负责人</u>
						</td>
						<td class="td2">
							<span class="td1"> 
								<s:select list="userList" listKey="intId" listValue="name" name="companyInfo.salesId"></s:select>
							</span>
						</td>
					</tr>
					<tr class="title">
						<td class="td1">
							<u class="td1">备注</u>
						</td>
						<td align="left" class="td1">
							<s:textarea name="companyInfo.remark" rows="10" cols="70"></s:textarea>
						</td>
					</tr>
					<tr class="title">
						<td colspan="2" align="center" class="title">
							<input class=button type=submit value="确认，并提交" name=Submit>
							<input class=button type=button value="返　　　　回" name=Submit3 onclick="history.back()">
						</td>
					</tr>
				</tbody>

			</table>
		</s:form>
	</BODY>
</HTML>
