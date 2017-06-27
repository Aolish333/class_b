<%@ page import="static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/26
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售员主页面</title>
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
<div class="container">
    <div class="row clearfix eye-protector-processed">
        <div class="col-md-12 column eye-protector-processed">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#" class="eye-protector-processed">销售首页</a>
                </li>
                <li>
                    <a href="statisticsPage.jsp?User_id=<%=user_id%>">统计页面</a>
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
        </div>
    </div>
    <div class="row clearfix eye-protector-processed">
        <div class="col-md-12 column eye-protector-processed">
            <div class="row clearfix eye-protector-processed">
                    <div class="col-md-6 column eye-protector-processed">
                        <h2>
                            销售员须知
                        </h2>
                        <p>
                            Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                            Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                            Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
                        </p>
                        <p>
                            <a class="btn" href="#">View details »</a>
                        </p>
                    </div>


                <div class="col-md-6 column eye-protector-processed">
                    <h1>销售记录上报</h1>
                    <br>
                    <br>
                    <br>
                    <form role="form" action="../ServletPackage/SalesRegistrationServlet">
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
                                <div>

                                    <div class="form-group" class="form-inline">
                                        用户编号：<br>
                                        <input value="" class="form-control" name="user_id">
                                    </div>

                                </div>
                                <button type="submit" class="btn btn-default eye-protector-processed">填写完成</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
