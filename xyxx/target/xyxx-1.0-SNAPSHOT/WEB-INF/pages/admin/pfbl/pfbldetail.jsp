<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/25
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <jsp:include page="../../topcss.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>评分比例</title>
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../../header.jsp"/>
<script language="javascript">

</script>

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">

    <!-- #section:basics/sidebar -->
    <jsp:include page="../../menu.jsp"/>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    查看评分比例信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" role="form" name="form" action="<%=request.getContextPath()%>/pfbl/selectall">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>



                                <tr>
                                    <td  align="right" valign="middle"><strong>平时</strong></td>
                                    <td>${ps}</td>
                                </tr>
                                <tr>
                                    <td  align="right" valign="middle"><strong>期末</strong></td>
                                    <td>${qm}</td>
                                </tr>


                                <tr>
                                    <td class="" align="right" valign="middle"></td>
                                    <input type="hidden" name="pfblid" value="${pfblid}">									<td>
                                    <button class="btn btn-info" type="button" onClick="window.history.go(-1);">
                                        <i class="ace-icon fa fa-check bigger-110"></i>返回	</button>


                                </td>

                                </tr>



                                </tbody>
                            </table>

                        </form>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content-area -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
    <jsp:include page="../../footer.jsp"/>

    ${msg}
</body>
</html>
