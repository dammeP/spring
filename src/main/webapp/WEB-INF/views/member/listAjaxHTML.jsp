<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:forEach items="${memList }" var="memList">
	<tr data-userid="${memList.userid }">
		<td>${memList.userid }</td>
		<td>${memList.usernm }</td>
		<td>${memList.alias }</td>
		<td><fmt:formatDate value="${memList.reg_dt}"  pattern="yyyy-MM-dd"/></td>
	</tr>
</c:forEach>



$$$$$$$$SEPARATOR$$$$$$$$


<c:forEach var="i" begin="1" end="${pages }">
	<c:choose>
		<c:when test=" ${i == pageVO.page}">
			<li class="active"><span>${i }</span></li>
		</c:when>
		<c:otherwise>
			<li><a
				href="javascript:memberListAjaxHTML(${i});">${i }</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>