<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateAdver" method="post">
<strong>广告修改</strong><br/><br/><br/>
<input type="hidden" name="funclubAdver.intId" value="<s:property value='funclubAdver.intId'/>"/>
<strong>广告名称:</strong><INPUT name="funclubAdver.name" value="<s:property value='funclubAdver.name'/>"/><br/><br/><br/>
<strong>广告简称:</strong><input name="funclubAdver.shotName" value="<s:property value='funclubAdver.shotName'/>"/><br/><br/>
<strong>广告地址:</strong><input  name="funclubAdver.furl" value="<s:property value='funclubAdver.furl'/>"/><br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>