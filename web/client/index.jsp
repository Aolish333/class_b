<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/23
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script>

    </script>
  </head>
  <body>
  <div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="../image/test.jpg" alt="First slide">
      </div>
      <div class="item">
        <img src="../image/test.jpg" alt="Second slide">
      </div>
      <div class="item">
        <img src="../image/test.jpg" alt="Third slide">
      </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">‹</a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">›</a>
  </div>
  <ul class="nav nav-list">
    <li class="nav-header">主导航</li>
    <li class="active"><a href="#">首页</a></li>
    <li><a href="#">电影</a></li>
    ...
  </ul>

  </body>
</html>
