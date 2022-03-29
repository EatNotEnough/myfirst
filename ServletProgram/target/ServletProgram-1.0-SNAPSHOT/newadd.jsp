
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/bootstrap.min.css" >
    <style type="text/css">
        body{background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);}
        .box1{
            overflow: hidden;
            width: 420px;
            height: 320px;
            background: #fbfbfb;
            text-align: center;
            margin: 100px auto 0;
            border-radius: 1.71429rem;
            box-shadow: rgba(23,25,29,0.5) 0px 16px 16px -16px,rgb(23 25 29/3%) 0px 14px 20px 0px,rgb(23 25 29/4%) 0px 0px 0px 1px;
        }
        input{
            width: 25em;
            height: 30px;
            border-radius: 4px;
            outline: none;
            margin-left: 10px;
            margin-bottom: 6px;
            border: none;
            box-shadow: 0 1px 3px rgb(50 50 93 / 15%), 0 1px 0 rgb(0 0 0 / 2%);}
        .input-group-lg{
            margin-top: 22px !important;
            background: #b5a7ff;
            color: white;
        }
        h3{margin-top: 20px;}
    </style>
</head>
<body>
<div class="box1">
<form action="<%=request.getContextPath()%>/add" method="get">
    <div>
<table class="table-bordered table-responsive-xxl " align="center">

        <h3>添加商品</h3>
        <tr>
            <th>名称:</th>
            <td>
                <input type="text" name="name" class="form-control"></td>
        </tr>
        <tr>
            <th>数量:</th>
            <td><input type="text" name="num" class="form-control"></td>
        </tr>
        <tr>
            <th>价格:</th>
            <td><input type="text" name="price" class="form-control"></td>
        </tr>
        <tr>
            <th>厂家:</th>
            <td><input type="text" name="factory" class="form-control"></td>
        </tr>
</table>
    <input type="submit" value="提交" class="input-group-lg" style="margin: auto 0;">
    </div>
</form>
</div>
<script type="javascript">
</script>
</body>
</html>
