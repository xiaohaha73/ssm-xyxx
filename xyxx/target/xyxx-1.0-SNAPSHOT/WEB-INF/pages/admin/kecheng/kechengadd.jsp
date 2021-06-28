<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/26
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="../../topcss.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加课程</title>
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../../header.jsp"/>
<script language="javascript">
    function checkDo(){
        if(form.kcmc.value==""){
            alert("课程名称不能为空");
            return false;
            form.kcmc.focus();
        }

        if(form.js.value==""){
            alert("介绍不能为空");
            return false;
            form.js.focus();
        }

        if(form.fbjs.value==""){
            alert("发布教师不能为空");
            return false;
            form.fbjs.focus();
        }


        form.action="<%=request.getContextPath()%>/admin/addkecheng";
        form.submit();
    }
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
                    添加课程信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" method="post"  role="form" name="form" action="<%=request.getContextPath()%>/admin/addkecheng">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 课程名称：</label></td>

                                    <td>	<input type="text"  placeholder="请输入课程名称" class="col-xs-10 col-sm-5"  id="kcmc" name="kcmc" required value="" /></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 介绍：</label></td>

                                    <td>
                                        <textarea name="js" cols="80" rows="5" placeholder="请输入介绍" required ></textarea>

                                    </td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 发布教师：</label></td>

                                    <td>	<input type="text"  placeholder="请输入发布教师" class="col-xs-10 col-sm-5"  id="fbjs" name="fbjs" required value="<%=session.getAttribute("user")%>" /></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 比例：</label></td>

                                    <td>
                                        <select name="bl">
                                          <c:forEach items="${pfbls}" var="bl">
                                                    <option value="${bl.mc}">
                                                            ${bl.mc}
                                                    </option>
                                                </c:forEach>
                                        </select>

                                    </td>


                                </tr>
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
