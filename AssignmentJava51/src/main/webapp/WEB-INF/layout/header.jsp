<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="i18n/global" scope="session" />
<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-2">
				<div class="header__logo">
					<a href="<c:url value='/video/home'/>"> <img
						src="<c:url value='/template/user/img/logo.png'/>" alt="" />
					</a>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="header__nav">
					<nav class="header__menu mobile-menu">
						<ul>
							<li class="active"><a href="<c:url value='/video/home'/>">Home</a></li>
							<li><a href="<c:url value='/video/all-video'/>">Anime</a></li>
							<%-- <li><a href="#"><fmt:message key="menu.contact" /></a></li> --%>
							<!--  -->
						<%-- 	<li class="active"><a href="<c:url value='/home'/>"><fmt:message
										key="memu.home" /></a></li> --%>
							<%-- <li><a href="<c:url value='/all-video'/>"><fmt:message
										key="memu.anime" /></a></li> --%>
							<li><a href="<c:url value='/video/blog'/>">Blog</a></li>
							<c:if test="${not empty sessionScope.user}">
								<li><a href="#" class="text-white">Xin chào ${user.username}<span
										class="arrow_carrot-down"></span>
								</a>
									<ul class="dropdown">
										<li><a href="<c:url value='/my-profile'/>">Profile</a></li>
										<li><a href="<c:url value='/video/my-history'/>">History</a></li>
										<li><a href="<c:url value='/video/favorite'/>">Liked
												Video</a></li>
										<li><a href="<c:url value='/logout'/>">Log Out </a></li>

									</ul></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-lg-2">
				<div class="header__right">
					 <a href="#"
						class="search-switch"><span class="icon_search"></span></a>
					<c:if test="${not empty sessionScope.user}">
						<a href="<c:url value='/my-profile'/>"><span
							class="icon_profile"></span></a>
					</c:if>
					<c:if test="${empty sessionScope.user}">
						<a href="<c:url value='/view-login'/>"><span class="icon_profile"></span></a>
					</c:if>
				</div>
			</div>
		</div>
		<div id="mobile-menu-wrap"></div>
	</div>
</header>