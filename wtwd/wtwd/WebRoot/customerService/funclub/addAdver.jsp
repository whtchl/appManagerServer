<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加广告</title>
</head>
<body>
<form action="addAdever" method="post">
<label><strong>添加广告</strong></label><br/><br/>
<input type="hidden" name="funclubAdver.code" value="<s:property value='funclubAdver.code'/>"/>
名称:<input name="funclubAdver.name" type="text"/><br/><br/>
简&nbsp;&nbsp;&nbsp;称:<input name="funclubAdver.shotName" type="text"/><br/><br/>
地址:<input name="funclubAdver.furl" type="text"/><br/><br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>