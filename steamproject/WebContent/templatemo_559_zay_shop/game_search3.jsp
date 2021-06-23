<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@page import="DTO.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/templatemo.css">
<link rel="stylesheet" href="assets/css/custom.css">

<!-- Load fonts style after rendering the layout styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/font.css">
</head>
<body>
	<%
	memberDTO dto = (memberDTO) session.getAttribute("member");
	%>
	<!-- Start Top Nav -->
	<nav
		class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block"
		id="templatemo_nav_top">
		<div class="container text-light">
			<div></div>
			<div>
				<%
				if (dto != null) {
					out.print("<h1>" + dto.getName() + "님 환영해요~😉");
				} else {
					out.print("<h1>로그인이 필요합니다!</h1>");
				}
				%>
				<%
				if (dto == null) {
					//out.print("<button class='btn btn-success' type='button' onclick='location.href='join.jsp' '>회원가입</button>");
					//out.print("<button class='btn btn-success' type='button' onclick='location.href='join.jsp' '>회원가입</button>");
				%>
				<button class="btn btn-success" type="button"
					onclick="location.href='join.jsp' ">회원가입</button>
				<button class="btn btn-success" type="button"
					onclick="location.href='login.jsp' ">로그인</button>

				<%
				} else {
				if (dto.getId().equals("admin")) {
					//out.print("<a href ='delete.jsp'>회원삭제</a>");
				%>
				<button class="btn btn-success" type="button"
					onclick="location.href='guestmanage.jsp' ">회원관리</button>
				<button class="btn btn-success" type="button"
					onclick="location.href='../logout' ">로그아웃</button>
				<%
				} else {
				//out.print("<a href='update.jsp'>개인정보수정</a>");
				//out.print("<a href='LogoutServiceCon.do'>로그아웃</a>");
				%>
				<button class="btn btn-success" type="button"
					onclick="location.href='../logout' ">로그아웃</button>

				<%
				}
				}
				%>



			</div>
		</div>
	</nav>
	<!-- Close Top Nav -->


	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-light shadow">
		<div
			class="container d-flex justify-content-between align-items-center">

			<a class="navbar-brand text-primary logo h1 align-self-center"
				href="mainPage.jsp"> SUGE </a>

			<button class="navbar-toggler border-0" type="button"
				data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div
				class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
				id="templatemo_main_nav">
				<div class="flex-fill">
					<ul
						class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
						<li class="nav-item"><a class="nav-link" href="recom.jsp">추천</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="categoryMain.jsp">카테고리</a></li>
						<li class="nav-item"><a class="nav-link" href="popChart.jsp">인기순위</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="board.jsp">게시판</a>
						</li>
					</ul>
				</div>
				<div class="navbar align-self-center d-flex">
					<div
						class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
					</div>
					<form action = "../select">
	                    <input type= "text" name = "search" placeholder = "게임 검색"> 
	                    <input type = "submit" value = "게임 검색">
                    </form>
				</div>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<%
	String[] question = {"게임에서 캐릭터의 성장 과정을 좋아하십니까?", "당신은 속도감 있는 스포츠를 좋아하십니까?", "귀하는 새로운 것을 체험하길 원하십니까?",
			"당신은 타격감을 중요시 여깁니까?", "주로 게임할 때 풍부한 스토리를 좋아하십니까?", "귀하는 부대 지휘하는 것을 좋아하십니까?"};
	%>
	<section>
		<div class="row text-center pt-3">
			<div class="col-lg-6 m-auto">
				<h1 class="h1">게임 추천</h1>
			</div>
		</div>
		<form class="row" height="1500px" id="search3">
		<div class="row" height="1500px">
			<%
			for (int i = 0; i < 6; i++) {
			%>
			<br> <br>
			<div class="col-lg-6 m-auto" align="center" width="100%">
				<h4 align="center">
					<%=(i + 8) + ". "%><%=question[i]%>
				</h4>

				예 <input type="radio" name="genre<%=i%>" value="1"> &nbsp;
				&nbsp; 아니오 <input type="radio" name="genre<%=i%>" value="0">
			</div>
			<br> <br> <br>
			<%
			}
			%>
		</div>
		<div align="center">
			<button class="btn btn-success" style="width: 200px; height: 50px" onclick = "location.href = 'recommand'">결과 확인</button>
		</div>
		</form>
		<br>
	</section>

	<!-- Start Footer -->
	<footer class="bg-dark" id="tempaltemo_footer">
		<div class="container">
			<div class="row right">

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-success border-bottom pb-3 border-light logo">SUGE</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><i class="fas fa-map-marker-alt fa-fw"></i> 광주광역시 남구 송암동
							CGI센터</li>
						<li><i class="fa fa-phone fa-fw"></i> <a
							class="text-decoration-none" href="tel:010-020-0340">010-0000-0000</a>
						</li>
						<li><i class="fa fa-envelope fa-fw"></i> <a
							class="text-decoration-none" href="mailto:info@company.com">suge@suge.com</a>
							<br> <br> <br> <br></li>
					</ul>
				</div>
				<!-- <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Index</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">추천</a></li>
                        <li><a class="text-decoration-none" href="#">카테고리</a></li>
                        <li><a class="text-decoration-none" href="#">인기순위</a></li>
                        <li><a class="text-decoration-none" href="#">게시판</a></li>
                       
                    </ul>
                </div>  -->



			</div>

			<div class="row text-light mb-4">
				<div class="col-12 mb-3">
					<div class="w-100 my-3 border-top border-light"></div>
				</div>
			</div>
			<div class="col-auto me-auto">
				<ul class="list-inline text-left footer-icons">
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="http://facebook.com/"><i
							class="fab fa-facebook-f fa-lg fa-fw"></i></a>
					</li>
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="https://www.instagram.com/"><i
							class="fab fa-instagram fa-lg fa-fw"></i></a>
					</li>
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="https://twitter.com/"><i
							class="fab fa-twitter fa-lg fa-fw"></i></a>
					</li>
					<li
						class="list-inline-item border border-light rounded-circle text-center">
						<a class="text-light text-decoration-none" target="_blank"
						href="https://www.linkedin.com/"><i
							class="fab fa-linkedin fa-lg fa-fw"></i></a>
					</li>
				</ul>
			</div>
		</div>

		<div class="w-100 bg-black py-3">
			<div class="container">
				<div class="row pt-2">
					<div class="col-12">
						<p class="text-left text-light">
							Suggest Steam Games &copy; 2021 SUGE | Designed by <a
								rel="sponsored" href="#" target="_blank">SUGE</a>
						</p>
					</div>
				</div>
			</div>
		</div>

	</footer>
	<!-- End Footer -->





	<!-- Start Script -->
	<script src="assets/js/jquery-1.11.0.min.js"></script>
	<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/templatemo.js"></script>
	<script src="assets/js/custom.js"></script>
	<!-- End Script -->

	<script src="assets/js/jquery-1.11.0.min.js"></script>
	<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/templatemo.js"></script>
	<script src="assets/js/custom.js"></script>
	
	<script>
	$("#next").click(function (event) {
        // Get form         
        var params = $('#search3').serialize();
        // Create an FormData object  
        $.ajax({             
           type: "POST",         
            url: "http://localhost:9000/flask",        
            data: params, 
            success: function (data) { 
               window.location.href = data;
				},
                
            error: function (e) {  
               console.log("ERROR : ", e);
               alert("fail");
             }     
       });
       </script>
        
    });


</body>
</html>