<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/5/29
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆首页</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
    <style>
        .ThreeDee {
            font-family: 'Microsoft YaHei';
            line-height: 1em;
            color: #fff9d6;
            font-weight:bold;
            font-size: 25px;
            text-shadow:0px 0px 0 rgb(197,197,197),1px 1px 0 rgb(169,169,169),2px 2px 0 rgb(141,141,141),3px 3px 0 rgb(113,113,113), 4px 4px 0 rgb(85,85,85),5px 5px 4px rgba(0,0,0,0.4),5px 5px 1px rgba(0,0,0,0.5),0px 0px 4px rgba(0,0,0,.2);}
    </style>

</head>
<body>
<div class="site-login-wrapper">
    <div class="header">
        <div class="ThreeDee">
            <h2>Login to
                <img src="image/font.png" alt="logo">
            </h2>
        </div>
    </div>
    <div class="login-form">
        <form action="/ServletPackage/AllLoginServlet" method="get">
            <ul class="form-content">
                <li class="login-items">
                    <span class="iconfont icon-yonghuming pics"></span><!--(矢量图库)-->
                    <input class="login-user" name="user" type="text" placeholder="IconDeposit">
                </li>
                <li class="login-items">
                    <span class="iconfont icon-mima pics"></span>
                    <input class="login-pwd" name="user_psw" type="password" placeholder="••••••••••••••">
                </li>
                <li class="login-items">
                    <span class="iconfont icon-mima pics"></span>
                    <select name="user_type" class="login-user">
                        <option value="visitor">游客</option>
                        <option value="seller">销售员</option>
                    </select>
                </li>
                <li class="login-items rmb">
                    <input id="checkbox" type="checkbox" checked>
                    <label class="square" for="checkbox"></label>
                    <label class="remember" for="checkbox">记住密码</label>
                </li>
                <li class="login-items rmb">
                    <a class="forget" href="/manage/InsterStuMe.jsp">Forgot username or password?</a>
                </li>
                <li class="login-items">
                    <button type="submit" class="login-btn">Login</button>
                </li>
            </ul>
        </form>
    </div>
    <div class="footer">
    </div>
</div>
</body>
</html>
