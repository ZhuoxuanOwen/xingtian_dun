<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
    String tableId = request.getParameter("tableId");
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<jsp:include page="/common/import_bootstrap.jsp"></jsp:include>
</head>
<body>
 
	<div class="main-container" id="main-container">
		<div class="page-content">
			
            <div class="row" style="height:50px;width:98%;padding-top:5px;">
 				 
 					<div class="col-sm-8">
 				
 					<select id="codeTemplate" name="dept" style="width:200px;margin-left:20px;"  class="form-control col-sm-5" >
					<option value="">请选择目标模板</option>
					<option value="JAVA_DO">Java-JavaDO</option>
					<option value="JAVA_Hibernate_DO">Java-JavaDO(Hibernate)</option>

					<option value="JAVA_DAO">Java-DAO接口</option>
					<option value="JAVA_IBATIS_DAO">Java-IbatisDAO</option>

					<option value="JAVA_Service">Java-Service接口</option>


					<option value="JAVA_IBATIS_SQL_MAP">Java-Ibatis配置文件</option>

					<option value="">前端-ExtJs表格Grid</option>
					<option value="">前端-ExtJs表单</option>
				  </select>
				  &nbsp;&nbsp;&nbsp;
				  <button onclick="generatorTemplateCode()" class="btn btn-success">生成代码</button>
				  
				  &nbsp;&nbsp;&nbsp;
				  <button onclick="generatorTemplateCode()" class="btn btn-danger">配置规则</button>
 				</div>
				

			</div>

		</div>

		 
		<textarea id="content" rows="18" cols="50" class="form-control"></textarea>

 	   

	</div>
	<SCRIPT type="text/javascript">
	 

			//生成代码
			function generatorTemplateCode(){
				var template = $('#codeTemplate').val();
				if(template == ""){
					alert("请选择对应的模板。");
					return;
				}
				var param = "tableId=<%=tableId%>&templateDefine=" + template;
				$.ajax({
						type : 'post',
						url : "<%=path%>/resourceJson/generatorTemplateCode.action",
						data : param,
						dataType : 'json',
						cache : false,
						contentType : "application/x-www-form-urlencoded;charset=UTF-8",
						success : function(data) {
							if (data.success) {
								$("#content").text(data.content);
							} else {
		
								alert(data);
							}
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							 alert(textStatus);
						}
					});
			}
	</SCRIPT>
</body>
</html>
