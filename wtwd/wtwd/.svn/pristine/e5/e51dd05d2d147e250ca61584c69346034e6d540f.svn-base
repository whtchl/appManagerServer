<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
<head>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加类型</title>
<script type="text/javascript"> 
//var html=document.getElementById('uplsoad').innerHTML;
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
<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
<body>
<form action="addCate" method="post" enctype="multipart/form-data">
<table cellspacing="1" cellpadding="3" width="100%" align="center" border="0">
<caption></caption>
<th colspan="8" class="td_title" style="TEXT-ALIGN: center">添加类型</th>
<tr class="tdbg"><td>类型名称:</td><td><input size="18" type="text" name="fileCategory.Name" /></td></tr>
<tr class="tdbg"><td>简    称:</td><td><input type="text" name="fileCategory.shotName" size="2"/></td></tr>
<tr class="tdbg"><td>位    置:</td><td>
<input checked="checked" type="radio" name="fileCategory.TPosition" value="1">
软件</td></tr>
<tr class="tdbg"><td>类型logo:</td><td><input type="file" name="upfile" id="logourl" size="30" onchange="check();" ></td></tr>
<tr class="tdbg"><td></td><td><input type="submit"  value="提交"></td></tr>
</table>
</form>
</body>
</html>