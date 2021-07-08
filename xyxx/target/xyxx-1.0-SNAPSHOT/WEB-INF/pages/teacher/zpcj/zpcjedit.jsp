<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/8
  Time: 22:41
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
  <title>更改总评成绩</title>
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

    if(form.pscj.value==""){
      alert("平时成绩不能为空");
      return false;
      form.pscj.focus();
    }

    if(form.qmcj.value==""){
      alert("期末成绩不能为空");
      return false;
      form.qmcj.focus();
    }

    if(form.zcj.value==""){
      alert("总成绩不能为空");
      return false;
      form.zcj.focus();
    }

    if(form.djsj.value==""){
      alert("登记时间不能为空");
      return false;
      form.djsj.focus();
    }


    form.action="<%=request.getContextPath()%>/teacher/editfinsc";
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
          修改总评成绩信息页面					</li>

      </ul><!-- /.breadcrumb -->


    </div>

    <!-- /section:basics/content.breadcrumbs -->
    <div class="page-content">

      <div class="page-content-area">

        <div class="row">
          <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <form class="form-horizontal" role="form" method="post"  name="form" action="<%=request.getContextPath()%>/teacher/editfinsc">
              <!-- #section:elements.form -->

              <table id="sample-table-1" class="table table-striped table-bordered table-hover">

                <tbody>

                <tr>

                  <td align="right" valign="middle"><strong>课程</strong></td>

                  <td>
                    <select name="kc">
                      <c:forEach items="${kelist}" var="ke">
                        <option value="${ke.kcmc}" ${ke.kcmc == kc? "selected":""}>
                            ${ke.kcmc}
                        </option>
                      </c:forEach>
                    </select>
                  </td>


                </tr>
                <tr>

                  <td align="right" valign="middle"><strong>学生</strong></td>

                  <td>
                    <select name="xs">
                      <c:forEach items="${stuList}" var="stu">
                        <option value="${stu.yhm}" ${stu.xm == xs? "selected":""}>
                            ${stu.xm}
                        </option>
                      </c:forEach>
                    </select>
                  </td>


                </tr>
                <tr>

                  <td align="right" valign="middle"><strong>平时成绩</strong></td>

                  <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入平时成绩" id="pscj" name="pscj" value="${pscj}" required></td>


                </tr>
                <tr>

                  <td align="right" valign="middle"><strong>期末成绩</strong></td>

                  <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入期末成绩" id="qmcj" name="qmcj" value="${qmcj}" required></td>


                </tr>
                <tr>

                  <td align="right" valign="middle"><strong>总成绩</strong></td>

                  <td><input type="text"  class="col-xs-10 col-sm-5" placeholder="请输入总成绩" id="zcj" name="zcj" value="${zcj}" required></td>


                </tr>

                <input type="hidden" name="zpcjid" value="${zpcjid}">


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