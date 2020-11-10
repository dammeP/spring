<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
$(function(){


	// client side에서는 서버사이드 변수나 값을 사용가능
	memberAjax('${param.userid}');
// 	memberAjax(${param.userid});

// 	memberAjax('brown');
// 	memberAjax(brown);
	
	$('#modifyBtn').on('click',function(){
		var userid = $('#userid_lb').data("userid");
	
		document.location="/member/update?userid=" + userid;
	})

	$('#profileDownBtn').on('click',function(){
		document.location="/profileDownView?userid=${memberVO.userid}";
	})
})


function memberDetailAjax(userid){

	$.ajax({url : "/member/detailAjax",
			// data : {userid : userid},		// 앞에꺼는 자바스크립트의 필드명, 두번째는 값
			data : "userid="+userid,
			method : "get",
			success : function(data){

				var member = data.memberVO;
				html += "<label>" + member.userid + "</label>";
				html += "<label>" + member.usernm + "</label>";
				html += "<label>" + member.alias + "</label>";
				html += "<label>" + member.addr1 + "</label>";
				html += "<label>" + member.addr2 + "</label>";
				html += "<label>" + member.zipcode + "</label>";
				html += "<label>" + member.reg_dt + "</label>";

			}

		})

	
	
}

</script>


<form class="form-horizontal" role="form">

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<%-- 							<img src="${cp }/profile/${memberVO.filename }"/> --%>
			<img src="${cp }/member/profileImg?userid=${memberVO.userid}" /><br>
			<button id="profileDownBtn" data-userid="${memberVO.userid }"
				type="button" class="btn btn-default">다운로드 :
				${memberVO.realfilename }</button>

		</div>
	</div>

	<div class="form-group">
		<label id="userid" for="userid" class="col-sm-2 control-label">사용자
			아이디</label>
		<div class="col-sm-10">
			<label id="userid_lb" data-userid="${memberVO.userid }"
			class="control=label">${memberVO.userid }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<label class="control=label">${memberVO.usernm }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<label class="control=label">${memberVO.alias }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<label class="control=label">********</label>
		</div>
	</div>

	<div class="form-group">
		<label for="addr1" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<label class="control=label">${memberVO.addr1 }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="addr2" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<label class="control=label">${memberVO.addr2 }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<label class="control=label">${memberVO.zipcode }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
		<div class="col-sm-10">
			<label class="control=label"><fmt:formatDate
					value="${memberVO.reg_dt}" pattern="YYYY-MM-dd" /></label>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="modifyBtn" type="button" class="btn btn-default">사용자
				수정</button>
			<%-- 							<a href="${cp }/memberRegist" class="btn btn-default pull-right">사용자 등록</a> --%>
		</div>
	</div>
</form>
