<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	   <LINK href="/images/main.css" type=text/css rel=stylesheet>
		<meta http-equiv="Content-Type" content="text/html; charset=uf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<table align="center">
				<s:iterator value="fileList">
					<tr>
						<td>
						<a href="getFileInfo?id=<s:property value='intId'/>"><img
								src="<s:property value='fileIcon'/>" />
						</a>
						</td>
						<td>
							文件名称:
							<a href="getFileInfo?id=<s:property value='intId'/>"><s:property
									value="name" />
							</a>
						</td>
					</tr>
					<tr>
						<td>
							文件详情:
							<s:property value="information" escape="false" />
							<s:if test="inforSign==1">
								<a href="">更多...>></a>
							</s:if>
						</td>
					</tr>
					<tr>
						<td>
							文件大小:
							<s:property value="fileSize" />
						</td>
					</tr>
					<tr>
						<td>
							下载次数:
							<s:property value="downLoadCount" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>
