<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
</head>
<body>
<form action="<s:property value='fileInformation.fileContent'/>">
<div align="center">
<table style="background-color:blue">
<tr ><td rowspan="2"><img src="<s:property value='fileInformation.fileIcon'/>"/></td><td><s:property value="fileInformation.name"/></td></tr>
<tr><td><s:property value="fileInformation.fileSize"/></td></tr>
</table>
<table>
<tr><td></td><td align="left">软件介绍:</td></tr>
<tr><td></td><td><s:property value="fileInformation.information" escape="false"/></td></tr>
<tr><td></td><td><img src="<s:property value='fileInformation.fileImage'/>" /></td></tr>
<tr><td></td><td>[下载次数]:<s:property value="fileInformation.downLoadCount"/></td></tr>
<tr><td></td><td>[文件等级]:<s:property value="fileInformation.fileGrad"/></td></tr>
<tr><td></td><td>[系统要求]:<s:property value="fileInformation.OSYQ"/></td></tr>
<tr><td></td><td>[系统版本]:<s:property value="fileInformation.fileVersion"/></td></tr>
<tr><td></td><td>[开发者] :<s:property value="fileInformation.fileDevloper"/></td></tr>

<tr><td></td><td><input value="下载" type="submit" /></td></tr>
</table>
</div>
</form>
</body>
</html>