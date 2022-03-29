<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="overflow: hidden">
<head>
    <link rel="stylesheet" href="css/1.css">
    <title>登录</title>
</head>

<body background="img/233.png" style="background-size: 100% 100%;overflow: hidden">
<div id="tips"><p><%=session.getAttribute("return")%></p></div>
<div class="signup">
    <h1 class="signup-heading">登录您的账户</h1>
    <div class="signup-or">
        <span class="signup-or-text">Login</span>
    </div>
    <form action="<%=request.getContextPath()%>/login" class="signup-form" autocomplete="off" method="post">
        <div class="form-group">
            <label for="name" class="form-label">用户名:</label>
            <input type="text" class="form-input" id="name" name="username" placeholder="">
        </div>
        <div class="form-group">
            <label for="email" class="form-label">密码:</label>
            <input type="password" class="form-input" id="email" name="password" placeholder="">
        </div>
        <button type="submit" class="form-submit">登录</button>
    </form>
    <p class="signup-already">没有账户？<a href="#" class="signup-already-link" onclick="register()">注册</a></p>
</div>
</body>
<script>
    const tip = document.querySelector("#tips");
    window.onload=function (){
        if (tip.innerHTML!="<p>null</p>"){
            tip.style.transition="all 1s ease";
            tip.style.opacity="1";
            setTimeout(stay,1500);
        }

    }
    function  stay(){
        tip.style.opacity="0";
    }
    function register(){
        window.open("register.jsp")
    }
</script>
</html>