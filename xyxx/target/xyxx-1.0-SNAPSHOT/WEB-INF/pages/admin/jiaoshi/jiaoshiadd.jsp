<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/11
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="../../topcss.jsp"/>
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

        if(form.lxdh.value==""){
            alert("联系电话不能为空");
            return false;
            form.lxdh.focus();
        }

        if(form.lxdz.value==""){
            alert("联系地址不能为空");
            return false;
            form.lxdz.focus();
        }

        if(form.xy.value==""){
            alert("学院不能为空");
            return false;
            form.xy.focus();
        }


        form.action="<%=request.getContextPath()%>/admin/addtea";
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
                    添加教师信息页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form class="form-horizontal" method="post"  role="form" name="form" action="<%=request.getContextPath()%>/admin/addtea">
                            <!-- #section:elements.form -->

                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                                <tbody>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right" for="yhm"> 用户名：</label></td>

                                    <td>	<input type="text"  placeholder="请输入用户名" class="col-xs-10 col-sm-5"  id="yhm" name="yhm" required value="" /></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right" for="mm"> 密码：</label></td>

                                    <td>	<input type="text"  placeholder="请输入密码" class="col-xs-10 col-sm-5"  id="mm" name="mm" required value="" /></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right" for="xm"> 姓名：</label></td>

                                    <td>	<input type="text"  placeholder="请输入姓名" class="col-xs-10 col-sm-5"  id="xm" name="xm" required value="" /></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right" for="lxdh"> 联系电话：</label></td>

                                    <td>	<input type="text"  placeholder="请输入联系电话" class="col-xs-10 col-sm-5"  id="lxdh" name="lxdh" required value="" /></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right" for="lxdz"> 联系地址：</label></td>

                                    <td>	<input type="text"  placeholder="请输入联系地址" class="col-xs-10 col-sm-5"  id="lxdz" name="lxdz" required value="" /></td>


                                </tr>
                                <tr>

                                    <td align="right" valign="middle">	<label class="control-label no-padding-right" for="xy"> 学院：</label></td>

                                    <td>	<input type="text"  placeholder="请输入学院" class="col-xs-10 col-sm-5"  id="xy" name="xy" required value="" /></td>


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
