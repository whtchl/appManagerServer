<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.cncoman.product.bean.*, com.cncoman.product.bean.ResourceInfo, java.util.*,com.cncoman.product.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>信息管理平台</TITLE>
<META http-equiv=content-type content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta http-equiv="expires" content="Wed,26 Feb 2000 08:21:10 GMT">
<STYLE type=text/css> 
BODY {
	BACKGROUND: url(../images/leftbg.gif); MARGIN: 0px; OVERFLOW: hidden
}
.left_color {
	TEXT-ALIGN: right
}
.left_color A {
	PADDING-RIGHT: 10px;  FONT-SIZE: 12px; 
	BACKGROUND: url(../images/menubg.gif) no-repeat 7px 50% !important; 
	BACKGROUND: url(../images/menubg.gif) no-repeat right 50%;/* ie 8/9*/
    *BACKGROUND: url(../images/menubg.gif) no-repeat right 50%;  /* ie 7*/
     _BACKGROUND: url(../images/menubg.gif) no-repeat right 50%;  /* ie 6*/
	MARGIN-BOTTOM: 2px; WIDTH: 180px; COLOR: #083772; LINE-HEIGHT: 23px; HEIGHT: 23px; TEXT-ALIGN: right; TEXT-DECORATION: none; display:block;
}
.left_color A:hover {
	BACKGROUND: url(../images/menubg_hover.gif) no-repeat right 50%; COLOR: #7b2e00
}
IMG {
	FLOAT: none; VERTICAL-ALIGN: middle
}
#on {
	FONT-WEIGHT: bold; BACKGROUND: url(../images/menubg_on.gif) #fff no-repeat right 50%; COLOR: #f20
}
HR {
	BORDER-TOP: #46a0c8 1px solid; WIDTH: 90%; HEIGHT: 0px; TEXT-ALIGN: left; size: 0
}
</STYLE>
<!-- 
<STYLE type=text/css>
BODY {
	BACKGROUND: url(../images/leftbg.gif); MARGIN: 0px; OVERFLOW: hidden
}
.left_color {
	TEXT-ALIGN: right
}
.left_color A {
	PADDING-RIGHT: 10px; DISPLAY: inline; FONT-SIZE: 12px; BACKGROUND: url(../images/menubg.gif) no-repeat right 50%; MARGIN-BOTTOM: 2px; WIDTH: 180px; COLOR: #083772; LINE-HEIGHT: 23px; HEIGHT: 23px; TEXT-ALIGN: right; TEXT-DECORATION: none
}
.left_color A:hover {
	BACKGROUND: url(../images/menubg_hover.gif) no-repeat right 50%; COLOR: #7b2e00
}
IMG {
	FLOAT: none; VERTICAL-ALIGN: middle
}
#on {
	FONT-WEIGHT: bold; BACKGROUND: url(../images/menubg_on.gif) #fff no-repeat right 50%; COLOR: #f20
}
HR {
	BORDER-TOP: #46a0c8 1px solid; WIDTH: 90%; HEIGHT: 0px; TEXT-ALIGN: left; size: 0
}
</STYLE>
 -->
<%
UserInfo curUser = (UserInfo) session.getAttribute(Constants.SESSION_USER);
if(curUser == null){
	response.sendRedirect("/");
}
List<ResourceInfo> list = curUser.getRole().getResourceList();
%>
<SCRIPT type=text/javascript>
<!--
	function disp(n){		
		var ids = new Array();
		<%
			int i = 0;
			for(ResourceInfo resource : list){
				if(resource.getGrade() == 1){
					%>
					ids[<%=i %>] = <%=resource.getIntId() %>;
					<%
					i++;
				}
			}
		%>

		for (var i = 0; i < ids.length; i++){
			if (!document.getElementById("left" + ids[i])){
			 	return;
			 }
			document.getElementById("left" + ids[i]).style.display="none";
		}
		document.getElementById("left"+n).style.display="";
	}
//-->
</SCRIPT>

<META content="MSHTML 6.00.2900.3268" name="GENERATOR"></HEAD>
<BODY>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border="0">
  <TBODY>
  <TR>
    <TD class=left_color id=menubar style="PADDING-TOP: 10px" vAlign=top>
    <!-- 
    <DIV id=left1>
	  <A href="/index.jsp" target=frmright>收益查询</A> 
	  <A href="/index.jsp" target=frmright>销量统计</A> 
	  <A href="/index.jsp" target=frmright>按通道查询</A>
      <A href="/index.jsp" target=frmright>请求查询</A> 
	 </DIV>
	  -->
    <%    
	for(ResourceInfo resource : list){
		if(resource.getGrade() == 1){
		%>
			<DIV id=left<%=resource.getIntId() %> style="DISPLAY: none">
			<%for(ResourceInfo resource2 : list){
				if(resource2.getGrade() == 2 && resource2.getParentId() == resource.getIntId()){
				%>
					 <A href="<%=resource2.getUrl() %>" target=frmright><%=resource2.getName() %></A>
				<%}
			} %>
			</DIV><%
		}
	}%>	
</TD></TR></TBODY></TABLE>
</BODY></HTML>
