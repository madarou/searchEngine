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
<link href="/jsp/zui/css/zui.min.css" rel="stylesheet">
<link href="/jsp/zui/css/doc.min.css" rel="stylesheet">
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
	<section>
		<article>
			<div class="example">
				<div class="panel panel-info">
				  <div class="panel-heading">
				    话题标题<a href="###" class="pull-right"><strong>Catouse</strong></a>
				  </div>
				  <div class="panel-body">
				    话题详情
				  </div>
				</div>
				
				<div class="comments">
					<header>
						<div class="pull-right">
							<a href="#commentReplyForm" class="btn btn-info btn-sm"><i
								class="icon-comment-alt"></i> 发表评论</a>
						</div>
						<h3>
							<i class="icon-comments icon-border-circle"></i> 26 discussion
						</h3>
						<div class="alert alert-info text-center">
							<a href="alert-link">3 条新的评论</a>
						</div>
					</header>
					<section class="comments-list">
						<div class="comment">
							<div class="content">
								<div class="pull-right">
									<span class="text-muted" title="2013-11-08 15:52:32">2
										hours ago</span> &nbsp;<strong>#5</strong>
								</div>
								<span class="author"> <a href="#"><strong>Catouse</strong></a>
									<span class="text-muted"> 回复 </span> <a href="#">Zhang
										Li</a>
								</span>

								<div class="text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Voluptatibus, illo eaque a iure in quidem
									officiis numquam ducimus odio non. Architecto, repellendus
									optio maxime quae sed molestiae ipsa animi tenetur!</div>
								<div class="actions">
									<a href="##">回复</a><a href="###" class="pull-right"><i class="icon-thumbs-o-up"></i> 123</a>
								</div>
							</div>
						</div>
						<div class="comment">
							<div class="content">
								<div class="pull-right">
									<span class="text-muted">2 hours ago</span> &nbsp;<strong>#4</strong>
								</div>
								<a href="#" class="author"><strong>Catouse</strong></a>
								<div class="text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Voluptatibus, illo eaque a iure in quidem
									officiis numquam ducimus odio non. Architecto, repellendus
									optio maxime quae sed molestiae ipsa animi tenetur!</div>
								<div class="actions">
									<a href="##">回复</a><a href="###" class="pull-right"><i class="icon-thumbs-o-up"></i> 123</a>
								</div>
							</div>
						</div>
						<div class="comment">
							<div class="content">
								<div class="pull-right">
									<span class="text-muted">4 hours ago</span> &nbsp;<strong>#3</strong>
								</div>
								<a href="#" class="author"><strong>Catouse</strong></a>
								<div class="text">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Eos, iusto at voluptatem quis aspernatur
									voluptas harum odit corporis consequatur dicta? Eos, unde,
									doloremque ab voluptatibus mollitia quam quas itaque quod
									repellendus sed optio cum blanditiis architecto excepturi
									quidem sint eaque.</div>
								<div class="actions">
									<a href="##">回复</a><a href="###" class="pull-right"><i class="icon-thumbs-o-up"></i> 123</a>
								</div>
							</div>
						</div>
						<div class="comment">
							<div class="content">
								<div class="pull-right">
									<span class="text-muted">1 days ago</span> &nbsp;<strong>#2</strong>
								</div>
								<a href="#" class="author"><strong>Catouse</strong></a>
								<div class="text">Excepturi voluptates ea esse voluptas ad
									voluptate voluptatibus laboriosam velit. Totam, fuga,
									laboriosam, optio, qui id voluptates nam fugit quibusdam labore
									alias atque laudantium repudiandae veniam delectus architecto
									libero ducimus consequatur hic sunt ipsa. Labore, eligendi
									sapiente dolores quibusdam ipsum.</div>
								<div class="actions">
									<a href="##">回复</a><a href="###" class="pull-right"><i class="icon-thumbs-o-up"></i> 123</a>
								</div>
							</div>
						</div>
						<div class="comment">
							<div class="content">
								<div class="pull-right">
									<span class="text-muted">2 months ago</span> &nbsp;<strong>#1</strong>
								</div>
								<a href="#" class="author"><strong>Catouse</strong></a>
								<div class="text">Assumenda, accusamus, inventore, ut, ea
									laboriosam quae sunt maxime labore quisquam quod nesciunt saepe
									quis. Debitis, fuga, ad, aut eaque vero vitae suscipit
									obcaecati nemo eligendi numquam id labore voluptas veniam sequi
									perspiciatis facilis voluptates dolorem minus quibusdam unde
									molestias.</div>
								<div class="actions">
									<a href="##">回复</a><a href="###" class="pull-right"><i class="icon-thumbs-o-up"></i> 123</a>
								</div>
							</div>
						</div>
					</section>
					<footer>
						<div class="reply-form" id="commentReplyForm">
							<div class="form">
								<form role="form">
									<div class="form-group">
										<textarea class="form-control new-comment-text" rows="2"
											placeholder="write a comment..."></textarea>
									</div>
									<div class="form-group comment-user" style="display: none">
										<div class="row">
											<div class="col-md-3">
												<span class="pull-right">或者</span> <a href="#">登录</a> &nbsp;<a
													href="##">注册</a>
											</div>
											<div class="col-md-7">
												<div class="form-group">
													<input type="text" class="form-control"
														id="nameInputEmail1" placeholder="Enter your name">
												</div>
												<div class="form-group">
													<input type="email" class="form-control"
														id="exampleInputEmail1" placeholder="Enter email">
												</div>
											</div>
											<div class="col-md-2">
												<button type="submit" class="btn btn-block btn-primary">
													<i class="icon-ok"></i>
												</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</footer>
				</div>
			</div>
		</article>
	</section>
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<!-- ZUI Javascript组件 -->
	<script src="/jsp/zui/js/zui.min.js"></script>
	<script src="/jsp/zui/js/doc.min.js"></script>
</body>
</html>