<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<title>주문</title>

<body>
	<!-- 	cart detail 기반으로 작성할 것 CART_NO , PROD_ID , PROD_QTY -->
	<section class="content">
		<div class="card">
			<div class="card-header with-border">
				<div class="card-body" style="text-align: center;">
					<div class="row">
						<div class="col-sm-12">
							<div class="card">
								<div class="card-body">
									여기에 주문할 상품들 보여줘야할듯?
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card">
								<div class="card-body">
									<table class="table table-bordered">
										<caption>결제정보</caption>
										<tr>
											<td>총 상품가격</td>
											<td>${orderlog.orderId }</td>
										</tr>
										<tr>
											<td>할인쿠폰</td>
											<td>${orderlog.orderId }</td>
										</tr>
										<tr>
											<td>배송비</td>
											<td>${orderlog.orderId }</td>
										</tr>
										<tr>
											<td>총 결제금액</td>
											<td>${orderlog.orderId }</td>
										</tr>
										<tr>
											<td>결제방법</td>
											<td>${orderlog.orderId }<input type="radio" value="온통대전"
												name="payment" checked="checked" />온통대전 <input type="radio"
												value="신용체크카드" name="payment" />신용체크카드 <input type="radio"
												value="휴대폰결제" name="payment" />휴대폰결제
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<!-- col -->
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card">
								<div class="card-body">
									<button type="button" onclick="order_go();">결제</button>
									<button onclick="">취소</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- card-body -->
		</div>
	</section>
<form role="orderForm" action="regist.do" method="post">
	<input id="" name="pictureFile" type="file" class="form-control" style="display:none;" onchange="picture_go();">
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>
	
	
	<script>
function orderlog(){
	
	
	
	
}
	
	
	</script>

</body>











