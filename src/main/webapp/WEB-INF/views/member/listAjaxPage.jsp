<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
// 해당 html이 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
	$(document).ready(function(){
	// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로받는다
// 		memberListAjax(1);
		memberListAjaxHTML(1);
		
			$('#memberList').on("click","tr",function(){	// tr이있는지 검사해서 있으면 실행한다
		 		// console.log("memberList tr click");
				// data-userid
				var userid = $(this).data("userid");
				console.log("userid : " + userid);

// 				document.location="/member/detail?userid=" + userid;
				document.location="/member/detailAjaxPage?userid=" + userid;
					
			})
	})

	function memberListAjax(p){
	
	$.ajax({url : "/member/listAjax",
			data : {page : p, pageSize : 5},	// 이방법은 파라미터형태로 보내는것 = form전송 
// 			data : "page=1&pageSize=5",
// 			data : JSON.stringify(){page : 1, pageSize : 5}),	
					// Controller에서 @RequestBody  JSON <---> JAVA OBJECT
			method : "get",
			success : function(data){
				var i =0;	

				// memberList tbody영역에 들어갈 html 문자열 생성
				var html="";
				for(var i =0; i< data.memList.length; i++){
					var member = data.memList[i];
					html += "<tr data-userid='"+member.userid+"' >";
					html += " <td>" + member.userid + "</td>";
					html += " <td>" + member.usernm + "</td>";
					html += " <td>" + member.alias + "</td>";
					html += " <td>" + member.fmt_reg_dt + "</td>";
					html += "</tr>";
				}			
				
				$('#memberList').html(html);	

				// 페이지 내비게이션 html문자열 동적으로 생성하기

				var html="";
				for(var j =1; j<data.pages; j++){
					if(j == data.pageVO.page) {
						 html += "<li class=\"active\"><span>"+j+"</span></li>";  
					}
					else{
								// <a href="javascript:memberListAjax(1);"/>
						html += "<li><a href=\"javascript:memberListAjax(" + j + ");\">"+j+"</a></li>";  
						 
					} 

				}
				$('.pagination').html(html);

				}
		})
		}

	function memberListAjaxHTML(p){
		
		$.ajax({url : "/member/listAjaxHTML",
				data : {page : p, pageSize : 5},	// 이방법은 파라미터형태로 보내는것 = form전송 
//	 			data : "page=1&pageSize=5",
//	 			data : JSON.stringify(){page : 1, pageSize : 5}),	
						// Controller에서 @RequestBody  JSON <---> JAVA OBJECT
				method : "get",
				success : function(data){
					$('#memberList').html(data);	

// 					var htmlArr = data.split("$$$$$$$$SEPARATOR$$$$$$$$");
// 					$('#memberList').html(htmlArr[0]);	
// 					$('ul.paginationt').html(htmlArr[1]);	

					// 페이지 내비게이션 html문자열 동적으로 생성하기

// 					$('.pagination').html(html);

					}
			})
			}
	

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


				</tbody>
			</table>
		</div>
		<a href="${cp }/member/regist" class="btn btn-default pull-right">사용자
			등록</a>
		<div class="text-center">
			<ul class="pagination">

			</ul>
		</div>
	</div>
</div>
