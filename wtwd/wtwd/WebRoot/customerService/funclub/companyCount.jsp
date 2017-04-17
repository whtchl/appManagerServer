<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<LINK href="/images/main.css" type=text/css rel=stylesheet>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<<LINK href="/images/main.css" type=text/css rel=stylesheet>
		<link href="css/calendar.css" rel="stylesheet" type="text/css">
		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
		<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
	</head>
	<body>

		<script type="text/javascript" src="/js/calendar.js"></script>
		<form action="companyCount" method="post">
			<label>
				<strong>请选择查询日期范围</strong> &nbsp;
				<input name="starTime" type="text" id="starTime"
					onclick="showcalendar(event, this);"
					onfocus="showcalendar(event, this);" size="15">
				至
				<input name="endTime" type="text" id="endTime"
					onclick="showcalendar(event, this);"
					onfocus="showcalendar(event, this);" size="15">
			</label>

			<select name="companyInfo.id">
				<option value="0" selected="selected">
					全部
				</option>
				<s:iterator value="companyList">
					<option value="<s:property value='id'/>">
						<s:property value="name" />
					</option>
				</s:iterator>
			</select>
			<input name="button33" type="submit" class="button" value="查询" />			
		</form>
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">
			<th colspan="8" class="td_title" style="TEXT-ALIGN: center">
				合作厂家统计
			</th>
			<tr>
				<td>
					合作厂家
				</td>
				<td>
					文件名称
				</td>
				<td>
					下载次数
				</td>
				<td>
					下载时间
				</td>
			</tr>
			<s:iterator value="dlInfoList" var="dl">
				<tr>
					<td>
						<s:property value="#dl.info.name" />
					</td>
					<td>
						<s:property value="#dl.fileInfo.name" />
					</td>
					<td>
						<s:property value="companyCount" />
					</td>
					<td>
						<s:property value="downLoadTime" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
