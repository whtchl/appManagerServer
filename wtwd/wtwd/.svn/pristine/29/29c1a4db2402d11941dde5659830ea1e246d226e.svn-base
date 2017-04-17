<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
共有[ <s:property value="pageModel.records" /> ]条记录

<!-- 
<s:bean name="org.apache.struts2.util.Counter">
<s:param name="first" value="pageModel.firstPage" />
<s:param name="last" value="pageModel.totalPage" />
<s:iterator>
	<s:if test='%{pageModel.curPage == (current - 1)}'>
		<font color="black"><b><s:property value='current - 1' /></b></font>
	</s:if>
	<s:if test='%{pageModel.curPage != (current - 1)}'>
		<A href="javascript:;" onclick="query('<s:property value='pageModel.url' />?pageModel.curPage=<s:property value='current - 1' />');return false;" ><s:property value='current - 1' /></A>
	</s:if>
</s:iterator>
</s:bean>
<s:if test='%{pageModel.totalPage > 5}'>
	<A href="javascript:;" onclick="query('<s:property value='pageModel.url' />?pageModel.firstPage=<s:property value='pageModel.firstPage + pageModel.endPage' />');return false;">&gt;&gt;|</A>
</s:if>
 -->
 
共[ <s:property value="pageModel.totalPage" /> ]页 
<a href="javascript:;"onclick = "pageInfo(1);return false;">首页</a>
<s:if test="pageModel.curPage-1 == 0">
上一页
</s:if>
<s:if test="pageModel.curPage-1 > 0">
<a href="javascript:;"onclick = "pageInfo(<s:property value='pageModel.curPage-1'/>);return false;">上一页</a>
</s:if>

<s:if test="pageModel.curPage == pageModel.totalPage">
下一页
</s:if>
<s:if test="pageModel.curPage < pageModel.totalPage">
<a href="javascript:;" onclick ="pageInfo(<s:property value='pageModel.curPage+1'/>);return false;">下一页</a>
</s:if>
<a href="javascript:;"onclick = "pageInfo(<s:property value='pageModel.totalPage'/>);return false;">尾页</a>
每页显示记录:
<s:select list="#{10:10,30:30,50:50,100:100}" name="pageModel.rowsOfPage" id="rowP"></s:select>
到第
<s:select id="curP" name="pageModel.curPage" list="(pageModel.totalPage).{#this + 1}">
</s:select>
页
<input type="image" src="images/gif-0999.gif" width="12" height="12">
&nbsp;&nbsp;&nbsp;
<script type="text/javascript" language="javascript">
	function pageInfo(next){
			document.getElementById("curP").value = next;
			document.forms[0].submit();
			
	}
	function query(url){
		alert(url);
		document.forms[0].action = url;
		document.forms[0].submit();
	}
</script>