<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>제품상세보기</title>

<body>

  <!-- Content Wrapper. Contains page content -->
  <div >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상세페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">제품관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
    <!-- Main content -->
    <section class="content register-page">
		<div style="width:700px;height: 500px;">
			<div class="login-logo">
    			<a href="<%=request.getContextPath()%>/prod/registForm.do"><b>상품 상세 보기</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist.do" method="post">	
						<div class="row">
							<div class="col-6">
								<input type="hidden" name="prodImg" />
									<div style="text-align: center;">
										<div id="pictureView" data-id="${product.prodId }" style="border: 1px solid green; height: 400px; width: 300px; margin: 0 auto;"></div>
									</div>
							</div>
							<div class="col-6">	
								<div class="form-group row">
									<label for="prodName" class="col-sm-3" style="font-size:0.9em;">
										<span style="color:red;font-weight:bold;"></span>상 품 명</label>
									<div class="col-sm-9 input-group-sm">								
										<input class="form-control" name="prodName" type="text" class="form-control" id="prodName"
												value="${product.prodId }" readonly />
									</div>
								</div>		
								<div class="form-group row">
									<label for="prodCost" class="col-sm-3" style="font-size:0.9em;">
										상품 가격</label>
									<div class="col-sm-8 input-group-sm">								
										<input class="form-control" name="prodCost" type="text" class="form-control" id="prodCost"
											style="color:red;font-size:2em;height: 45px;" value="${product.prodCost }" readonly/>
									</div>
									<strong class="col-sm-1" style="font-size:2em; color:red;">원</strong>
								</div>
								<div class="form-group row">
									<label for="prodQty" class="col-sm-3" style="font-size:0.9em;">
										상품 수량</label>
									<div class="col-sm-9 input-group-sm">								
										<input class="form-control" name="prodQty" type="text" class="form-control" id="prodQty"
											style="font-size:0.9em;" value="${product.prodQty }" readonly/>
									</div>
								</div>
								<div class="form-group row">
									<label for="authority" class="col-sm-3" style="font-size:0.9em;" >구분1</label>
									<div class="col-sm-9">
										<input class="form-control" name="prodWho" type="text" class="form-control" id="prodWho"
											style="font-size:0.9em;" value="${product.prodWho }" readonly/>
									</div>
								</div>	
								<div class="form-group row">
									<label for="authority" class="col-sm-3" style="font-size:0.9em;" >구분2</label>
									<div class="col-sm-9">
										<input class="form-control" name="prodClass" type="text" class="form-control" id="prodClass"
											style="font-size:0.9em;" value="${product.prodClass }" readonly/>
									</div>
								</div>	
								<div class="form-group row">
									<label for="prodSize" class="col-sm-3" style="font-size:0.9em;">
										<span style="color:red;font-weight:bold;"></span>Size</label>
									<div class="col-sm-9 input-group-sm">								
										<input class="form-control" name="prodSize" type="text" class="form-control" id="prodSize"
												value="${product.prodSize }" readonly />
									</div>
								</div>					
								<div class="form-group row">
									<label for=prodDesc class="col-sm-3" style="font-size:0.9em;">상품설명</label>
									<div class="col-sm-9 input-group-sm">
										<textarea name="prodDesc" class="form-control" id="prodDesc" rows="4" style="resize: none;"
												 readonly>${product.prodDesc }</textarea>
									</div>
								</div>
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
				<div class="card-footer" >
		          		<div class="row">
			          		
			          		
			          		<div class="col-sm-3 text-center">
			          			<button type="button" onclick="location.href='modifyForm.do?id=${member.id}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
			          		</div>
		          		
			          		<div class="col-sm-3 text-center">
			          			<button type="button" onclick="location.href='remove.do?id=${member.id}';" 
			          			id="deleteBtn" class="btn btn-danger" >삭 제</button>
			          		</div>
		          			<c:if test="${member.enabled ne 0 }">
			          		<div class="col-sm-3 text-center">
			          			<button type="button" onclick="location.href='stop.do?id=${member.id}';" 
			          			id="stopBtn" class="btn btn-info" >정 지</button>
			          		</div>
			          		</c:if>
			          	
			          		<div class="col-sm-3 text-center">
			            		<button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">닫 기</button>
			            	</div>
		          	    </div>  	
		          </div>
			</div>
		</div>
	</section>		<!-- /.content -->
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<script>
window.onload=function(){
	MemberPictureThumb(document.querySelector('[data-id="${product.prodId}"]'),'${product.prodImg}');
}
</script>  
  
</body>










