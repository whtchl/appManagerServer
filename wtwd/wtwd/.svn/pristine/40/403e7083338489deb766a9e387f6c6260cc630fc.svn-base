<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.0 transitional//EN">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- saved from url=(0038)http://localhost/bbs/Admin/setting.asp -->
<HTML><HEAD><TITLE>管理页面</TITLE>
<LINK 
href="../images/main.css" type=text/css rel=stylesheet>

<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
<SCRIPT LANGUAGE="JavaScript">
var updatemesge='${sessionScope.LNAME}';
if(updatemesge!=null&&updatemesge!=''){
<%
session.setAttribute("LNAME", null);	
%>
}
<!-- 
var box="";
function delAll(csize) 
{
   for (var j = 1; j <=csize; j++) 
   {
      box = eval("document.checkboxform.slec" + j); 
      box.checked = false;
   }
}

function checkAll(csize) 
{ 
  for (var j = 1; j <= csize; j++) 
  {  
     box = eval("document.checkboxform.slec" + j);  
       box.checked = true;
   }
}

function DesignPageSize(svalue,limitvalue,logname){
	
    window.location="showloginuser.action?limitSet="+limitvalue+"&pageSize="+svalue+"&loginName="+logname;

}

function deleteAll(csize,pagenow,areavalue,logname,logid)
{
    var h="";
if(logid==""){
  for (var j = 1; j <= csize; j++) 
  {
     box = eval("document.checkboxform.slec" + j);  
       if(box.checked){
           h=h+box.value+",";
	   }
   }
    if(h==""){
   alert("请选择要操作的用户！");
   }
   else{
	   if(window.confirm("是否确认删除选中的记录?")==true){
    window.location="deleteLoginUser.action?loginIdList="+h+"&limitSet="+areavalue+"&pageSize="+csize+"&pageNow="+pagenow+"&loginName="+logname;
	   }
   }
}
else{
  if(window.confirm("是否确认删除此条记录?")==true){
    window.location="deleteLoginUser.action?loginId="+logid+"&limitSet="+areavalue+"&pageSize="+csize+"&pageNow="+pagenow+"&loginName="+logname;
	   }
}
}
function startOrForbatAll(statusflag,csize,pagenow,areavalue,logname,logid)
{
	var k="";
if(logid==""){
  for (var j = 1; j <= csize; j++) 
  {
     box = eval("document.checkboxform.slec" + j);  
       if(box.checked){
		   k=k+box.value+",";
	   }
   }
   if(k==""){
   alert("请选择要操作的用户！");
   }
   else{
	   if(window.confirm("是否确认?")==true){
	  window.location="login_updateStatusFlag.action?statusflag="+statusflag+"&loginIdList="+k+"&limitSet="+areavalue+"&pageSize="+csize+"&pageNow="+pagenow+"&loginName="+logname;
   }}
}
else{
  if(window.confirm("是否确认?")==true){
	  window.location="login_updateStatusFlag.action?statusflag="+statusflag+"&loginId="+logid+"&limitSet="+areavalue+"&pageSize="+csize+"&pageNow="+pagenow+"&loginName="+logname;
   }
}
}

 -->
</script>

<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
</HEAD>
<BODY>
<table cellspacing="1" cellpadding="3" width="100%" align=left border="0">
    <tbody>
      <tr>
        <th colspan="7" class="td_title" style="TEXT-ALIGN: center">应用版本管理<span class="STYLE1"></span> </th>
      </tr>
	 
      <tr><td valign="top">[<a href="topaddVerInfo?ptype=<s:property value="ptype"/>">新增版本</a>]<br></td>
        <td colspan="4" valign="top">&nbsp;  </td>
      </tr><tr>
        <td width="20%" height="45" align="center" class="td2"><strong>序号</strong></td>
        <td width="19%" align="center" class="td2"><strong>版本号</strong> </td>
        <td width="35%" align="center" class="td2"><strong>说明</strong></td>
        <td width="13%" align="center" class="td2"><strong>时间</strong></td>
        <td width="13%" align="center" class="td2"><strong>操作</strong></td>
      </tr>
    </tbody>
	<form name="checkboxform">
    <tbody>
	 <s:iterator value="versionInfo" status="listid">
	 <s:if test="(#listid.count%2)==1">
     <s:set name="cs" value="%{'td1'}" />
     </s:if>
	 <s:else>
      <s:set name="cs" value="%{'td2'}" />
	 </s:else>
      <tr>
        <td align="center" class='<s:property value="%{#cs}"/>'><s:property value="#listid.count"/>          </td>
	    <td height="36" align="center" class='<s:property value="%{#cs}"/>'>
	      <s:property value="ver"/></td>
        <td align="center" class='<s:property value="%{#cs}"/>'><s:property value="remark"/>				</td>
        <td align="center" class='<s:property value="%{#cs}"/>'>
          <s:property value="creatTime"/>&nbsp;                					</td>
        <td align="center" class='<s:property value="%{#cs}"/>'><a href="pgetVerInfo?vid=<s:property value="id"/>&ptype=<s:property value="ptype"/>">修改</a></td>
      </tr>
      </s:iterator>
      <tr>
        <td colspan="7" align="center" class="td1">&nbsp;        </td></tr>
      <tr>
        <td colspan="7" align="right" class="td2">&nbsp;</td>
      </tr>
    </tbody> 
</table>
</BODY></HTML>