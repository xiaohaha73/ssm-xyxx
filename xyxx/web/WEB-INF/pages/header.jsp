<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/27
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="navbar" class="navbar navbar-default">

    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span></button>

        <div class="navbar-header pull-left">
            <!-- #section:basics/navbar.layout.brand -->
            <a href="#" class="navbar-brand">
                <small>
                    学院教务系统 </small> </a></div>

        <!-- #section:basics/navbar.dropdown -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">


                <!-- #section:basics/navbar.user_menu -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">

								<span class="user-info">
									欢迎您<br/>
									<%=session.getAttribute("user")%>								</span>

                        <i class="ace-icon fa fa-caret-down"></i> </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

                        <li class="divider"></li>

                        <li>
                            <a href="<%=request.getContextPath()%>/loginout">
                                <i class="ace-icon fa fa-power-off"></i>
                                登出 </a></li>
                    </ul>
                </li>

                <!-- /section:basics/navbar.user_menu -->
            </ul>
        </div>

        <!-- /section:basics/navbar.dropdown -->
    </div><!-- /.navbar-container -->
</div>
