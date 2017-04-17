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
<META content="MSHTML 6.00.2900.3268" name=GENERATOR></HEAD>
<BODY>
<s:fielderror />
 <form action="addCategory" method="post">
<table cellspacing=1 cellpadding=3 width="100%" align=center border=0>
    <tbody>
      <tr>
        <th colspan=2 class="td_title" style="TEXT-ALIGN: center">添加网址类型
		</th>
      </tr>
      <TR>
        <TD width="90" class=td2>类型名称</TD>
        <TD width="640"class=td2>
          <div align="left"><INPUT size=25 name="webCategoryInfo.name"/><br>
              </div></TD></TR>
                <TR>
        <TD width="90" class=td2>排序</TD>
        <TD width="640"class=td2>
          <div align="left"><INPUT size=5 name="webCategoryInfo.sort" value="0"/><br>
              </div></TD></TR>
      
      <TR>
        <TD width="90" class=td1>&nbsp;</TD>
        <TD class=td1>
        <input  type="submit" class="button" value="提交">
        <input  type="button" class="button" value="返回" onclick="history.back(-1)">
        </TD>
      </TR>
    </tbody>
 
</table>
 </form>
</BODY></HTML>