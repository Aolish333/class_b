<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/24
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var d = new Date()

        document.write(d.getFullYear())
        document.write(".")
        document.write(d.getMonth()+1)
        document.write(".")
        document.write(d.getDate())
        document.write(".")
        document.write(d.getHours())
        document.write(".")
        document.write(d.getMinutes())
        document.write(".")
        document.write(d.getSeconds())

    </script>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>

</body>
</html>
