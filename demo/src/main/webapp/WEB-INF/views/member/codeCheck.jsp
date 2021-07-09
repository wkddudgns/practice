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
<title>Mail Confirm</title>
</head>
<body>

<div align="center">
<div class="card border-primary mb-3" style="max-width: 50rem;" align="center" >
  <div class="card-header">Mail Confirm</div>
  <div class="card-body">

    <p class="card-text"><form action = "/member/codeCheck2" method="get">
E-Mail : <input type="text" name = memberEmail id = memberEmail>
<input type="submit" class="btn btn-success" value="OK"><br>
</form>
  </div>
</div>
</div>


</body>
</html>