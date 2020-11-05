<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/WEB-INF/views/layout/commonLib.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(document).ready(function(){
	$('#zipcodeBtn').on('click',function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
				console.log(data);

				$('#addr1').val(data.roadAddress);
				$('#zipcode').val(data.zonecode);
				
	        }
	    }).open();
	})

	$('#updateBtn').on('click',function(){
		// client side - validation
		// server side - validation
		// validation 로직은 일단 생략

		$('#frm').submit();
	})
})


</script>


</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/WEB-INF/views/layout/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" action="/member/update" method="POST" enctype="multipart/form-data">
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img src="${cp }/profileImg?userid=${memberVO.userid}"/>
							<input type="file" name="realFile"/>
						</div>
					</div>
				
					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
<%-- 						<label class="control-label" id="userid" name="userid" value="${memberVO.userid }">${memberVO.userid }</label> --%>
							<input type="text" class="form-control" id="userid" name="userid" value="${memberVO.userid}" READONLY/>${memberVO.userid}
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="usernm" name="usernm" value="${memberVO.usernm}" placeholder="${param.usernm}"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias" value="${memberVO.alias}"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass" value="${memberVO.pass}"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
<%-- 							<label class="control-label">${memberVO.addr1 }</label><br> --%>
							<input type="text" class="form-control" id="addr1" name="addr1" value="${memberVO.addr1}" READONLY/>
							<button id="zipcodeBtn"type="button" class="btn btn-default">우편번호 찾기</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
<%-- 							<label class="control-label">${memberVO.addr2 }</label> --%>
							<input type="text" class="form-control" id="addr2" name="addr2" value="${memberVO.addr2}" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
<%-- 							<label class="control-label">${memberVO.zipcode }</label> --%>
							<input type="text" class="form-control" id="zipcode" name="zipcode" value="${memberVO.zipcode}" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="updateBtn" type="submit" class="btn btn-default">수정하기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
