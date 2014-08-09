<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, spn_test.ClassInfoDAO, spn_test.ClassInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style = "position:absolute; top:50px; left:25px; width:100px; height: 250px; max-height: 250px; border:1px solid red; overflow:scroll">
	<form action="/Spn_project/ClassInfoServlet" method="POST">
	
		<%
		ClassInfoDAO dao = new ClassInfoDAO();
		ArrayList<ClassInfo> clist = dao.getClassesByProf();
		int count = 0;
		if(clist !=null) {
			int len = clist.size();
			for(count = 0; count < len; count++){
			%>
				
		<input style="height: 30px; width: 100px; font-size: 14px; border: 0; outline:#00FF00 solid 4px;"
			type="submit" name = "<%=clist.get(count).getCid() %>" 
			value="CS <%=clist.get(count).getCid() %>">
			<% }
			} %>
	</form>
</div>	
<% String selec = (String)request.getAttribute("Sel");
if (selec != null) {out.println(selec);} %>	


</body>
</html>