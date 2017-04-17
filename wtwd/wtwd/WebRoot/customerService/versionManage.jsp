<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>
		<SCRIPT language=javascript type=text/javascript>
		var boardxml='';var ISAPI_ReWrite=0;
		  function deleteVersion(id){
			 if(window.confirm("确定删除吗？")==true){
				window.location.href="deleteVersion?vid="+id;
				}
			}
		
		</SCRIPT>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
	</HEAD>
	<BODY>
		<s:form action="versionManage">
			<table cellspacing="1" cellpadding="3" width="100%" align=left
				border="0">

				<tbody>
					<tr>
						<th colspan="7" class="td_title" style="TEXT-ALIGN: center">版 本 管 理</th>
					</tr>
					<tr>
						<td width="12%">
						
						  <div align="center"><strong> 快速查找：</strong><br/>
			          </div></td>
					    <td colspan="6"><!-- 
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
                          
                          <input class="button" type=submit value="确认" name=Submit2222>
                      【<a href="addVersion">添加</a>】 </td>
				    </tr>
				</tbody>

				<tbody>
					<tr>
						<td align="center" class="td2">
							<strong>序号</strong>						</td>
						<td width="5%" align="center" class="td2">名称</td>
						<TD width="9%" align="center" class="td2">
							<strong>版本号</strong>						</TD>
						<TD width="10%" align="center" class="td2"><strong>发布状态</strong></TD>						
						<td width="10%" align="center" class="td2"><strong>更新时间</strong></td>
						<td width="6%" align="center" class="td2"><strong>备注</strong></td>
						<td width="38%" align="center" class="td2"><strong>操作</strong></td>
					</tr>
					<s:iterator value="versionManage" status="listid">
						<tr>
							<td align="center" class="td1">
								<s:property
								value="#listid.count+(pageModel.curPage-1)*pageModel.rowsOfPage" />							</td>
							<td align="center" class="td1">
								<s:property value="name"/>							</td>
							<td align="center" class="td1">								
								<s:property value="verInfo.ver"/>							</td>
							<td align="center" class="td1">
							<s:if test="issue==0"><font color="red"><b> 否</b> </font> </s:if><s:else><font color="blue"><b>是</b></font> </s:else>															</td>
							<td align="center" class="td1">
								<s:property value="uploadTime"/>					</td>
							<td align="center" class="td1">
								<s:property value="remark"/>							</td>
							<td align="center" class="td1">
								<a href="updateVersion?issue=1&vid=<s:property value="id"/>" >发布</a>|<a href="updateVersion?issue=0&vid=<s:property value="id"/>">禁用</a>|
								<a href="/toUpdateCompanyVersion?vm.id=<s:property value='id'/>">修改</a>|<a href="#" onclick="deleteVersion(<s:property value="id"/>);" >删除</a> 							</td>
						</tr>
					</s:iterator>					
					<tr>
						<td colspan="7" class="td1">
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