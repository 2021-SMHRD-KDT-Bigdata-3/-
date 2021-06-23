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
		<div class="container d-flex justify-content-between align-items-center">

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
					<input type="text" name="search" placeholder="게임 검색"> <a
						class="nav-icon d-none d-lg-inline" href="#"
						data-bs-toggle="modal" data-bs-target="#templatemo_search"> <i
						class="fa fa-fw fa-search text-dark mr-2"></i>
					</a>
				</div>
			</div>
		</div>
	</nav>
	<br>
	<br>
	
	<section>
		<div class="row text-center pt-3">
			<div class="col-lg-6 m-auto">
				<h1 class="h1">게임 추천</h1>
			</div>
		</div>
		<div class="row" height="1500px">
			<br> <br>
			<div class="col-lg-6 m-auto" align="center" width="100%">
				<h4 align="center">
					5. 당신은 복잡한 게임을 어떻게 생각하십니까?
				</h4>
				부정적 <input type="radio" name="lv" value="1"> &nbsp;
				&nbsp; 그저그렇다 <input type="radio" name="lv" value="2"> &nbsp;
				&nbsp; 긍정적 <input type="radio" name="lv" value="3">
			</div>
			<br> <br> <br>
			<br> <br> <br>
			
			<br> <br>
			<div class="col-lg-6 m-auto" align="center" width="100%">
				<h4 align="center">
					6. 게임 선택할 때 후기에 많은 영향을 받습니까?
				</h4>
				매우아니다 <input type="radio" name="score" value="1"> &nbsp;
				&nbsp; 아니다 <input type="radio" name="score" value="2"> &nbsp;
				&nbsp; 보통 <input type="radio" name="score" value="3"> &nbsp;
				&nbsp; 그렇다 <input type="radio" name="score" value="4"> &nbsp;
				&nbsp; 매우그렇다 <input type="radio" name="score" value="5">
			</div>
			<br> <br> <br>
			<br> <br> <br>
			
			<br> <br>
			<div class="col-lg-6 m-auto" align="center" width="100%">
				<h4 align="center">
					7. 당신은 어떤 테마를 선호하십니까?
				</h4>
				19금 <input type="checkbox" name="graphic" value="19"> &nbsp;
				&nbsp; SF <input type="checkbox" name="graphic" value="sf"> &nbsp;
				&nbsp; 공포 <input type="checkbox" name="graphic" value="공포"> &nbsp;
				&nbsp; 미스터리 <input type="checkbox" name="graphic" value="미스터리"> &nbsp;
				&nbsp; 생존 <input type="checkbox" name="graphic" value="생존"> &nbsp;
				&nbsp; 스포츠 <input type="checkbox" name="graphic" value="스포츠"> &nbsp;
				&nbsp; 애니 <input type="checkbox" name="graphic" value="애니"> &nbsp;
				&nbsp; 오픈월드 <input type="checkbox" name="graphic" value="오픈월드"> &nbsp;
				&nbsp; 음악 <input type="checkbox" name="graphic" value="음악"> 
				<!-- 나중에 중간통록에서 묶어준다. -->
			</div>
			<br> <br> <br>
			<br> <br> <br>
			
		</div>
		<div align="center">
			<button class="btn btn-success" style="width: 200px; height: 50px" onclick = "location.href = 'game_search3.jsp'">다음으로</button>
		</div>
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
	<script src="assets/js/custom.js"></script><!-- Start Script -->
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
	
	
	
	
</body>