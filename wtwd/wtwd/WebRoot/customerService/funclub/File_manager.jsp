<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<LINK href="/images/main.css" type=text/css rel=stylesheet>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>文件管理</title>
		<script type="text/javascript">
			function deletFileW(id){
			 if(window.confirm("确定删除吗？")==true){
				window.location.href="DeletFileW?id="+id;
				}
			}
			
			function updateView(id){
				window.location.href="updateFile?type=go&id="+id;
			}
			
			function orderIndex(csize){
				var k="";
				var id="";
				var  ms="是否确定？";
				 var s;
				 
				 if(window.confirm(ms)==true){
				
				  for (var j = 0; j < csize; j++) 
				  {
				     box = eval("document.indexform.orderBy" + j);  
				     Tid = eval("document.indexform.Tid" + j); 
						   k=k+box.value+",";
						 
						   id=id+Tid.value+",";
						   if(box.value==""){
						   s=1;
						   }
				   }
				  if(s!=1){
				    window.location="/updateFileShowId?webshowid="+k+"&webIDList="+id;	
					}else{
					alert("显示排序不能为空！");
					}
				 }
			 }
			 
			 function seleByCateId(position){
				var select=document.getElementById("select");
			 	var value=select.options[select.selectedIndex].value;
				 if(value!=0){
				 	window.location="SoftGameredirect?cateId="+value+"&position="+position;
				 }else {
					 if(position==1){
					   window.location="SoftFileManger";
					 }else{
					   window.location="GameFileManger";
					 }
				 }
			 }
			 function selePage(page,type,position){
			 	var select=document.getElementById("select");
			 	var cate=select.options[select.selectedIndex].value;
			 	window.location="SoftGameredirect?cateId="+cate+"&page="+page+"&type="+type+"&position="+position;
			 }
		</script>
	</head>
	<META content="MSHTML 6.00.2900.3268" name="GENERATOR">
	<style type="text/css">

</style>
	<body>
		<form action="deletFile" enctype="multipart/form-data"
			name="indexform">

			<s:iterator value="fileList" id="lisid">
				<s:property value="listId.#index" />
				<s:if test="(listId%2)==1">
					<s:set name="cs" value="%{'td1'}" />
				</s:if>
				<s:else>
					<s:set name="cs" value="%{'td2'}" />
				</s:else>
			</s:iterator>

			<table cellspacing="1" cellpadding="3" width="100%" align="center"
				border="0">
				<th colspan="10" class="td_title" style="TEXT-ALIGN: center">
					<s:if test="cateList.get(0).getTPosition()==2">游戏文件管理</s:if>
					<s:else>软件文件管理</s:else>				</th>
				<tr  >
					<td colspan="10">
						<s:if test="cateList!=null">
							<select id="select"
								onchange="seleByCateId('<s:property value='cateList.get(0).getTPosition()'/>');">
								<option value="0">
									全部								</option>
								<s:iterator value="cateList">
									<option value="<s:property value='IntId'/>"
										<s:if test="IntId==fileCategory.IntId">selected</s:if>>
										<s:property value="shotName" />
									</option>
								</s:iterator>
							</select>
						</s:if>					</td>
				</tr>
				<TR>
					<td width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						显示序号					</td>
					<td width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						序号					</td>
					<td width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						文件名称					</td>
					<td width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						实际大小(B)					</td>
					<td  width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						上传时间					</td>
					<td width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						文件logo					</td>
					<td width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						文件类型					</td>
					<td width="9%" align="center" class='<s:property value="%{#cs}"/>'>
						文件说明					</td>
					<td width="8%" align="center" class='<s:property value="%{#cs}"/>'>
						统计次数					</td>
					<td width="11%" align="center" class='<s:property value="%{#cs}"/>'>
						操作					</td>
				</TR>
				<s:iterator value="fileList" var="file">
					<TR>
						<td  class='<s:property value="%{#cs}"/>'>
							<input size="4" value="<s:property value='showId' />"
								name="orderBy<s:property value='listId'/>" />
							<input value='<s:property value="intId"/>' type="hidden"
								name="Tid<s:property value='listId'/>" />						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<s:property value='listId+1' />						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<s:property value="name" />						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<s:property value="fileSize" />						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<s:date name="createDay" format="yyyy-MM-dd" />
							<s:property value="createTime"/>						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<img width="58" height="58" src="<s:property value='fileIcon'/>" />						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<s:iterator value="cateList" var="cate">
								<s:if test="#cate.IntId==#file.categoryId">
									<s:property value="shotName" />
								</s:if>
							</s:iterator>						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<s:property value="shotInformation" escape="false" />						</td>
						<td class='<s:property value="%{#cs}"/>'>
							<s:property value="invente" escape="false" />						</td>
						<td align="center" class='<s:property value="%{#cs}"/>'>
							<a href="javascript:;"
								onclick="deletFileW(<s:property value='IntId'/>)">删除</a>&nbsp;|&nbsp;
							<a href="javascript:;"
								onclick="updateView(<s:property value='IntId'/>)">编辑</a>&nbsp;|&nbsp;<a href="getfuncommentsList?cid=<s:property value='IntId'/>">评论管理</a>						</td>
					</TR>
				</s:iterator>
				<tr >
					<td colspan="10" align="center" valign="middle">
						共
					    <s:property value="pageCount" />
					页					
						
					 	<s:if test="page>1">
					 	<a href="javascript:;" onClick="selePage('<s:property value='page'/>','preview','<s:property value='cateList.get(0).getTPosition()'/>')">上一页</a>						</s:if>
					
					 	
						<s:if test="pageCount>page">|
					<a href="javascript:;" onClick="selePage('<s:property value='page'/>','next','<s:property value='cateList.get(0).getTPosition()'/>')">下一页</a>						</s:if>					</td>
				</tr>
			</table>
			<!--<s:property value='cateList.get(0).getIntId()' />-->
			<input name="button3" type="button" class="button" value="确定"
				onClick="javascript:orderIndex(<s:property value="fileList.size()"/>);" />
		</form>
	</body>
</html>
