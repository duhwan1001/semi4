<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="cri" value="${pageMaker.cri }" />
<c:set var="orderlogList" value="${dataMap.orderlogList }" />
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
					<div class="input-group row">
						<!-- 												<select class="form-control col-md-3" name="perPageNum" id="perPageNum" onchange="list_go(1,'list.do');"> -->
						<!-- 													<option value="10">정렬개수</option> -->
						<%-- 													<option value="2"${cri.perPageNum == 2 ? 'selected' : ''}>2개씩</option> --%>
						<%-- 													<option value="3"${cri.perPageNum == 3 ? 'selected' : ''}>3개씩</option> --%>
						<%-- 													<option value="5"${cri.perPageNum == 5 ? 'selected' : ''}>5개씩</option> --%>
						<!-- 												</select> -->
						<!-- 												<select class="form-control col-md-3" name="searchType" id="searchType"> -->
						<!-- 							<option value="">주문상태</option>  -->
						<%-- 							<option value="i" ${cri.searchType eq 's' ? 'selected' : ''}>주문상태</option>  --%>
						<%-- 							<option value="p" ${cri.searchType eq 'd' ? 'selected' : ''}></option>  --%>
						<!-- 						</select> -->
						<input class="form-control" type="text" name="keyword"
							placeholder="주문한 상품을 적어주세요" value="" /> <span
							class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn"
								data-card-widget="search" onclick="list_go(1,'list.do');">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
					<div class="row">
						<button type="button" class="btn btn-primary" onclick="">최근6개월</button>
						<button type="button" class="btn btn-primary" onclick="">2021</button>
						<button type="button" class="btn btn-primary" onclick="">2020</button>
						<button type="button" class="btn btn-primary" onclick="">2019</button>
						<button type="button" class="btn btn-primary" onclick="">2018</button>
					</div>
				</div>
			</div>
			<div class="card-body" style="text-align: center;"></div>
		</div>
		<!-- card -->
		<c:forEach var="orderlog" items="${orderlogList }">
			<div class="row" >
				<div class="col-sm-12">
					<div class="card">
						<div class="card-header"></div>
						<div class="card-body">
							<div class="row">
								<div class="col-sm-6">
									<fmt:formatDate value="${orderlog.buyDate }" />
									주문
								</div>
								<div class="col-sm-6">
									${orderlog.orderId }
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10">
									<div class="card">
										<div class="card-header">${orderlog.orderStatus }</div>
										<div class="card-body">
<%-- 											<div>${orderlog.orderId }</div> --%>
<%-- 											<div>${orderlog.buyDate }</div> --%>
											<div class="row">
												<div class="col-sm-6">가격</div>
											</div>
										</div>
										<div class="card-footer"></div>
									</div>
								</div>
								<div class="col-sm-2">
									<div class="card">
										<div class="card-body" style="text-align: center;">
											<div class="row">
<!-- 												<button class="btn btn-primary " type="button" onclick="">배송조회</button> -->
												<button style="width: 100%" class="btn btn-primary " type="button" onclick="OpenWindow('detail.do?orderId=${orderlog.orderId}','','800','900')">상세조회</button>
											</div>
											<div style="height: 3px"></div>
											<div class="row">
												<button style="width: 100%"  class="btn btn-primary" type="button" onclick="">교환:반품</button>
											</div>
											<div style="height: 3px"></div>
											<div class="row">
												<button style="width: 100%"  class="btn btn-primary" type="button" onclick="">리뷰 작성</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<c:set var="list_url" value="list.do"></c:set>
		<%@ include file="/WEB-INF/views/common/pagination.jsp"%>
	</section>
	<!-- content -->
	<script src="/resources/js/common.js"></script>
	<script type="text/javascript">
	</script>
</body>



