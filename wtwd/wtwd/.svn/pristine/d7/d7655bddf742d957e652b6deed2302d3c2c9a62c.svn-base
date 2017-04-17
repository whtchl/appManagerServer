<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML><HEAD>
<TITLE>管理页面</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK href="../images/main.css" type=text/css rel=stylesheet>
<SCRIPT src="../images/main82.js" type=text/javascript></SCRIPT>
<SCRIPT src="../script/common.js" type="text/javascript"></SCRIPT>
<SCRIPT src="../images/setting_admin.js" type=text/javascript></SCRIPT>
<style type="text/css">
<!--
.STYLE1 {color: #FF3366}
-->
</style>
<SCRIPT type="text/javascript">

 function isChart() {
	var el = document.getElementById('Brand_E'); 
	reg = /^[A-Za-z\-\_]+$/;
	var result = reg.test(el.value); 
	if(!result){ 
            el.className = "warn"; 
             return false;  
         } 
     else
        {  el.className = "";
           return true; 
         } 
  }
function isurl(vurl){
var turl=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\ %&=]*)?/;
//var el = document.getElementById('weburl'); 
var result = turl.test(vurl.value); 
	if(!result){ 
            vurl.className = "warn"; 
             return false;  
         } 
     else
        {  vurl.className = "";
           return true; 
         } 
}

function isPhone(e) {     
	var key = window.event ? e.keyCode : e.which;    
	var keychar = String.fromCharCode(key);     
	var el = document.getElementById('servicetel');    
	reg = /^(\+\d+ )?(\(\d+\) )?[\d\- ]+$/; 
	var result = reg.test(keychar);    
	if(!result){ 
            el.className = "warn"; 
			alert("只能输入数字");
             return false;  
         } 
     else
        {  el.className = "";
           return true; 
         } 
} 

function check(){
  if(!isChart()){
     alert("品牌英文名称只能输入英文字母");
	 return false;
  }
  if(document.getElementById('weburl').vaule!=''&&!isurl(document.getElementById('weburl'))){
    alert("weburl请输入合法的网址！");
	 return false;
  }
    if(document.getElementById('wapurl').vaule!=''&&!isurl(document.getElementById('wapurl'))){
    alert("wapurl请输入合法的网址！");
	 return false;
  }
  var logopic = document.getElementById("logopic").value;
   if(logopic!=""){
  if(getExtn(logopic)!="jpg"&&getExtn(logopic)!="jpeg"&&getExtn(logopic)!="gif"&&getExtn(logopic)!="png"&&getExtn(logopic)!="bmp"){
   alert("你上传LOGO图不是图片文件");
   return false;
  }
  }
   return true;

}
</SCRIPT>
<META content="MSHTML 6.00.2900.3268" name=GENERATOR></HEAD>
<BODY>
<s:fielderror />
 <form name="theform" action="pupdateVerInfo" method="post"   onSubmit="return check();">
<table cellspacing=1 cellpadding=3 width="100%" align=center border=0>
 
    <tbody>
	 
      <tr>
        <th colspan=2 class="td_title" style="TEXT-ALIGN: center">修改版本信息		</th>
      </tr>
      <TR>
        <TD width="90" class=td2>版本号</TD>
        <TD width="640"class=td2>
          <div align="left"><INPUT size=25 name="versionbean.ver" value="<s:property value="versionbean.ver"/>"/><input type="hidden" name="versionbean.id" value="<s:property value="versionbean.id"/>"/>
         <input type="hidden" name="ptype" value="<s:property value="ptype"/>"/> </div></TD></TR>
      
     
      <TR>
        <TD width="90" class="td1">说明<br></TD>
        <TD class="td1"><label>
          <textarea name="versionbean.remark" cols="80" rows="5"><s:property value="versionbean.remark"/></textarea>
        </label>          &nbsp;<span class="STYLE1"></span></TD>
      </TR>
	  
      <TR>
        
      </TR>
      <TR>
        <TD width="90" class=td1>&nbsp;</TD>
        <TD class=td1><input name="tj" type="submit" class="button" id="tj" value="提 交"></TD>
      </TR>
    </tbody>
 
</table>
 </form>
</BODY></HTML>