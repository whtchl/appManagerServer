<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>
		<SCRIPT language=javascript type=text/javascript>var boardxml='';var ISAPI_ReWrite=0;</SCRIPT>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
	    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
        </style>
</HEAD>
	<BODY>
		<s:form action="sversionManage">
			<table cellspacing="1" cellpadding="3" width="100%" align=left
				border="0">

				<tbody>
					<tr>
						<th colspan="6" class="td_title" style="TEXT-ALIGN: center"><a href="versionManage">版本管理</a>/<span class="STYLE1">OSM版本管理</span> </th>
					</tr>
					<tr>
						<td>
						
						  <div align="center"><strong> 快速查找：</strong><br/>
				        </div></td>
					    <td colspan="5"><!-- 
							<input class="button" type=submit value="确认" name=Submit2222> -->
                          <strong>版本号:</strong>
                          <label>
                          <s:select list="versionInfo"   listValue="ver" listKey="id"  headerKey="-1" headerValue="请选择"
                            name="versionId" id="ver" 
                           ></s:select>
                          <strong>发布状态:</strong></label>
                          <label>
                          <select name="issue" >
                            <option value="-1" selected >所有</option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                            
                          </select>
                          </label>
                              <strong>客户:
                          <label>
                          <s:select list="companyList" listValue="name+'->'+code" listKey="code"  headerKey="-1" headerValue="请选择" name="code" id="company" ></s:select>
        
                          </label>
                          </strong>
                          <input class="button" type=submit value="确认" name=Submit2222>
                      【<a href="saddVersion">添加</a>】 </td>
				    </tr>
				</tbody>

				<tbody>
					<tr>
						<td width="7%" align="center" class="td2">
							<strong>序号</strong>						</td>
						<TD width="21%" align="center" class="td2">
							<strong>版本号</strong>						</TD>
						<td width="15%" align="center" class="td2"><strong>客户</strong></td>
						<TD width="16%" align="center" class="td2"><strong>发布状态</strong></TD>						
						<td width="22%" align="center" class="td2"><strong>更新时间</strong></td>
						<td width="19%" align="center" class="td2"><strong>操作</strong></td>
					</tr>
					<s:iterator value="versionManage" status="listid">
						<tr>
							<td align="center" class="td1">
								<s:property
								value="#listid.count+(pageModel.curPage-1)*pageModel.rowsOfPage" />							</td>
							<td align="center" class="td1">								
								<s:property value="verInfo.ver"/>							</td>
							<td align="center" class="td1">								
													
								<s:property value="code" />,<s:property value="company.name" />							</td>
							<td align="center" class="td1">
							<s:if test="issue==0">否</s:if><s:else>是</s:else>
															</td>
							<td align="center" class="td1">
								<s:property value="uploadTime"/>					</td>
							<td align="center" class="td1">
								<a href="supdateVersion?issue=1&vid=<s:property value="id"/>" >发布</a>|<a href="supdateVersion?issue=0&vid=<s:property value="id"/>">禁用</a>|<a href="sdeleteVersion?vid=<s:property value="id"/>">删除</a> 							</td>
						</tr>
					</s:iterator>					
					<tr>
						<td colspan="6" class="td1">
							<div align="right">
						     <%@ include file="/include/page.jsp" %>
							</div>						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
		<script type="text/javascript">
			function qpb(uid){
				var iHeight = 400;
				var iWidth = 600;
				var iTop = (window.screen.height - iHeight)/2;
				var iLeft = (window.screen.width - iWidth)/2;
				window.open("/contactList?contactInfo.id=" + uid, "", "height=" + iHeight + ", width=" + iWidth + ", location=no, toolbar=no, top=" + iTop + ", left=" + iLeft + ", resizable=no, scrollbars=yes");
			}
		</script>
	</BODY>
</HTML>