<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>登录页面</title>

    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <style>
        .BG{
            background: url(${pageContext.request.contextPath}/img/register.png);
        }
        .checkcode{
            width: 50%;
        }
        .deng{
            margin-top: 10px;
        }
        .yan{
            position: relative;
        }
        #image_check{
            height: 34px;
            width: 49%;
            padding-left: 20px;
            position: absolute;
            left: 50%;
            top: 0%;
        }
    </style>
    <script>
        window.onload = function(){
            document.getElementById("image_check").onclick = function(){
                this.src="${pageContext.request.contextPath}/checkCodeController/checkCode.do?time="+new Date().getTime();
            }
        }
    </script>
</head>

<body class="hold-transition login-page BG">
<div class="login-box">
    <div class="login-logo">
        <a><b style="color: #3c8dbc">商场信息</b>后台管理系统</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">登录系统</p>

        <form action="${pageContext.request.contextPath}/userInfo/login.do" method="post">
            <div class="form-group has-feedback">
                <input type="text" name="username" class="form-control"
                       placeholder="用户名"> <span
                    class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" class="form-control"
                       placeholder="密码"> <span
                    class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="yan">
                <input type="text" name="checkcode" id="checkcode" class="form-control checkcode"
                       placeholder="请输入验证码">
                <img id="image_check" src="${pageContext.request.contextPath}/checkCodeController/checkCode.do">
            </div>
            <div class="text-center" style="color: #ff0000">${msg}</div>

            <div class="row deng" >
                <div class="col-xs-4"></div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>
    </div>
    <!-- /.login-box-body -->
</div>

<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function() {
        $('input').iCheck({
            checkboxClass : 'icheckbox_square-blue',
            radioClass : 'iradio_square-blue',
            increaseArea : '20%' // optional
        });
    });
</script>
</body>

</html>