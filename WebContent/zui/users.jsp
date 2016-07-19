<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
<link rel="stylesheet" href="/searchEngine/zui/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="/searchEngine/zui/css/owl.carousel.min.css">
	<link rel="stylesheet" href="/searchEngine/zui/cssowl.theme.min.css">
	
	<style type="text/css">
		h1{ display: block; height: 100px; line-height: 100px; text-align: center; color: #fff;}
		.testimonial{
		    background-color: #f3f3f3;
		    border-radius: 5px;
		    padding: 10px 30px 30px 30px;
		    margin: 0 15px;
		}
		.testimonial .pic{
		    width: 90px;
		    height: 90px;
		    margin: 0 30px 15px 0;
		    float: left;
		}
		.testimonial .pic img{
		    width: 100%;
		    height: auto;
		    border-radius: 50%;
		}
		.testimonial .testimonial-title{
		    color: #000000;
		    font-size: 16px;
		    margin-top: 5px;
		    font-weight: 800;
		    text-transform: capitalize;
		}
		.testimonial .testimonial-title small{
		    display: block;
		    /* color: #dc005a; */
		   /*  color:#03b8cf; */
		   color:#fff;
		    font-size: 14px;
		    font-weight: 800;
		    margin-top: 10px;
		}
		.testimonial .testimonial-review p{
		    color: #888888;
		    font-size: 15px;
		    font-style: italic;
		    line-height: 19px;
		    margin-bottom: 0;
		}
		.owl-theme .owl-controls{
		    margin-top: 20px;
		}
		.owl-theme .owl-controls .owl-page span{
		    width: 10px;
		    height: 10px;
		    background:#fff;
		    opacity: 1;
		}
		.owl-theme .owl-controls .owl-page.active span,
		.owl-theme .owl-controls.clickable .owl-page:hover span{
		    background: #fff;
		    border: 1px solid #cdcdcd;
		}
		.owl-pagination{
		    margin-top: 40px;
		}
		.owl-theme .owl-controls .owl-page.active span, .owl-theme .owl-controls.clickable .owl-page:hover span{
		    background:#3F4144;
		    border:3px solid #fff;
		}
		@media screen and (max-width: 990px){
		    .testimonial-parallax h2{
		        margin-bottom: 40px;
		    }
		    .testimonial{
		        margin: 0;
		    }
		}
		.mt50{padding-top: 50px;}
		.test{ width: 100%; height: 50px; line-height: 50px;}
		.test a{ padding: 0px 20px;}
	</style>
</head>
<body>
	<header>
			<div class="rt-bk">
				<i class="bk"></i>
				<p><span onclick="javascript:history.back(-1);" style="pointer:cursor">返回</span><!-- <input type="button" onclick="javascript:history.back(-1);" value="返回上一页"> --></p>
			</div>
			<div class="top-name">
				<p>朋友推荐</p>
			</div>
		</header>
	<section>
								<!-- <div class="testimonial">
		                            <div class="pic">
		                                <img src="/searchEngine/zui/img/1.jpg" alt=""/>
		                            </div>

		                            <div class="testimonial-review">
		                                <h4 class="testimonial-title">
		                                    Williamson
		                                    <small>Web Developer</small>
		                                </h4>
		                                <p>
		                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent a pharetra lectus. Etiam sed metus vitae felis placerat congue.
		                                </p>
		                            </div>
		                        </div> -->
		                       <c:forEach items="${users}" var="user" varStatus="s">
								<div class="testimonial">
		                            <div class="pic">
		                                <img src="${user.avatar}" alt=""/>
		                                <br>
		                            </div>
		                            <div class="testimonial-review">
		                                <h4 class="testimonial-title">
		                                   ${user.name}<br><br>
		                                   <%-- <small>
		                                     <c:forEach items="${user.tags}" var="tag" varStatus="st">
												${tag.names}
											</c:forEach>
										   </small> --%>
										   <c:forEach items="${user.tags}" var="tag" varStatus="st">
												<span class="label" style="background-color: #03b8cf">${tag.names}</span>
											</c:forEach>
		                                </h4>
		                                <p>${user.description}</p>
		                            </div>
		                        </div>
		                      	<br>
							</c:forEach>
		<article>
			<div contenteditable="false" spellcheck="false" class="example">
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
							<i class="icon-list-ul icon-border-circle"></i>用户列表
							&nbsp;<small>26 users</small>
						</h3>
					</header> -->
					<section class="cards">
						<div>
							<%-- <c:forEach items="${users}" var="user" varStatus="s">
								<div class="card">
									<div style="float: left">
										<img src="${user.avatar}" alt="" width="85px" height="85px" class="img-circle"><span><a href="/searchEngine/users/profile?username=${user.name}"><strong>${user.name}</strong></a></span>
									</div>
									<div class="card-heading">
										<span class="pull-right"><a href="###"><i
												class="icon-heart-empty"></i>${user.followers_count}</a>&nbsp;<a href="###"><i
												class="icon-comment"></i>${user.comments_count}</a></span> <br>
										<div class="card-content text-muted">
											<c:forEach items="${user.tags}" var="tag" varStatus="st">
												<span class="label">${tag.names}</span>
												<c:if test="${st.count%5==0}">
													<br>
												</c:if>
											</c:forEach>
											<c:if test="${fn:length(user.tags)<5}">
												<br><br>
											</c:if>
											<c:if test="${fn:length(user.tags)==5}">
												<br>
											</c:if>
										</div>
									</div>
									<div class="card-actions" style="text-align: right">
										<button class="btn btn-success btn-sm">
											<i class="icon-comments-alt"></i>邀请
										</button>
										<button class="btn btn-danger btn-sm">
											<i class="icon-smile"></i>关注
										</button>
									</div>
	
								</div>
							</c:forEach> --%>
						</div>
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
	<script src="/jsp/zui/js/zui.min.js"></script>
	<script src="/jsp/zui/js/doc.min.js"></script>
</body>
</html>