<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html 
xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
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
    
    
     function refreshValidateCodeImage(){		
		var timenow = new Date().getTime();
		document.getElementById("VcodeLogin").src = "/vcs?d=" + timenow;
	}
	document.onkeydown = keyListener;
function keyListener(){

    if(window.event.keyCode == 13){
     
    	var nameObj = document.getElementById("TxtUserName");
    	
    	var pwdObj = document.getElementById("TxtPassword");
    	
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
</script>
<script type="text/javascript" src="images/r.core.js"></script>
<script type="text/javascript" src="images/webface_news_vip.js"></script>
<title>数据产品运营中心</title>
<link rel="stylesheet" href="css/viplogin_bak.css">
<meta name="GENERATOR" content="MSHTML 9.00.8112.16457">
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
</head>
<body>
<div id="bgHeight" class="bgHeight">
		<input class="productName" value="vip" type="hidden">
		<!--登录页背景-->
		<div class="viploginbg"><img style="width: 1260px; height: auto; margin-top: -40px; margin-left: 0px; visibility: visible;" src="images/aboEBF4.tmp"></div>
		<!--/登录页背景-->
		<!--顶部导航-->
		<div class="topbar">
				<div class="topmain">
						<h1 class="logo">
								<a href="http://p.test.com"></a>
						</h1>
				</div>
		</div>
		<!--/顶部导航-->
		<!--登录框-->
		<form name="yubonform" id="yubonform" action="logon"  method="post">
		<div style="margin-top: 50px; margin-bottom: 50px;" id="loginBox" class="loginBox">
				<ul class="vipMailbox">
				        <li class="set2" >
						<font color="red"><b><s:actionerror/></b></font>
						</li>
						<li class="mailname">
								<label class="placeholder" for="vipname">输入用户名</label>
								<input id="vipname" class="username focus"  tabindex="1" name="userInfo.loginId" type="text">
								<a style="display: none;" class="clearname"   href="#"></a>
								<div style="clear: both; visibility: hidden;" class="loginError loginError1 tip23">&nbsp;</div>
						</li>
						<li class="mailpass">
								<input id="vippassword" class="password" tabindex="2"  name="userInfo.pwd" type="password">
								<label class="placeholder"   for="vippassword">输入密码</label>
						</li>
						<li class="set" >
								<input id="store2" tabindex="4"   type="hidden">
														</li>
						<li  class="checkcodeBox">
								<div class="clearfix">
										<input id="TxtValidateCode" name="TxtValidateCode" onfocus=this.select();  type="text">
										<IMG id=VcodeLogin
													title=看不清楚，换一个
													style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; CURSOR: hand; BORDER-RIGHT-WIDTH: 0px"
													onclick=refreshValidateCodeImage();
													src="/vcs">
								</div>
								<p class="clearfix">
										<a   href="#" onclick=refreshValidateCodeImage();>看不清？换一个</a>
								</p>
						</li>
						<li class="btn">
								<a class="loginBtn" tabindex="3" href="#" onclick=submitYouFrom();>登录</a>
								<a 
  class="register" href="#" 
  target="_blank">重置</a>
						</li>
				</ul>
		</div>
		</form>
		<!--/登录框-->
		<!--底部-->
		<div class="vipfooter">
				<div class="footenter">
						<div class="copyRight">信息科技有限公司 版权所有 Copyright © 2010-2013 xxx Corporation,
								All Rights</div>
						<div class="nav">
								<a title="官方微博" href="#" target="_blank">官方微博</a>|
								<a title="意见反馈" href="#" target="_blank">意见反馈</a>|
								<a title="帮助" href="#" target="_blank">帮助</a>
						</div>
				</div>
		</div>
		<!--/底部-->
</div>
<script type="text/javascript">
    var loginBox = document.getElementById('loginBox');
    var setMiddle = function(){
        var middleH;
        var windoww = Math.max(document.body.clientWidth, document.documentElement.clientWidth),
            windowh = Math.max(document.body.clientHeight, document.documentElement.clientHeight);
        if(windowh <= 500 && windoww <= 950){
            middleH = getMiddleH(1);
        }else if(windowh <= 500){
            middleH = getMiddleH(1);
        }else if(windoww <= 950){
            middleH = getMiddleH();
        }else{
            middleH = getMiddleH();
        }
        loginBox.style.marginTop =
        loginBox.style.marginBottom = middleH + 'px';
    };
    //获得居中高度
    function getMiddleH(flag){
        var bgHeight = document.getElementById('bgHeight');
        var height = loginBox.clientHeight;
        if(!flag){
            return (bgHeight.clientHeight - 54 - 65 - height)/2;
        }else{
            return (500- 54 - 65 - height)/2;
        }
    }
    setMiddle();
   
	function submitYouFrom(){ 
	 document.yubonform.submit(); 
	 }
</script>
<script type="text/javascript" src="images/login_121023_2.js"></script>
</body>
</html>
