<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/27
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <jsp:include page="../topcss.jsp"/>
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../header.jsp"/>


<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">

    <!-- #section:basics/sidebar -->
    <jsp:include page="menu.jsp"/>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                </li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content-area -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
    <jsp:include page="../footer.jsp"/>
</body>
</html>
