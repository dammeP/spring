<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
$(document).ready(function(){
	$('#memberList tr').on("click",function(){
// 		console.log("memberList tr click");
		// data-userid
		var userid = $(this).data("userid");
		console.log("userid : " + userid);

		document.location="/member/detail?userid=" + userid;
		
	})
})

</script>


<div class="row">
	tiles : memberListContent.jsp
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<tbody id="memberList">
					<c:forEach items="${memList }" var="memList">
						<tr data-userid="${memList.userid }">
							<td>${memList.userid }</td>
							<td>${memList.usernm }</td>
							<td>${memList.alias }</td>

							<!--  format : yyyy-MM-dd -->
							<td><fmt:formatDate value="${memList.reg_dt}"
									pattern="yyyy-MM-dd" /></td>
							<%-- 									<td>${memList.reg_dt pattern="yyyy-MM-dd"}</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="${cp }/member/regist" class="btn btn-default pull-right">사용자
			등록</a>
		<%-- 						  pages : ${pages} --%>
		<%--       					  page : ${page } --%>
		<div class="text-center">
			<ul class="pagination">
				<c:forEach var="i" begin="1" end="${pages }">
					<c:choose>
						<c:when test=" ${i == page}">
							<li class="active"><span>${i }</span></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath }/member/list?page=${i}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
