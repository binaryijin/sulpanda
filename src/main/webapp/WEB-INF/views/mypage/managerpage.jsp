<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<style>
	.container {
		display: flex;
		justify-content: center;
	}

	.container img {
		flex: 1;
		max-width:200px;
		max-height: 200px;
		object-fit: cover; /* 이미지 비율 유지 및 정사각형으로 표시 */
		width:200px; /* 이미지 너비를 100px로 지정 */
		height: 200px; /* 이미지 높이를 100px로 지정 */
		margin: 20px;
	}
</style>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<tiles:insertAttribute name="header"/>
<section>


<br>
<div class="container">

 
	<a  href="productListMng.do"><img src="assets/img/005.png"></a>
	<a  href="managerUpdateMember.do"><img src="assets/img/004.png"></a>

  
	<a  href="managerBoard.do?page=1"><img src="assets/img/006.png"></a>
</div><br><br><p>

	<br><br>

</section>

<tiles:insertAttribute name="footer"/>

</body>
</html>