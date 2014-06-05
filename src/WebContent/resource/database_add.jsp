<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<title>资源管理-添加数据库资源</title>
		<meta http-equiv="pragma" content="no-cache">
		<jsp:include page="/common/import_bootstrap.jsp"></jsp:include>

	</head>
	<body>
		<div class="main-container" id="main-container">
		<div class="page-content">
			<table width="100%" border="0" align="center" cellpadding="0"
				class="editgrid" cellspacing="0">
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						业务名称：
					</td>
					<td width="777" height="50" class="td_RT">
						<input value="" size="26" type="text" id="businessName"  name="businessName" class="form-control col-sm-5" maxlength="50" placeholder="请输入数据库资源业务名称"
							style="width: 220px;" />
					</td>
				</tr>
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						数据库类型：
					</td>
					<td width="777" height="50" class="td_RT">
						<select 	style="width: 220px;" id="dbType"  class="form-control">
							<option value="mysql_v5">MySQL 5.0</option>
							<option value="oracle_11g">Oracle11g</option>
							<option value="db2_v9">DB2 V9</option>
							<option value="mssqlserver_v2005">SQL Server 2005</option>
						</select> 
					</td>
				</tr>
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						数据库服务器地址：
					</td>
					<td width="777" height="50" class="td_RT">
						<input value="" size="26" type="text" id="serverAddress"
							name="serverAddress" maxlength="50"  class="form-control"
							style="width: 220px;"  placeholder="请填写服务器IP地址"/> 
					</td>
				</tr>
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						数据库服务器端口：
					</td>
					<td width="777" height="50" class="td_RT">
						<input value="" size="26" type="text" id="serverPort"
							name="serverPort" maxlength="50"  class="form-control" 
							style="width: 220px;" /> 
					</td>
				</tr>
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						连接用户：
					</td>
					<td width="777" height="50" class="td_RT">
						<input value="" size="26" type="text" id="userName"
							name="userName" maxlength="50"  class="form-control" 
							style="width: 220px;" /> 
					</td>
				</tr>
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						连接密码：
					</td>
					<td width="777" height="50" class="td_RT">
						<input value="" size="26" type="text" id="userPassword"
							name="userPassword" maxlength="50" 	 class="form-control" 
							style="width: 220px;" /> 
					</td>
				</tr>
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						数据库名称：
					</td>
					<td width="777" height="50" class="td_RT">
						<input value="" size="26" type="text" id="dbName"
							name="dbName" maxlength="50"  class="form-control" 
							style="width: 220px;" /> 
					</td>
				</tr>
				<tr>
					<td width="360" height="50" align="right" class="td_LT">
						数据库描述：
					</td>
					<td width="777" height="50" class="td_RT">
						<textarea rows="4" cols="40" name="dbRemark" id="dbRemark" style="width: 220px;"  class="form-control" ></textarea>
					</td>
				</tr>
			</table>
		</div>
		<script type="text/javascript">
		
			     var DG = frameElement.lhgDG; 
				 DG.addBtn( 'save', '保存', savemoduleject ); 
			
			     //初始化信息
				 function savemoduleject()
				 {
				 	var businessName =  $("#businessName").val();
				 	var dbType = $("#dbType").val();
				 	var serverAddress =  $("#serverAddress").val();
				 	var serverPort =  $("#serverPort").val();
				 	var userName =  $("#userName").val();
				 	var userPassword =  $("#userPassword").val();
				 	var dbName =  $("#dbName").val();
				 	var dbRemark =  $("#dbRemark").val();
				 	
				 
				 	
				 	if(businessName == ""){
				 		alert("业务名称不能为空,请输入!");
				 		return ;
				 	} 
				 	if(serverAddress == ""){
				 		alert("数据库服务器地址不能为空,请输入!");
				 		return ;
				 	}
				 	if(serverPort == ""){
				 		alert("数据库服务器端口不能为空,请输入!");
				 		return ;
				 	}
				 	if(userName == ""){
				 		alert("连接用户不能为空,请输入!");
				 		return ;
				 	}
				 	if(userPassword == ""){
				 		alert("连接密码不能为空,请输入!");
				 		return ;
				 	} 
				 	if(dbName == ""){
				 		alert("数据库名称不能为空,请输入!");
				 		return ;
				 	} 
				 	 
				 	
				    var param = "vo.businessName="+businessName+"&vo.dbType="+dbType;
				    		param+="&vo.serverAddress="+serverAddress+"&vo.serverPort=" + serverPort;
				    		param+="&vo.userName="+userName+"&vo.userPassword="+userPassword;
				    		param+="&vo.dbName="+dbName+"&vo.dbRemark="+dbRemark;
				 	
				 	 $.ajax( {
						type : 'post',
						url : '<%=path%>/resourceJson/saveDatabase.action',
						data : param,
						dataType : 'json',
					    contentType: "application/x-www-form-urlencoded;charset=UTF-8",
						success : function(data) {
							if(data.success)
							{
								DG.cancel();
								alert("温馨提示","保存数据库信息成功!");
								DG.curWin.refushDatabaseList();
							}else
							{
								alert(data);
							}
						},
						error : function(XMLHttpRequest, textStatus,errorThrown) {
							alert(textStatus); 
						}
					});
				 }
		</script>
		</div>
		
		
	</body>
</html>
