<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>

<html>

<head>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> 
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/sketchy/bootstrap.min.css" rel="stylesheet"> 

    <style> 
        
        fieldset{width: 600px; margin: auto; padding: 40px; border: 1px solid #ccc; border-radius: 8px; box-shadow: inset 0 1px 1px rgba(0,0,0,.075)} 
        legend{width: auto; border-bottom: 0; margin: 0; font-weight: 700; font-size: 18px;} 
        .form-group:nth-child(1) label{display: block;} 
        .form-group:nth-child(1) input[type=text]{width: 80%; display: inline-block} 

        .form-group:nth-child(3) label{display: block;} 
        .form-group:nth-child(3) input{display: inline-block;  width: 48%} 
        .form-group:nth-child(3) input:first-of-type{margin-right: 3%;} 

        .form-group:nth-child(4) label{display: block;} 
        .form-group:nth-child(4) input{float: left; width: 30%; margin-right: 3%;} 
        .form-group:nth-child(4) select{width: 24%; height: 34px; border-radius:4px;} 
   
        .form-group:nth-child(5) > label{display: block;} 
        .form-group:nth-child(5) .radio_wrap{padding: 6px 4px 3px 4px; text-align: center; border-radius:6px; border: 1px solid #ccc;} 
        .form-group:nth-child(5) .radio_wrap input{margin-right: 4%;} 

        .form-group:nth-child(6) > label:first-of-type{display: block;} 
        .form-group:nth-child(6) .checkbox_wrap {padding: 6px 4px 3px 4px; text-align: center; border-radius:6px; border: 1px solid #ccc; } 
        .form-group:nth-child(6) .checkbox_wrap input{margin-right: 3%;} 

        .form-group:nth-child(7) label{display: block;} 
        .form-group:nth-child(7) input{display: inline-block;  width: 35%} 
        .form-group:nth-child(7) input:first-of-type{margin-right: 3%;} 
        .form-group:nth-child(7) input[type=button]{width: 24%;} 

        .form-group:nth-child(9) textarea {width: 100%; resize: none; border: 1px solid #ccc; border-radius: 8px; box-shadow: inset 0 1px 1px rgba(0,0,0,.075)} 
    </style> 


<meta charset="UTF-8">
<title>[ 회 원 가 입 ]</title>
</head>
<body>

<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">


//jquery
$(function() {

    $("input[id=password]").keyup(function(e){
       var data = $(this).val();

       if(data.length < 5 || data.length > 10) {
          $("#password").css("color", "red");
       } else {
          $("#password").css("color", "green");
          $("#password").text("사용할 수 있는 비밀번호입니다.");
       }

       if(e.keyCode == 13)   formCheck();
       
    });

    $("input[type=button]").click(formCheck);
    
 });

//javascript
function formCheck(){

   var email = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

   var nickname = document.getElementById("nickname").value;
   var password = document.getElementById("password").value;
   var password2 = document.getElementById("password2").value;
   var birth = document.getElementById("birth").value;
   var tag = document.getElementsByName("tag");
   var count = 0;

   if(email.test($('input[name=email]').val()) === false) {
		alert("잘못된 이메일 형식입니다.");
	        return false;
	}

	if(nickname=='') {
		alert("닉네임을 입력해 주세요.")
		return false;
		}
	if(password.length < 5 || password.length > 10) {
		alert("비밀번호는 5~10글자로 입력해 주세요.")
		return false;
		}
	if(password != password2) {
		alert("동일한 비밀번호를 입력해 주세요.")
		return false;
		}
	if(birth=='') {
		alert("생일을 입력해 주세요.")
		return false;
		}

	for(var i=0; i<tag.length; i++) {
		if(tag[i].checked==true){
			count++;
			}
	}
	if(count<5) {
	alert("태그를 5개 이상 선택해주세요")
	return false;
	} 
	
   return true;
   }

      

</script>


<div align="center">
<div class="card border-primary mb-3" style="max-width: 50rem;" align="center" >
  <div class="card-header">Join</div>
  <div class="card-body">

    <p class="card-text">
<form action = "/member/join" method="post" onsubmit="return formCheck();">

E-mail
 <div class="form-group"> 
<input type="text" class="form-control" name = email id = email>
<input type="button"class="btn btn-warning" value="OK">
</div>
NICKNAME<input type="text" class="form-control" name = nickname id = nickname><br>
PW<input type="password" class="form-control" name = password id=password><br>
PW-Check<input type="password" class="form-control" name = password2 id =password2><br>
BIRTH<input type="text" class="form-control" name = birth id= birth size="8" placeholder="YYYYMMDD"><br>
<div class="button" align="center">
Gender <br> 
<i style='font-size:24px' class='fas'>🙎🏻‍♀️‍️</i><input type="radio"id="gender" name="gender" value="남성" checked="checked">
<i style='font-size:24px' class='fas'>🙍🏻‍♂️</i><input type="radio" id="gender" name="gender" value="여성"><br><br>	
TAG<br>
<i style='font-size:24px' class='fas'>🍱‍️</i><input type="checkbox" id="tag" name="tag" value="맛집">
<i style='font-size:24px' class='fas'>🍺‍</i><input type="checkbox" id="tag" name="tag" value="술집">
<i style='font-size:24px' class='fas'>☕</i><input type="checkbox" id="tag" name="tag" value="카페">
<i style='font-size:24px' class='fas'>⛰</i><input type="checkbox" id="tag" name="tag" value="등산">
<i style='font-size:24px' class='fas'>🏕</i><input type="checkbox" id="tag" name="tag" value="캠핑">
<br>
<br>


<input type="submit" class="btn btn-success" value="SIGNUP"><br>
</div>
</form>

  </div>
  </div>
  </div>
</body>
</html>