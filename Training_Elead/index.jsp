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
 	<h1>��ë����</h1>
  	<form name="kanbing" action="/sanmaokanbing/Yandaifu" method="get" onsubmit="return validate();"/>
  		UserName:<input id="userName" name="userName"/><br>
  		Money:<input id="money" name="money"/><br>
		Gender:<input type="radio" name="sex" value="1" checked>��</input>
                <input type="radio" name="sex" value="2">Ů</input>
               <input type="radio" name="sex" value="3">Female-Man</input><br>
        City: <select name="city" id= "city">
			    <option value="0" selected></option>
				<option value="1">����</option>
				<option value="2">�ٷ�</option>
				<option value="3">����</option>
				<option value="4">����</option>
				<option value="5">�Ӱ�</option>				
			  </select><br>
  		<input type="submit" value="submit">
  	</form>
  <input type="button" value="�ύ " onclick="validateform()"/>
  <input type="hidden" value="<%=error %>" id="errorId"/>
  
  </body>
  
  
  <script type="text/javascript">
  function validate(){
	if(confirm("ȷ�����ύ��")){
     var username=document.getElementById("userName").value;
	 var money=document.getElementById("money").value;
 	if(username.length==0){
 		alert("����������");
 		return false;
 	}
 	
 	if(money.length==0){
      alert("��������");
      return false;
    }
    
    
    var cityObj = document.getElementById("city");
    var selectIndex = cityObj.selectedIndex;//����ǵڼ�����ѡ����
    var cityText = cityObj.options[selectIndex].text //��ñ�ѡ�е���Ŀ���ı�
    if(cityText.length == 0){
      alert("��ѡ�����");
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