<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row border border-primary">
	<form action="TypeController" method="post">
		<div class="mt-2 text-center">Add Type</div>
		<div class="form-outline mb-3 mt-2">
			<h5>Id:${type.id}</h5>
		</div>
		<div class="form-outline ">
			<input type="text" id="form4Example1" class="form-control"
				name="name" required="required" value="${type.name}" /> <label
				class="form-label" for="form4Example1">Name Type</label>
		</div>


		<!-- Submit button -->
		<button formaction="<c:url value='/admin/type/add-type'/>" type="submit"
			class="btn btn-primary btn-block mb-4">Add</button>
		<button formaction="<c:url value='/admin/type/edit-type'/>/${type.id}"
			type="submit" class="btn btn-primary btn-block mb-4">Update</button>
	</form>
</div>
<div class="row mt-2">
	<h3>List Video</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Active</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="x">
				<tr>
					<th scope="row">${x.id}</th>
					<td>${x.name}</td>
					<td>${x.active==true?'Active':'Non-Active'}</td>
					<td><a
						href="<c:url value='/admin/type/view-edit-type' />/${x.id}"
						class="edit" data-toggle="modal"><i class="fa fa-pencil"
							aria-hidden="true">Edit</i></a> <br> <a
						href="<c:url value='/admin/type/delete-type' />/${x.id}"
						class="delete" data-toggle="modal"><i class="fa fa-trash-o"
							aria-hidden="true"></i>Dele</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="product__pagination text-center">
		<c:forEach begin="1" end="${totalPage}" varStatus="i">
			<a href="/admin/type?pageNum=${i.index}" class="current-page">${i.index}</a>
		</c:forEach>
	</div>

</div>
