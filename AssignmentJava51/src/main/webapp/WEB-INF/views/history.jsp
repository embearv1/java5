<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<!-- Video begin -->
	<section>
		<div class="text-center mt-3">
			<h3 class="text-white">Your Watched Video</h3>
		</div>
	</section>

	<section class="product-page spad">
		<div class="container">
			<div class="row">
				<c:forEach items="${videohis}" var="x">
					<div class="col-lg-4 col-md-6 col-sm-6">
						<div class="product__item">
						<a href="<c:url value="/video/detail/${x.id}"/>">
							<div class="product__item__pic set-bg"
								data-setbg="<c:url value='${x.video.poster}'/>">
								<div class="view">
									<i class="fa fa-eye"></i>${x.video.views}</div>
							</div>
							</a>
							<div class="product__item__text">
								<ul>
									<li>${x.video.type.name}</li>
								</ul>
								<h5>
									<a href="<c:url value="/video/detail?id=${x.video.id}"/>">${x.video.title}</a>
								</h5>
								<h6 class="text-white">View Date:${x.view_date}</h6>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<!-- Video end -->