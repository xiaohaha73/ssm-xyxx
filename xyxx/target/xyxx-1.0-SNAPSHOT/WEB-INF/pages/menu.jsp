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
                <span class="menu-text"> 管理员管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/admin/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加管理员</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%= request.getContextPath()%>/admin/listpage?start=0&size=4">
                        <i class="menu-icon fa fa-caret-right"></i>
                        管理员列表</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 教师管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/admin/addteacher">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加教师</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%=request.getContextPath()%>/admin/teacherlist">
                        <i class="menu-icon fa fa-caret-right"></i>
                        教师列表</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 班级管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/admin/addbanji">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加班级</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%=request.getContextPath()%>/admin/banjilist">
                        <i class="menu-icon fa fa-caret-right"></i>
                        班级列表</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 学生管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/xuesheng/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加学生</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%=request.getContextPath()%>/xuesheng/listpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        学生列表</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 评分比例管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/pfbl/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加评分比例</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/pfbl/listpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        评分比例列表</a>

                    <b class="arrow"></b>							</li>

            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 课程管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/kecheng/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加课程</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/kecheng/listpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        课程列表</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/sksj/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加上课时间</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/sksj/listpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        上课时间列表</a>

                    <b class="arrow"></b>							</li>
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
                    <a href="<%=request.getContextPath()%>/kcb/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加课程表</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/kcb/listpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        课程表列表</a>

                    <b class="arrow"></b>							</li>
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
                <span class="menu-text"> 个人信息 </span>
                <b class="arrow fa fa-angle-down"></b>						</a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/gly/modify">
                        <i class="menu-icon fa fa-caret-right"></i>
                        个人信息</a>
                    <b class="arrow"></b></li>
            </ul>
        </li>
    </ul>


    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>				</div>
</div>

