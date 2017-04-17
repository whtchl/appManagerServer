
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

		<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
		<script type="text/javascript">
			function havePic(){
				var advType = document.getElementById("advType").value;
				if(advType == 1){
					document.getElementById("uploadPic").style.display = "";
				}else{
					document.getElementById("uploadPic").style.display = "none";
				}
			}
		</script>
	</HEAD>
	<BODY>
		<form action="ssaveVersionInfo" method="post" enctype="multipart/form-data">
			<table cellspacing="1" cellpadding="3" width="937" align="center"
				border="0" height="263">
				<tr>
					<th colspan="3" class="td_title" style="TEXT-ALIGN: center">
						<span class="td_title" style="TEXT-ALIGN: center">新增版本</span>
					</th>
				</tr>
                <tr class='tdbg2'>
					<td width='16%' align='left' class="td1"> 
						名称</td>
					<td width='84%' class="td1">
					    <input  name="vname" type="text" /> <s:actionerror/>
					</td>
				</tr>
				<tr class='tdbg2'>
					<td width='16%' align='left' class="td1"> 
						选择版本</td>
					<td width='84%' class="td1">
					    <s:select list="versionInfo"   listValue="ver" listKey="id"   name="versionId" id="ver" 
                   ></s:select>
					</td>
				</tr>
				<tr class='tdbg2' id="uploadPic">
					<td width='16%' align='left' class="td1"> 
						上传文件包<br></td>
					<td width='84%' class="td1">
						<input type="file" name="apk" />
					</td>
				</tr>
				<tr class='tdbg2'>
					<td width='16%' align='left' class="td1"> 
						选择客户</td>
					<td width='84%' class="td1">
						<s:select list="companyList" listValue="name+'->'+code" listKey="code"   name="code" id="company" ></s:select>
					</td>
				</tr>
				
				
				
				<tr class="td1">
					<td width='16%' align='left' class="td1">
						备注
					</td>
					<td width='84%' class="td1">
						<label>
						<textarea name="remark" cols="80" rows="6"></textarea>
						</label>
						
						
				  </td>
				</tr>
				<table cellspacing="1" cellpadding="3" width="100%" align="center"
					border="0">
					<tr class="tdbg">
						<td align='center' class="td2">
							<input class=button type=submit value="确认并提交" name=Submit>
						</td>
					</tr>
				</table>
	</BODY>
</HTML>
