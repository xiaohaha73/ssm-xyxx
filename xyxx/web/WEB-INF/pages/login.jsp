<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<meta name="description" content="Restyling jQuery UI Widgets and Elements" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="/assets/css/ace-fonts.css" />
	<link rel="stylesheet" href="/assets/css/ace.min.css" id="main-ace-style" />
	<!--[if lte IE 9]>
	<link rel="stylesheet" href="/assets/css/ace-part2.min.css" />
	<![endif]-->
	<!--[if lte IE 9]>
	<link rel="stylesheet" href="/assets/css/ace-ie.min.css" />
	<![endif]-->
	<script src="/assets/js/ace-extra.min.js"></script>
	<!--[if lte IE 8]>
	<script src="/assets/js/html5shiv.min.js"></script>
	<script src="/assets/js/respond.min.js"></script>
	<![endif]-->

</head>

<body class="login-layout blur-login">
<div class="main-container">
	<div class="main-content">
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="login-container">
					<div class="center"><br>
						<br>
						<br>

						<h1>
							<span class="white">学院教务系统</span>								</h1>
					</div>

					<div class="space-6"></div>

					<div class="position-relative">
						<div id="login-box" class="login-box visible widget-box no-border">
							<div class="widget-body">
								<div class="widget-main">
									<br>

									<h4 class="header blue lighter bigger">
										<i class="ace-icon fa fa-coffee green"></i>
										输入登录信息											</h4>

									<div class="space-6"></div>

									<form name="form" method="post" action="/logincheck">
										<fieldset>
											<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="username" placeholder="用户名"  required/>
															<i class="ace-icon fa fa-user"></i>														</span>													</label>

											<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="password" placeholder="密码"  required/>
															<i class="ace-icon fa fa-lock"></i>														</span>													</label>
											<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<select name="qx">
																<option value="student">学生</option>
																<option value="teacher">教师</option>
																<option value="admin">管理员</option>
															</select>
															<i class="ace-icon fa fa-user"></i>													</span>													</label>

											<div class="space"></div>
											<div class="login_alert" style="color: red;font-weight: bolder;font-size: 14px">${msg}</div>

											<div class="clearfix">


												<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
													<i class="ace-icon fa fa-key"></i>
													<span class="bigger-110">登录</span>														</button>
											</div>

											<div class="space-4"></div>
										</fieldset>
									</form>
								</div><!-- /.widget-main -->

								<div class="toolbar clearfix">										</div>
							</div><!-- /.widget-body -->
						</div><!-- /.login-box -->
						<!-- /.forgot-box -->
						<!-- /.signup-box -->
					</div>
					<!-- /.position-relative -->
				</div>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.main-content -->
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='/assets/js/jquery.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
	window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
	if('ontouchstart' in document.documentElement) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
	jQuery(function($) {
		$(document).on('click', '.toolbar a[data-target]', function(e) {
			e.preventDefault();
			var target = $(this).data('target');
			$('.widget-box.visible').removeClass('visible');//hide others
			$(target).addClass('visible');//show target
		});
	});

</script>
</body>
</html>