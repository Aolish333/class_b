<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/28
  Time: 17:09
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
<center>
<h2>选择指定日期进行查询</h2>
    <h3>请输入日期：</h3>
<form method="post" action="#">
    <div class="control-group">
        <%--<label class="control-label">选取时间</label>--%>
        <div class="controls input-append date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
            <input size="16" type="text" value="" readonly name="data">
            <span class="add-on"><i class="icon-remove">C</i></span>
            <span class="add-on"><i class="icon-th">E</i></span>
        </div>
        <%--<input type="hidden" id="dtp_input2" value="" /><br/>--%>
    </div>
    <button type="submit" class="btn btn-default" data-toggle="tooltip" title="默认的 Tooltip">查询</button>
</form>
</center>


<script type="text/javascript" src="/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">

    $('.form_date').datetimepicker({
        format: 'yyyy-mm-dd',
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>

</body>
</html>
