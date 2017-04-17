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
<s:form action="brandManager" method="post">	
	<table cellspacing="1" cellpadding="3" width="600" align="left"
			border="0">
			<tr>
				<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
					<span class="td_title" style="TEXT-ALIGN: center">品牌机型管理</span>
				</th>
			</tr>
			<tr class="td2">
				<td align="center" class="STYLE6">
					<strong>
						品牌
					</strong>
				</td>
				<td align="center" class="STYLE6">
					<strong>机型</strong>
				</td>
				<td align="center" class="STYLE6">
					<strong>操作</strong>
				</td>	
			</tr>
			<s:iterator value="brandList" id="info">
			<TR>
				<TD align="center" class="STYLE19">
					<s:property value="name"/>
				</TD>
				<TD align="center" class="STYLE19">
					<s:iterator value="machineList">
						<s:property value="code" />
					</s:iterator>
				</TD>
				<TD align="center" class="STYLE19">
					<a href="javascript:;" onclick="updateBrand(<s:property value='intId' />);">修改</a> | <a href="/deleteBrand?brandInfo.intId=<s:property value='intId' />">删除</a>
				</TD>				
			</TR>
		</s:iterator>
		
		<tr>
				<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
					<span class="td_title" style="TEXT-ALIGN: center">机型列表</span>
				</th>
			</tr>
			<tr class="td2">
				<td align="center" class="STYLE6" colspan="3">
					<s:checkboxlist list="machineList" name="brandInfo.mids" listKey="intId" listValue="code"></s:checkboxlist>
				</td>			
			</tr>
			<tr class="td2">
				<td align="center" class="STYLE6" colspan="3">
					<s:select list="brandList" listKey="intId" listValue="name" name="brandInfo.intId"></s:select>
					<input type="button" value="归类" onclick="updateMachineBrand();"/>
					<input type="button" value="添加新品牌" onclick="addBrand();"/>
				</td>
			</tr>
		</table>		
</s:form>
<script type="text/javascript">
<!--
function addBrand(){
	var iHeight = 250;
	var iWidth = 400;
	var iTop = (window.screen.height - iHeight)/2;
	var iLeft = (window.screen.width - iWidth)/2;
	window.open("company/createBrand.jsp", "", "height=" + iHeight + ", width=" + iWidth + ", location=no, toolbar=no, top=" + iTop + ", left=" + iLeft + ", resizable=no, scrollbars=yes");
}
function updateBrand(id){
	var iHeight = 250;
	var iWidth = 400;
	var iTop = (window.screen.height - iHeight)/2;
	var iLeft = (window.screen.width - iWidth)/2;
	window.open("/toUpdateBrand?brandInfo.intId=" + id, "", "height=" + iHeight + ", width=" + iWidth + ", location=no, toolbar=no, top=" + iTop + ", left=" + iLeft + ", resizable=no, scrollbars=yes");
}
function updateMachineBrand(){
	document.forms[0].action = "/updateMachineBrand";
	document.forms[0].submit();
}
//-->
</script>

	</BODY>
</HTML>