<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>data123管理页面</TITLE>
		<META http-equiv=content-type content="text/html; charset=UTF-8">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>
		<link href="css/calendar.css" rel="stylesheet" type="text/css">

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
		<script language="javascript" src="js/calendar.js"
			type="text/javascript"></script>
		<s:form action="orzAppSta" method="post">
			<table width="100%" border="0" cellpadding="1" cellspacing="1">
			<tr>
        <th colspan=2 class="td_title" style="TEXT-ALIGN: center">应用下载统计
		</th>
      </tr>
				<tr class="title">
					<td width="100%" class="td_title1" style="TEXT-ALIGN:  left">
						<strong>查询条件：</strong>日期
						<s:textfield name="orzStaInfo.fromDay" cssClass="textfield"
								size="8" maxlength="8" onclick="showcalendar(event, this);"
								onfocus="showcalendar(event, this);" readonly="readonly" />
							至
							<s:textfield name="orzStaInfo.toDay" cssClass="textfield"
								size="8" maxlength="8" onclick="showcalendar(event, this);"
								onfocus="showcalendar(event, this);" readonly="readonly" />
								
		 
		<s:select list="#{1:'-按日期-',2:'-按月份-',3:'-按产品-',4:'-按渠道-'}"	name="orzStaInfo.groupBy" id="groupBy"></s:select>

						<INPUT type="submit" class="BUTTON" value="查询">
					</td>					
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="1" cellspacing="1">				
				<tr class="td2">
					<td align="center" class="td2" >
						<strong> <s:property value="orzStaInfo.title"/> </strong>
					</td>
			 		 <td align="center" class="td2" >
						<strong>下载用户</strong>
					</td>
					<td align="center" class="td2" >
						<strong>下载用户累计</strong>
					</td>  	
					 <td align="center" class="td2" >
						<strong>下载次数</strong>
					</td>
					<td align="center" class="td2" >
						<strong>下载次数累计</strong>
					</td> 
				</tr>
				<s:iterator value="orzStaList" id="info" status="s" var="ss">
					<TR>
					<TD align="center">
						<s:property value="title"/>
					</TD>
					<s:if test="#ss.title=='合计：'"><!-- 判断是否是最后一个对象 -->
					<TD align="center">
						<s:property value="user"/>(去重)
					</TD>
					</s:if>
					<s:else>
					<TD align="center">
						<s:property value="user"/>
					</TD>
					</s:else>
					<TD align="center">
						<s:property value="allUser"/>
					</TD>
					<TD align="center">
						<s:property value="download"/>
					</TD>
					<TD align="center">
						<s:property value="downloads"/>
					</TD>
				</TR>
				</s:iterator>
			</table>			
		</s:form>
		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	</BODY>
</HTML>
