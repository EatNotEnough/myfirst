<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/1.css">
    <title>注册</title>
</head>
<body background="img/1.png" style="background-size: 100% 100%;">
<div id="tips"><p><%=session.getAttribute("return")%></p></div>
<div class="signup">
    <h1 class="signup-heading">注册你的新账户</h1>
    <div class="signup-or">
        <span class="signup-or-text">Register</span>
    </div>

    <form action="<%=request.getContextPath()%>/register" class="signup-form" autocomplete="off">
        <div class="form-group">
            <label for="name" class="form-label">用户名:</label>
            <input type="text" class="form-input" id="name" name="username" placeholder="">
        </div>
        <div class="form-group">
            <label for="email" class="form-label">密码:</label>
            <input type="password" class="form-input" id="email" name="password" placeholder="">
        </div>
        <button type="submit" class="form-submit">注册</button>
    </form>
</div>
</body>
<script>
    const tip = document.querySelector("#tips");
    window.onload=function (){
        if (tip.innerHTML=="<p>注册成功!</p>"){
            tip.style.transition="all 1s ease";
            tip.style.opacity="1";
            setTimeout(stay,1500);
        }
    }
    function  stay(){
        tip.style.opacity="0";
    }
</script>
</html>
