<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>안녕하세요 jsp 페이지 입니다.</div>
	<% String name = "오늘은 화요일!!!!"; %>
	<h1><% out.print(name); %></h1>
	<h2><%=name %></h2>
	
	<% for(int i = 1; i <=10; i++) { %>
	<h1><%= i %></h1>
	<% } %>
	
	<% File file = new File("c:\\zzz\\");
	   String[] fileList = file.list(); %>
	<ul>
	<% for(int i =0; i < fileList.length ; i++) {%>
		<% String fileName = fileList[i]; %>
		<li><%=fileName %></li>
	<% }%>
	</ul>
</body>
</html>