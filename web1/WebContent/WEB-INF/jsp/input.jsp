<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>INPUT JSP PAGE</h1>
	
	<h4>${watch[0]}</h4>
	<h4>${name} Ver 1.9</h4>

	<h1>	
			<form Action='inputResult.jsp' Method='post'>
			<input type='text' name='v1'>
			<select name='oper'>
				<option value='plus'>+</option>
				<option value='minus'>-</option>
				<option value='mul' >*</option>
				<option value='div' >/</option>
			</select>
			<input type="text" name='v2'>
			<input type='submit' value='계산'><input type='reset'>
			</form>
			
			<iframe name = "secondframe" width = 500 height = 500 src='/hello/result' >
			</iframe>
	</h1>	
	
</body>
</html>