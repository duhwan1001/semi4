<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
function totalPrice(){
	var total = 0;
	$("input[name=price]").each(function(idx){ 
		if($(this).is(":checked") == true) {
			var qty = $(this).parent().nextAll()[3].childNodes[1].childNodes[1].childNodes[3].childNodes[1].innerHTML;
	        var price = $(this).attr('id');
	        total += parseInt(price * qty);
		}
	}); 
	$("#totalPrice").html(total);
}
function qtyMinus(targetObj, cartNo){
	qtyValue = $(targetObj).next()[0].childNodes[1].innerHTML;
	
	if(qtyValue-1 < 1) return;
	$(targetObj).next()[0].childNodes[1].innerHTML = qtyValue - 1;
	
	$.ajax({
        url : "/cart/cartQtyMinus.do?cartNo="+cartNo,
        method : "post",
        success : function(result){
        	totalPrice()
        },
        error:function(error){
           alert("시스템장애로 수정 불가합니다.");
        }
     }); 
}

function qtyPlus(targetObj, cartNo){
	qtyValue = $(targetObj).prev()[0].childNodes[1].innerHTML;
	$(targetObj).prev()[0].childNodes[1].innerHTML = parseInt(qtyValue) + 1;
	$.ajax({
        url : "/cart/cartQtyPlus.do?cartNo="+cartNo,
        method : "post",
        success : function(result){
        	totalPrice()
        },
        error:function(error){
           alert("시스템장애로 수정 불가합니다.");
        }
     });
}

function order_go(){
	var orderList = new Array();
	$("input[name=price]").each(function(idx){ 
		if($(this).is(":checked") == true) {
			prodId = $("[name=prodIdArr]")[idx];
			pId = $(prodId).attr('id');
			qty = $("[name=qtyArr]")[idx].innerHTML;
			var data = new Object();
			data.prodId = pId;
			data.prodQty = qty;
			orderList.push(data);
		}
	}); 
	var jsonData = JSON.stringify(orderList) ;
	console.log(jsonData) ;
	
	$.ajax({
		url:"/orderlog/modify.do",
		type:"post",
		data:jsonData,	
		contentType:'application/json',
		success:function(data){
		}
		else{
			
		}	
	});
}
</script>