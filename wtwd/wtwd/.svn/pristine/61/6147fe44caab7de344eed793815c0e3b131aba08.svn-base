<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<head>
<script>

function tochange(value){
if(value==1){
document.getElementById('rj1').style.display='block';
document.getElementById('zj1').style.display='none';
document.getElementById('yx1').style.display='none';

}
else if(value==2){
document.getElementById('yx1').style.display='block';
document.getElementById('zj1').style.display='none';
document.getElementById('rj1').style.display='none';

}
else if(value==3){
document.getElementById('zj1').style.display='block';
document.getElementById('rj1').style.display='none';
document.getElementById('yx1').style.display='none';

}

}
</script>
</head>
<body>
<div align="center">

<div><a href="http://wz.easou.com?esid=whmaHuvL29I&amp;wver=t"><img src="http://wz.easou.com/images/logo2.png" /></a></div>
<div id="seach">
<input id="search_input" class="inputsearh" type="text" autocomplete="off" maxlength="38" value="全国高考" name="q" />
<input id="search_type_input" type="hidden" name="search_kind" value="searchcont"/>
<input id="search_btn" name="ch_wappage" class="aclose" type="submit" value="搜索"/>
</div>
<div id="adver">
*诺基亚WP7最新款手机580元
</div>
<a id="rujian"  href="javascript:;" onmousemove="tochange(1);">软件</a>
<a id="yx"  href="javascript:;" onmousemove="tochange(2);">游戏</a>
<a id="zj"  href="javascript:;" onmousemove="tochange(3);">装机必备</a>

<div id="rj1" >
<s:iterator value="cateList" var="file">
<s:if test="#file.TPosition==0"><a href="getFileList?id=<s:property value='IntId'/>"><s:property value="shotName"/></a></s:if>
</s:iterator>
</div>
<div  id="yx1"><s:iterator value="cateList" var="file">
<s:if test="#file.TPosition==1"><a href="getFileList?id=<s:property value='IntId'/>"><s:property value="shotName"/></a></s:if>
</s:iterator></div>
<div  id="zj1"><s:iterator value="cateList" var="file">
<s:if test="#file.TPosition==2"><a href="getFileList?id=<s:property value='IntId'/>"><s:property value="shotName"/></a></s:if>
</s:iterator>
</div>

</div>
</body>
<script type="text/javascript">
document.getElementById('rj1').style.display='block';
document.getElementById('zj1').style.display='none';
document.getElementById('yx1').style.display='none';
</script>
</html>