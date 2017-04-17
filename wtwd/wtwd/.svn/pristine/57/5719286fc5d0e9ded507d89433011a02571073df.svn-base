<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.cncoman.product.bean.*, com.cncoman.product.bean.ResourceInfo, java.util.*,com.cncoman.product.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>信息管理平台</TITLE>
<META http-equiv=content-type content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta http-equiv="expires" content="Wed,26 Feb 2000 08:21:10 GMT">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px; BACKGROUND: url(../images/top_bg.gif) #337abb; MARGIN: 0px
}
DIV {
	PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px
}
.system_logo {
	MARGIN-TOP: 5px; FLOAT: left; MARGIN-LEFT: 5px; WIDTH: 360px; TEXT-ALIGN: left
}
#tabs {
	FLOAT: left; WIDTH: auto; LINE-HEIGHT: normal
}
#tabs UL {
	PADDING-RIGHT: 10px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 27px; LIST-STYLE-TYPE: none
}
#tabs LI {
	PADDING-RIGHT: 0px; DISPLAY: inline; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px
}
#tabs A {
	PADDING-RIGHT: 0px; PADDING-LEFT: 4px; BACKGROUND: url(../images/tableft6.gif) no-repeat left top; FLOAT: left; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px; TEXT-DECORATION: none
}
#tabs A SPAN {
	PADDING-RIGHT: 8px; DISPLAY: block; PADDING-LEFT: 6px; BACKGROUND: url(../images/tabright6.gif) no-repeat right top; FLOAT: left; PADDING-BOTTOM: 6px; COLOR: #e9f4ff; PADDING-TOP: 8px
}
#tabs A SPAN {
	FLOAT: none
}
#tabs A:hover SPAN {
	COLOR: #fff
}
#tabs A:hover {
	BACKGROUND-POSITION: 0% -42px
}
#tabs A:hover SPAN {
	BACKGROUND-POSITION: 100% -42px; COLOR: #222
}
</STYLE>
<META content="MSHTML 6.00.2900.3268" name="GENERATOR"></HEAD>
<BODY>
<DIV class=menu>
<DIV class=system_logo style="padding-top:5px;"><img src="../images/succLogo2.png"></DIV>
<DIV id=tabs>
<%
UserInfo curUser = (UserInfo) session.getAttribute(Constants.SESSION_USER);
if(curUser == null){
	response.sendRedirect("/");
}
List<ResourceInfo> list = curUser.getRole().getResourceList();
%>
	<UL>
	  <%for(ResourceInfo resource : list){
	  if(resource.getGrade() == 1){
	  	%>
	  	<LI><A onclick=parent.frmleft.disp(<%=resource.getIntId() %>);href="<%=resource.getUrl() %>" target=frmright><SPAN><%=resource.getName() %></SPAN></A></LI> 
	  	<%
	  }
 }%>
	
	</UL>

</DIV>
<DIV style="CLEAR: both"></DIV></DIV></BODY></HTML>
