<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html 
xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>数据产品运营中心</title>
<link rel="stylesheet" href="css/viplogin_bak.css">
<meta name="GENERATOR" content="MSHTML 9.00.8112.16457">
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
<script language="javascript">
// 修复 IE 下 PNG 图片不能透明显示的问题
function fixPNG(myImage) {
var arVersion = navigator.appVersion.split("MSIE");
var version = parseFloat(arVersion[1]);
if ((version >= 5.5) && (version < 7) && (document.body.filters))
{
     var imgID = (myImage.id) ? "id='" + myImage.id + "' " : "";
     var imgClass = (myImage.className) ? "class='" + myImage.className + "' " : "";
     var imgTitle = (myImage.title) ? "title='" + myImage.title   + "' " : "title='" + myImage.alt + "' ";
     var imgStyle = "display:inline-block;" + myImage.style.cssText;
     var strNewHTML = "<span " + imgID + imgClass + imgTitle

   + " style=\"" + "width:" + myImage.width

   + "px; height:" + myImage.height

   + "px;" + imgStyle + ";"

   + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"

   + "(src=\'" + myImage.src + "\', sizingMethod='scale');\"></span>";
     myImage.outerHTML = strNewHTML;
} } 

window.onload=function(){
         document.getElementById("top").style.height=screen.height/5+"px";
        
}//
</script>

<script type="text/javascript">
    var conf = {
        isVip:false,
        isMem:false
    };
    var sinaSSOConfig = {
        entry : 'pcncoman', // 本产品的标识
        loginType : 0,
        setDomain : true,
        pageCharset :'UTF-8',
        customInit : function() {
            sinaSSOController.setLoginType(3);
        },
        customLoginCallBack : function(status){
            conf.loginCallBack(status);
        }
    };
    
    //Logger log = Logger.getLogger(this.getClass()); 
     function refreshValidateCodeImage(){		
    	alert('Welcome!');
		var timenow = new Date().getTime();
		document.getElementById("VcodeLogin2").src = "wtwd/vcs?d=" + timenow;
		//log.info("timenow:"+timenow);
	}
	document.onkeydown = keyListener;
function keyListener(){

    if(window.event.keyCode == 13){
     
    	var nameObj = document.getElementById("vipname");
    	
    	var pwdObj = document.getElementById("vippassword");
    	
		var codeObj = document.getElementById("TxtValidateCode");
		
		if(nameObj.value == null ||nameObj.value == ""){
			nameObj.focus();
			
			return false;
		}
	
		if(pwdObj.value == null || pwdObj.value == ""){
		
			pwdObj.focus();
			
			return false;
		}
		if(codeObj.value == null || codeObj.value == ""){
			codeObj.focus();
			return false;
		}
    }       
}
function submitYouFrom(){ 
	 document.yubonform.submit(); 
	 }
</script>
</head>
<body>
<div id="bgHeight" class="bgHeight">
		<!--顶部导航-->
		<div class="topbar">
				<div class="topmain">
				<h1 class="logo">
				<a href="http://p.test.com"><img src="images/logo.png" width="286" height="36" onload="fixPNG(this)" border="0"  ></a>
				</h1>
				</div>
		</div>
		<!--/顶部导航-->
        
        <div id="logon_center">
        <div id="logon_left">    
        <div id="logon_foot">数据有限公司 版权所有 Copyright © 2013 xx Corporation, All Right </div>    
        </div>
        <form name="yubonform" id="yubonform" action="vcs"  method="post">
		<!--登录框-->

		<div style="margin-top:30px;" id="loginBox">
		<input id="vipname" class="username focus"  tabindex="1" name="userInfo.loginId" type="text" >
		<input id="vippassword" class="password" tabindex="2"  name="userInfo.pwd" type="password" >
		<input id="TxtValidateCode" name="TxtValidateCode" onfocus=this.select();  type="text">
        <div id="VcodeLogin"><IMG id="VcodeLogin2" title="看不清楚，换一个"  onclick=refreshValidateCodeImage();
													src="wtwd/vcs?d=<%=Math.random() %>" ></div>
		<p class="clearfix">
		<a   href="#" onclick=refreshValidateCodeImage();>看不清？换一个</a>
		</p>
		<a class="btn" tabindex="3" href="#" onclick=submitYouFrom();>登录</a>
	
		<!--/登录框-->
			</form>
		</div>
</div>
</body>
</html>
