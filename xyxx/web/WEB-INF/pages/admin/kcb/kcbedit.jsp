<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/29
  Time: 13:50
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
    <title>课程表编辑界面</title>
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

        if(form.skdd.value==""){
            alert("上课地点不能为空");
            return false;
            form.skdd.focus();
        }

        if(form.sksj.value==""){
            alert("上课时间不能为空");
            return false;
            form.sksj.focus();
        }

        if(form.sm.value==""){
            alert("说明不能为空");
            return false;
            form.sm.focus();
        }


        form.action="<%=request.getContextPath()%>/admin/editkcb";
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
                    修改课程表信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" role="form" method="post"  name="form" action="<%=request.getContextPath()%>/admin/editkcb">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>

                                <tr>

                                    <td align="right" valign="middle"><strong>课程</strong></td>

                                    <td>
                                        <select name="kc">
                                            <c:forEach items="${keList}" var="ke">
                                                <option value="${ke.kcmc}" ${ke.kcmc == kc? "selected":""}>
                                                        ${ke.kcmc}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>上课地点</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入上课地点" id="skdd" name="skdd" value="${skdd}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>上课时间</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入上课时间" id="sksj" name="sksj" value="${sksj}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right"> 节：</label></td>

                                    <td><select name="ks">
                                        <c:forEach items="${keshiList}" var="keshi">
                                            <option value="${keshi.ks}" ${keshi.ks == ks ? "selected":""}>
                                                    ${keshi.ks}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    </td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>说明</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入说明" id="sm" name="sm" value="${sm}" required></td>


                                </tr>


                                <input type="hidden" name="kcbid" value="${kcbid}">


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
