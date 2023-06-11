<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Anime Section Begin -->
<section class="anime-details spad">
	<div class="container">

		<div class="row">
			<div class="col-lg-12">
				<div class="mb-2">
				<h2 class="text-white mb-2">Couldn't find video</h2>
					 <%-- <video id="player" playsinline controls
							data-poster="<c:url value='${video.poster}'/>">
							<source src="<c:url value='${video.href}'/>" type="video/mp4" />
							
						</video> --%>
					<iframe width="1100" height="400"
						src="https://www.youtube.com/embed/xxx" title="video"
						frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
				</div>
			</div>
		</div>
		<div class="text-center  mb-4"> <a class="btn btn-danger" href="${request.getContextPath()}/video/all-video">See Other Video</a> </div>

	</div>
</section>
<!-- Anime Section End -->