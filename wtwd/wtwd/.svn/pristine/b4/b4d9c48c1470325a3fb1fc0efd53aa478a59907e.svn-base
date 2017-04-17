<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<script type="text/javascript">
function oncl(vv){
alert(vv);
}
</script>
</head>
<body>
<form action="addGameFileInfo" method="post" enctype="multipart/form-data">
<table>
<caption>添加文件名称</caption>
<tr><td>文件类型:<select onchange="oncl(this.value);" name="fileInformation.categoryId">
<s:iterator value="cateList" >
<option value="<s:property value='IntId'/>"><s:property value="shotName"/></option>
</s:iterator>
</select></tr>
<tr><td>名    称:<input type="text" name="fileInformation.name"/></td></tr>
<tr><td>文件大小:<input type="text" name="fileInformation.fileSize"/></td></tr>
<tr><td>文件logo:<input type="file" name="pcLogo"/></td></tr>
<tr><td>上传软件:<input type="file" name="softFile"/></td></tr>
<tr><td>下载等级:<input type="radio" checked="checked" name="fileInformation.fileGrad" value="2"/>☆☆<input type="radio" name="fileInformation.fileGrad"  value="3"/>☆☆☆<input type="radio" name="fileInformation.fileGrad"  value="4"/>☆☆☆☆<input type="radio" name="fileInformation.fileGrad"  value="5"/>☆☆☆☆☆</td></tr>
<tr><td>文件详情:<input type="text" name="fileInformation.information"/></td></tr>
<tr><td>文件图片:<input type="file" name="upfile"/></td></tr>
<tr><td>系统平台:<input type="text" name="fileInformation.OSYQ"/></td></tr>
<tr><td>版本型号:<input type="text" name="fileInformation.fileVersion"/></td></tr>
<tr><td>开 发 者:<input type="text" name="fileInformation.fileDevloper"/></td></tr>
</table>
<input type="submit" value="提交"/>
</form>
</body>
</html>