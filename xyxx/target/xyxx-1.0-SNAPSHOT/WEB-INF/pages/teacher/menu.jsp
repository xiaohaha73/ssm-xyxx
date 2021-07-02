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
                <span class="menu-text"> 课程表管理 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/common/kcblistpage">
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
                    <a href="<%=request.getContextPath()%>/teacher/xuankepage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        选课列表</a>

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
                    <a href="<%=request.getContextPath()%>/chengji/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加成绩</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/chengji/daoru.jsp">
                        <i class="menu-icon fa fa-caret-right"></i>
                        成绩导入</a>

                    <b class="arrow"></b>							</li>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/chengji/listpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        成绩列表</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%=request.getContextPath()%>/zpcj/addpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加总评成绩</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%=request.getContextPath()%>/zpcj/listpage">
                        <i class="menu-icon fa fa-caret-right"></i>
                        总评成绩列表</a>

                    <b class="arrow"></b>							</li>


            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 班级查看 </span>

                <b class="arrow fa fa-angle-down"></b>						</a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/tongji/banjilist.jsp">
                        <i class="menu-icon fa fa-caret-right"></i>
                        班级查看</a>

                    <b class="arrow"></b>							</li>

                <li class="active">
                    <a href="<%=request.getContextPath()%>/tongji/index.jsp">
                        <i class="menu-icon fa fa-caret-right"></i>
                        平均成绩</a>

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
                    <a href="<%=request.getContextPath()%>/jiaoshi/modify">
                        <i class="menu-icon fa fa-caret-right"></i>
                        个人信息</a>

                    <b class="arrow"></b>							</li>
            </ul>
        </li>
    </ul>


    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>				</div>
</div>


