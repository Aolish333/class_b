<%@ page import="static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8" %>
<%@ page import="dao.TicketSellerPackage" %>
<%@ page import="domain.SalesStatus" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.InfoInput" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
<%--<center>--%>
<%--<h2>选择指定日期进行查询</h2>--%>

<%--<h3>请输入日期：</h3>--%>
<%--<form method="post" action="#">--%>
<%--<div class="control-group">--%>
<%--&lt;%&ndash;<label class="control-label">选取时间</label>&ndash;%&gt;--%>
<%--<div class="controls input-append date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">--%>
<%--<input size="16" type="text" value="" readonly name="data">--%>
<%--<span class="add-on"><i class="icon-remove">C</i></span>--%>
<%--<span class="add-on"><i class="icon-th">E</i></span>--%>
<%--</div>--%>
<%--&lt;%&ndash;<input type="hidden" id="dtp_input2" value="" /><br/>&ndash;%&gt;--%>
<%--</div>--%>
<%--<button type="submit" class="btn btn-default" data-toggle="tooltip" title="默认的 Tooltip">查询</button>--%>
<%--</form>--%>
<%--</center>--%>

<table>
    <%
        request.setCharacterEncoding(UTF_8);
        String id = request.getParameter("User_id");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = request.getParameter("data");
        if (dateString != null) {
            Date date = dateFormat.parse(dateString);

//        java.sql.Date date = java.sql.Date.valueOf(request.getParameter("data"));
            //获取列表进行操作
            InfoInput infoInput = new InfoInput();
            infoInput.setUser_id(Integer.parseInt(id));
            //待补充
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = sdf.format(date);
            infoInput.setSaleDate(strDate);
    %>
    <%
            TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
            List<SalesStatus> list = ticketSellerPackage.SelectSalesStatus___date(infoInput);
    %>

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
            for (SalesStatus salesStatus : list) {
        %>
        <tr>
            <td><%=salesStatus.getSales_type()%>
            </td>
            <td><%=salesStatus.getSales_price()%>
            </td>
            <td><%=salesStatus.getSales_earning()%>
            </td>
            <td><%=salesStatus.getSales_amount()%>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</table>

<script type="text/javascript" src="/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">

    $('.form_date').datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>
</body>
</html>
