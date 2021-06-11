<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head></head>

<title>주문변경</title>

<body>
<form action="modify.do" method="post" id="modifyForm">
	<h3>주문변경</h3>
	<section class="content">
		<div class="row">
			<div class="col-sm-12">
				<div class="card">
					<div class="card-header"></div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-body">
										변경선택
										<select id="orderChooseSelect" name="orderChooseSelect">
											<option name="orderChooseOption" value="r">환불신청</option>
											<option name="orderChooseOption" value="e">교환신청</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-header">
									<h3>사유작성란</h3>
									</div>
									<div class="card-body">
											<textarea cols="50" rows="10" placeholder="내용을 입력해주세요"></textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-header">
										<h3>환불계좌</h3>
									</div>
									<div class="card-body">
										<select>
											<option selected="selected">은행선택</option>
											<option>농협</option>
											<option>하나은행</option>
											<option>제일은행</option>
											<option>제주은행</option>
											<option>등등</option>
										</select> 
										계좌번호 : <input type="text" size="20"><br><br>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-header">
										<h3>답변수신방법<h3> 
									</div>
									<div class="card-body">
										이메일주소 : <input type="text" size="20"><br><br>
										휴대전화 : <input type="text" size="20">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="card">
									<div class="card-body">
										<button type="submit">확인</button>
										<button type="button" onclick="CloseWindow();">취소</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<input type="hidden" name="orderDetailNo" value="${orderDetailNo }">
</form>
</body>



