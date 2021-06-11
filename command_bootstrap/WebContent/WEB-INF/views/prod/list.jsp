<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageMaker" value="${pageMaker}" />
<c:set var="cri" value="${pageMaker.cri}" />
<c:set var="prodList" value="${prodList}" />

<head>
<style>
#pictureView{
	border-radius:20px;
	text-align: center;
}
.prodList{
	margin: 20px;
}
.prodName{
	font-size: 2em;
}
.prodCost{
	font-size:2.1em;
	color:#f52c5e;
	font-weight:bold;
}
.prodBtn{
	text-align: center;
}
</style>
</head>

<title>공지목록</title>

<body>
	<!-- Main content -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>상품목록</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"> <i
								class="fa fa-dashboard"></i>상품조회
						</a></li>
						<li class="breadcrumb-item active">목록</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<!-- Main content -->
    <section class="content">		
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('registForm.do','상품등록',800,700);">상품등록</button>				
				<div id="keyword" class="card-tools" style="width:450px;">
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum"
					  		onchange="list_go();">
					  		<option value="10" >정렬개수</option>
					  		<option value="20" ${cri.perPageNum == 20 ? 'selected':''}>20개씩</option>
					  		<option value="30" ${cri.perPageNum == 30 ? 'selected':''}>30개씩</option>
					  		<option value="40" ${cri.perPageNum == 40 ? 'selected':''}>40개씩</option>
					  		
					  	</select>						
						<select class="form-control col-md-4" name="searchType" id="searchType">
							<option value=""  ${cri.searchType eq '' ? 'selected':'' }>전 체</option>
							<option value="상의" ${cri.searchType eq '상의' ? 'selected':'' }>상의</option>
							<option value="하의" ${cri.searchType eq '하의' ? 'selected':'' }>하의</option>
							<option value="신발" ${cri.searchType eq '신발' ? 'selected':'' }>신발</option>
						</select>					
						<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${param.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="list_go(1);" 
							data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>						
			</div>
			<div class="card-body">
				<ul style="list-style: none;">
					<c:if test="${empty prodList }" >
						<li>데이터가 없습니다.</li>
					</c:if>						
					<c:forEach items="${prodList }" var="prod">
						<li class="prodList" style="width: 300px; float: left;" >
							<div id="pictureView" data-id="${prod.prodId }"
								style=" height: 400px; width: 300px; margin: 0 auto;
								background-image: url('getPicture.do?picture=${prod.prodImg}');background-position:center;
								background-repeat:no-repeat;
								">
							</div>
							<strong class="prodName">${prod.prodName}</strong>
							<br>
							<span class="prodCost">${prod.prodCost }원</span>
							<br>
							<button type="button" class="btn btn-primary">구매하기</button>
							<button type="button" class="btn btn-primary">장바구니</button>
							<button type="button" class="btn btn-primary" onclick="OpenWindow('detail.do?prodId=${prod.prodId}','상품상세조회',800,700);">상세보기</button>
						</li>	
					</c:forEach>
				</ul>				
			</div>
			<div class="card-footer">
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>				
			</div>
		</div>
		
    </section>
    <!-- /.content -->

<script src="/resources/js/common.js" ></script>

</body>







