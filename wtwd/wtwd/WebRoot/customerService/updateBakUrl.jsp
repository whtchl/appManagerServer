<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0041)http://localhost/bbs/Admin/main_index.asp -->
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
	<!-- 短信 DIV -->
		<div>
			<s:form action="updateBakUrl" method="post"  >
				<table cellspacing="1" cellpadding="3" width="100%" align="center"
					border="0">
					<tr>
						<th colspan="2" class="td_title" style="TEXT-ALIGN: center"> 修改备用域名</th>
					</tr>
					<tr class="tdbg2">
						<td width='16%' align='left' class="td2"> 
							备用域名<br></td>
						<td width='84%' class="td2">
							
						    <label>
						    <input type="text" name="bakUrlInfo.bakurl" size="50" value="<s:property value='bakUrlInfo.bakurl'/>"/>
						     <input type="hidden" name="bakUrlInfo.id" value="<s:property value='bakUrlInfo.id'/>"/>
						    </label></td>
					</tr>
					<tr class="tdbg2">
						<td width='16%' align='left' class="td2"> 
							产品<br></td>
						<td width='84%' class="td2">
							
						    <label>
						   <s:select list="#{100:'客服中心'}" name="bakUrlInfo.pord" headerKey="0" headerValue="-请选择产品-"></s:select>
						    </label></td>
					</tr>
					<tr class="tdbg">
						<td align='left' class="td1">&nbsp;
							
						</td>
						<td class="td1">
							<input class=button type=submit value="确认并提交" name=Submit2>
							<input class=button type=button value="返回" onclick="history.back(-1)">
						</td>
					</tr>					
				</table>

			</s:form>
		</div>
		<!-- 短信DIV结束 -->
		
	</BODY>
</HTML>