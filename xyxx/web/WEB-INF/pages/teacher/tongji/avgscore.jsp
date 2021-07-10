<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/10
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="gb2312" />
    <jsp:include page="../topcss.jsp"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

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
                    学生信息列表页面					</li>

            </ul><!-- /.breadcrumb -->


        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">
                班级名称：<%=bj%>  课程：<%=kc%> 平时平均成绩
                <div class="row">
                    <div class="col-xs-12">
                        <form name="form" method="post" action="">
                            <table id="table1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>




                                    <th ><strong>姓名</strong></th>

                                    <th ><strong>考试次数</strong></th>

                                    <th ><strong>平均成绩</strong></th>

                                </tr>
                                </thead>

                                <tbody id="table2">
                                <%
                                    int i=1;
                                    ResultSet r=null;
                                    int num=0;
                                    int pj=0;
                                    if(rs!=null){
                                        while(rs.next()){


                                            sql="select count(1) as num ,avg(cj) as pj from chengji where xs='"+rs.getString("yhm")+"' and kc='"+kc+"' and lx='平时'";
                                            db.open();
                                            r=db.query(sql);
                                            if(r.next()){
                                                num=r.getInt("num");
                                                pj=r.getInt("pj");
                                            }
                                %>
                                <tr>


                                    <td  height="28"  ><%=rs.getString("xm")%></td>

                                    <td  height="28"  ><%=num%></td>

                                    <td  height="28"  ><%=pj%></td>


                                </tr>

                                <%
                                            i++;
                                        }
                                    }
                                %>



                                </tbody>
                            </table>
                            <span id="spanFirst">第一页</span> <span id="spanPre">上一页</span> <span id="spanNext">下一页</span> <span id="spanLast">最后一页</span> 第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
                        </form>
                    </div><!-- /.span -->
                </div><!-- /.row -->
            </div><!-- /.page-content-area -->
        </div><!-- /.page-content -->
    </div><!-- /.main-content -->
    <jsp:include page="../footer.jsp"/>


</body>
</html>
