<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>管理页面</TITLE>
		<META http-equiv=content-type content="text/html; charset=UTF-8">
		<LINK href="../images/main.css" type=text/css rel=stylesheet>
		<SCRIPT src="../images/main82.js" type=text/javascript></SCRIPT>

		<SCRIPT src="../images/admin.js" type=text/javascript></SCRIPT>

		<SCRIPT language=javascript type=text/javascript>var boardxml='';var ISAPI_ReWrite=0;</SCRIPT>
		<script type='text/javascript' src='/dwr/interface/JMobileSalesService.js'></script>
	  	<script type='text/javascript' src='/dwr/engine.js'></script>
	  	<script type='text/javascript' src='/dwr/util.js'></script>

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
	</HEAD>
	<BODY>
	<script type="text/javascript" language="javascript">
		function checkIdentity(){
			var identity = document.getElementById("mobileSalesInfo.identity").value;
			var isIDCard1 = new Object();
			var isIDCard2 = new Object();
			
			//身份证正则表达式(15位) 
			isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
			
			//身份证正则表达式(18位) 			
			isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[A-Z])$/;
			
			if (isIDCard1.test(identity) || isIDCard2.test(identity)){
				JMobileSalesService.validIdentity(identity, afterCheck);
			}else{
				alert("请重新输入正确的身份证码！");				
			}
		}
		function afterCheck(flag){
			if(!flag){
				alert("该身份证号码已注册过!!");
			}
		}
	</script>
	<s:form action="register" method="post">
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">
			<tr>
				<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
					<span class="td_title" style="TEXT-ALIGN: center">销售人员注册</span>
					<s:property value="mobileSalesInfo.loginId" />
				</th>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>身份证号码</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:textfield name="mobileSalesInfo.identity" onblur="checkIdentity()"></s:textfield>
					</span>
				</td>
			</tr>
			<tr class="td1">
				<td width='16%' align='left' class="td1">
					<u>密码</u>
				</td>
				<td width='84%' class="td1">
					<s:textfield name="mobileSalesInfo.pwd"></s:textfield>					
				</td>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>确认密码</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<input name="" type="text" />
					</span>
				</td>
			</tr>
			<tr class="tdbg">
				<td align='left' class="td2">
					<u>姓名</u>
				</td>
				<td class="td2">
					<span class="td1"> 
						<s:textfield name="mobileSalesInfo.name"></s:textfield>
					</span>
				</td>
			</tr>			
			
		</table>		
		<table cellspacing="1" cellpadding="3" width="100%" align="center"
			border="0">
			<tr class="tdbg">
				<td align='center' class="td2">
					<input class=button type=submit value="确认并提交" name=Submit>
				</td>
			</tr>
		</table>
		</s:form>
	</BODY>
</HTML>
