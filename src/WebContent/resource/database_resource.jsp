<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>数据库资源管理</title>
<jsp:include page="/common/import_static.jsp"></jsp:include>
<script src="<%=path%>/assets/js/lhgdialog/lhgcore.min.js"></script>
<script src="<%=path%>/assets/js/lhgdialog/lhgdialog.min.js"></script>
</head>
<body>
	<div class="main-container" id="main-container">
		<div class="page-content">
			<div class="page-header">
				<h1>
					数据平台 <small> <i class="icon-double-angle-right"></i>
						数据库资源管理
					</small>
				</h1>
			</div>

			<div class="row col-xs-12">
				<div class="col-sm-6">
					<button class="btn btn-primary" onclick="return regDatabase();">注册数据源</button>
					<script type="text/javascript">
						//注册数据源信息
						function regDatabase(){
							 var dg = new J.dialog({ id:'regDatabase',title:'请输入数据库信息',iconTitle:false,width:680,height:490,cover:true, page:'<%=path%>/resource/initAddDatabase.action'}); 
							 dg.ShowDialog(); 	
						}
						
					</script>

					<button class="btn btn-warning" onclick="return regDatabase();">数据库监控</button>

					<button class="btn btn-pink" onclick="return refushDatabaseList()">刷新页面</button>
				</div>
			</div>
			<div class="row col-xs-12"></div>

			<div class="row col-xs-12" style="margin-top: 10px;">

				<div class="table-responsive">
					<table id="sample-table-1"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center"><label> <input type="checkbox"
										class="ace" /> <span class="lbl"></span>
								</label></th>
								<th>业务名称</th>
								<th>数据库类型</th>
								<th>数据库名称</th>
								<th>用户名</th>
								<th>服务器地址</th>
								<th>端口</th>
								<th>表记录数</th>
								<th>字符集</th>

								<th class="hidden-480" style="width: 10%">备注/错误信息</th>
								<th class="hidden-480" style="width: 15%">操作</th>
							</tr>
						</thead>

						<tbody>
							<s:iterator value="databases" id="db">
								<tr>
									<td class="center"><label> <input type="checkbox"
											class="ace" id="<s:property value="databaseId"/>" /> <span
											class="lbl"> </span>
									</label></td>

									<td><s:property value="businessName" /></td>
									<td><s:property value="dbType" /></td>
									<td><s:property value="dbName" /></td>
									<td><s:property value="userName" /></td>
									<td><s:property value="serverAddress" /></td>
									<td><s:property value="serverPort" /></td>
									<td class="hidden-480"><s:property value="tableCount" /></td>
									<td><s:property value="dbCharset" /></td>

									<td class="hidden-480">
									    <s:if test="%{#db.dbStatus==4}">
											<font color='red'><s:property value="errorMsg" /></font>
										</s:if> <s:else>
											<s:property value="dbRemark" />
										</s:else></td>

									<td>
										<s:if test="%{#db.dbStatus==1}">
											<i class="icon-spinner icon-spin orange bigger-125"></i>
										</s:if> 
										<s:elseif test="%{#db.dbStatus==4}">
											<button class="btn btn-xs btn-danger"
												onclick="initDatabase(<s:property value="databaseId"/>)">
												<i class="icon-retweet bigger-120"></i>
											</button>
										</s:elseif> 
										<s:else>
											<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
											 
												 
												<button class="btn btn-xs btn-info"
													onclick="initDatabase(<s:property value="databaseId"/>)">
													<i class="icon-cogs bigger-120"></i>
												</button>

												<button class="btn btn-xs btn-warning"
													onclick="initTableList(<s:property value="databaseId"/>)">
													<i class="icon-calendar bigger-120"></i>
												</button>
											</div>

										</s:else>
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
	
		//加载数据库表
		function initTableList(databaseId){
			if(!window.confirm('进入表资源详细信息？')){
				return ;
			}
			location.href="<%=path%>/resource/tableList.action?databaseId="+databaseId;
		}
		
		//初始化数据库资源
		function initDatabase(databaseId){
					/* var row = $('#tt_dbresult').datagrid('getSelected');
					if(!row){
						jQuery.messager.alert('温馨提示','请选择对应的数据源！');
						return ;
					} */
					
					if(!window.confirm('确定开始初始化数据库资源？')){
						return ;
					}
					
					var param = "vo.databaseId="+ databaseId;
					$.ajax({
							type : 'post',
							url : '<%=path%>/resourceJson/initDatabase.action',
							data : param,
							dataType : 'json',
						    contentType: "application/x-www-form-urlencoded;charset=UTF-8",
							success : function(data) {
								if(data.success)
								{
									refushDatabaseList();
									alert("开始初始化数据库!");
									
								}else{
									alert(data);
								}
							},
							error : function(XMLHttpRequest, textStatus,errorThrown) {
								jQuery.messager.alert(textStatus); 
							}
					});
		}
		
		function refushDatabaseList(){
			 window.location.href="<%=path%>/resource/databaseList.action";
		}
	</script>
</body>
</html>