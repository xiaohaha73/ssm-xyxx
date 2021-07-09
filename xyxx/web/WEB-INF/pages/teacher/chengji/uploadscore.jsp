<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/9
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <jsp:include page="../../topcss.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>成绩表格导入</title>
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../../header.jsp"/>
<script language="javascript">
    function check(){
        if(form.upfile.value==""){
            alert("文件不能为空");
            return;
        }
        form.action="<%=request.getContextPath()%>/teacher/uploadscore";
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
                    添加学生信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" method="post" name="form" action="${pageContext.request.contextPath}/teacher/uploadscore" enctype="multipart/form-data" onsubmit="return check();">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>

                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> excel 文件：</label></td>

                                    <td>
                                        <input type="file" name="uploadFile"/>
<%--                                        <input type="hidden" name="kname" value="fj">--%>
<%--                                        <input type="button" value="上传" onclick="check();"/>--%>
                                    </td>


                                </tr>

                                <tr>
                                    <td class="" align="right" valign="middle"></td>

                                    <td>
                                        <button class="btn btn-info" type="submit" onclick="check()">
                                            <i class="ace-icon fa fa-check bigger-110"></i>立即提交	</button>

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


</body>
</html>
