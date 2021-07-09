<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/25
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <jsp:include page="../../topcss.jsp"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<jsp:include page="../../header.jsp"/>
<script language="javascript">
    function checkDo(){
        if(form.yhm.value==""){
            alert("用户名不能为空");
            return false;
            form.yhm.focus();
        }

        if(form.mm.value==""){
            alert("密码不能为空");
            return false;
            form.mm.focus();
        }

        if(form.xm.value==""){
            alert("姓名不能为空");
            return false;
            form.xm.focus();
        }

        if(form.zy.value==""){
            alert("专业不能为空");
            return false;
            form.zy.focus();
        }

        if(form.xy.value==""){
            alert("学院不能为空");
            return false;
            form.xy.focus();
        }

        if(form.nl.value==""){
            alert("年龄不能为空");
            return false;
            form.nl.focus();
        }

        if(form.dh.value==""){
            alert("电话不能为空");
            return false;
            form.dh.focus();
        }

        if(form.bj.value==""){
            alert("班级不能为空");
            return false;
            form.bj.focus();
        }


        form.action="<%=request.getContextPath()%>/common/editstudent";
        form.submit();
    }
</script>

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">

    <!-- #section:basics/sidebar -->
        <%
		if(session.getAttribute("role").equals("teacher")){
	%>
    <jsp:include page="../../teacher/menu.jsp"/>
        <% }else {%>
    <jsp:include page="../../menu.jsp"/>

        <%}%>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    修改学生信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" role="form" method="post"  name="form" action="<%=request.getContextPath()%>/common/editstudent">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>

                                <tr>

                                    <td align="right" valign="middle"><strong>用户名</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入用户名" id="yhm" name="yhm" value="${yhm}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>密码</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入密码" id="mm" name="mm" value="${mm}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>姓名</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入姓名" id="xm" name="xm" value="${xm}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>专业</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入专业" id="zy" name="zy" value="${zy}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>学院</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入学院" id="xy" name="xy" value="${xy}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>年龄</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入年龄" id="nl" name="nl" value="${nl}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>电话</strong></td>

                                    <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入电话" id="dh" name="dh" value="${dh}" required></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle"><strong>班级</strong></td>

                                    <td>
                                            <select name="bj">
                                                <c:forEach items="${banjis}" var="banji">
                                                    <option
                                                            value="${banji.bj}"
                                                            ${banji.bj.equals(bj)? "selected":""}
                                                    >
                                                            ${banji.bj}
                                                    </option>
                                                </c:forEach>
                                            </select>


                                    </td>


                                </tr>


                                <input type="hidden" name="xsid" value="${xsid}">


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