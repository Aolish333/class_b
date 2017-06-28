<%@ page import="dao.UserPackage" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/26
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%request.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id="ticketseller" class="domain.TicketSeller">
        <jsp:setProperty name="ticketseller" property="*"/>
    </jsp:useBean>
    <%
        UserPackage userPackage=new UserPackage();
        int rs = userPackage.InsertTicket_seller(ticketseller);
        out.print("成功添加"+rs+"行内容");
        response.setHeader("refresh", "3;url=../index.jsp");
    %>
</body>
</html>
