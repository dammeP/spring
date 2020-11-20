<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js.cookie-2.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>

	
	$(function() {
		if (Cookies.get("REMEMBERME") == "Y") {
			// $('input[name=remember]').attr('checked',true);
			$('input[type=checkbox]').prop('checked', true);
			$('#inputEmail').attr('value', Cookies.get("USERNM"));

		} else {

			// $('input[name=remember]').attr('checked',false);
			$('input[type=checkbox]').prop('checked', false);

		}
		// sign in 버튼이 클릭 되었을때 이벤트 핸들러
		$('button').on('click', function() {
			console.log("button_click");
			if ($('input[type=checkbox]').prop('checked') == true) {
				Cookies.set("REMEMBERME", "Y")
				Cookies.set("USERNM", $("#inputEmail").val())
			} else {
				Cookies.remove("REMEMBERME");
				Cookies.remove("USERNM");
			}

			//submit
			$("form").submit();
		})
	})

	function getCookieValue(cookieName) {
		// 자바스크립트 로직
		result = "";
		var cookies = document.cookie.split("; ");
		for (i = 0; i < cookies.length; i++) {
			cookies2 = cookies[i].split("=");
			if (cookies2[0] == cookieName) {
				result = cookies2[1];
				return result;
			}
		}
		return ""; // 원하는 쿠키가 없는경우
	}

	function setCookie(cookieName, cookieValue, expires) {

		///document.cookie = "USERNM = brown; path=/; expires=Web; 07 Oct 2020 00:38:35 GMT;"
		var today = new Date();

		// 현재날짜에서 미래로 + expires 만큼 한 날짜 구하기
		today.setDate(today.getDate() + expires);

		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires="
				+ today.toGMTString();
		console.log(document.cookie);

	}

	// 해당쿠키의 expires속성을 과거날짜로 변경
	function deleteCookie(cookieName) {
		setCookie(cookieName, "", -1); // 현재날짜에서 -1
	}
</script>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="icon" href="../../favicon.ico"> -->

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
  </head>

  <body>
  	msg:${msg }<br>
  	msg_s:${msg_s }<br>
  	<c:remove var="msg_s" scope="session"/>
  	
  	msg_ra : ${msg_ra }
  	
    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath }/login/process" >
        <h2 class="form-signin-heading"><spring:message code="login.signin"></spring:message></h2>
        <label for="inputEmail" class="sr-only"><spring:message code="login.userid"></spring:message></label>
        <input type="email" id="inputEmail" name="userid" class="form-control" placeholder="Email address" required autofocus value="brown">
        <label for="inputPassword"  class="sr-only"><spring:message code="login.password"></spring:message></label>
        <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Password" required value="brownPass">
        <div class="checkbox">
          <label>
            <input type="checkbox" name="remember" value="remember-me"><spring:message code="login.rememberme"></spring:message>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
    