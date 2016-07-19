<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" type="text/css"
	href="/searchEngine/zui/css/profile.css">
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
</head>
<body>
	<div id="_centent">
		<header>
			<div class="rt-bk">
				<i class="bk"></i>
				<p><span onclick="javascript:history.back(-1);" style="pointer:cursor">返回</span><!-- <input type="button" onclick="javascript:history.back(-1);" value="返回上一页"> --></p>
			</div>
			<div class="top-name">
				<p>个人中心</p>
			</div>
		</header>

		<div class="head">
			<div class="head-img">
				<img class="img-circle" src="${user.avatar}">
			</div>
			<div class="head-dsb">
				<p class="dsb-name" style="color:black"><strong>${user.name}</strong></p>
				<p class="dsb-id">
					<c:forEach items="${user.tags}" var="tag" varStatus="s">
									<span class="label">${tag.names}</span>
					</c:forEach>
				</p>
				<p class="dsb-id" style="color:black">Rio:${user.description}</p>
			</div>
		</div>

		<div class="nav">
			<ul>
				<li><i class="idt"></i>
					<p>话题&nbsp;${user.comments_count}</p></li>
				<li class="pt-line"><i class="clt"></i>
					<p>关注&nbsp;${user.followers_count}</p></li>
				<li><i class="rcm"></i>
					<p>粉丝&nbsp;${user.followers_count}</p></li>
			</ul>
		</div>

		<section class="mt-1">
			<div class="ps-lt">
				<div class="lt-dsb">
					<p>修改个人资料</p>
					<i class="arr-right"></i>
				</div>
				<div class="lt-dsb cl-bb">
					<p>修改密码</p>
					<i class="arr-right"></i>
				</div>
			</div>
		</section>

		<section class="mt-2">
			<div class="ps-lt">
				<div class="lt-dsb cl-bb">
					<p>声音推送通知</p>
					<i class="check-on"></i>
				</div>
			</div>
		</section>

		<section class="mt-3">
			<div class="ps-lt">
				<div class="lt-dsb">
					<p>猜你喜欢</p>
					<i class="arr-right"></i>
				</div>
			</div>
			<div class="ps-lt">
				<div class="lt-dsb">
					<p>附近热门</p>
					<i class="arr-right"></i>
				</div>
			</div>
			<div class="ps-lt">
				<div class="lt-dsb cl-bb">
					<p>设置</p>
					<i class="arr-right"></i>
				</div>
			</div>
		</section>

		<div class="jg"></div>
	</div>
	<footer>
		<div class="mune">
			<a href="/searchEngine/index/index"><img src="/searchEngine/zui/img/1.png"></a>
			<p>找话题</p>
		</div>
		<div class="mune">
			<a href="/searchEngine/publish/publish"><img src="/searchEngine/zui/img/2.png"></a>
			<p>发话题</p>
		</div>
		<div class="mune">
			<a href="/searchEngine/users/users"><img src="/searchEngine/zui/img/3.png"></a>
			<p>找朋友</p>
		</div>
		<div class="mune">
			<a href="/searchEngine/users/me"><img src="/searchEngine/zui/img/4.png"></a>
			<p>个人中心</p>
		</div>
	</footer>

	<script>
		(function(doc, win) {
			var docEl = doc.documentElement, resizeEvt = 'orientationchange' in window ? 'orientationchange'
					: 'resize', recalc = function() {
				var clientWidth = docEl.clientWidth;
				if (!clientWidth)
					return;
				docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
			};

			if (!doc.addEventListener)
				return;
			win.addEventListener(resizeEvt, recalc, false);
			doc.addEventListener('DOMContentLoaded', recalc, false);
		})(document, window);
	</script>
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$('.check-on').click(function() {
			$(this).toggleClass('check-off');
		})
	</script>
</body>
</html>