<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="inputAction.jsp" method="post" target="zeroframe">
		<ul>
			<li>
				<label>도서이름 </label>
				<input type='text' name ='bookName'>
			</li>
			<li>
				<label>출판사 </label>
				<input type='text' name ='publisher'>
			</li>
			<li>
				<label>설명 </label>
				<input type='text' name ='bookDesc'>
			</li>
			<li>
				<input type='reset' name ='재작성'>
				<input type='submit' name ='등록'>
			</li>
			<li>AAA</li>
		</ul>
	</form>
	<iframe name = "zeroframe" ></iframe>
	<script>
	function showMsg(msg){
		alert("INPUT PAGE "+msg);
	}
	</script>
</body>
</html>