<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<title>상품등록</title>

<body>

	<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상품등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">상품관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	등록
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
    			<a href="<%=request.getContextPath()%>/prod/registForm.do"><b>상품 등록</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist.do" method="post">	
						<div class="row">
							<div class="col-6">
								<input type="hidden" name="prodImg" />
									<div style="text-align: center;">
										<div id="pictureView" style="border: 1px solid green; height: 400px; width: 300px; margin: 0 auto;"></div>
										<div class="mailbox-attachment-info">
											<div class="input-group input-group-sm">
												<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
												<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/>
												<span class="input-group-append-sm">											
													<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											
												</span>
											</div>
										</div>
									</div>
									<br />
							</div>
							<div class="col-6">	
								<div class="form-group row">
									<label for="prodName" class="col-sm-3" style="font-size:0.9em;">
										<span style="color:red;font-weight:bold;"></span>상 품 명</label>
									<div class="col-sm-9 input-group-sm">								
										<input class="form-control" name="prodName" type="text" class="form-control" id="prodName"
												placeholder="상품명을 입력하세요" />
									</div>
								</div>		
								<div class="form-group row">
									<label for="prodCost" class="col-sm-3" style="font-size:0.9em;">
										상품 가격</label>
									<div class="col-sm-8 input-group-sm">								
										<input class="form-control" name="prodCost" type="text" class="form-control" id="prodCost"
											onkeyup="this.value=this.value.replace(/[^0-9]/g, &#39;&#39;);"
											style="color:red;font-size:2em;height: 45px;"/>
									</div>
									<strong class="col-sm-1" style="font-size:2em; color:red;">원</strong>
								</div>
								<div class="form-group row">
									<label for="prodQty" class="col-sm-3" style="font-size:0.9em;">
										상품 수량</label>
									<div class="col-sm-9 input-group-sm">								
										<input class="form-control" name="prodQty" type="text" class="form-control" id="prodQty"
											onkeyup="this.value=this.value.replace(/[^0-9]/g, &#39;&#39;);"
											style="font-size:0.9em;"/>
									</div>
								</div>
								<div class="form-group row">
									<label for="authority" class="col-sm-3" style="font-size:0.9em;" >구분1</label>
									<div class="col-sm-9">
										<select name="prodWho" class="form-control" style="font-size:0.9em;">
											<option value="남성">남성</option>
											<option value="여성">여성</option>
											<option value="KIDS">KIDS</option>
										</select>
									</div>
								</div>	
								<div class="form-group row">
									<label for="authority" class="col-sm-3" style="font-size:0.9em;" >구분2</label>
									<div class="col-sm-9">
										<select name="prodClass" class="form-control" style="font-size:0.9em;">
											<option value="상의">상의</option>
											<option value="하의">하의</option>
											<option value="신발">신발</option>
										</select>
									</div>
								</div>	
								<div class="form-group row">
									<label for="prodSize" class="col-sm-3" style="font-size:0.9em;">
										<span style="color:red;font-weight:bold;"></span>Size</label>
									<div class="col-sm-9 input-group-sm">								
										<input class="form-control" name="prodSize" type="text" class="form-control" id="prodSize"
												placeholder="사이즈를 입력하세요" />
									</div>
								</div>					
								<div class="form-group row">
									<label for=prodDesc class="col-sm-3" style="font-size:0.9em;">상품설명</label>
									<div class="col-sm-9 input-group-sm">
										<textarea name="prodDesc" class="form-control" id="prodDesc" rows="4" style="resize: none;"
												placeholder="상품설명을 적으세요"></textarea>
									</div>
								</div>
								
								
								<div class="card-footer">
									<div class="row">								
										<div class="col-sm-6">
											<button type="button" id="registBtn" onclick="regist_go();" 
												class="btn btn-info" style="width: 120px;">등록하기</button>
									 	</div>
									 	
									 	<div class="col-sm-6">
											<button type="button" id="cancelBtn" onclick="CloseWindow();"  style="width: 120px;"
												class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
										</div>
									
									</div>
								</div>
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
			</div>
		</div>
	</section>		<!-- /.content -->
</div>
<!-- /.content-wrapper -->


<form role="imageForm" action="upload/picture.do" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" onchange="picture_go();"
			style="display:none;">
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>

<script src="/resources/js/prod/regist.js" ></script>

</body>












