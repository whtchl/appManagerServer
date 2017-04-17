<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<LINK href="/images/main.css" type=text/css rel=stylesheet>
		<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>修改文件详细信息</title>
		<script type="text/javascript">
			 function checkLogo(){
				 var val=document.getElementById('pcLogo').value;//获取login的值
				 var lastIndex=val.lastIndexOf('.');//以.为分隔符
				 var typeName=val.substring(lastIndex+1);//得到.后面的文件类型
				 if(typeName=='jpg'||typeName=='jpeg'||typeName=='gif'||typeName=='png'){
				   return true;
				 }else{
				 	alert('请选择正确的图片格式');
				 	//document.getElementById('uplsoad').innerHTML=html;
				 }
			 }
			 
			 function checkFileImage(){
				 var val=document.getElementById('upfile').value;//获取login的值
				 var lastIndex=val.lastIndexOf('.');//以.为分隔符
				 var typeName=val.substring(lastIndex+1);//得到.后面的文件类型
				 if(typeName=='jpg'||typeName=='jpeg'||typeName=='gif'||typeName=='png'){
				   return true;
				 }
				 else{
					 alert('请选择正确的图片格式');
					 //document.getElementById('uplsoad').innerHTML=html;
				 }
			 }	
			    function add(){//欢迎来到站长特效网，我们的网址是www.zzjs.net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
 var oTr = document.getElementById("addtr").rows[0];
 var newTr = oTr.cloneNode(true);
 document.getElementById("addtr").getElementsByTagName("tbody")[0].appendChild(newTr);
 newTr.cells[1].firstChild.value = newTr.rowIndex+1;
  if(newTr.rowIndex>0){
  document.getElementById("dl").disabled=0
  }
 document.getElementById("b1").disabled = newTr.rowIndex ==9 ;
}
function del(){//欢迎来到站长特效网，我们的网址是www.zzjs.net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。

 var tbl = document.getElementById('addtr');
 var lastRow = tbl.rows.length;
if (lastRow > 1) tbl.deleteRow(lastRow - 1);
if (lastRow < 3){
document.getElementById("dl").disabled=1
}
 if(lastRow<=9){
 document.getElementById("b1").disabled=0
 }
}	
		</script>
	</head>
	<body>
		<form id="form1" action="/updateFile" enctype="multipart/form-data"
			method="post">
			<input type="hidden" name="fileInformation.intId"
				value="<s:property value='fileInformation.intId'/>" />
			<input type="hidden" name="fileInformation.fileIcon"
				value="<s:property value='fileInformation.fileIcon'/>" />
			<input type="hidden" name="fileInformation.fileImage"
				value="<s:property value='fileInformation.fileImage'/>" />
			<input type="hidden" name="fileInformation.fileContent"
				value="<s:property value='fileInformation.fileContent'/>" />
			<table>
				<th colspan="8" class="td_title" style="TEXT-ALIGN: center">
					修改详细信息
				</th>
				<s:if test="cateList!=null">
					<tr>
						<td>
							文件类型:
						</td>
						<td>
							<select name="fileInformation.categoryId">
								<s:iterator value="cateList">
									<option value="<s:property value='IntId'/>"
										<s:if test="intId==fileInformation.categoryId">selected</s:if>>
										<s:property value="shotName" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
				</s:if>
				<tr>
					<td>
						文件名称：
					</td>
					<td>
						<input type="text" name="fileInformation.name"
							value="<s:property value='fileInformation.name'/>" />
					</td>
				</tr>
				<tr>
					<td>
						下载名称:
					</td>
					<td>
						<input type="text" name="fileInformation.downName"
							value="<s:property value='fileInformation.downName'/>" />
					</td>
				</tr>
				<tr>
					<td>
						图片预榄：
					</td>
					<td>
						<img height="89" width="90"
							src="<s:property value='fileInformation.fileIcon'/>" />
					</td>
				</tr>
				<tr>
					<td>
						文件logo：
					</td>
					<td>
						<input type="file" name="pcLogo" id="pcLogo"
							onchange="checkLogo();" />
					</td>
				</tr>
				<input type="hidden" name="fileInformation.flag"   value='0' />
				<!-- 
				<tr>
					<td>
						推广:
					</td>
					<td>
						<input type="radio" name="fileInformation.flag" <s:if test="fileInformation.flag==1">checked</s:if>
							value='1'/>
						是
						<input type="radio" name="fileInformation.flag" <s:if test="fileInformation.flag==0">checked</s:if> 
						    value='0' />
						否
					</td>
				</tr>
				<tr>
					<td>
						推荐到必备:
					</td>
					<td>
						<input type="radio" name="fileInformation.essentail"
							<s:if test="fileInformation.essentail==1">checked</s:if>
							value='1' />
						是
						<input type="radio" name="fileInformation.essentail" value='0'
							<s:if test="fileInformation.essentail==0">checked</s:if> />
						否
					</td>
				</tr>
				 -->
				 <input type="hidden" name="fileInformation.essentail" value='0' />
				<tr>
					<td>
						上传软件:
					</td>
					<td>
						<input type="file" name="softFile" />
					</td>
				</tr>
				<tr>
					<td>
						文件大小:
					</td>
					<td>
						<input type="text" name="fileInformation.fileSize"
							value="<s:property value='fileInformation.fileSize'/>" />
						&nbsp;B
					</td>
				</tr>
				<tr>
					<td>
						apk包名:
					</td>
					<td>
						<input type="text" name="fileInformation.packages"
							value="<s:property value='fileInformation.packages'/>" />
						&nbsp;如：com.dat.caa.is
					</td>
				</tr>
				<tr>
					<td>
						下载次数：
					</td>
					<td>
						<input type="text" disabled="disabled"
							value="<s:property value='fileInformation.downLoadCount'/>" />
					</td>
				</tr>
				<tr>
					<td>
						虚拟次数：
					</td>
					<td>
						<input type="text" name="fileInformation.invente"
							value="<s:property value='fileInformation.invente'/>" />
					</td>
				</tr>
				<tr>
					<td>
						下载等级：
					</td>
					<td>
						<input type="text" name="fileInformation.fileGrad"
							value="<s:property value='fileInformation.fileGrad'/>" />
					</td>
				</tr>
				<tr>
					<td>
						图片预榄：
					</td>
					<td><s:iterator value="imagesName" id="image">
     					<img src="<s:property value='image'/>" />
			 	</s:iterator>
						<br>
				<tr>
					<td>
						文件图片：
					</td>
					<TD >
							<input type="button" id="b1" value="添加一行" onClick="add()" />
							<input type="button" id="dl" value="删除一行" onClick="del()" />
							&nbsp; &nbsp;
							
							<table width="100%" border="0" cellspacing="0" cellpadding="0"
								id="addtr">

								<tr >
									<td width="67" align="right" class="td1">
										第
									</td>
									<td width="144" height="30" align="left" class="td1">
										<input type="text" size="2" disabled="disabled" value="1" />
										张:
									</td>
									<td width="936" align="left" class="td1">
										图片
										<input type="file" name="upsfile">
										
										
									</td>
								</tr>

							</table>
						</TD>
				</tr>
				<tr>
					<td>
						文件详情:
					</td>
					<td>
						<textarea rows="10" cols="70" id="informateion" name="fileInformation.information"><s:property value="fileInformation.information" /></textarea>
					</td>
				</tr>
				<tr>
					<td>
						系统要求：
					</td>
					<td>
						<input type="text" name="fileInformation.OSYQ"
							value="<s:property value='fileInformation.OSYQ'/>" />
					</td>
				</tr>
				<tr>
					<td>
						版本号：
					</td>
					<td>
						<input type="text" name="fileInformation.fileVersion"
							value="<s:property value='fileInformation.fileVersion'/>" />
					</td>
				</tr>
				<tr>
					<td>
						开发者：
					</td>
					<td>
						<input type="text" name="fileInformation.fileDevloper"
							value="<s:property value='fileInformation.fileDevloper'/>" />
					</td>
				</tr>
			</table>
			<input type="submit" value="提交" />
		</form>
		
	</body>
</html>
