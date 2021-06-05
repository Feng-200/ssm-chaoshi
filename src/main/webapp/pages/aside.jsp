<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="//at.alicdn.com/t/font_2293660_nhjidft5l8k.css">
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/touxiang.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-right info">
				${userInfo.username}
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="iconfont icon-shouye"></i> <span>首页</span></a></li>


			<li class="treeview"><a href="#"> <i class="iconfont icon-zhonglei"></i>
					<span>种类管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting1"><a
						href="${pageContext.request.contextPath}/category/findAll.do">
							<i class="iconfont icon-liebiao1"></i> 种类列表
					</a></li>
					<li id="system-setting2"><a
						href="${pageContext.request.contextPath}/pages/category-add.jsp"> <i
							class="iconfont icon-tianjia"></i> 增加种类
					</a></li>

				</ul>
			</li>



			<li class="treeview"><a href="#"> <i class="iconfont icon-shangpin"></i>
				<span>商品管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting3"><a
							href="${pageContext.request.contextPath}/products/findAll.do"> <i
							class="iconfont icon-liebiao"></i> 商品列表
					</a></li>
					<li id="system-setting4"><a
							href="${pageContext.request.contextPath}/category/findCategoryToProductAdd.do"> <i
							class="iconfont icon-tianjia"></i> 增加商品
					</a></li>
				</ul>
			</li>

		</ul>
	</section>
</aside>