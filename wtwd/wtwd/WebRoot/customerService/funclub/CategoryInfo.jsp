<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更改</title>
<script type="text/javascript">
 function check(){
 var val=document.getElementById('logourl').value;//获取login的值
 var lastIndex=val.lastIndexOf('.');//以.为分隔符
var typeName=val.substring(lastIndex+1);//得到.后面的文件类型
 if(typeName=='jpg'||typeName=='jpeg'||typeName=='gif'||typeName=='png'){
   return true;
 }
 else{
 alert('请选择正确的图片格式');
 //document.getElementById('uplsoad').innerHTML=html;
 }
  }
</script>
</head>
<body>
<form action="goUpdate" method="post" enctype="multipart/form-data">
<input type="hidden" value="<s:property value='fileCategory.IntId'/>" name="fileCategory.IntId"/>
<input   type="hidden" value="<s:property value='fileCategory.TIcon'/>" name="fileCategory.TIcon"/>
类型名称<input value="<s:property value='fileCategory.Name'/>" name="fileCategory.Name"/><br/><br/>
简    称：<input value="<s:property value='fileCategory.shotName'/>" name="fileCategory.shotName"/><br/><br/>
<img src="<s:property value='fileCategory.TIcon'/>" /><br/><br/>
类型图片:<input type="file" name="pcLogo" id="logourl"  onchange="check();"/><br/><br/>
位    置:<input type="radio" name="fileCategory.TPosition" value="1" checked >
软件<br>
<input value="提交" type="submit"/>
</form>
</body>
</html>