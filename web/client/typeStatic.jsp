<%@ page import="dao.TicketSellerPackage" %>
<%@ page import="static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8" %>
<%@ page import="domain.SalesStatus" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/26
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>按类型统计</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
<table>
    <%
        request.setCharacterEncoding(UTF_8);
        //获取列表进行操作
        String id = request.getParameter("User_id");
        User user = new User();
        user.setUser_id(Integer.parseInt(id));
        TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
        List<SalesStatus> list = ticketSellerPackage.SelectSalesStatus___type(user);
    %>

    <button type="button" class="btn btn-default" data-toggle="tooltip" title="默认的 Tooltip">查询</button>
    <table class="table table-striped">
        <caption>按门票的类型进行统计</caption>
        <thead>
        <tr>
            <th>门票类型</th>
            <th>各类门票的价格</th>
            <th>销售金额</th>
            <th>销售情况</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (SalesStatus salesStatus :list){
        %>
        <tr>
            <td><%=salesStatus.getSales_type()%></td>
            <td><%=salesStatus.getSales_price()%></td>
            <td><%=salesStatus.getSales_earning()%></td>
            <td><%=salesStatus.getSales_amount()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</table>
</body>
</html>
