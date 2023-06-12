<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<div class="mb-3 text-center">
	<span class=" bg-warning text-white">Add New Film</span>
</div>
<form action="${pageContext.request.contextPath}/admin/add-video" method="post"
	enctype="multipart/form-data">
	<div class="form-outline mb-4 mt-2">
		<input type="text" id="form4Example1" class="form-control"
			name="title" required="required" /> <label class="form-label"
			for="form4Example1">Tiltle</label>
	</div>
	<div class="form-outline mb-4">
		<select name="type">
			<c:forEach items="${all_type}" var="c">
				<option value="${c.id}">${c.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-outline mb-4 mt-2">
		<input type="file" name="posterVd" class="form-control"
			 /> <label class="form-label" >Poster</label>
	</div>

	<div class="form-outline mb-4 mt-2">
		<input type="text" id="form4Example1" class="form-control" name="href" />
		<label class="form-label" for="form4Example1">Href</label>
	</div>

	<!-- Message input -->
	<div class="form-outline mb-4">
		<textarea class="form-control" id="form4Example3" rows="4"
			name="description" required="required"></textarea>
		<label class="form-label" for="form4Example3">Description</label>
	</div>

	<!-- Submit button -->
	<button type="submit" class="btn btn-success btn-block mb-4">Add</button>
</form>

<div class="mt-2">${err}</div>