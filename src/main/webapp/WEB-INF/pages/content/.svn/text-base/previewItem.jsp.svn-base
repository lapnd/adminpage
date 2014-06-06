<%@page import="com.hugelist.client.entities.Classification2"%>
<%@page import="com.hugelist.client.entities.ClassItemWValue"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="panel-wrapper">
	<div class="panel">
		<div class="tabs">
			<ul>
				<li class="last active"><a href="#" rel="tab-01-content">Preview ${currentCls.name} - Item Table</a></li>
			</ul>
			<div class="collapse">collapse</div>
		</div>
		
		<div class="tabs-content">
			<!-- ## Panel Content  -->
			<div id="tab-01-content" class="active">
				<form method="post" action="">
				
					<% 
					Classification2 lstClass = (Classification2) session.getAttribute("currentCls");
					List<ClassItemWValue> lstItem = (List<ClassItemWValue>) lstClass.getItems();
					if(lstItem.size() >0){
						
						ClassItemWValue item = null;
						for(int i=0;i<lstItem.size();i++){
							item = lstItem.get(i);
							if(item.getTypeName().toLowerCase().equals("value")){
							%>
								<div class="group fixed">
									<label style="color: black;"><%=item.getName() %> :</label> <input type="text" style="width: 200px;margin-right: 15px;">
									<label style="width: 250px;"><%=item.getValueUnit() %></label>
								</div>
							<%
							}else if(item.getTypeName().toLowerCase().equals("description")){
							%>
								<div class="group fixed">
									<label style="color: black;"><%=item.getName() %></label>
								</div>
							<%
							}else if(item.getTypeName().toLowerCase().equals("radio")){
							%>
								<div class="inline"> 
									<input type="radio"> 
									<label style="color: black;"><%=item.getName() %></label> 
								</div>
							<%
							}else if(item.getTypeName().toLowerCase().equals("other")){
							%>
								<div class="inline">
									<label style="margin-right: 60px;
			    								  vertical-align: top;color: black;"><%=item.getName() %>:</label>
									<textarea rows="3" cols="26"></textarea>
								</div>
							<%
							}else if(item.getTypeName().toLowerCase().equals("check box")){
							%>
								<div class="inline"> 
									<input type="checkbox"> 
									<label style="color: black;"><%=item.getName() %></label> 
								</div>
							<%
							}
						}
					}
					%>
					<c:if test="${not empty preview_crud}">
						<c:if test="${preview_crud=='true'}">
							<div>
								<a href="<c:url value="/${p_command}"/>" class="button-blue">Save</a>
								<a href="<c:url value="/menu2/${menuId}/${currentCls.id}"/>" class="button-blue">Cancel</a>
							</div>
						</c:if>
						
					</c:if>
				</form>
			</div>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<div class="shadow"></div>
</div>