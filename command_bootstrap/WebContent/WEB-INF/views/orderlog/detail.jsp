<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head></head>

<title>회원목록</title>

<body>
	<!-- Main content -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>주문목록</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"> <i
								class="fa fa-dashboard"></i>주문관리
						</a></li>
						<li class="breadcrumb-item active">목록</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<section class="content">
		<div class="card">
			<div class="card-header with-border" style="text-align: left;">
				<div id="keyword" style="width: 550px;">
					<!-- class="card-tools"  : 오른쪽 정렬시킴-->
					<div class="row">
						<h3>주문목록</h3>
					</div>
				</div>
			</div>
			<div class="card-body" style="text-align: center;"></div>
		</div>
		<!-- card -->
		<c:forEach var="orderlog" items="${orderlogList }">
			<div class="row">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-header"></div>
						<div class="card-body">
							<div class="row">
								<div class="col-sm-6">
									<fmt:formatDate value="${orderlog.buyDate }" />
									주문
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<div class="card">
										<div class="card-header">${orderlog.orderStatus }</div>
										<div class="card-body">
											<div>${orderlog.orderId }</div>
											<div>${orderlog.prodId }</div>
											<div>${orderlog.prodQty }</div>
											<div class="row">
												<div class="col-sm-6">가격</div>
												<div class="col-sm-6">장바구니담기</div>
											</div>
										</div>
										<div class="card-footer"></div>
									</div>
								</div>
								<div class="col-sm-2">
									<div class="card">
										<div class="card-body">
											<div>
												<button class="btn btn-primary " type="button" onclick="">배송조회</button>
											</div>
											<div>
												<button class="btn btn-primary" type="button" onclick="OpenWindow('modifyForm.do?orderId=${orderlog.orderId }','','800','900')">교환:반품</button>
											</div>
											<div>
												<button class="btn btn-primary" type="button" onclick="">리뷰
													작성</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div>
								배송정보
							</div>
							<div>
								결제정보
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<c:set var="list_url" value="list.do"></c:set>
	</section>
	<!-- content -->
	<script src="/resources/js/common.js"></script>
	<script type="text/javascript">
	</script>
</body>



