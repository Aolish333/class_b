<%@ page import="static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/25
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
<%
    request.setCharacterEncoding(UTF_8);
    String user_id = (String) session.getAttribute("User_id");
    session.setAttribute("User_id",user_id);
%>
<%--<%=session.getAttribute("User_id")%>--%>
<div class="container">
    <div class="row clearfix eye-protector-processed">
        <div class="col-md-12 column eye-protector-processed">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#" class="eye-protector-processed">首页</a>
                </li>
                <li>
                    <a href="dishonour.jsp?User_id=<%=user_id%>">退票界面</a>
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
            <div class="row clearfix eye-protector-processed">
                <div class="col-md-6 column eye-protector-processed">
                    <form role="form"  action="/ServletPackage/BuyTicketServlet">
                        <div class="form-group">
                            <div>
                                <div class="form-group">
                                    类型及价格：
                                    <select class="form-control" name="ticket_type">
                                        <option>团体票</option>
                                        <option>成人票</option>
                                        <option>儿童票</option>
                                        <option>老人票</option>
                                        <option>学生票</option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-default eye-protector-processed">购买</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-6 column eye-protector-processed">
                    <table class="table">
                        <center>
                            <caption>购票指南</caption>
                        </center>
                        <thead>
                        <tr>
                            <th>
                                类型
                            </th>
                            <th>
                                价格
                            </th>
                            <th>
                                适合人群
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>
                                团体票
                            </th>
                            <th>
                                25
                            </th>
                            <th>
                                团体票适合3个以上的人群
                            </th>
                        </tr>
                        <tr class="success">
                            <th>
                                成人票
                            </th>
                            <th>
                                30
                            </th>
                            <th>
                                大于18岁小于60岁
                            </th>
                        </tr>
                        <tr class="error">
                            <th>
                                老人票
                            </th>
                            <th>
                                20
                            </th>
                            <th>
                                适合大于60岁的人群
                            </th>
                        </tr>
                        <tr class="warning">
                            <th>
                                儿童票
                            </th>
                            <th>
                                20
                            </th>
                            <th>
                                适合小于18岁的人群
                            </th>
                        </tr>
                        <tr class="info">
                            <th>
                                儿童票
                            </th>
                            <th>
                                15
                            </th>
                            <th>
                                适合小于18岁的人群
                            </th>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
