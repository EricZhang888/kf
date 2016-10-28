<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="cn">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>1号房 - 登录</title>
<meta name="keywords" content="1号房">
<meta name="description" content="1号房">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<link rel="shortcut icon" href="favicon.ico">
<link href="./resource/cssfolder/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="./resource/cssfolder/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

<link href="./resource/cssfolder/animate.min.css" rel="stylesheet">
<link href="./resource/cssfolder/style.min.css?v=4.1.0" rel="stylesheet">
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
</head>

<body class="gray-bg">
	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div class="middle-box">
				<img alt="logo" src="./resource/imgs/logo.png">
			</div>
			<h3>欢迎使用 1号房</h3>
			<form class="m-t" role="form" action="index">
				<div class="form-group">
					<input type="email" class="form-control" placeholder="用户名" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码" required>
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登录</button>
				<!-- <p class="text-muted text-center">
					<a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
				</p>
				 -->
			</form>
		</div>
	</div>
	<!-- 全局js -->
	<script src="./resource/javascript/jquery.min.js?v=2.1.4"></script>
	<script src="./resource/javascript/bootstrap.min.js?v=3.3.6"></script>

</body>
</html>