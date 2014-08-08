<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
							 var dg = new J.dialog({ id:'regDatabase',title:'请输入数据库信息',iconTitle:false,width:680,height:490,cover:true, page:'<%=path%>/res/database/initAddDatabase.do'}); 
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
							<c:forEach items="${databaseList }" var="db">
								<tr>
									<td class="center"><label> <input type="checkbox"
											class="ace" id="${db.databaseId }" /> <span
											class="lbl"> </span>
									</label></td>

									<td>${db.businessName }</td>
									<td>${db.dbType }</td>
									<td>${db.dbName }</td>
									<td>${db.userName }</td>
									<td>${db.serverAddress }</td>
									<td>${db.serverPort }</td>
									<td class="hidden-480">
											${db.tableCount }
									</td>
									<td>${db.dbCharset }</td>

									<td class="hidden-480">
									  <c:choose>
									  	<c:when test="${db.dbStatus==4 }">
									  		<font color='red'>${db.errorMsg }</font>
									  	</c:when>
									  	<c:otherwise>
									  	   ${db.dbRemark }
									  	</c:otherwise>
									  </c:choose>
									<td>
									  <c:choose>
									  	<c:when test="${db.dbStatus==1 }">
									  		<i class="icon-spinner icon-spin orange bigger-125"></i>
									  	</c:when>
									  	<c:when test="${db.dbStatus==4 }">
									  		<button class="btn btn-xs btn-danger"
												onclick="initDatabase(${db.databaseId})">
												<i class="icon-retweet bigger-120"></i>
											</button>
									  	</c:when>
									  	<c:otherwise>
									  	   <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
												<button class="btn btn-xs btn-info"
													onclick="initDatabase(${db.databaseId})">
													<i class="icon-cogs bigger-120"></i>
												</button>
												<button class="btn btn-xs btn-warning"
													onclick="initTableList(${db.databaseId})">
													<i class="icon-calendar bigger-120"></i>
												</button>
											</div>
									  	</c:otherwise>
									  </c:choose>
									</td>
								</tr>
							</c:forEach>

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
			location.href="<%=path%>/res/table/tableList.do?databaseId="+databaseId;
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
			 window.location.href="<%=path%>/res/database/databaseList.do";
		}
	</script>
</body>
</html>