<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/27
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="footer">
    <div class="footer-inner">
        <!-- #section:basics/footer -->
        <div class="footer-content">
						<span class="bigger-120">
						学院教务系统</span>					</div>

        <!-- /section:basics/footer -->
    </div>
</div>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>			</a>		</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="<%=request.getContextPath()%>/assets/js/page.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery-ui.custom.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/fuelux/fuelux.spinner.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/date-time/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/date-time/daterangepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap-colorpicker.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.knob.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.autosize.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.maskedinput.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap-tag.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/typeahead.jquery.min.js"></script>

<!-- ace scripts -->
<script src="<%=request.getContextPath()%>/assets/js/ace-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->


<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace.onpage-help.css" />


<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="<%=request.getContextPath()%>/assets/js/ace/elements.onpage-help.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/ace/ace.onpage-help.js"></script>