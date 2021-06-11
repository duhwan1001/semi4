<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>

</head>

<title>장바구니</title>

<body>
<style>
.codr_unit_amount{
	margin: 0 auto;
    width: 96px;
}
.codr_amount {
  display: block;
  position: relative;
  width: 40px;
  padding: 0 30px;
}

.codr_amount .codr_b_minus {
  overflow: hidden;
  position: absolute;
  top: 0px;
  left: 3px;
  width: 28px;
  height: 28px;
  border: 1px solid #d1d1d1;
  color: #777;
  font-size: 15px;
  font-family: "나눔바른고딕", NanumBarunGothic;
  text-align: center;
  line-height: 24px;
}

.codr_amount .codr_b_plus {
  overflow: hidden;
  position: absolute;
  top: 0;
  right: -35px;
  width: 28px;
  height: 28px;
  border: 1px solid #d1d1d1;
  color: #777;
  font-size: 15px;
  font-family: "나눔바른고딕", NanumBarunGothic;
  text-align: center;
  line-height: 25px;
}

:lang(en) .codr_amount .codr_b_minus font,
:lang(en) .codr_amount .codr_b_plus font,
:lang(zh) .codr_amount .codr_b_minus font,
:lang(zh) .codr_amount .codr_b_plus font {
  font-family: "나눔바른고딕", NanumBarunGothic !important;
}

.codr_amount .codr_b_minus:hover,
.codr_amount .codr_b_plus:hover {
  border-color: #222;
  background: #fafafa;
  color: #222;
}

.codr_amount .codr_b_minus:active,
.codr_amount .codr_b_plus:active {
  border-color: #222;
  background: #222;
  color: #fff;
}

.codr_amount .codr_b_minus.active,
.codr_amount .codr_b_plus.active {
  border-color: #222;
  background: #222;
  color: #fff;
}

.codr_amount .codr_inpbx {
  display: inline-block;
  width: 40px;
  height: 28px;
  border: 1px solid #d1d1d1;
  border-width: 1px 0;
  background: #fff;
  vertical-align: top;
}

.codr_amount .codr_inpbx input {
  display: block;
  width: 40px;
  height: 28px;
  border: 0;
  background: none;
  font-size: 14px;
  line-height: 28px;
  color: #777;
  text-align: center;
}

.codr_amount_qty{
	display: block;
	width: 38px;
	height: 26px;
	border: 0;
	background: none;
	font-size: 14px;
	line-height: 26px;
	color: #777;
	text-align: center;
}

.codr_amount.disabled {
  opacity: 0.3;
}

.codr_amount.disabled .codr_b_minus:hover,
.codr_amount.disabled .codr_b_plus:hover,
.codr_amount.disabled .codr_b_minus:active,
.codr_amount.disabled .codr_b_plus:active {
  border: 1px solid #d1d1d1;
  background: #fff;
  color: #777;
}

.codr_amount_tip {
  position: absolute;
  left: 0;
  top: 100%;
  min-width: 100px;
  margin-top: -5px;
  text-align: center;
}

.codr_amount_tip:before {
  position: absolute;
  top: 1px;
  left: 43px;
  z-index: 1;
  width: 0;
  height: 0;
  margin: 0 auto;
  border-bottom: 9px solid #888;
  border-left: 7px solid transparent;
  border-right: 7px solid transparent;
  content: "";
}

.codr_amount_tiptx {
  display: inline-block;
  overflow: hidden;
  position: relative;
  z-index: 1;
  height: 26px;
  margin-top: 9px;
  padding: 0 15px;
  border-radius: 13px;
  background: #888;
  font-size: 11px;
  font-weight: bold;
  color: #fff;
  text-align: center;
  white-space: nowrap;
  letter-spacing: -0.3px;
  line-height: 26px;
}
</style>
	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>장바구니</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>장바구니
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
	 <!-- Main content -->
    <section class="content">		
		<div class="card">
			<div class="card-header with-border">
				<div id="keyword" class="card-tools" style="width:450px;">
					<div class="input-group row">
						
					</div>
				</div>						
			</div>
			<div class="card-body">
				<table class="table table-bordered text-center" >					
					<tr style="font-size:0.95em;">
						<th style="width:5%;">체 크</th>
						<th style="width:15%;">상품이미지</th>
						<th style="width:20%;">상품명</th>
						<th style="width:15%;">가격</th>
						<th style="width:20%;">선택수량</th>
						<th style="width:20%;">삭제하기</th>
					</tr>				
					<c:if test="${empty cartList }" >
						<tr>
							<td colspan="6">
								<strong>장바구니 목록이 없습니다.</strong>
							</td>
						</tr>
					</c:if>						
					<c:forEach items="${cartList }" var="cart">
						<tr style='font-size:0.85em;'>
							<td><input type="checkbox" name="price" id="${cart.prod_cost }" onclick="totalPrice()" checked></td>
							<td><img src="/prod/getPicture.do?picture=${cart.prod_img}" style="width: 200px;"></td>
							<td><h4>${cart.prod_name }</h4></td>
							<td><h4>${cart.prod_cost }원</h4></td>
							<td>
							<div class="codr_unit_amount">
								<div class="codr_amount">
									<a href="javascript:void(0);" role="button" class="codr_b_minus payTracking" name="btUpdOrdQtyMinus" onclick="qtyMinus(this, '${cart.cart_no}')"><span aria-hidden="true">-</span><span class="blind"></span></a>
									<span class="codr_inpbx">
										<span class="codr_amount_qty">${cart.prod_qty }</span>
									</span>
									<a href="javascript:void(0);" role="button" class="codr_b_plus payTracking" name="btUpdOrdQtyPlus" onclick="qtyPlus(this, '${cart.cart_no}')"><span aria-hidden="true">+</span><span class="blind"></span></a>
								</div>
							</div>
							</td>
							<td><a href="/cart/cartDeleteItem.do?cartNo=${cart.cart_no}"><h4>삭제하기</h4></a></td>
						</tr>
					</c:forEach>
				</table>				
			</div>
			<div class="card-footer">
				<h1>주문합계 : <span id="totalPrice">0</span>원</h1>		
			</div>
			<div class="card-footer">
				<button type="button" class="btn btn-primary" id="orderBtn" onclick=""
					style="margin: 0 auto; display: block; margin-bottom: 15px;">주문하기</button>				
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>				
			</div>
		</div>
		
    </section>
    <!-- /.content -->

<script src="/resources/js/common.js" ></script>
 <%@ include file="./cart_js.jsp" %>
<c:if test="${!empty cartList }" >
<script>
window.onload = function(){
	totalPrice()
}
</script>
</c:if>
</body>







