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
 	<h1>三毛看病</h1>
  	<form name="kanbing" action="/sanmaokanbing/Yandaifu" method="get" onsubmit="return validate();"/>
  		UserName:<input id="userName" name="userName"/><br>
  		Money:<input id="money" name="money"/><br>
		Gender:<input type="radio" name="sex" value="1" checked>男</input>
                <input type="radio" name="sex" value="2">女</input>
               <input type="radio" name="sex" value="3">Female-Man</input><br>
        City: <select name="city" id= "city">
			    <option value="0" selected></option>
				<option value="1">西安</option>
				<option value="2">临汾</option>
				<option value="3">咸阳</option>
				<option value="4">宝鸡</option>
				<option value="5">延安</option>				
			  </select><br>
  		<input type="submit" value="submit">
  	</form>
  <input type="button" value="提交 " onclick="validateform()"/>
  <input type="hidden" value="<%=error %>" id="errorId"/>
  
  </body>
  
  
  <script type="text/javascript">
  function validate(){
	if(confirm("确定表单提交吗？")){
     var username=document.getElementById("userName").value;
	 var money=document.getElementById("money").value;
 	if(username.length==0){
 		alert("请输入姓名");
 		return false;
 	}
 	
 	if(money.length==0){
      alert("请输入金额");
      return false;
    }
    
    
    var cityObj = document.getElementById("city");
    var selectIndex = cityObj.selectedIndex;//获得是第几个被选中了
    var cityText = cityObj.options[selectIndex].text //获得被选中的项目的文本
    if(cityText.length == 0){
      alert("请选择城市");
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