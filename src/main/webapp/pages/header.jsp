<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- 页面头部 -->
<header class="main-header">
	<!-- Logo -->
	<a href="${pageContext.request.contextPath}/pages/main.jsp" class="logo" style="background-color: #3c8dbc"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b></b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b></b>商场商品后台管理</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" style="background-color: #3c8dbc">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
        <div class="pull-left hidden-xs">
            <b width="100%" id="time" style="line-height: 50px">
                <script language='javascript'>
                    function su() {
                        var tody = new Date();
                        var nian = tody.getFullYear();
                        var yue = tody.getMonth() + 1;
                        var day = tody.getDate();
                        var hour = tody.getHours();
                        var min = tody.getMinutes();
                        var miao = tody.getSeconds();
                        document.getElementById('time').innerHTML = nian + "年" + yue + "月" + day + "日"
                            + hour + "时" + min + "分" + miao + "秒";
                    }
                    setInterval("su();", 1000);
                </script>
            </b>
        </div>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}/img/touxiang.jpg" class="user-image" alt="User Image">
				    </a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header" style="background-color: #3c8dbc">
                            <img src="${pageContext.request.contextPath}/img/touxiang.jpg"
							class="img-circle" alt="User Image"></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="${pageContext.request.contextPath}/pages/register.jsp" class="btn btn-default btn-flat">注册账号</a>
							</div>
							<div class="fa-pull-left col-md-2">
								<a href="${pageContext.request.contextPath}/pages/updatePassword.jsp" class="btn btn-default btn-flat">修改密码</a>
							</div>
							<div class="pull-right">
								<a href="${pageContext.request.contextPath}/pages/login.jsp" class="btn btn-default btn-flat">注销</a>
							</div>
						</li>
					</ul></li>

			</ul>
		</div>
	</nav>
</header>
<!-- 页面头部 /-->