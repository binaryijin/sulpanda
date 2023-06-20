<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
    /* 리뷰 테이블 스타일 */
    #reviewArea table {
        border-collapse: collapse;
        width: 100%;
    }

    #reviewArea th,
    #reviewArea td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    /* 리뷰 작성창 스타일 */
    #reviewForm {
        margin-top: 20px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f5f5f5;
    }

    #reviewForm label {
        font-weight: bold;
    }

    #reviewForm input[type="text"],
    #reviewForm textarea {
        width: 100%;
        padding: 5px;
        border-radius: 3px;
        border: 1px solid #ccc;
    }

    #reviewForm input[type="submit"] {
        padding: 5px 10px;
        border-radius: 3px;
        border: none;
        background-color: #4CAF50;
        color: #fff;
        cursor: pointer;
    }

    #reviewForm input[type="submit"]:hover {
        background-color: #45a049;
    }

</style>

<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/templatemo.css">
<link rel="stylesheet" href="assets/css/custom.css">


<!-- Load fonts style after rendering the layout styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">

<link rel="stylesheet" href="assets/css/cart.css">
</head>
<body>
	<tiles:insertAttribute name="header" />

	<!-- 상품 상세보기 페이지 -->
	<section class="bg-light">
		<div class="container pb-5">
			<div class="row">
				<div class="col-lg-5 mt-5">
					<div class="card mb-3">
						<img class="card-img img-fluid"
							src="${pageContext.request.contextPath}/upload/${product.productImg}"
							alt="상품 이미지" id="product-detail">
					</div>
				</div>
				<!-- col end -->
				<div class="col-lg-7 mt-5">
					<div class="card">
						<div class="card-body">
							<h1 class="h2">${product.productName}</h1>
							<p class="h3 py-2">
								<c:choose>
									<c:when test="${product.productSale == 'Y'}">
										<del>${product.productPrice}원</del> ${product.productSalePrice}원
   								 </c:when>
									<c:otherwise>
      										${product.productPrice}원
    									</c:otherwise>
								</c:choose>
							</p>
							<ul class="list-inline">
								<li class="list-inline-item">
									<p>종류</p>
								</li>
								<li class="list-inline-item">
									<p class="text-muted">
										<strong>${product.productKind}</strong>
									</p>
								</li>
							</ul>

							<ul class="list-inline">
								<li class="list-inline-item">
									<p>당도</p>
								</li>
								<li class="list-inline-item">
									<p class="text-muted">
										<strong>${product.productTaste}</strong>
									</p>
								</li>
							</ul>

							<ul class="list-inline">
								<li class="list-inline-item">
									<p>탄산</p>
								</li>
								<li class="list-inline-item">
									<p class="text-muted">
										<strong>${product.productSparkling}</strong>
									</p>
								</li>
							</ul>

							<ul class="list-inline">
								<li class="list-inline-item">
									<p>도수</p>
								</li>
								<li class="list-inline-item">
									<p class="text-muted">
										<strong>${product.productABV}도</strong>
									</p>
								</li>
							</ul>

							<%-- Buy 및 Add To Cart 버튼 > 로그인 상태에 따라 표시 --%>
							<c:choose>
								<c:when test="${empty id}">
									<p style="color: red;">
										19세 미만 구매 불가 <br>로그인 후 구매 가능합니다. <br>
										<button class="btn btn-success btn-lg"
											onclick="location.href='login.do'">Login</button>
								</c:when>
								<c:otherwise>
									<form id="frmmmm" action="cartInsert.do" method="post">
										<input type="hidden" name="productId"
											value="${product.productId}"> <input type="hidden"
											name="productName" value="${product.productName}"> <input
											type="hidden" name="productFee"
											value="${product.productPrice}"> <input type="hidden"
											id="productCount" name="productCount" value="">

									</form>
									<div class="row">
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">Quantity <input
													type="hidden" name="product-quanity" id="product-quanity"
													value="1"></li>
												<li class="list-inline-item"><span
													class="btn btn-success" id="btn-minus" onclick="minus()">-</span></li>
												<li class="list-inline-item"><span
													class="badge bg-secondary" id="var-value">1</span></li>
												<li class="list-inline-item"><span
													class="btn btn-success" id="btn-plus" onclick="plus()">+</span></li>
											</ul>
										</div>
									</div>
									<div class="row pb-3">
										
										<div class="row pb-3">
											<div class="col d-grid">
												<button type="button" class="btn btn-success btn-lg" name="buy" value="buy" onclick="buyProduct()">
												Buy
												</button>
											</div>
											<div class="col d-grid">
												<button type="button" class="btn btn-success btn-lg" onclick="addCart()" id = "adct" name="adct" value="addtocart">
												Add To Cart
												</button>
											</div>
										</div>
									</div>

								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
			<div>
			<form id="tpsub" action="buyProduct.do" method="post">
				<input type="hidden" id="totalPrice2" name="totalPrice2" value="">
				<input type="hidden" id="productName2" name="productName2" value="">
				<input type="hidden" id="productCount2" name="productCount2" value="">
			</form>
			</div>
		</div>
		
		<div id="reviewArea">
		<h2 style="text-align:center; margin-right: 10px;">REVIEW</h2>
			<table class="bright" style="width: 80%;" align="center"><br>
				<tr>
					<th>작성자</th>
					<th>점수</th>
					<td>내용</td>
					<th>작성일자</th>
				</tr>
				
				
				<c:forEach items="${reviews}" var="r">
	<tr>
		<td style="padding: 15px;">
			${r.memberId }
		</td>
		<td style="padding: 15px;">
			<c:forEach var="rating" begin="1" end="5">
				<c:if test="${r.reviewScore >= rating }">
					★
				</c:if>
				<c:if test="${r.reviewScore < rating }">
					☆
				</c:if>
			</c:forEach>
		</td>
		<td style="padding: 15px;">
			${r.reviewContent }
		</td>
		<td style="padding: 15px;">
			${r.reviewDate }
		</td>
	</tr>
		</c:forEach>
			</table><br>
		</div>
	</section>

	<tiles:insertAttribute name="footer" />
	<script>
		function addCart() {
			let productCount = document.getElementById("productCount");
			let span = document.getElementById("var-value");
			productCount.value = span.textContent;

			let frm = document.getElementById("frmmmm");
			frm.submit();

		}

		function minus() {
			let span = document.getElementById("var-value");

			if (Number(span.textContent) <= 1) {
				alert("더이상 내릴 수 없습니다.");
			} else {
				num = Number(span.textContent) - 1;
			}
			span.textContent = num;
		}

		function plus() {
			let span = document.getElementById("var-value");

			num = Number(span.textContent) + 1;
			span.textContent = num;
		}

		
		function buyProduct(){
			let num = document.getElementById("var-value").textContent;
			
			let num2 = num * ${product.productPrice};
			
			let totalPrice = document.getElementById("totalPrice2");
			totalPrice.value = num2;
			
			let productName = document.getElementById("productName2");
			productName.value = "${product.productName}";
			
			let productCount = document.getElementById("productCount2");
			productCount.value = Number(num);
			
			let frm = document.getElementById("tpsub");
			
			frm.submit();
		}

	</script>

</body>
</html>