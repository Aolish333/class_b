<%@ page import="domain.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="dao.UserPackage" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/28
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<% request.setCharacterEncoding("utf-8");--%>
<%--//    int id = Integer.parseInt(request.getParameter("user_id"));--%>
    <%--User user = new User();--%>
    <%--user.setUser_id(id);--%>
    <%--UserPackage userupdate = new UserPackage();--%>
    <%--ResultSet rs = userupdate.SelectId(id);--%>
    <%--//out.println(rs);--%>
    <%--//out.println(rs.next());--%>
    <%--if (rs.next()) {--%>
<%--%>--%>
<form action="doupdateuser.jsp?
<%--user_id=<%=rs.getInt(id)%>--%>
" method="post">
    Id:<input type="text" name="user_id">
    用户名<input type="text" name="user_name">
    密码<input type="text" name="user_psw">
    年龄<input type="text" name="user_age">
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</select>
</form>

</body>
</html>
