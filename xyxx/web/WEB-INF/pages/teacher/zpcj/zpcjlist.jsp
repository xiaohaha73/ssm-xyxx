<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/8
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <jsp:include page="../../topcss.jsp"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>总评成绩列表</title>
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../../header.jsp"/>
<script language="javascript">

</script>

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">

    <!-- #section:basics/sidebar -->
    <jsp:include page="../menu.jsp"/>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    总评成绩信息列表页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <form name="form" method="post" action="<%=request.getContextPath()%>/zpcj/listpage">

                            课程<input type="text" name="kc" value="">

                            学生<input type="text" name="xs" value="">

                            <input type="submit" value="查询" class="btn btn-info">
                            <table id="table1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>

                                    <th ><strong>课程</strong></th>

                                    <th ><strong>学生</strong></th>

                                    <th ><strong>平时成绩</strong></th>

                                    <th ><strong>期末成绩</strong></th>

                                    <th ><strong>总成绩</strong></th>

                                    <th ><strong>登记时间</strong></th>
                                    <th  class="hidden-480">操作</th>
                                </tr>
                                </thead>

                                <tbody id="table2">
                                <c:forEach items="${list}" var="mymap" varStatus="status">
                                    <tr>
                                        <td   height="28" >${status.count}</td>
                                        <td>${mymap.kc}</td>

                                        <td>${mymap.xs}</td>

                                        <td>${mymap.pscj}</td>

                                        <td>${mymap.qmcj}</td>

                                        <td>${mymap.zcj}</td>

                                        <td>${mymap.djsj}</td>


                                        <td><div class="hidden-sm hidden-xs btn-group"><a href="<%= request.getContextPath()%>/teacher/delfinsco?keyid=${mymap.zpcjid}"  onClick="javascript:if(confirm('是否删除')){return true;} else{return false;}" class="btn btn-xs btn-danger">删除</a>
                                            <a href="<%= request.getContextPath()%>/teacher/updatefinsco?keyid=${mymap.zpcjid}"  class="btn btn-xs btn-success"  >修改</a><a href="<%= request.getContextPath()%>/teacher/zpcjdetail?keyid=${mymap.zpcjid}"    class="btn btn-xs btn-info" >详情</a></div></td>
                                    </tr>

                                </c:forEach>

                                </tbody>

                            </table>
                            <span id="spanFirst">第一页</span> <span id="spanPre">上一页</span> <span id="spanNext">下一页</span> <span id="spanLast">最后一页</span> 第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
                        </form>
                    </div><!-- /.span -->
                </div><!-- /.row -->
            </div><!-- /.page-content-area -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
    <jsp:include page="../../footer.jsp"/>
    ${msg}
</body>
</html>
