<%@ page import="domain.User" %>
<%@ page import="dao.UserPackage" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/28
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    User user = new User();
    user.setUser_id(Integer.parseInt(request.getParameter("user_id")));
    user.setUser_name(request.getParameter("user_name"));
    user.setUser_psw(request.getParameter("user_psw"));
    user.setUser_age(request.getParameter("user_age"));
    UserPackage userPackage=new UserPackage();
    userPackage.UpdateUser(user);%>
    修改成功！
<%response.setHeader("refresh", "3;url=../index.jsp");
%>
</body>
</html>
