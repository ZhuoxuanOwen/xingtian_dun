<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>表资源源管理</title>
<jsp:include page="/common/import_static.jsp"></jsp:include>
<script src="<%=path%>/assets/js/lhgdialog/lhgcore.min.js"></script>
<script src="<%=path%>/assets/js/lhgdialog/lhgdialog.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
</head>
<body>
    	<div class="page-header" style="position: fixed; z-index: 1000;background-color: #fff;width: 100%;">
		
			<div class="row col-xs-12" >
						<div class="col-lg-10">
							<button class="btn btn-primary" onclick="return codeGen();">代码生成</button>
							<script type="text/javascript">
							//代码生成器
							function codeGen(){
								var tableId = $('input:radio[name="cktableId"]:checked').val();
								if(!tableId){
									alert('请先选择对应的数据表！');
									return;
								}
								
								var dg = new J.dialog({ id:'tableCodeGen',title:'代码生成器',iconTitle:false,width:900,height:520,cover:true, page:'<%=path%>/resource/build_code_generator.jsp?tableId='+tableId}); 
	   		 				 	dg.ShowDialog(); 
							}
						</script>

						<button class="btn btn-success" onclick="return regDatabase();">数据列明细</button>
						<button class="btn btn-danger" onclick="return regDatabase();">数据导出</button>
						<button class="btn btn-pink" onclick="return regDatabase();">数据迁移</button>
						<button class="btn btn-info" onclick="return regDatabase();">同步字典</button>
						<button class="btn btn-purple" onclick="return regDatabase();">刷新</button>
						<button class="btn btn-grey" onclick="return regDatabase();">返回</button>
					</div>

					<div class="col-lg-2"></div>
 

			</div>
	</div>

	<div class="main-container" id="main-container">
		<div class="page-content">
				
			<div class="row col-xs-12" style="top: 50px; margin-top: 10px;">

				<div class="table-responsive">
					<table id="sample-table-1"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center"></th>
								<th>表名称</th>
								<th>所属库</th>
								<th>映射对象名称</th>
								<th>存储引擎</th>
								<th class="hidden-480">表总记录数</th>
								<th>表数据大小</th>
								<th class="hidden-480">操作</th>
							</tr>
						</thead>

						<tbody>
							<s:iterator value="tableList">
								<tr>
									<td class="center"><label> <input type="radio"
											name="cktableId" class="ace"
											value="<s:property value="tableId"/>" /> <span class="lbl">
										</span>
									</label></td>

									<td><s:property value="tableName" /></td>
									<td></td>
									<td><s:property value="className" /></td>
									<td><s:property value="tableEngine" /></td>
									<td><s:property value="tableRowSize" /></td>
									<td><s:property value="tableDataSize" /></td>
									<td>
										<div
											class="visible-md visible-lg hidden-sm hidden-xs btn-group">
											<button class="btn btn-xs btn-success">
												<i class="icon-ok bigger-120"></i>
											</button>

											<button class="btn btn-xs btn-info">
												<i class="icon-edit bigger-120"></i>
											</button>

											<button class="btn btn-xs btn-danger">
												<i class="icon-trash bigger-120"></i>
											</button>

											<button class="btn btn-xs btn-warning">
												<i class="icon-flag bigger-120"></i>
											</button>
										</div>

										<div class="visible-xs visible-sm hidden-md hidden-lg">
											<div class="inline position-relative">
												<button class="btn btn-minier btn-primary dropdown-toggle"
													data-toggle="dropdown">
													<i class="icon-cog icon-only bigger-110"></i>
												</button>

												<ul
													class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
													<li><a href="#" class="tooltip-info"
														data-rel="tooltip" title="View"> <span class="blue">
																<i class="icon-zoom-in bigger-120"></i>
														</span>
													</a></li>

													<li><a href="#" class="tooltip-success"
														data-rel="tooltip" title="Edit"> <span class="green">
																<i class="icon-edit bigger-120"></i>
														</span>
													</a></li>

													<li><a href="#" class="tooltip-error"
														data-rel="tooltip" title="Delete"> <span class="red">
																<i class="icon-trash bigger-120"></i>
														</span>
													</a></li>
												</ul>
											</div>
										</div>
									</td>
								</tr>
							</s:iterator>

						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>


		</div>
	</div>

	<script type="text/javascript">
	
			//初始化数据库资源
			function initDatabase(databaseId){
// 						var row = $('#tt_dbresult').datagrid('getSelected');
// 						if(!row){
// 							jQuery.messager.alert('温馨提示','请选择对应的数据源！');
// 							return ;
// 						}
						var param = "vo.databaseId="+ databaseId;
						$.ajax({
								type : 'post',
								url : '<%=path%>
		/resAjax/initDatabase.action',
						data : param,
						dataType : 'json',
						contentType : "application/x-www-form-urlencoded;charset=UTF-8",
						success : function(data) {
							if (data == "success") {
								jQuery.messager.alert('温馨提示', "开始初始化数据库!");
							} else {
								jQuery.messager.alert(data);
							}
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							jQuery.messager.alert(textStatus);
						}
					});
		}
	</script>
</body>
</html>
