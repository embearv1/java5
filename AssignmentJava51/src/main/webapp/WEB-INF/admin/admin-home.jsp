<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Admin-Pro lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Admin-Pro lite design, Admin-Pro lite dashboard bootstrap 5 dashboard template">
<meta name="description"
	content="Admin-Pro Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
<meta name="robots" content="noindex,nofollow">
<title>Admin-Pro</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/adminpro-lite/" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="<c:url value='/template/admin/images/favicon.png'/>" />
<!-- Bootstrap Core CSS -->
<link
	href="<c:url value='/template/admin/plugins/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<!-- This page CSS -->
<!--c3 CSS -->
<link
	href="<c:url value='/template/admin/plugins/c3-master/c3.min.css'/>"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value='/template/admin/css/style.css'/>"
	rel="stylesheet">
<!-- You can change the theme colors from here -->
<link
	href="<c:url value='/template/admin/css/colors/default-dark.css'/>"
	id="theme" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="fix-header fix-sidebar card-no-border">
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="loader">
			<div class="loader__figure"></div>
			<p class="loader__label">Admin Pro</p>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar">
			<nav class="navbar top-navbar navbar-expand-md navbar-light">
				<!-- ============================================================== -->
				<!-- Logo -->
				<!-- ============================================================== -->
				<div class="navbar-header">
					<a class="navbar-brand" href="<c:url value='/admin/home'/>"> <!-- Logo icon --> <b>
							<img src="<c:url value='/template/admin/images/logo-icon.png'/>"
							alt="homepage" class="dark-logo" />
					</b> <!--End Logo icon --> <!-- Logo text --> <span> <img
							src="<c:url value='/template/admin/images/logo-text.png'/>"
							alt="homepage" class="dark-logo" />
					</span>
					
					</a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse">
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav me-auto">
						<!-- This is  -->
						<li class="nav-item"><a
							class="nav-link nav-toggler hidden-md-up waves-effect waves-dark"
							href="javascript:void(0)"><i class="ti-menu"></i></a></li>
					</ul>
					<!-- ============================================================== -->
					<!-- User profile and search -->
					<!-- ============================================================== -->
					<ul class="navbar-nav my-lg-0">
						<!-- ============================================================== -->
						<!-- Search -->
						<!-- ============================================================== -->
						<li class="nav-item hidden-xs-down search-box"><a
							class="nav-link hidden-sm-down waves-effect waves-dark"
							href="javascript:void(0)"><i class="ti-search"></i></a>
							<form class="app-search">
								<input type="text" class="form-control"
									placeholder="Search & enter"> <a class="srh-btn"><i
									class="ti-close"></i></a>
							</form></li>
						<!-- ============================================================== -->
						<!-- Profile -->
						<!-- ============================================================== -->
						<li class="nav-item"><a
							class="nav-link waves-effect waves-dark" href="<c:url value='/admin/home'/>"><img
								src="<c:url value='/template/user/img/meo-den-logo.png'/>"
								alt="user" class="profile-pic" /></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<aside class="left-sidebar">
			<!-- Sidebar scroll-->
			<div class="scroll-sidebar">
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav">
					<ul id="sidebarnav">
						<li><a class="waves-effect waves-dark" href="<c:url value='/admin/home'/>"
							aria-expanded="false"><i class="mdi mdi-gauge"></i><span
								class="hide-menu">Home</span></a></li>
						<li><a class="waves-effect waves-dark"
							href="<c:url value='/admin/user'/>" aria-expanded="false"><i
								class="mdi mdi-account-check"></i><span class="hide-menu">Manager
									User</span></a></li>
						<li><a class="waves-effect waves-dark"
							href="<c:url value='/admin/manage-video'/>" aria-expanded="false"><i
								class="mdi mdi-table"></i><span class="hide-menu">Manager
									Video</span></a></li>
						<li><a class="waves-effect waves-dark"
							href="<c:url value='/admin/type'/>" aria-expanded="false"><i
								class="mdi mdi-table"></i><span class="hide-menu">Manager
									Type Video</span></a></li>
						<li><a class="waves-effect waves-dark"
							href="<c:url value='/admin/logout-admin'/>" aria-expanded="false"><i
								class="mdi mdi-logout"></i><span class="hide-menu">Log Out</span></a></li>
					</ul>
				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->
		</aside>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Bread crumb and right sidebar toggle -->
				<!-- ============================================================== -->
				<jsp:include page="${link}"/>
			</div>
			<!-- footer -->
			<!-- ============================================================== -->
			<footer class="footer">
				© Made Back-End By Em Nguyen</a>
			</footer>
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script
		src="<c:url value='/template/admin/plugins/jquery/jquery.min.js'/>"></script>
	<!-- Bootstrap popper Core JavaScript -->
	<script
		src="<c:url value='/template/admin/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- slimscrollbar scrollbar JavaScript -->
	<script
		src="<c:url value='/template/admin/js/perfect-scrollbar.jquery.min.js'/>"></script>
	<!--Wave Effects -->
	<script src="<c:url value='/template/admin/js/waves.js'/>"></script>
	<!--Menu sidebar -->
	<script src="<c:url value='/template/admin/js/sidebarmenu.js'/>"></script>
	<!--Custom JavaScript -->
	<script src="<c:url value='/template/admin/js/custom.min.js'/>"></script>
	<!-- ============================================================== -->
	<!-- This page plugins -->
	<!-- ============================================================== -->
	<!--c3 JavaScript -->
	<script src="<c:url value='/template/admin/plugins/d3/d3.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/c3-master/c3.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/alertAdmin.js'/>"></script>
</body>

</html>