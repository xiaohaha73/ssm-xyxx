<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/27
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar" class="sidebar responsive">

    <ul class="nav nav-list">
        <li class="active">
            <a href="#">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> 系统菜单 </span>						</a>

            <b class="arrow"></b>					</li>


        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 课程管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">


                <li class="active">
                    <a href="<%=request.getContextPath()%>/kecheng/list">
                        <i class="menu-icon fa fa-caret-right"></i>
                        课程浏览</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>


        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 课程表管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">

                <li class="active">
                    <a href="<%=request.getContextPath()%>/kcb/list">
                        <i class="menu-icon fa fa-caret-right"></i>
                        课程表浏览</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>

        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 选课管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">

                <li class="active">
                    <a href="<%=request.getContextPath()%>/xuanke/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加选课</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/xuanke/list">
                        <i class="menu-icon fa fa-caret-right"></i>
                        我的选课列表</a>

                    <b class="arrow"></b>							</li>


            </ul>
        </li>


        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 成绩管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/chengji/list">
                        <i class="menu-icon fa fa-caret-right"></i>
                        我的成绩列表</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%=request.getContextPath()%>/zpcj/list">
                        <i class="menu-icon fa fa-caret-right"></i>
                        我的总评成绩</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 个人信息 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/xuesheng/modify">
                        <i class="menu-icon fa fa-caret-right"></i>
                        个人信息</a>

                    <b class="arrow"></b>							</li>
            </ul>
        </li>



    </ul><!-- /.nav-list -->


    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>				</div>
</div>
