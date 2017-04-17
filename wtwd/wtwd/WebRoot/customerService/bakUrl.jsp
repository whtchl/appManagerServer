<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0041)http://localhost/bbs/Admin/main_index.asp -->
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
        function delP(){
			return confirm ("确定要删除吗？");
		}
        
        </script>
	</HEAD>
	<BODY>
	<!-- 短信 DIV -->
		<div>
			<s:form action="bakUrl" method="post"  >
				<table cellspacing="1" cellpadding="3" width="100%" align="center"
					border="0">
					<tr>
						<th colspan="4" class="td_title" style="TEXT-ALIGN: center"> 备用域名管理/<a href="/addBakUrl"><font color="red">添加备用域名</font></a></th>
					</tr>
			<tr>
				<td colspan="4" align="left">
					快速查询：
					 <s:select list="#{100:'客服中心'}" name="bakUrlInfo.pord" headerKey="0" headerValue="-请选择产品-"></s:select>
                      <input type=submit value="查询" name=Submit2222>
				</td>		
			</tr>
			<tr>
				<td align="center"  class="td2"><strong>序号</strong></td>		
				<td align="center"  class="td2"><strong>域名地址</strong></td>
				<td align="center"  class="td2"><strong>产品</strong></td>	
				<td align="center"  class="td2"><strong>操作</strong></td>
			</tr>
						<s:iterator value="bakUrlList" status="p">
						<tr>
							<td   align="center"  class="td1">
	  							<s:property value="#p.count"/>		
	  						</td>
	  						<td  align="center"  class="td1">
	  							<s:property value="bakurl"/>
	  						</td>
	  						<td  align="center"  class="td1">	
	  						<s:if test="pord==100">客服中心</s:if>
	  						</td>
	  					<td  align="center"  class="td1">	
	  						<a href="/toUpdateBakUrl?bakUrlInfo.id=<s:property value="id"/>">修改</a>|
	  						<a href="/deleteBakUrl?bakUrlInfo.id=<s:property value="id"/>" onclick="return delP();">删除</a> 	
	  					</td>
	  				</tr>
	  				</s:iterator>					
				</table>

			</s:form>
		</div>
		<!-- 短信DIV结束 -->
		
	</BODY>
</HTML>