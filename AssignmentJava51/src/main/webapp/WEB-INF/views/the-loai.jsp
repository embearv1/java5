<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Product Section Begin -->
<section class="product-page spad">
	<div class="container">
		<div class="product__page__content">
			<div class="product__page__title">
				<div class="row">
					<div class="col-lg-8 col-md-8 col-sm-6">
						<div class="section-title">
							<h4>List Video</h4>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<div class="product__page__filter">
							<p>Sort Video:</p>
							<select>
								<option value="">All</option>
								<option value="">1-6</option>
								<option value="">A-Z</option>
							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-2">
				<div class="text-white">
					<h5 class="font-weight-bold">Type Video</h5>
				</div>
				<br>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/video/all-video" class="list-group-item list-group-item-primary"">All
						Video</a>
						<c:forEach items="${_listType}" var="x">
						 <a href="${pageContext.request.contextPath}/video/genre/${x.id}" class="list-group-item  list-group-item-primary">${x.name}</a>
						 </c:forEach>
				</div>
			</div>
			<div class="col-10">
				<c:forEach items="${list}" var="x">
					<div class="col-lg-4 col-md-6 col-sm-12 float-left">
						<div class="product__item">
							<a href="<c:url value="/video/detail/${x.id}"/>">
								<div class="product__item__pic set-bg"
									data-setbg="<c:url value='${x.poster}'/>">
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i>${x.views}</div>
								</div>
							</a>
							<div class="product__item__text">
								<ul>
									<li>${x.type.name}</li>
								</ul>
								<h5>
									<a href="<c:url value="/video/detail/${x.id}"/>">${x.title}</a>
								</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="product__pagination text-center">
			<a href="?pageNum=1"><i class="fa fa-angle-double-left"></i></a>
			<c:forEach begin="1" end="${totalPage}" varStatus="i">
				<a href="?pageNum=${i.index}" class="current-page">${i.index}</a>
			</c:forEach>
			<a href="?pageNum=${totalPage}"><i
				class="fa fa-angle-double-right"></i></a>
		</div>
	</div>
</section>
<!-- Product Section End -->