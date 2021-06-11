var formData ="";


function picture_go(){
   formData = new FormData($('form[role="imageForm"]')[0]);
   //alert("file choice");
   
   var form = $('form[role="imageForm"]');
   var picture = form.find('[name=pictureFile]')[0];
   
   //업로드 확인변수 초기화
   form.find('[name="checkUpload"]').val(0);
   var fileFormat=
      picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
      
   //이미지 확장자 jpg 확인
   if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
      alert("이미지는 jpg/jpeg 형식만 가능합니다.");
      picture.value="";      
      return;
   } 
   
   //이미지 파일 용량 체크
   if(picture.files[0].size>1024*1024*1){
      alert("사진 용량은 1MB 이하만 가능합니다.");
      return;
   };
   
   document.getElementById('inputFileName').value=picture.files[0].name;
   

   if (picture.files && picture.files[0]) {
      var reader = new FileReader();
       reader.onload = function (e) {
           $('div#pictureView')
              .css({'background-image':'url('+e.target.result+')',
                 'background-position':'center',
                 'background-size':'cover',
                 'background-repeat':'no-repeat'
                 });
        }
      reader.readAsDataURL(picture.files[0]);
      
   }
} 

function upload_go(){
   //alert("upload btn click");
   if($('input[name="pictureFile"]').val()==""){
      alert("사진을 선택하세요.");
      $('input[name="pictureFile"]').click();
      return;
   };   
   
   
   if($('input[name="checkUpload"]').val()==1){
      alert("이미업로드 된 사진입니다.");
      return;
      
   }
   
   
   $.ajax({
      url:"/prod/picture.do",
      data:formData,
      type:'post',
      processData:false,
      contentType:false,
      success:function(data){
         //업로드 확인변수 세팅
         $('input[name="checkUpload"]').val(1);
         
         //저장된 파일명 저장.
         $('input#oldFile').val(data); // 변경시 삭제될 파일명
         $('form[role="form"]  input[name="prodImg"]').val(data);
         
         alert("사진이 업로드 되었습니다.");
         
         
      },
      error:function(error){
         alert("현재 사진 업로드가 불가합니다.\n 관리자에게 연락바랍니다.");
      }
   });
}


//사용자 등록


function regist_go(){
   var uploadCheck = $('input[name="prodImg"]').val();
   if(!uploadCheck){
      alert("사진업로드는 필수 입니다");
      return;
   }
   
   if($('input[name="prodName"]').val() == ""){
      alert("상품명은 필수입니다.");
      $('input[name="prodName"]').focus();
       return;
   }
   
   
   if($('input[name="prodCost"]').val()==""){
      alert("상품가격은 필수입니다.");
      $('input[name="prodCost"]').focus();
      return;
   }
   
   if($('input[name="prodSize"]').val()==""){
      alert("상품사이즈는 필수입니다.");
      $('input[name="prodSize"]').focus();
      return;
   }
   
   if($('input[name="prodDesc"]').val()==""){
	      alert("상품설명은 필수입니다.");
	      $('input[name="prodDesc"]').focus();
	      return;
	   }
   
   var form = $('form[role="form"]');
   form.submit();
}

















