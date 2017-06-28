<%@ page import="static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/26
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计销售情况</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
<%
    request.setCharacterEncoding(UTF_8);
%>
<div class="container">
    <div class="row clearfix eye-protector-processed">
        <div class="col-md-12 column eye-protector-processed">
            <ul class="nav nav-tabs">
                <li >
                    <a href="../client/salePage.jsp" >销售首页</a>
                </li>
                <li class="active">
                    <a href="salePage.jsp" class="eye-protector-processed">统计页面</a>
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
                    <jsp:include page="mouthStatic.jsp?"/>
                </div>

                <div class="col-md-6 column eye-protector-processed">
                    <jsp:include page="typeStatic.jsp"/>
                </div>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="row clearfix eye-protector-processed">
                <div class="col-md-6 column eye-protector-processed">
                    <jsp:include page="test.jsp"/>

                </div>
                <div class="col-md-6 column eye-protector-processed">
                    <jsp:include page="dayStatistic.jsp"/>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
