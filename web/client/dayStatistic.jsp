<%@ page import="static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8" %>
<%@ page import="dao.TicketSellerPackage" %>
<%@ page import="domain.SalesStatus" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.InfoInput" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/26
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计指定某天的销售量</title>
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
        InfoInput infoInput = new InfoInput();
        infoInput.setUser_id(Integer.parseInt(id));
        //待补充
        infoInput.setSaleDate(Date);
        TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
        List<SalesStatus> list = ticketSellerPackage.SelectSalesStatus___date(user);
    %>

    <button type="button" class="btn btn-default" data-toggle="tooltip" title="默认的 Tooltip">查询</button>
    <table class="table table-striped">
        <caption>指定某天的日销售量</caption>
        <thead>
        <tr>
            <th>票务类型</th>
            <th>票价</th>
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
