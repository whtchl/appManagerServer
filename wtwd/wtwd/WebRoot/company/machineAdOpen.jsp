<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0038)http://localhost/bbs/Admin/setting.asp -->
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<META http-equiv=content-type content="text/html; charset=UTF-8">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>


		<SCRIPT language=javascript type=text/javascript>var boardxml='';var ISAPI_ReWrite=0;</SCRIPT>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
		<script language="javascript" src="js/letterIndex.js"
			type="text/javascript"></script>
	</HEAD>
	<BODY>
		<s:form action="machAdOpen" method="post">
			<table cellspacing="1" cellpadding="3" width="100%" align="center"
				border="0">
				<tbody>
					<tr>
						<th colspan="14" class="td_title2" style="TEXT-ALIGN: center">
							渠道广告开关管理						</th>
					</tr>
					<tr>
						<td colspan="14">
							<strong>快速查询：</strong>
							<span class="td1">							
							<s:select list="companyList" listKey="code" listValue="name" name="explainben.prodCode" headerKey="" headerValue="-请选择厂商"></s:select>							
							<s:select list="#{1:'测试',2:'即时推送',3:'不推送',7:'3天后推送',4:'30天后推送',5:'60天后推送',6:'90天后推送'}" headerKey="0" headerValue="-推送广告状态-" name="explainben.autoFeeStatus"></s:select>
							<s:select list="productList" listKey="number" listValue="name" name="explainben.linkHours" headerKey="" headerValue="-合作产品-"></s:select>							
							</span>
							<input class="button" type=submit value="查 询" name=Submit2222>						</td>
					</tr>
					<tr class="td2">
						<td width="6%" align="center">
							<strong>序号</strong>						</td>
						<td width="15%" align="center">
							<strong>合作厂家</strong>						</td>
						<td width="14%" align="center">
							<strong>合作项目</strong>						</td>
						<td width="11%" align="center">
							<strong>合作产品</strong>						</td>
						<td width="9%" align="center"><strong>下载数</strong></td>
						<td width="11%" align="center""><strong>活跃用户</strong>（参考）</td>
						<td width="9%" align="center""><strong>等级</strong></td>
						<td width="11%" align="center"">
							<strong>推送广告状态</strong>						</td>
						<td width="14%" align="center"">
							<strong>操作</strong>						</td>
					</tr>
				</tbody>
				<tbody>
					<s:iterator value="explainList" id="machine" status="s">
						<tr>
							<td align="center" class="td2">
								<s:property value="intId" />							</td>
							<td align="center" class="td2">
								<span class="td1"><s:property value="shieldPids" /> </span>
								（<s:property value="prodExplain" />）							</td>
							<td align="center" class="td2">
								<s:property value="feeExplain" />							</td>							
							<td align="center" class="td2">
								<s:property value="prodCode" />							</td>
							<td align="center" class="td2"><input value='<s:property value="pushscount"/>' name="explainben.pushcount" /></td>
							<td align="center" class="td2"><s:property value="usercount"/> </td>
							<td align="center" class="td2"><s:select list="#{1:'A-低',2:'B-中',3:'C-高'}" value="level" name="explainben.levels"></s:select></td>
							<td align="center" class="td2">
							<s:select list="#{1:'测试',2:'即时推送',3:'不推送',7:'3天后推送',4:'30天后推送',5:'60天后推送',6:'90天后推送'}" value="autoFeeStatus" name="explainben.shieldPids"></s:select>							</td>
							<td align="center" class="td2">	
							<a href="#" onClick="d(<s:property value="intId" />,<s:property value="#s.count" />)">提交修改</a>							</td>
						</tr>
					</s:iterator>
					<tr>
						<td colspan="14" align="right" class="td1">
							<span class="td1">
								<div align="right">
									<%@ include file="/include/page.jsp" %>
								</div>
							</span>						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
		<script type="text/javascript">
			function d(id,count){
				document.forms[0].action = "updateMachAdOpen?explainben.intId=" + id + "&explainben.machineId="+count;
				document.forms[0].submit();
			}
		</script>
		
	</BODY>
</HTML>

