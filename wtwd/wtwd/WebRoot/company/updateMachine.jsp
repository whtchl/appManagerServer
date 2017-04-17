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
<script language="javascript">
 function change(){
  if(999999 == document.all("self").value){
   document.all("wr").disabled = false;
   document.all("wr").name = document.all("self").name;
   document.all("self").name = "";
  }else{
   document.all("wr").disabled = "disabled";
   document.all("wr").value = "";
   document.all("self").name="machineInfo.isPoint";
  }
 }


</script>
	</HEAD>
	<BODY>
		<s:form action="updateMachine" method="post" enctype="multipart/form-data">
		<s:hidden value="%{machineInfo.intId}" name="machineInfo.intId"></s:hidden>
		<s:hidden value="%{machineInfo.companyCode}" name="machineInfo.companyCode"></s:hidden>
		<s:hidden value="%{machineInfo.profit}" name="machineInfo.profit"></s:hidden>
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">			
			<tbody>
				<tr>
					<th colspan="2" class="font2" style="TEXT-ALIGN:  left">
						【修改 合作项目】
					</th>
				</tr>
				<tr>
					<td height="45" align="right" class="td2">
						合作厂家：
					</td>
					<td align="left" class="td2">
						<span class="STYLE1">
							<s:property value="machineInfo.company.name" />
						</span>
					</td>
				</tr>
				<tr>
					<td width="22%" height="45" align="right" class="td1">
						合作项目代码：
					</td>
					<td width="78%" align="left" class="td1">
						<s:textfield name="machineInfo.code"></s:textfield><font color="red">2011-11-21后新增的机型代码不能超过15个字符</font>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td align="right" class="td2">
						出包日期：
					</td>
					<td align="left" class="td2">
						<span class="td1"> 
							<s:textfield name="machineInfo.repotDay"></s:textfield> 
						</span>
					</td>
				</tr>
				<tr class="td1">
					<td height="36" align="right" class="td1">
						合作产品：
					</td>
					<td align="left" class="td1">
						<s:checkboxlist list="productList" listKey="number" listValue="name" name="machineInfo.prods" value="machineInfo.prods" disabled="true"></s:checkboxlist>
					</td>
				</tr>
				<tr class="td1">
					<td height="36" align="right" class="td1">
						支持的业务类型：
					</td>
					<td align="left" class="td1">
						<s:checkboxlist list="#{1:'通知栏广告'}" name="machineInfo.feeTypeIds"></s:checkboxlist>
					</td>
				</tr>
				<!-- 
				<tr>
					<td align="right" class="td2">
						合作模式：
					</td>
					<td align="left" class="td2">
						<span class="td1">
							<s:select list="#{1:'分成',2:'包机',3:'分成+包机'}" headerKey="0" headerValue="-请选择合作模式-" name="machineInfo.balanceType"></s:select>
						</span>
					</td>
				</tr>
				<tr>
					<td height="45" align="right" class="td1">
						结算比例：
					</td>
					<td align="left" class="td1">
						<s:textfield name="machineInfo.cnDeduct" size="6" maxlength="6"></s:textfield>%
					</td>
				</tr>
				<tr>
					<td height="45" align="right" class="td1">
						兼职商务分成：
					</td>
					<td align="left" class="td1">
						<s:textfield name="machineInfo.saleDeduct" size="6" maxlength="6"></s:textfield>%
					</td>
				</tr>
				<tr>
					<td height="45" align="right" class="td1">
						厂商分成比例：
					</td>
					<td align="left" class="td1">
						<s:textfield name="machineInfo.manuRate" size="6" maxlength="6"></s:textfield>%
					</td>
				</tr>
				<tr>
					<td height="45" align="right" class="td1">
						收益自动调整比例：
					</td>
					<td align="left" class="td1">
						<s:textfield name="machineInfo.adjust" size="6" maxlength="6"></s:textfield>%
					</td>
				</tr>
				<tr>
					<td align="right" class="td2">
						产品计费状态：
					</td>
					<td align="left" class="td2">
						<span class="td1">
							<s:select list="#{1:'测试',2:'计费',3:'免费',7:'3天试用',4:'30天试用',5:'60天试用',6:'90天试用'}" name="machineInfo.prodFeeStatus"></s:select>							
						</span>
					</td>
				</tr>
				 -->
				 <!-- 
				<tr>
					<td align="right" class="td1">
						推送广告状态：
					</td>
					<td align="left" class="td1">
						<s:select list="#{1:'测试',2:'即时推送',3:'不推送',7:'3天后推送',4:'30天后推送',5:'60天后推送',6:'90天后推送'}" name="machineInfo.autoFeeStatus"></s:select>
					</td>
				</tr>
				 -->
				<!-- 
				<tr>
					<td align="right" class="td1">
						是否弹出广告：
					</td>
					<td align="left" class="td1">
						<s:select list="#{1:'弹出',2:'不弹出'}" name="machineInfo.backFeeStatus"></s:select>							
					</td>
				</tr>
				 -->
				<tr>
					<td align="right" class="td1">
						客服中心广告：
					</td>
					<td align="left" class="td1">
						<s:select list="#{0:'不显示',1:'显示'}" name="machineInfo.bottomAdvSwitch"></s:select>						
					</td>
				</tr>
				<!-- 
				<tr>
					<td align="right" class="td1">
						推送广告：
					</td>
					<td align="left" class="td1">
						<s:select list="#{0:'不推送',1:'推送'}" name="machineInfo.pushAdvSwitch"></s:select>
					</td>
				</tr>
				<tr class="td1">
					<td height="36" align="right" class="td2">
						屏蔽级别：
					</td>
					<td align="left" class="td2">
						<s:radio list="#{'Y':'屏蔽','N':'不屏蔽'}" name="machineInfo.shieldStatus"></s:radio>					
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						<span class="td1">GPRS流量提醒开关：</span>
					</td>
					<td align="left" class="td1">
						<span class="td1"> 
							<s:radio list="#{0:'不提醒',1:'提醒'}" name="machineInfo.lltx"></s:radio>	
						</span>
					</td>
				</tr>
				<tr>
					<td align="right" class="td2">
						<span class="td1">菜单产品显示状态</span>：
					</td>
					<td class="td2">
						<s:radio list="#{'N':'显示','Y':'不显示'}" name="machineInfo.menuDis"></s:radio>	
					</td>
				</tr>
				 -->
				<tr>
					<td align="right" class="td1">
						服务器补发销量开关：
					</td>
					<td class="td1">
						<s:radio list="#{1:'补发',0:'不补发'}" name="machineInfo.moSaleSMS"></s:radio>					
					</td>
				</tr>
				<!-- 
				<tr>
					<td align="right" class="td1">
						结算状态：
					</td>
					<td class="td1">
						<s:select list="#{'Y':'正常','N':'暂停'}" name="machineInfo.balanceStatus"></s:select>						
					</td>
				</tr>
				 -->
				 <!-- 
				<tr>
					<td align="right" class="td1">
						屏蔽省份：
					</td>
					<td class="td1">
						<s:checkboxlist list="provinceList" listKey="intId" listValue="name" name="machineInfo.pids"></s:checkboxlist>
					</td>
				</tr>
				 -->
				<tr>
					<td align="right" class="td1"> 
						延保月数： 
					</td>
					<td class="td1">
					<s:textfield name="machineInfo.repair" size="8"  maxlength="8"   /> 
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						延保开关：
					</td>
					<td class="td1">
						<s:radio list="#{1:'开',0:'关'}" name="machineInfo.isopen" ></s:radio>
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						缤纷市场开关：
					</td>
					<td class="td1">
						<s:radio list="#{1:'开',0:'关'}" name="machineInfo.isAppshop" ></s:radio>
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						查看IMEI开关：
					</td>
					<td class="td1">
						<s:radio list="#{1:'开',0:'关'}" name="machineInfo.isIMEI" ></s:radio>
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						商城显示状态：
					</td>
					<td class="td1">
						<s:radio list="#{1:'商城',2:'缤纷市场',3:'特惠区'}" name="machineInfo.shopStyle"></s:radio>
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						联网销量提示设置：
					</td>
					<td align="left" class="td1">
					<s:if test="machineInfo.isPoint==-1||machineInfo.isPoint==1||machineInfo.isPoint==0||machineInfo.isPoint==7||machineInfo.isPoint==30">
					<s:select list="#{-1:'不提示',0:'只提示一次',1:'每日提示一次',7:'每周提示一次',30:'每30天提示一次',999999:'自定义天数'}" id="self" onchange="change()" name="machineInfo.isPoint" value="machineInfo.isPoint"></s:select> 
				   <input type="text" id="wr" disabled="false" />
					</s:if>
					<s:else>
					<s:select list="#{-1:'不提示',0:'只提示一次',1:'每日提示一次',7:'每周提示一次',30:'每30天提示一次',999999:'自定义天数'}" id="self" onchange="change()"  value="999999"></s:select> 
				   <input type="text" id="wr" name="machineInfo.isPoint" value="${isPoint}" />
					
					</s:else>
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						包版本：
					</td>
					<td class="td2">
						<input type="text" name="machineInfo.pakName" value="<s:property value="machineInfo.pakName" />">
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						上传包：
					</td>
					<td class="td2">
						<input type="file" name="pak" accept=".apk"/><font color="red">（包名不能有中文）</font> <input type="hidden" name="machineInfo.pakPath" value="<s:property value="machineInfo.pakPath" />">
					<br/><s:property value="machineInfo.pakPath" />
					</td>
				</tr>
				<tr>
					<td align="right" class="td1">
						出包人：
					</td>
					<td class="td2">
						<input type="text" name="machineInfo.pakUser" value="<s:property value="machineInfo.pakUser" />">
					</td>
				</tr>
				<tr>
					<td align="right" class="td2">
						其他备注：
					</td>
					<td class="td2">
						<s:textarea name="machineInfo.remark" cols="86" rows="2"></s:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="td_title2" style="TEXT-ALIGN: center">
						<input class=button type=submit value="确认，并提交！" name=Submit3>
						<input class=button type=button value="返　　　　　回" name=Submit3 onclick="history.back()">
					</td>
				</tr>
			</tbody>			
		</table>
		</s:form>
	</BODY>
</HTML>