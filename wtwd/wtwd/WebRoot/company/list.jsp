<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>
		<SCRIPT language=javascript type=text/javascript>var boardxml='';var ISAPI_ReWrite=0;</SCRIPT>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
		<style type="text/css">
<!--
.STYLE1 {color: #000000}
.STYLE2 {color: #FF0000}
.STYLE11 {color: #FF0000}
-->
</style>
	</HEAD>
	<BODY>
		<s:form action="companyList">
			<table cellspacing="1" cellpadding="3" width="100%" align=left
				border="0">

				<tbody>
					<tr>
						<th colspan="6" class="td_title" style="TEXT-ALIGN: center">
							合作方管理【
							<a href="createCompany" class="STYLE11">新增合作方</a>】
						</th>
					</tr>
					<tr>
						<td colspan="6">
							<strong>名称或编号：</strong>

							<s:textfield name="companyInfo.code"></s:textfield>
								
							<s:select list="userList" listKey="intId" listValue="name" headerKey="0" headerValue="-请选择商务-" name="companyInfo.salesId"></s:select>
							<input class="button" type=submit value="确认" name=Submit2222>
						</td>
					</tr>
				</tbody>

				<tbody>
					<tr>
						<td align="center" class="td2">
							<strong>序号</strong>
						</td>
						<TD align="center" class="td2">
							<strong>合作方名称</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>合作方代码</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>添加日期</strong>
						</TD>
						<td align="center" class="td2">
							<strong>商务负责人</strong>
						</td>
						<td align="center" class="td2">
							<strong>操作管理</strong>
						</td>
					</tr>
					<s:iterator value="companyList">
						<tr>
							<td align="center" class="td1">
								<s:property value="intId"/>
							</td>
							<td align="center" class="td1">
								<a href="toUpdateCompany?companyInfo.intId=<s:property value='intId'/>">
									<s:property value="name"/>
								</a>
							</td>
							<td align="center" class="td1">
								<a href="toUpdateCompany?companyInfo.intId=<s:property value='intId'/>">
									<s:property value="code"/>
								</a>
							</td>
							<td align="center" class="td1">
								<s:property value="time" />
							</td>
							<td align="center" class="td1">
								<s:property value="userInfo.name" />
							</td>
							<td align="center" class="td1">
								<span class="td2">
									<a href="toUpdateCompany?companyInfo.intId=<s:property value='intId'/>">修改</a>
									| <a href="machineList?machineInfo.companyCode=<s:property value='code'/>&machineInfo.company.salesId=0">项目管理</a>
									| <a href="userList?userInfo.company.intId=<s:property value='intId'/>&userInfo.role.intId=0">账户管理</a></span>
							</td>
						</tr>
					</s:iterator>					
					<tr>
						<td colspan="6" class="td1">
							<div align="right">
								<%@ include file="/include/page.jsp" %>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</BODY>
</HTML>
