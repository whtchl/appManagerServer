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
		<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
.STYLE2 {color: #000000}
-->
</style>
<script language="javascript" src="js/letterIndex.js"
			type="text/javascript"></script>
	</HEAD>
	<BODY>
		<s:form action="machineList" method="post">
			<table cellspacing="1" cellpadding="3" width="100%" align="center"
				border="0">
				<tbody>
					<tr>
						<th colspan="11" class="td_title2" style="TEXT-ALIGN: center">
							合作项目管理
						</th>
					</tr>
					<tr>
						<td colspan="11">
							<strong>快速查询：</strong>
							<span class="td1">							
							<s:select list="companyList" listKey="code" listValue="name" name="machineInfo.companyCode" headerKey="" headerValue="-按厂商"></s:select>							
							<s:select list="#{1:'测试',2:'即时推送',3:'不推送',7:'3天后推送',4:'30天后推送',5:'60天后推送',6:'90天后推送'}" headerKey="0" headerValue="-推送广告状态-" name="machineInfo.autoFeeStatus"></s:select>
							<s:select list="userList" listKey="intId" listValue="name" name="machineInfo.company.salesId" headerKey="0" headerValue="-按商务人员-"></s:select>
							</span>
							<s:textfield name="machineInfo.code"></s:textfield>
							<input class="button" type=submit value="确认" name=Submit2222>
						</td>
					</tr>
					<tr class="td2">
						<td width="5%" align="center">
							<strong>序号</strong>
						</td>
						<td width="11%" align="center">
							<strong>合作厂家</strong>
						</td>
						<td width="8%" align="center">
							<strong>合作项目</strong>
						</td>
						<td width="8%" align="center">
							<strong>出包日期</strong>
						</td>						
						<td width="9%" align="center">
							<strong>商务负责人</strong>
						</td>
						<!-- 
						<td width="9%" align="center">
							<strong>合作模式</strong>
						</td>
						<td width="6%" align="center">
							<strong>产品计费状态</strong>
						</td>
						 -->
						<td width="8%" align="center"">
							<strong>推送广告状态</strong>
						</td>
						<!-- 
						<td width="8%" align="center"">
							<strong>屏蔽级别</strong>
						</td>
						<td width="8%" align="center"">
							<strong>结算状态</strong>
						</td>
						 -->
						<td width="16%" align="center"">
							<strong>操作</strong>
						</td>
					</tr>
				</tbody>
				<tbody>
					<s:iterator value="machineList" id="machine">
						<tr>
							<td align="center" class="td2">
								<s:property value="intId" />
							</td>
							<td align="center" class="td2">
								<span class="td1"><s:property value="company.name" /> </span>
								（<s:property value="company.code" />）
							</td>
							<td align="center" class="td2">
								<a href="listMacProd?machineInfo.intId=<s:property value='intId' />" title="点击配置业务"><s:property value="code" /></a>
							</td>
							<td align="center" class="td2">
								<s:property value="repotDay" />
							</td>							
							<td align="center" class="td2">
								<s:property value="company.userInfo.name" />
							</td>
							<!-- 
							<td align="center" class="td2">
								<s:property value="balanceTypeStr" />
							</td>
							<td align="center" class="td2">
								<s:property value="prodFeeStatusStr" />
							</td>
							 -->
							<td align="center" class="td2">
								<s:property value="autoFeeStatusStr" />
							</td>
							<!-- 
							<td align="center" class="td2">
								<s:property value="shieldStatus" />
							</td>
							<td align="center" class="td2">
								<s:property value="balanceStatus" />
							</td>
							 -->
							<td align="center" class="td2">								
								<a href="toUpdateMachine?machineInfo.intId=<s:property value='intId' />">详情</a>&nbsp;|&nbsp;
								<a href="phoneStat?statInfo.manu=<s:property value='company.code' />&statInfo.mach=<s:property value='code' />&statInfo.groupBy=1">销量</a>&nbsp;|&nbsp;								
								<a href="listMacProd?machineInfo.intId=<s:property value='intId' />" title="点击配置业务">配置业务</a>
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td colspan="11" align="right" class="td1">
							<span class="td1">
								<div align="right">
									<%@ include file="/include/page.jsp" %>
								</div>
							</span>
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</BODY>
</HTML>

