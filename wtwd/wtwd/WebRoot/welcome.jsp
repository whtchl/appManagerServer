<%
/*
String agent = request.getHeader("User-Agent");
if(agent != null && agent.indexOf("Windows NT") > 0){
	request.getRequestDispatcher("/login.jsp").forward(request, response);
}else{
	request.getRequestDispatcher("/login").forward(request, response);
}
*/
request.getRequestDispatcher("/login.jsp").forward(request, response);
%>