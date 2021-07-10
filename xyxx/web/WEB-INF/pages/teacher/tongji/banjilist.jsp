<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/10
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <jsp:include page="../../topcss.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>班级查看</title>
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
                    班级信息列表页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <form name="form" method="post" action="">
                            <table id="table1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>

                                    <th ><strong>班级</strong></th>
                                    <th class="hidden-480">操作</th>
                                </tr>
                                </thead>

                                <tbody id="table2">

                                <c:forEach items="${list}" var="mymap" varStatus="status">
                                <tr>
                                    <td scope="row">${status.count}</td>
                                    <td  height="28"  >${mymap.bj}</td>

                                    <td>	<div class="hidden-sm hidden-xs btn-group"><a href="<%=request.getContextPath()%>/teacher/xuankepage" class="btn btn-xs btn-success" >选课情况</a>
                                        <a href="<%=request.getContextPath()%>/teacher/finalscorelist" class="btn btn-xs btn-success" >期末及格率</a>
                                    </div></td>

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

</body>
</html>
