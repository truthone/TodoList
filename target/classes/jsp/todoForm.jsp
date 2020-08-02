<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta name="viewport" content="width = device-width">
<link rel="stylesheet" type="text/css" href="todoForm.css?ver=4">
</head>

<body>
	<header>
		<div class="todoFormTitle">할일 등록</div>
	</header>

	<form action="./TodoAdd" method="POST">
		<div class="wrap">
			어떤일인가요? <br> <input id="title" type="text" name="title"
				maxlength="24" placeholder="swift 공부하기(24자까지)" required><br>
		</div>
		<div class="wrap">
			누가 할일인가요?<br> <input id="name" type="text" name="name"
				placeholder="홍길동" required><br>
		</div>
		<div class="wrap">
			우선순위를 선택하세요<br>
			<div class="seq">
				<input type="radio" name="sequence" value="1" required>1순위
			</div>
			<div class="seq">
				<input type="radio" name="sequence" value="2" required>2순위
			</div>
			<div class="seq">
				<input type="radio" name="sequence" value="3" required>3순위
			</div>
		</div>

		<nav>
			<div class="preBtn">
				<a href="./main"> 이전</a>
			</div>
			<input class="blueBtn" type="submit" value="제출"> <input
				class="blueBtn" type="reset" value="내용지우기">
		</nav>

	</form>

</body>

</html>