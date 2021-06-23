<%@page import="DTO.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>board</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="assets/css/font.css">

    <!-- Load map styles -->
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A==" crossorigin="" />
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
<style>
	body{
		font-family: 'SEBANG_Gothic_Bold';
		
	}
</style>
</head>

<body>
 <% memberDTO dto = (memberDTO)session.getAttribute("member");
						
							%>
    <!-- Start Top Nav -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
                <div class="container text-light">
              		<div>
              		</div>
                	<div>
                	<%
							if(dto != null){
										out.print("<h1>"+dto.getName()+  "님 환영해요~😉");
							}else{
								out.print("<h1>로그인이 필요합니다!</h1>");
							}
							%>
                		<%
								if(dto==null){
									//out.print("<button class='btn btn-success' type='button' onclick='location.href='join.jsp' '>회원가입</button>");
									//out.print("<button class='btn btn-success' type='button' onclick='location.href='join.jsp' '>회원가입</button>");
									%>
									<button class="btn btn-success" type="button" onclick="location.href='join.jsp' ">회원가입</button>
			                		<button class="btn btn-success" type="button" onclick="location.href='login.jsp' ">로그인</button>
								
								<% }else{
									if(dto.getId().equals("admin")){
										//out.print("<a href ='delete.jsp'>회원삭제</a>");%>
										<button class="btn btn-success" type="button" onclick="location.href='guestmanage.jsp' ">회원관리</button>
										<button class="btn btn-success" type="button" onclick="location.href='../logout' ">로그아웃</button>
									<%}else{
									//out.print("<a href='update.jsp'>개인정보수정</a>");
									//out.print("<a href='LogoutServiceCon.do'>로그아웃</a>");%>
									<button class="btn btn-success" type="button" onclick="location.href='../logout' ">로그아웃</button>
								
									<% }}
								%>
								
								
                		
                	</div>
                </div>
    </nav>
    
    <!-- Close Top Nav -->

    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-primary logo h1 align-self-center" href="mainPage.jsp">
                SUGE
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="recom.jsp" >추천</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="categoryMain.jsp" >카테고리</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="popChart.jsp" >인기순위</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="board.jsp" >게시판</a>
                        </li>
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                    </div>
                    <form action = "../select">
	                    <input type= "text" name = "search" placeholder = "게임 검색"> 
	                    <input type = "submit" value = "게임 검색">
                    </form>
                </div>
            </div>

        </div>
    </nav>
    <!-- Close Header -->

    <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>


    <!-- Start Content Page -->
        <div class="col-md-6 m-auto text-center">
            <br>
            <h1 style="color:black; font-weight: 900;">글쓰기</h1>
            <br>
        </div>
    <!-- Start Contact --> 
    <%
    request.setCharacterEncoding("UTF-8");	%>
    <div id = "board">
				<form action="../writeboard" method="post" enctype="multipart/form-data"><!-- file 때문에 application/x-www-form-urlencoded을 바꿔줬다 -->
				<table id="list" align="center">
					<tr>
                  <td style="color:black; font-weight: 900;">제목</td>
                  <td colspan="2"><input type="text" name="title" style="width:630px;"> </td>
               </tr>
               <tr>
                  <td style="color:black; font-weight: 900;">작성자</td>
                  <td><input disabled="disabled" type="text" name="id" value=<%=dto.getName() %> style="width:630px;"> </td>
               	</tr>
               	<tr>
                  	<td style="color:black; font-weight: 900;">내용</td>
					<td colspan="2" align="right">
						<input type="file" value="이미지추가" name="img" style="width:250px;" >
					</td>
               	</tr>
               	<tr>
                  <td colspan="2" >
                     <textarea name="text" rows="15" cols="59" style="resize: none;"></textarea>         
                  </td>
               </tr>
               <tr>
                    </tr>
               <tr>
                  <td colspan="2" align="right">
                     <input type="reset" value="초기화" class="btn btn-primary">
                     <input type="submit" value="작성하기" class="btn btn-primary">
                  </td>
               </tr> 
				</table>
				</form>
			</div>
			<br>
    <!-- End Contact -->

     <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row right" >

                <div class="col-md-4 pt-5" >
                    <h2 class="h2 border-bottom pb-3 border-light logo">SUGE</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li>
                            <i class="fas fa-map-marker-alt fa-fw"></i>
                            광주광역시 남구 송암동 CGI센터
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none" href="tel:010-020-0340">010-0000-0000</a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none" href="mailto:info@company.com">suge@suge.com</a>
                        </li>
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
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                        </li>
                    </ul>
                </div>
            </div>

        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="col-12">
                        <p class="text-left text-light">
                            Suggest Steam Games &copy; 2021 SUGE 
                            | Designed by <a rel="sponsored" href="#" target="_blank">SUGE</a>
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
</body>
</html>