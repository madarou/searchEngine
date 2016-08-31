<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- <link rel="stylesheet" type="text/css"
	href="/searchEngine/zui/css/profile.css"> -->
<style>
#pageContent .media
{
  max-width: 100%;
  text-align: center;
  vertical-align: middle;
  color: #aaa;
  background-color: #eee;
  border:1px solid #ddd;
  font-size: 20px;
}
footer{ position:fixed;bottom:0px;left:0px; margin-top:0.2rem; width:7.5rem; height:0.99rem; background:url(/searchEngine/zui/img/projection.png) repeat-x; padding-top:0.2rem; font-size:0.24rem;}
.mune{ float:left; margin-left:0.54rem; width:1.2rem; height:0.7rem; text-align:center;}
.mune p{ font-size:0.22rem; color:#656565;}
.mune img{ width:0.5rem; height:0.5rem;}

header{ position:relative; width: 7.5rem; height: 0.84rem;  border-bottom:1px solid #d4d4d8; background-color: #fff;}
.rt-bk{ position:absolute; top:0.27rem; left:0.15rem; float:left;}
.rt-bk p{ float:left; font-size:0.24rem;}
.bk{display: block; margin:0.045rem 0.25rem 0 0; float:left; width: 0.15rem; height: 0.24rem; background: url(/searchEngine/zui/img/rt-bk.png) no-repeat; background-size: 0.15rem 0.24rem;}
.top-name{ text-align:center; font-size:0.34rem; line-height:0.84rem;}
</style>
</head>
<body>
		<header>
			<div class="rt-bk">
				<i class="bk"></i>
				<p><span onclick="javascript:history.back(-1);" style="pointer:cursor">返回</span><!-- <input type="button" onclick="javascript:history.back(-1);" value="返回上一页"> --></p>
			</div>
			<div class="top-name">
				<p>话题推荐</p>
			</div>
		</header>
<c:if test="${requestScope.topics!=null}">${test}</c:if>
	<c:forEach var="topic" items="${requestScope.topics}" varStatus="status">
		${topic.title }
	</c:forEach>
	<section>
		<article>
			<div class="example">
				<br>
				<ul class="breadcrumb breadcrumb-block">
					<li><i class="icon-location-arrow icon-muted"></i></li>
					<li class="active">推荐</li>
					<li><a href="#">人气</a></li>
					<li><a href="#">最新</a></li>
					<li class="pull-right"><a href="/searchEngine/users/me"><i class="icon icon-user"></i></a></li>
				</ul>
				<div class="list">
					<!-- <header>
						<h3>
							<i class="icon-list-ul icon-border-circle"></i>话题列表
							&nbsp;<small>26 topics</small><a href="/searchEngine/publish/publish"><i class="icon icon-edit pull-right"></i></a>
						</h3>
						
					</header> -->
					<section class="items items-hover">
						<c:forEach items="${topics}" var="topic" varStatus="s">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right">
										<a href="###"><i class="icon-heart-empty"></i></a>
									</div>
									<h4>
										<a href="/searchEngine/users/profile?username=${topic.user}">${topic.user}</a>
									</h4>
								</div>
								<div class="item-content">
									<!-- <div class="media pull-left">
										<div class="media-place-holder"
											style="width: 100px; height: 100px; line-height: 100px">100x100</div>
									</div> -->
									<div class="text"><a href="/searchEngine/join/join?topic=${topic.content}">${topic.content}</a></div>
								</div>
								<div class="item-footer">
									<c:forEach items="${topic.tags}" var="tag" varStatus="s">
										<span class="label">${tag}</span>
									</c:forEach>
									 &nbsp; <a href="#"
										class="text-muted"><i class="icon-comments"></i>${topic.joinNumber}</a><br>
									<span class="text-muted">${topic.pubTime}</span>
								</div>
							</div>
						</c:forEach>
						
					</section>
				</div>
			</div>
		</article>
	</section>
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
	<!-- ZUI Javascript组件 -->
	<!-- <script src="/jsp/zui/js/zui.min.js"></script> -->
	<!-- <script src="/jsp/zui/js/doc.min.js"></script> -->
</body>
</html>