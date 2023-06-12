<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
							<li class="active"><a href="<c:url value='/video/home'/>"><s:message code="label.home.home"/></a></li>
							<li><a href="<c:url value='/video/all-video'/>"><s:message code="label.home.video"/></a></li>
							<%-- <li><a href="#"><fmt:message key="menu.contact" /></a></li> --%>
							<!--  -->
							<%-- 	<li class="active"><a href="<c:url value='/home'/>"><fmt:message
										key="memu.home" /></a></li> --%>
							<%-- <li><a href="<c:url value='/all-video'/>"><fmt:message
										key="memu.anime" /></a></li> --%>
							<li><a href="<c:url value='/video/blog'/>"><s:message code="label.home.blog"/></a></li>
							<li><a href="#" class="text-white"><s:message code="label.home.tlanguge"/> <span class="arrow_carrot-down"></a>
								<ul class="dropdown">
									<li><a href="/change-language?language=en"> <img alt="" width="50px"
											src="https://s2.o7planning.com/templates/o7planning/resources/images/languages/en.png">
									</a></li>
									<li><a href="/change-language?language=vi"> <img alt="" width="50px"
											src="https://s2.o7planning.com/templates/o7planning/resources/images/languages/vi.png">
									</a></li>
								</ul></li>
							<c:if test="${not empty sessionScope.user}">
								<li><a href="#" class="text-white"><s:message code="label.home.hello"/>
										${user.username}<span class="arrow_carrot-down"></span>
								</a>
									<ul class="dropdown">
										<li><a href="<c:url value='/my-profile'/>"><s:message code="label.home.profile"/></a></li>
										<li><a href="<c:url value='/video/my-history'/>"><s:message code="label.home.history"/></a></li>
										<li><a href="<c:url value='/video/favorite'/>">
												<s:message code="label.home.favorite"/></a></li>
										<li><a href="<c:url value='/logout'/>"><s:message code="label.home.logout"/> </a></li>

									</ul></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-lg-2">
				<div class="header__right">
					<a href="#" class="search-switch"><span class="icon_search"></span></a>
					<c:if test="${not empty sessionScope.user}">
						<a href="<c:url value='/my-profile'/>"><span
							class="icon_profile"></span></a>
					</c:if>
					<c:if test="${empty sessionScope.user}">
						<a href="<c:url value='/view-login'/>"><span
							class="icon_profile"></span></a>
					</c:if>
				</div>
			</div>
		</div>
		<div id="mobile-menu-wrap"></div>
	</div>
</header>