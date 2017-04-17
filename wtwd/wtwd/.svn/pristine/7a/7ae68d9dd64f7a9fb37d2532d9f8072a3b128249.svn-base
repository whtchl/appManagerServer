<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
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
	</HEAD>
	<BODY>
		<s:form action="listMacProd" method="post">
			<table cellspacing="1" cellpadding="3" width="100%" align=left
				border="0">
				<tbody>
					<tr>
						<th colspan="14" class="td_title" style="TEXT-ALIGN: center">
							项目产品配置
						</th>
					</tr>
					<tr>
						<td height="45" align="center" class="td2">
							<strong>序号</strong>
						</td>
						<td align="center" class="td2">
							<strong>厂商 </strong>
						</td>
						<td align="center" class="td2">
							<strong>机型</strong>
						</td>
						<td align="center" class="td2">
							<strong>产品</strong>
						</td>
						
						<td align="center" class="td2">
							<strong>价格(元)</strong>
						</td>
						<!-- 
						<td align="center" class="td2">
							<strong>计费周期<br/>(天)</strong>
						</td>
						 -->
						<td align="center" class="td2">
							<strong>广告日限(条)</strong>
						</td>
						<td align="center" class="td2">
							<strong>广告月限(条)</strong>
						</td>
						<td align="center" class="td2">
							<strong>联网周期<br/>(分钟)</strong>
						</td>
						<!-- 
						<td align="center" class="td2">
							<strong>联网日期(日期)<br/>格式:2|12|22</strong>
						</td>
						<td align="center" class="td2">
							<strong>资费说明</strong>
						</td>
						<td align="center" class="td2" style="display:none">
							<strong>产品说明</strong>
						</td>	
						<td align="center" class="td2">
							<strong>资费提醒</strong>
						</td>
						 -->					
						<td align="center" class="td2">
							<strong>操作</strong>
						</td>
					</tr>
				</tbody>
				<tbody>
					<s:iterator value="explainList" id="explain">
						<tr>
							<td align="center" class="td1">
								<s:property value="intId" />
							</td>
							<td align="center" class="td1">
								<s:property value="company.name" />
							</td>
							<td align="center" class="td1">
								<s:property value="machine.code" />
							</td>
							<td align="center" class="td1">
								<s:property value="product.name" />
							</td>
							
							<td align="center" class="td1">
								<input name="price<s:property value='intId' />"  value="<s:property value='price' />" type="text" size="3" maxlength="3"/>
							</td>
							<!-- 
							<td align="center" class="td1">
								<input name="feeCycle<s:property value='intId' />"  value="<s:property value='feeCycle' />" type="text" size="3" maxlength="3"/>
							</td>	
							 -->						
							<td align="center" class="td1">
								<s:if test='%{#explain.prodCode == "100"}'>
									<input name="userDailyLimit<s:property value='intId' />"  value="<s:property value='dailyUserLimit' />" type="text" size="7" maxlength="7"/>
								</s:if>
								<s:if test='%{#explain.prodCode != "100"}'>
									/
								</s:if>
							</td>
							<td align="center" class="td1">
								<s:if test='%{#explain.prodCode == "100"}'>
									<input name="userMonthlyLimit<s:property value='intId' />"  value="<s:property value='monthlyUserLimit' />" type="text" size="7" maxlength="7"/>
								</s:if>
								<s:if test='%{#explain.prodCode != "100"}'>
									/
								</s:if>
							</td>
							
							<td align="center" class="td1">
								<s:if test='%{#explain.prodCode == "100"}'>
									<input name="linkHours<s:property value='intId' />"  value="<s:property value='linkHours' />" type="text" size="4" maxlength="4"/>
								</s:if>
								<s:if test='%{#explain.prodCode != "100"}'>
									/
								</s:if>
							</td>
							<!-- 
							<td align="center" class="td1">
								<s:if test='%{#explain.prodCode == "100"}'>
									<input name="linkDays<s:property value='intId' />"  value="<s:property value='linkDays' />" type="text" size="9" maxlength="9"/>
								</s:if>
								<s:if test='%{#explain.prodCode != "100"}'>
									/
								</s:if>
							</td>
							
							<td align="center" class="td1">
								<input name="feeExplain<s:property value='intId' />"  value="<s:property value='feeExplain' />" type="text" size="75"/>	
								
							</td>
							<td align="center" class="td1"  style="display:none">
								<input name="prodExplain<s:property value='intId' />"  value="<s:property value='prodExplain' />" type="text" size="75"/>									
							</td>
							<td align="center" class="td1">
								<s:if test='%{#explain.feeExplainStatus == "N"}'>
									<input type="radio" name="feeExplainStatus<s:property value='intId' />" value="Y">提醒
									<input type="radio" name="feeExplainStatus<s:property value='intId' />" value="N" checked="checked">不提醒
								</s:if>
								<s:if test='%{#explain.feeExplainStatus == "Y"}'>
									<input type="radio" name="feeExplainStatus<s:property value='intId' />" value="Y" checked="checked">提醒
									<input type="radio" name="feeExplainStatus<s:property value='intId' />" value="N">不提醒
								</s:if>
							</td>
							 -->
							<td align="center" class="td1">
								<a href="#a"  onclick="updateMacProd(<s:property value='intId' />,<s:property value='machineId' />);">修改</a> | <a href="macProd?prodid=<s:property value='intId' />&machineInfo.intId=<s:property value='machineId' />">控制</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tr>
					<td colspan="13" class="td_title2" style="TEXT-ALIGN: center">						
						<input class=button type=button value="返　　　　　回" name=Submit3 onclick="history.back()">
					</td>
				</tr>
			</table>
		</s:form>
		<script type="text/javascript">
			function updateMacProd(id, machineId){
			
				document.forms[0].action = "updateMacProd?id=" + id + "&machineInfo.intId=" + machineId;
				document.forms[0].submit();
			}
		</script>
	</BODY>
</HTML>
