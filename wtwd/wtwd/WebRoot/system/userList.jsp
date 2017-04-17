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
		<s:form action="userList">
			<table cellspacing="1" cellpadding="3" width="100%" align=left
				border="0">

				<tbody>
					<tr>
						<th colspan="12" class="td_title" style="TEXT-ALIGN: center">
							系统用户列表
						</th>
					</tr>
					<tr>
						<td colspan="12">
							<strong>快速查询：</strong>
							
							<s:select list="roleList" listKey="intId" listValue="name" headerKey="0" headerValue="-请选择角色-" name="userInfo.role.intId"></s:select>
							
							<s:select list="companyList" listKey="intId" listValue="name" headerKey="0" headerValue="-请选择公司-" name="userInfo.company.intId"></s:select>

						
						<INPUT type="submit" class="BUTTON" value="查询">
						</td>
					</tr>
				</tbody>

				<tbody>
					<tr>
						<td align="center" class="td2">
							<strong>序号</strong>
						</td>
						<td align="center" class="td2">
							<strong>姓名</strong>
						</td>
						
						<TD align="center" class="td2">
							<strong>登陆ID</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>公司</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>角色</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>可登陆平台</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>最后访问</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>访问次数</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>最后访问IP</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>状态</strong>
						</TD>
						<td align="center" class="td2">
							<strong>创建时间</strong>
						</td>
						<TD align="center" class="td2">
							<strong>操作</strong>
						</TD>
					</tr>
					<s:iterator value="userList">
						<tr>
							<td align="center" class="td1">
								<s:property value="intId"/>
							</td>
							<td align="center" class="td1">
								<s:property value="name" />
							</td>							
							<td align=center class="td1">
								<s:property value="loginId"/>
							</td>
							<td align=center class="td1">
								<s:property value="company.name"/>
							</td>
							<td align=center class="td1">
								<s:property value="role.name"/>
							</td>
							<td align=center class="td1">
								<s:if test="validDomain == 1">
									test1.com.cn
								</s:if>
								<s:elseif test="validDomain == 2">
									test2.cn
								</s:elseif>
								<s:elseif test="validDomain == 3">
									test3.com
								</s:elseif>
							</td>
							<td align=center class="td1">
								<s:property value="lastAccessTime"/>
							</td>
							<td align="center" class="td1">
								<s:property value="accessTimes" />
							</td>
							<td align="center" class="td1">
								<s:property value="ip"/>
							</td>							
							<td align="center" class="td1">
								<s:if test='valid == "Y"'>
									启用
								</s:if>
								<s:else>
									<font color="red"><b>禁用</b></font>
								</s:else>								
							</td>
							<td align="center" class="td1">
								<s:property value="createTime" />
							</td>
							<td align="center" class="td1">
								<a href="toUpdateUser?userInfo.intId=<s:property value='intId'/>">修改</a>
							</td>
						</tr>
					</s:iterator>					
					<tr>
						<td colspan="12" class="td1">
							<div align="right">
								<%@ include file="/include/page.jsp" %>
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</BODY>
</HTML>
