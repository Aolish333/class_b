<%@ page import="dao.UserPackage" %>
<%@ page import="domain.RefundTicket" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Ticket" %>
<%@ page import="static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/26
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退票界面</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
<%
    request.setCharacterEncoding(UTF_8);
    //获取列表进行操作
    String id = request.getParameter("User_id");
    User user = new User();
    user.setUser_id(Integer.parseInt(id));
    UserPackage userPackage = new UserPackage();
    List<Ticket> list = userPackage.SelectUserId(user);

%>
<div class="container">
    <div class="row clearfix eye-protector-processed">
        <div class="col-md-12 column eye-protector-processed">
            <ul class="nav nav-tabs">
                <li>
                    <a href="buy_ticket.jsp">首页</a>
                </li>
                <li class="active">
                    <a href="#" class="eye-protector-processed">退票界面</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
                    <ul class="dropdown-menu eye-protector-processed">
                        <li>
                            <a href="#">操作</a>
                        </li>
                        <li>
                            <a href="#">设置栏目</a>
                        </li>
                        <li>
                            <a href="#">更多设置</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">分割线</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="col-md-12 column eye-protector-processed">
                <table class="table table-striped">
                    <caption>退票指南</caption>
                    <thead>
                    <tr>
                        <th>票名</th>
                        <th>票号</th>
                        <th>票价</th>
                        <th>原价</th>
                        <th>类型</th>
                        <th>票的有效开始时间</th>
                        <th>票的到期时间</th>
                        <th>退票操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Ticket ticket : list) {
                    %>
                    <tr>
                        <td><%=ticket.getTicket_name()%></td>
                        <td><%=ticket.getTicket_no()%></td>
                        <td><%=ticket.getTicket_price()%></td>
                        <td>30</td>
                        <td><%=ticket.getTicket_type()%></td>
                        <td><%=ticket.getTicket_begin()%></td>
                        <td><%=ticket.getTicket_end()%></td>
                        <td><a href="/ServletPackage/RefundTicketServlet?Ticket_id=<%=ticket.getTicket_no()%>&User_id=<%=user.getUser_id()%>">退票</a></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
