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
footer{ position:fixed;bottom:0px;left:0px; margin-top:0.2rem; width:7.5rem; height:0.99rem; background:url(/searchEngine/zui/img/projection.png) repeat-x; padding-top:0.2rem; font-size:0.24rem;}
.mune{ float:left; margin-left:0.54rem; width:1.2rem; height:0.7rem; text-align:center;}
.mune p{ font-size:0.22rem; color:#656565;}
.mune img{ width:0.5rem; height:0.5rem;}

header{ position:relative; width: 7.5rem; height: 0.84rem;  border-bottom:1px solid #d4d4d8; background-color: #fff;}
.rt-bk{ position:absolute; top:0.27rem; left:0.15rem; float:left;}
.rt-bk p{ float:left; font-size:0.24rem;}
.bk{display: block; margin:0.045rem 0.25rem 0 0; float:left; width: 0.15rem; height: 0.24rem; background: url(/searchEngine/zui/img/rt-bk.png) no-repeat; background-size: 0.15rem 0.24rem;}
.top-name{ text-align:center; font-size:0.34rem; line-height:0.84rem;}

.example {
    position: relative;
    padding: 10px;
    margin: 0 0 15px;
    border: 1px solid #ddd;
    border-style: solid;
    outline: 0;
    -webkit-transition: all .3s;
    transition: all .3s;
}
</style>
</head>
<body>
		<header>
			<div class="rt-bk">
				<i class="bk"></i>
				<p><span onclick="javascript:history.back(-1);" style="pointer:cursor">返回</span><!-- <input type="button" onclick="javascript:history.back(-1);" value="返回上一页"> --></p>
			</div>
			<div class="top-name">
				<p>话题讨论</p>
			</div>
		</header>
	<section>
		<article>
			<div class="example">
				<form class="form-horizontal form-condensed" role="form"
					method='post'>
					<!-- <div class="form-group">
						<label class="col-md-2 control-label">标题</label>
						<div class="col-md-10">
							<input type='text' name='title' id='title' value=''
								class='form-control' placeholder='' />
						</div>
					</div>-->
					<div class="form-group">
						<div class="col-md-10">
							${topic}
						</div>
					</div>
					
					<div class="form-group">
						<!-- <div class="col-md-10 alert alert-info text-center">
							<a href="alert-link">34条历史消息...</a>
						</div> -->
						<div class="col-md-10">
							<div class="example row">
								<div class="alert alert-info text-center">
									<a href="alert-link">34条历史消息...</a>
								</div>
								<div class="col-xs-1">
									<a href="###" class="avatar"> <!-- <i class="icon-user icon-2x"></i> -->
											</a>
								</div><div class="col-xs-1"></div>
								<div class="help-block alert alert-info col-xs-8">
									<div class="comment">
										
										<div class="content">
											<div class="pull-right text-muted">2 个小时前</div>
											<div>
												<a href="###"><strong>Catouse</strong></a> <span
													class="text-muted">回复</span> <a href="###">张士超</a>
											</div>
											<div class="text">你到底把我家钥匙放哪里了...</div>
											<div class="actions">
												<a href="##">回复</a>
											</div>
										</div>
									</div>
								</div>
								<!-- 写评论 -->
								<div class="reply-form" id="commentReplyForm">
									<!-- <div class="col-xs-2">
										<a href="###" class="avatar"><i
											class="icon-user icon-border icon-2x icon-muted"></i></a>
									</div> -->
									<div class="form">
										<form role="form">
											<div class="form-group">
												<textarea class="form-control new-comment-text" rows="2" style="margin: 15px;width: 95%;"
													placeholder="我想说..."></textarea>
											</div>
										</form>
									</div>
								</div>
								<!-- 写评论 -->
							</div>
						</div>

					</div>

					<!-- <div class="form-group">
						<input type='text' name='keywords' id='keywords' value=''
									class='form-control' />
						<div class="col-md-offset-10 col-md-2 pull-right">
							<input type='submit' id='submit' class="btn btn-info" style="padding: 8px 25px;line-height: 1.25;border-radius: 4px"
								value='发布' data-loading='稍候...' /> <input type='hidden'
								name='type' id='type' value='article' />
						</div>
					</div> -->
				</form>
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