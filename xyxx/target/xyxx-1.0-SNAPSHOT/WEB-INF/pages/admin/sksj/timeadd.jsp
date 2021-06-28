<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/27
  Time: 22:31
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
    <title>添加上课时间</title>
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

        if(form.xq.value==""){
            alert("星期不能为空");
            return false;
            form.xq.focus();
        }

        if(form.j.value==""){
            alert("节不能为空");
            return false;
            form.j.focus();
        }


        form.action="<%=request.getContextPath()%>/admin/addtime";
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
                    添加上课时间信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" method="post"  role="form" name="form" action="<%=request.getContextPath()%>/admin/addtime">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 课程：</label></td>

                                    <td>


                                        <select name="kc">
                                            <c:forEach items="${kelist}" var="ke">
                                                <option value="${ke.kcmc}">
                                                        ${ke.kcmc}
                                                </option>
                                            </c:forEach>
                                        </select>


                                    </td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 星期：</label></td>

                                    <td>

                                        <select name="xq">
                                            <c:forEach items="${xqList}" var="xq">
                                                <option value="${xq.xq}">
                                                        ${xq.xq}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 节：</label></td>

                                    <td>	<select name="j">
                                        <c:forEach items="${keshiList}" var="ks">
                                            <option value="${ks.ks}">
                                                    ${ks.ks}
                                            </option>
                                        </c:forEach>
                                    </select></td>


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
