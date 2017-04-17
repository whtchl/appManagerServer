<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>类型管理</title>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<script type="text/javascript">
function DeletCate(id,filecount){
if(window.confirm("确定删除?")){
if(filecount!=0){
alert('里面有文件!不能删除');
}
else {
window.location.href="DeletCate?id="+id;
 }
}
else return ;
}

function goUpdate(id){
window.location.href="goUpdate?id="+id;
}
function orderIndex(csize)
{
var k="";
var id="";
var  ms="是否确定？";
 var s;
 
 if(window.confirm(ms)==true){

  for (var j = 0; j < csize; j++) 
  {
     box = eval("document.indexform.orderBy" + j);  
     Tid = eval("document.indexform.Tid" + j); 
		   k=k+box.value+",";
		  
		   id=id+Tid.value+",";
		   if(box.value==""){
		   s=1;
		   }
   }
  if(s!=1){
    window.location="/updateShowId?webshowid="+k+"&webIDList="+id;	
	}else{
	alert("显示排序不能为空！");
	}
 }
}
</script>
</head>
<body>
<form  name="indexform" id="indexform" action="/categoryManage">
<table cellspacing="1" cellpadding="3" width="100%" align="center" border="0">
<th colspan="8" class="td_title" style="TEXT-ALIGN: center">类型管理</th>
<tr><td>显示位置</td><td>序号</td><td>名称</td><td>简称</td><td>下载统计</td><td>图标</td><td>位置</td><td>操作</td></tr>
<s:iterator value="cateList">
<tr>
<td><input size="2" value="<s:property value='showId' />" name="orderBy<s:property value='listId'/>"/>
<input value='<s:property value="IntId"/>' type="hidden" name="Tid<s:property value='listId'/>" /></td>
<td><s:property value='listId+1'/></td>
<td><s:property value="Name"/>(<s:property value="fileCount"/>个)</td>
<td><s:property value="shotName"/></td>
<td><s:property value="downCount"/></td>
<td><IMG width="70" height="60" alt="" src="<s:property value='TIcon'/>"/></td>
<td>
<s:if test="TPosition==1">软件</s:if>
<s:else >游戏</s:else>
</td>
<td><a href="javascript:;" onclick="DeletCate(<s:property value='intId'/>,<s:property value="fileCount"/>)">删除</a>&nbsp;|&nbsp;<a href="javascript:;" onclick="goUpdate(<s:property value='intId'/>)">编辑</a></td>
</tr>
</s:iterator>
</table>
<input name="button3" type="button" class="button" value="确定" onClick="javascript:orderIndex(<s:property value="cateList.size()"/>);" />
</form>
</body>
</html>