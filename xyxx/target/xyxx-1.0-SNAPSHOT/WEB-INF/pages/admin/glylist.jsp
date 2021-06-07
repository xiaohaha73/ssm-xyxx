<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/5
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <jsp:include page="../topcss.jsp"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../header.jsp"/>
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
                    管理员信息列表页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <form name="form" method="post" action="<%=request.getContextPath()%>/gly/listpage">
                            用户名<input type="text" name="yhm" value="">
                            <input type="submit" value="查询" class="btn btn-info">
                        </form>

                            <table id="table1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>

                                    <th ><strong>用户名</strong></th>

                                    <th ><strong>密码</strong></th>

                                    <th ><strong>姓名</strong></th>
                                    <th  class="hidden-480">操作</th>
                                </tr>
                                </thead>

                                <tbody id="table2">
                                <c:forEach items="${list}" var="mymap" varStatus="status">
                                    <tr>
                                        <td   height="28" >${status.count}</td>
                                        <td>${mymap.yhm}</td>

                                        <td>${mymap.mm}</td>

                                        <td>${mymap.xm}</td>


                                        <td><div class="hidden-sm hidden-xs btn-group"><a href="<%= request.getContextPath()%>/admin/del?keyid=${mymap.glyid}"  onClick="javascript:if(confirm('是否删除')){return true;} else{return false;}" class="btn btn-xs btn-danger">删除</a>
                                            <a href="<%= request.getContextPath()%>/admin/modifypage?keyid=${mymap.glyid}"  class="btn btn-xs btn-success"  >修改</a><a href="<%= request.getContextPath()%>/admin/detail?keyid=${mymap.glyid}"    class="btn btn-xs btn-info" >详情</a></div></td>
                                    </tr>

                                </c:forEach>

                                </tbody>

                            </table>

                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                    <li class="active">
                                        <a href="<%= request.getContextPath()%>/admin/listpage?start=0&size=4">1</a>
                                    </li>
                                    <li>
                                        <a href="<%= request.getContextPath()%>/admin/listpage?start=0&size=4">2</a>
                                    </li>
                                    <li>
                                        <a href="<%= request.getContextPath()%>/admin/listpage?start=0&size=4">3</a>
                                    </li>
                                    <li>
                                        <a href="<%= request.getContextPath()%>/admin/listpage?start=0&size=4">4</a>
                                    </li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>

                    </div><!-- /.span -->
                </div><!-- /.row -->
            </div><!-- /.page-content-area -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
    <jsp:include page="../footer.jsp"/>
    ${msg}
</body>
</html>

