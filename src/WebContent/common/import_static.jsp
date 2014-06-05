<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
		
<!-- basic styles -->
<link href="<%=path %>/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>/assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="<%=path %>/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace-skins.min.css" />

<script src="<%=path %>/assets/js/jquery-2.0.3.min.js"></script>
<script src="<%=path %>/assets/js/bootstrap.min.js"></script>
<script src="<%=path %>/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="<%=path %>/assets/js/jquery.dataTables.min.js"></script>
<script src="<%=path %>/assets/js/jquery.dataTables.bootstrap.js"></script>

<!-- ace scripts -->

<script src="<%=path %>/assets/js/ace-elements.min.js"></script>
<script src="<%=path %>/assets/js/ace.min.js"></script>