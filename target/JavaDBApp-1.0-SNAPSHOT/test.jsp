<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ibm.json.java.JSONObject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% JSONObject json = (JSONObject)request.getAttribute("json"); %>
<h3>Name:- <%=json.get("name") %></h3>
<h3>Host:- <%=json.get("host") %></h3>
<h3>db:- <%=json.get("db") %></h3>
<h3>port:- <%=json.get("port") %></h3>
<h3>jdbcurl:- <%=json.get("jdbcurl") %></h3>
<br></br>
<h4><%= request.getAttribute("name") %> </h4>
<h4><%= request.getAttribute("col2") %></h4>
</body>
</html>