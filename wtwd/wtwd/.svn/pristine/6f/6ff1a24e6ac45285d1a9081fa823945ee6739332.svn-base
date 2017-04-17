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
		<s:form action="/resourceList">
			<table cellspacing="1" cellpadding="3" width="100%" align=left
				border="0">

				<tbody>
					<tr>
						<th colspan="11" class="td_title" style="TEXT-ALIGN: center">
							系统资源列表
						</th>
					</tr>
					<tr>
						<td colspan="11">
							<strong>快速查询：</strong>
							
							<s:select list="#{1:'一级菜单', 2:'二级菜单', 3:'三级菜单'}" headerKey="0" headerValue="-请选择级别-" name="resourceInfo.grade"></s:select>
							<s:select list="#{1:'test1.com.cn', 2:'test2.cn'}" headerKey="0" headerValue="-请选择域名-" name="resourceInfo.domain"></s:select>
							名称、URL：<input type="text"  name="resourceInfo.name">
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
							<strong>名称</strong>
						</td>
						<td align="center" class="td2">
							<strong>URL</strong>
						</td>
						<td align="center" class="td2">
							<strong>ExtjsPanel名称</strong>
						</td>
						<TD align="center" class="td2">
							<strong>菜单级别</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>排序</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>备注</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>范围</strong>
						</TD>						
						<TD align="center" class="td2">
							<strong>操作</strong>
						</TD>
					</tr>
					<s:iterator value="resourceList">
						<tr>
							<td align="center" class="td1">
								<s:property value="intId"/>
							</td>
							<td align="center" class="td1">
								<s:property value="name" />
							</td>							
							<td align=center class="td1">
								<s:property value="url"/>
							</td>
							<td align=center class="td1">
								<s:property value="extPanelName"/>
							</td>
							<td align=center class="td1">								
								<s:property value="grade"/>
							</td>
							<td align=center class="td1">								
								<s:property value="sort"/>
							</td>
							<td align=center class="td1">
								<s:property value="remark"/>
							</td>
							<td align=center class="td1">								
								<s:if test="domain == 0">
									公用
								</s:if>
								<s:elseif test="domain == 1">
									test1.com.cn
								</s:elseif>
								<s:elseif test="domain == 2">
									test2
								</s:elseif>
							</td>
							<td align="center" class="td1">
								<a href="toUpdateResource?resourceInfo.intId=<s:property value='intId'/>" title="修改菜单">修改菜单</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:form>
	</BODY>
</HTML>
