<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK href="/images/main.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table >
<tr><td>序号</td><td>简称</td><td>地址</td><td>编辑</td></tr>
<s:iterator value="adverList">
<tr>
<td><s:property  value="intId"/></td>
<TD><s:property  value="shotName"/></TD>
<td><s:property  value="furl"/></td>
<td><a href="javascript:;" onClick="rdelete(<s:property value='intId'/>);">删除</a>|<a href="updateAdver?id=<s:property value='intId'/>">编辑</a></td>
</tr>
</s:iterator>
</table>
<script type="text/javascript" language="javascript">
			function rdelete(cmdId){
				if(confirm("确认要物理删除吗？")){
					document.forms[0].action = "DelAdver?id=" + cmdId;
					document.forms[0].submit();
				}
			}			
		</script>
</body>
</html>