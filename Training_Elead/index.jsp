<%@ page language="java" import="java.lang.*" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>


<%
  String error = request.getParameter("error");
  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <body>
 	<h1>ÈýÃ«¿´²¡</h1>
  	<form name="kanbing" action="/sanmaokanbing/Yandaifu" method="get" onsubmit="return validate();"/>
  		UserName:<input id="userName" name="userName"/><br>
  		Money:<input id="money" name="money"/><br>
		Gender:<input type="radio" name="sex" value="1" checked>ÄÐ</input>
                <input type="radio" name="sex" value="2">Å®</input>
               <input type="radio" name="sex" value="3">Female-Man</input><br>
        City: <select name="city" id= "city">
			    <option value="0" selected></option>
				<option value="1">Î÷°²</option>
				<option value="2">ÁÙ·Ú</option>
				<option value="3">ÏÌÑô</option>
				<option value="4">±¦¼¦</option>
				<option value="5">ÑÓ°²</option>				
			  </select><br>
  		<input type="submit" value="submit">
  	</form>
  <input type="button" value="Ìá½» " onclick="validateform()"/>
  <input type="hidden" value="<%=error %>" id="errorId"/>
  
  </body>
  
  
  <script type="text/javascript">
  function validate(){
	if(confirm("È·¶¨±íµ¥Ìá½»Âð£¿")){
     var username=document.getElementById("userName").value;
	 var money=document.getElementById("money").value;
 	if(username.length==0){
 		alert("ÇëÊäÈëÐÕÃû");
 		return false;
 	}
 	
 	if(money.length==0){
      alert("ÇëÊäÈë½ð¶î");
      return false;
    }
    
    
    var cityObj = document.getElementById("city");
    var selectIndex = cityObj.selectedIndex;//»ñµÃÊÇµÚ¼¸¸ö±»Ñ¡ÖÐÁË
    var cityText = cityObj.options[selectIndex].text //»ñµÃ±»Ñ¡ÖÐµÄÏîÄ¿µÄÎÄ±¾
    if(cityText.length == 0){
      alert("ÇëÑ¡Ôñ³ÇÊÐ");
      return false;
    }
    
    return true;
  }else {
     return false;
    }
  }
  
  var error = document.getElementById("errorId").value;
  if(error != null && error != "null" && error.length != 0){
     alert(error);
  }
  </script>
</html>