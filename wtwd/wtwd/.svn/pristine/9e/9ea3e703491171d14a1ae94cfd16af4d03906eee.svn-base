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
		<s:form action="roleMosList">
			<table cellspacing="1" cellpadding="3" width="100%" align=left
				border="0">

				<tbody>
					<tr>
						<th colspan="11" class="td_title" style="TEXT-ALIGN: center">Mos系统角色列表 
						</th>
					</tr>					
				</tbody>

				<tbody>
					<tr>
						<td align="center" class="td2">
							<strong>序号</strong>
						</td>
						<td align="center" class="td2">
							<strong>角色名称</strong>
						</td>
						
						<TD align="center" class="td2">
							<strong>用户数</strong>
						</TD>
						<TD align="center" class="td2" style="display:none">
							<strong>权限</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>有效性</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>备注</strong>
						</TD>
						<TD align="center" class="td2">
							<strong>操作</strong>
						</TD>
					</tr>
					<s:iterator value="roleList">
						<tr>
							<td align="center" class="td1">
								<s:property value="intId"/>
							</td>
							<td align="center" class="td1">
								<s:property value="name" />
							</td>							
							<td align=center class="td1">
								<a href="userMosList?userInfo.role.intId=<s:property value='intId'/>">共有(<s:property value="userCount"/>)个用户</a>
							</td>
							<td align=center class="td1" style="display:none">
								<s:if test="intId == 1">
									系统管理员
								</s:if>
								<s:else>
									<s:iterator value="resourceList">
										<s:property value="name"/>
									</s:iterator>
								</s:else>
							</td>
							<td align=center class="td1">
								<s:property value="valid"/>
							</td>
							<td align=center class="td1">
								<s:property value="remark"/>
							</td>
							<td align="center" class="td1">
								<a href="toUpdateRoleMos?roleInfo.intId=<s:property value='intId'/>" title="修改角色">详情</a>
								&nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="javascript:;" onclick="gotoo(<s:property value='intId'/>); return false;">删除</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:form>
		 <script type="text/javascript">
      	function gotoo(id){
      		if(confirm("该角色下所有用户将会被一起删除，确定要删除吗？")){
	      		document.forms[0].action = "deleteRoleMos?roleInfo.intId=" + id;
	      		document.forms[0].submit();
      		}
      	}
      </script>
	</BODY>
</HTML>
