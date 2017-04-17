<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cncoman.product.bean.*,com.cncoman.product.util.Constants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%
UserInfo curUser = (UserInfo) session.getAttribute(Constants.SESSION_USER);
if(curUser == null){
	response.sendRedirect("/");
}
%>
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<TITLE>管理页面信息管理平台</TITLE>
		<META http-equiv=content-type content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="images/zs_16x16.ico">
		<LINK href="/images/style.css" type=text/css rel=stylesheet>
		<STYLE>.main_left {
	TABLE-LAYOUT: auto; BACKGROUND: url(images/left_bg.gif)
}
.main_left_top {
	BACKGROUND: url(images/left_menu_bg.gif); PADDING-TOP: 5px
}
.main_left_title {
	PADDING-LEFT: 15px; FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #fff; TEXT-ALIGN: left
}
.left_iframe {
	BACKGROUND: none transparent scroll repeat 0% 0%; VISIBILITY: inherit; WIDTH: 180px; HEIGHT: 92%
}
.main_iframe {
	Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 92%
}
TABLE {
	FONT-SIZE: 12px; FONT-FAMILY: tahoma, 宋体, fantasy
}
TD {
	FONT-SIZE: 12px; FONT-FAMILY: tahoma, 宋体, fantasy
}
</STYLE>
		<SCRIPT>
var status = 1;
/*
var Menus = new DvMenuCls;
document.onclick=Menus.Clear;
*/
function switchSysBar(){
     if (1 == window.status){
		  window.status = 0;
          switchPoint.innerHTML = '<img src="images/left.gif">';
          document.all("frmTitle").style.display="none"
     }
     else{
		  window.status = 1;
          switchPoint.innerHTML = '<img src="images/right.gif">';
          document.all("frmTitle").style.display=""
     }
}
</SCRIPT>
		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
	</HEAD>
	<BODY style="MARGIN: 0px">
		<TABLE style="BACKGROUND: #c3daf9" height="100%" cellSpacing=0
			cellPadding=0 width="100%" border="0">
			<TBODY>
				<TR>
					<TD colspan="3" height=58>
						<IFRAME id=top
							style="VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%" name=top
							src="include/Top.jsp" frameborder="0" scrolling=no></IFRAME>
					</TD>
				</TR>
				<TR>
					<TD colspan="3" height=30>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border="0">
							<TBODY>
								<TR height=32>
									<TD style="PADDING-LEFT: 10px" width=16
										background=images/bg2.gif>
										<IMG src="images/user.png" alt="" align=absMiddle>
									</TD>
									<TD width="80%" background=images/bg2.gif>
										&nbsp;欢迎您，
										<font color="#0099cc">【<%=curUser.getCompany().getName() %>】</font><font color="#ff9900"><%=curUser.getName() %></font>，今天是<%=new java.text.SimpleDateFormat("yyyy年MM月dd日 E").format(new java.util.Date()) %>										
									</TD>
									<TD width="20%" align="right" background=images/bg2.gif>
										<A href="toChangePwd" target="frmright">修改密码</A>
										<A onClick="exit();" href="logout.action">安全退出</A>&nbsp;&nbsp;
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
				<TR>
				
				<!-- 
					<TD id=frmTitle style="BACKGROUND: #c9defa" vAlign=top align=middle
						name="fmtitle">
						<IFRAME id=frmleft
							style="BACKGROUND: url(images/leftop.gif) no-repeat; VISIBILITY: inherit; WIDTH: 185px; HEIGHT: 100%"
							name=frmleft src="include/left.jsp" frameborder="0"
							allowTransparency></IFRAME>
					</TD>
					<TD style="WIDTH: 0px" valign="center">
						<DIV onclick=switchSysBar()>
							<SPAN class=navpoint id=switchPoint title=关闭/打开左栏><IMG
									alt="" src="images/right.gif">
							</SPAN>
						</DIV>
					</TD>
					<TD style="WIDTH: 100%" vAlign=top>
						<iframe id=frmright
							style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%"
							name=frmright src="main_index.htm" frameborder="0" scrolling=yes></iframe>
					</TD>
					 -->
					 
					 <TD width="16%"  id=frmTitle style="BACKGROUND: #c9defa" vAlign=top align="right"
						name="fmtitle">
						<IFRAME id=frmleft
							style="BACKGROUND: url(images/leftop.gif) no-repeat; VISIBILITY: inherit; WIDTH: 185px; HEIGHT: 100%"
							name=frmleft src="include/left.jsp" frameborder="0"
							allowTransparency></IFRAME>
					</TD>
					<TD width="2%" style="WIDTH: 0px" valign="center">
						<DIV onclick=switchSysBar()>
							<SPAN class=navpoint id=switchPoint title=关闭/打开左栏><IMG
									alt="" src="images/right.gif">
							</SPAN>
						</DIV>
					</TD>
					<TD style="WIDTH: 100%" width="81%" vAlign=top>
						<iframe id=frmright
							style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%"
							name=frmright src="main_index.htm" frameborder="0" scrolling=yes></iframe>
					</TD>
					
				</TR>
			</TBODY>
		</TABLE>
		<DIV id=dvbbsannounce_true style="DISPLAY: none">
		</DIV>
	</BODY>
</HTML>