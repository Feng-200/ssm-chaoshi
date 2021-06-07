<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
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


			<li class="treeview"><a href="#"> <i class="fa  fa-th-large"></i>
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



			<li class="treeview"><a href="#"> <i class="fa fa-cart-plus"></i>
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

            <li class="treeview"><a href="#"> <i class="fa fa-users"></i>
                <span>工种管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">
                    <li id="system-setting5"><a
                            href="${pageContext.request.contextPath}/bumen/findAll.do">
                        <i class="fa fa-list-alt"></i> 工种列表
                    </a></li>
                    <li id="system-setting6"><a
                            href="${pageContext.request.contextPath}/pages/bumen-add.jsp"> <i
                            class="iconfont icon-tianjia"></i> 增加工种
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa  fa-user"></i>
                <span>员工管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">
                    <li id="system-setting7"><a
                            href="${pageContext.request.contextPath}/yuangong/findAll.do">
                        <i class="fa fa-building-o"></i> 员工列表
                    </a></li>
                    <li id="system-setting8"><a
                            href="${pageContext.request.contextPath}/bumen/findBumenToYuangongAdd.do"> <i
                            class="fa fa-user-plus"></i> 增加员工
                    </a></li>
                </ul>
            </li>
		</ul>
	</section>
</aside>