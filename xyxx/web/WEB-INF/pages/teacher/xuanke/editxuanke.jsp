<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/2
  Time: 22:46
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
    <title>更改选课</title>
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../../header.jsp"/>
<script language="javascript">
    function checkDo(){
        if(form.kc.value==""){
            alert("课程不能为空");
            return false;
            form.kc.focus();
        }

        if(form.xs.value==""){
            alert("学生不能为空");
            return false;
            form.xs.focus();
        }

        if(form.xksj.value==""){
            alert("选课时间不能为空");
            return false;
            form.xksj.focus();
        }

        if(form.zt.value==""){
            alert("状态不能为空");
            return false;
            form.zt.focus();
        }


        form.action="<%=request.getContextPath()%>/teacher/updatexuanke";
        form.submit();
    }
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
                    修改选课信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" role="form" method="post"  name="form" action="<%=request.getContextPath()%>/teacher/updatexuanke">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>

                                <tr>

                                    <td align="right" valign="middle"><strong>课程</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入课程" id="kc" name="kc" value="${kc}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>学生</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入学生" id="xs" name="xs" value="${xs}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>选课时间</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入选课时间" id="xksj" name="xksj" value="${xksj}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>状态</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入状态" id="zt" name="zt" value="${zt}" required></td>


                                </tr>


                                <input type="hidden" name="xkid" value="${xkid}">


                                <tr>
                                    <td class="" align="right" valign="middle"></td>

                                    <td>
                                        <button class="btn btn-info" type="submit">
                                            <i class="ace-icon fa fa-check bigger-110"></i>立即提交	</button>

                                        <button class="btn" type="reset">
                                            <i class="ace-icon fa fa-undo bigger-110"></i>重新输入			</button>
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
