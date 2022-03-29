<%@ page import="com.example.model.Order" %><%--
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Title</title>
    <style>
        label,td,.td{color: white !important;}
        .table{    --bs-table-striped-bg: rgba(0, 0, 0, 0);}
        #all{
            box-shadow: rgba(23,25,29,0.5) 0px 16px 16px -16px,rgb(23 25 29/3%) 0px 14px 20px 0px,rgb(23 25 29/4%) 0px 0px 0px 1px;
            width: 700px;
            background-color: #009dff;;
            border-radius: 1.71429rem;
            margin: 100px auto 0;
        }
        table{
            width: 700px;
            height: 200px
        }
        label{
            font-size: 25px;
            font-weight: bold;
            margin-top: 30px;
        }
        .td{
                text-align: center;
            line-height: 80px;
            border-style: none;
        }
        .tr:hover{
            background-color: rgba(255, 255, 255, 0.3);
            /*-moz-box-shadow: 0 0 10px #ccc;*/
            /*-webkit-box-shadow: 0 0 10px #ccc;*/
            /*box-shadow: 0 0 10px #ccc;*/
        }
        .tr{
            /*transition: all .2s ease-in-out;*/
            border-radius:20px ;
            border-style: none;
            height: 80px;
            border-bottom: 1px solid #ffffff42;

        }
        a{
            height:45px;
        }
        #zhuxiao{
            height: 10px;
            position:absolute;
            right: 8%;
            top: 15%;
            color: red;
        }
        body{
          background: linear-gradient(90deg,#fff2ec 0,#f0f1f6 42%,#e1f0ff 100%);
        }
        .a3{color: #ffffff;
            position: relative;
            bottom: 10px;
            text-decoration: none;
        }

    </style>
<%--    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css" >--%>
</head>

<a name="logout" href="<%=request.getContextPath()%>/logout"><img src="./img/zhuxiao.png" style="width: 25px;position:absolute;right:10%;top:15%" alt=""></a><p id="zhuxiao">注销</p>

<body>
<div id="all" align="center">
    <label>订单列表</label>
    <table  class="table-striped table table-striped table table-hover"  style="border-style: none;"><!-- style="border: aquamarine;width: 800px;height: 200px"-->
        <tr class="tr">
            <th class="td">编号</th>
            <th class="td">名称</th>
            <th class="td">数量</th>
            <th class="td">价格</th>
            <th class="td">厂家</th>
            <th class="td">操作</th>
        </tr>
        <c:forEach var="order" items="${orderList}">
            <tr class="tr">
                <td class="td">${order.orderId}</td>
                <td class="td">${order.orderName}</td>
                <td class="td">${order.orderNum}</td>
                <td class="td">${order.orderPrice}</td>
                <td class="td">${order.factory}</td>
                <td class="td">
                        <%--   --%>
                    <a  href="<%=request.getContextPath()%>/modify.jsp?id=${order.orderId}&name=${order.orderName}&num=${order.orderNum}&price=${order.orderPrice}&factory=${order.factory}"><img
                            src="./img/输入修改.png" style="width: 25px;margin-right: 15px" alt=""></a>
                    <a  onclick="del('${order.orderId}','${order.orderName}','${order.orderNum}','${order.orderPrice}','${order.factory}')"><img
                            src="./img/减去.png" style="width: 25px;" alt=""></a>
                </td class="td">
        </c:forEach>

    </table>
    <a class="a3" href="<%=request.getContextPath()%>/newadd.jsp">新增订单</a>
</div>
    <script type="text/javascript">

            function del(id,name,num,price,factory) {
                let flag = confirm("确认删除"+factory+"生产的"+name+"吗?"); // 点击后返回值判定 ture false
            if(flag){
                // window.location.href = "RecordCare.aspx?id=" +id+"&name="+ escape(name);
                window.location.href="<%=request.getContextPath()%>/delete?orderId="+id;
                }else {
               return false;
            }
            }
    </script>
</body>
</html>