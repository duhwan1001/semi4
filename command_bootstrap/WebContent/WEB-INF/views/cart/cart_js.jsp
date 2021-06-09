<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
function qtyMinus(targetObj, cartNo){
	qtyValue = $(targetObj).next()[0].childNodes[1].innerHTML;
	$(targetObj).next()[0].childNodes[1].innerHTML = qtyValue - 1;
	
	$.ajax({
        url : "/cart/cartQtyMinus.do?cartNo="+cartNo,
        method : "post",
        success : function(result){
        
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
        
        },
        error:function(error){
           alert("시스템장애로 수정 불가합니다.");
        }
     });
}
</script>