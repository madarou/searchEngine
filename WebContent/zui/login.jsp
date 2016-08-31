<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
<!-- zui -->
<link href="/searchEngine/zui/css/zui.min.css" rel="stylesheet">
<link href="/searchEngine/zui/css/doc.min.css" rel="stylesheet">

<style>
#pageContent .media {
	max-width: 100%;
	text-align: center;
	vertical-align: middle;
	color: #aaa;
	background-color: #eee;
	border: 1px solid #ddd;
	font-size: 20px;
}
</style>
<style>
			* {
				margin: 0;
				padding: 0;
				font-family: "微软雅黑";
			}
			
			body {
				background: #F7F7F7;
			}
			
			.form {
				position: absolute;
				top: 50%;
				left: 54%;
				margin-left: -185px;
				margin-top: -210px;
				height: 420px;
				width: 340px;
				font-size: 18px;
				-webkit-box-shadow: 0px 0px 10px #A6A6A6;
				background: #fff;
			}
			
			.border-btn {
				border-bottom: 1px solid #ccc;
			}
			
			#landing,
			#registered {
				float: left;
				text-align: center;
				width: 170px;
				padding: 15px 0;
				color: #545454;
			}
			
			#landing-content {
				clear: both;
			}
			
			.inp {
				height: 30px;
				margin: 0 auto;
				margin-bottom: 30px;
				width: 200px;
			}
			
			.inp>input {
				text-align: center;
				height: 30px;
				width: 200px;
				margin: 0 auto;
				transition: all 0.3s ease-in-out;
			}
			
			.login {
				border: 1px solid #A6A6A6;
				color: #a6a6a6;
				height: 30px;
				width: 202px;
				text-align: center;
				font-size: 13.333333px;
				margin-left: 70px;
				line-height: 30px;
				margin-top: 30px;
				transition: all 0.3s ease-in-out;
			}
			
			.login:hover {
				background: #A6A6A6;
				color: #fff;
			}
			
			#bottom {
				margin-top: 10px;
				font-size: 13.333333px;
				color: #a6a6a6;
				text-align:center;
			}
			
			#registeredtxt {
				float: left;
				margin-left: 80px;
			}
			
			#forgotpassword {
				float: right;
				margin-right: 80px;
			}
			
			#photo {
				border-radius: 80px;
				border: 1px solid #ccc;
				height: 80px;
				width: 80px;
				margin: 0 auto;
				overflow: hidden;
				clear: both;
				margin-top: 30px;
				margin-bottom: 30px;
			}
			
			#photo>img:hover {
				-webkit-transform: rotateZ(360deg);
				-moz-transform: rotateZ(360deg);
				-o-transform: rotateZ(360deg);
				-ms-transform: rotateZ(360deg);
				transform: rotateZ(360deg);
			}
			
			#photo>img {
				height: 80px;
				width: 80px;
				-webkit-background-size: 220px 220px;
				border-radius: 60px;
				-webkit-transition: -webkit-transform 1s linear;
				-moz-transition: -moz-transform 1s linear;
				-o-transition: -o-transform 1s linear;
				-ms-transition: -ms-transform 1s linear;
			}
			
			
			#registered-content {
				margin-top: 40px;
				display: none;
			}
			
			.fix {
				clear: both;
			}
			.form{
				display: none;
			}
		</style>
</head>
<body>
	<div class="form">
			<div id="landing">登录</div>
			<div id="registered">注册</div>
			<div class="fix"></div>
			<div id="landing-content">
				<form class="form-horizontal form-condensed" role="form" action="checkLogin"
					method='post'>
					<div id="photo"><img src="/searchEngine/zui/img/photo.jpg" /></div>
					<div class="inp"><input type="text" name='username' placeholder="用户名" /></div>
					<div class="inp"><input type="password" placeholder="密码" /></div>
					<div style="text-align:center"><input type='submit' class="btn btn-info" style="padding: 8px 25px;line-height: 1.25;border-radius: 4px"
								value='登录' data-loading='稍候...' /></div>
					<div id="bottom">
						<img style="height:35px;width:35px" src="/searchEngine/zui/img/qweibo.png" />
						<img style="height:35px;width:35px" src="/searchEngine/zui/img/qqq.png" />
						<img style="height:35px;width:35px" src="/searchEngine/zui/img/qweixin.png" />
					</div>
				</form>
			</div>
			<div id="registered-content">
				<div class="inp"><input type="text" placeholder="请输入用户名" /></div>
				<div class="inp"><input type="password" placeholder="请输入密码" /></div>
				<div class="inp"><input type="password" placeholder="请再次输入密码" /></div>
				<div class="inp"><input type="text" placeholder="电子邮箱" /></div>
				<div class="login">立即注册</div>
			</div>
	</div>
	<!-- <section>
		<article>
			<div class="example">
				<form class="form-horizontal form-condensed" role="form" action="checkLogin"
					method='post'>
					<div class="form-group">
						<label class="col-md-2 control-label">用户名</label>
						<div class="col-md-10">
							<input type='text' name='username' id='username' value=''
								class='form-control' placeholder='' />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
						<div class="col-md-10">
							<input type='text' name='keywords' id='keywords' value=''
								class='form-control' />
							<div class="help-block alert alert-warning" style="text-align:center">
								<span><i class="icon icon-qq icon-2x"></i></span>&nbsp;&nbsp;&nbsp;&nbsp;
								<span><i class="icon icon-wechat icon-2x"></i></span>&nbsp;&nbsp;&nbsp;&nbsp;
								<span><i class="icon icon-weibo icon-2x"></i></span>
							</div>
						</div>
						
					</div>

					<div class="form-group">
						<div class="col-md-offset-10 col-md-2" style="text-align:center">
							<input type='button' id='register' class='btn btn-info'
								value='注册' data-loading='稍候...' /> <input type='hidden'
								name='type' id='type' value='article' />
							<input type='submit' id='submit' class='btn btn-primary'
								value='登录' data-loading='稍候...' /> <input type='hidden'
								name='type' id='type' value='article' />
						</div>
					</div>
				</form>
			</div>
		</article>
	</section>
 -->	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
			$(document).ready(function() {
				
				$(".form").slideDown(500);
				
				$("#landing").addClass("border-btn");

				$("#registered").click(function() {
					$("#landing").removeClass("border-btn");
					$("#landing-content").hide(500);
					$(this).addClass("border-btn");
					$("#registered-content").show(500);
					
				})

				$("#landing").click(function() {
					$("#registered").removeClass("border-btn");
					$(this).addClass("border-btn");
					
					$("#landing-content").show(500);
					$("#registered-content").hide(500);
				})
			});
	</script>
</body>
</html>