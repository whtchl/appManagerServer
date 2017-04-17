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
			 
			 function seleByCateId(value){
				 window.location="SoftGameredirect?cateId="+value;
			 }
		</script>
		<link href="css/main.css" type=text/css rel=stylesheet>
	</head>
	<body>
		<form action="deletFile" enctype="multipart/form-data"
			name="indexform">
		  <table cellspacing="1" cellpadding="3" width="100%" align="center"
				border="0">
  <th colspan="9" class="td_title" style="TEXT-ALIGN: center"> 装机必备管理 </th>
  <tr>
    <td align="center" class='<s:property value="%{#cs}"/>'> 显示序号 </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 文件名称 </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 实际大小 </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 上传时间 </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 文件logo </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 文件类型 </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 文件说明 </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 下载次数 </td>
    <td align="center" class='<s:property value="%{#cs}"/>'> 操作 </td>
  </tr>
  <s:iterator value="fileList">
    <tr>
      <td><input size="4" value="<s:property value='showId' />"
								name="orderBy&lt;s:property value='listId'/&gt;" />
          <input value='<s:property value="intId"/>' type="hidden"
								name="Tid&lt;s:property value='listId'/&gt;" />      </td>
      <td><s:property value="name" />      </td>
      <td><s:property value="fileSize" />      </td>
      <td><s:date name="createDay" format="yyyy-MM-dd" />
          <s:property value="createTime"/>      </td>
      <td><img width="58" height="58" src="<s:property value='fileIcon'/>" /> </td>
      <td><s:iterator value="cateList" var="cate">
        <s:if test="#cate.IntId==categoryId">
          <s:property value="shotName" />
        </s:if>
      </s:iterator>      </td>
      <td><s:property value="shotInformation" escape="false" />      </td>
      <td><s:property value="invente" escape="false" />      </td>
      <td><a href="javascript:;"
								onClick="deletFileW(<s:property value='IntId'/>)">删除</a>&nbsp;|&nbsp; <a href="javascript:;"
								onClick="updateView(<s:property value='IntId'/>)">编辑</a>&nbsp;|&nbsp;<a href="getfuncommentsList?cid=10">评论管理</a></td>
    </tr>
	
  </s:iterator>
   <tr>
    <td colspan="9" align="center" class='<s:property value="%{#cs}"/>'> <input name="button3" type="button" class="button" value="确定"
				onClick="javascript:orderIndex(<s:property value="fileList.size()"/>);" /></td>
    </tr>
          </table>
		 
		</form>
	</body>
</html>
