<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width = device-width">
<link rel="stylesheet" href="main.css?ver=4">

</head>

<body>

	<header>
		<nav>
			<div id="headTitle">나의 해야할 일들</div>
			<div id="registerBtn">
			   <a href="./TodoForm"> 새로운 TODO 등록</a>
			</div>
		</nav>
	</header>

	<div class="SECTIONS">
		<section id="doneSection">
			<div class="CardHead">DONE</div>

			<c:forEach var="item" items="${list}">
				<c:if test="${item.type == 'DONE'}">
					<article id="${item.id}" class="${item.type}">
						<div class="title">${item.title}</div>
						<div class="sub">등록날짜: ${item.regdate}, ${item.name}, 우선순위  ${item.sequence}</div>
					</article>
				</c:if>
			</c:forEach>
			
		</section>

		<section id="doingSection">
			<div class="CardHead">DOING</div>
			
			<c:forEach var="item" items="${list}">
				<c:if test="${item.type == 'DOING'}">
					<article id="${item.id}" class="${item.type}">
						<div class=title>${item.title}</div>
						<div class="sub">
							등록날짜: ${item.regdate}, ${item.name}, 우선순위 ${item.sequence}
							<button class="stateBtn">&#8594</button>
						</div>
					</article>
				</c:if>
			</c:forEach>
			
		</section>

		<section id="todoSection">
		
			<div class="CardHead">TODO</div>
			
			<c:forEach var="item" items="${list}">
				<c:if test="${item.type == 'TODO'}">
					<article id="${item.id}" class="${item.type}">
						<div class="title">${item.title}</div>
						<div class="sub">
							등록날짜: ${item.regdate}, ${item.name}, 우선순위 ${item.sequence}
							<button class="stateBtn">&#8594</button>
						</div>
					</article>
				</c:if>
			</c:forEach>

		</section>
	</div>

	<script src="click.js?ver=16"> </script>

</body>

</html>