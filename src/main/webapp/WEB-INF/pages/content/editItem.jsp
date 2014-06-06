<%@page import="com.hugelist.client.entities.Classification2"%>
<%@page import="com.hugelist.client.entities.ItemTypeEnum"%>
<%@page import="com.hugelist.client.entities.ClassItemWValue"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
function showField() { 
   var x=document.getElementById("slbType");
   if(x.value == 3)
   		document.getElementById("overlay").style.display="block";
   else
   		document.getElementById("overlay").style.display="none";

}

function submitForm(commad){
	document.getElementById('txtCommad').value = commad;
	document.forms['edit_form_item'].submit();
}
</script>

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>Edit Item</h4>
			<div class="collapse">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->
			<form method="post" action="<c:url value="/updateItem"/>" name="edit_form_item">
				<div class="group fixed">
					<label>Item Name </label> 
											 <input type="text" value="${edtItem.name}"
													 onblur="if(value=='') value = '${edtItem.name}'"
													 onfocus="if(value=='${edtItem.name}') value = ''"
													 id="txtItemName" 
													 name="txtItemName">
											  <input type="hidden" 
													 value=""
													 id="txtCommad" 
													 name="txtCommad">
											  <input name="txtItemId" 
											  		 type="hidden" 
											  		 readOnly="true" 
											  		 value="${edtItem.id}" 
											  		 onblur="if(value=='') value = '${edtItem.id}'" 
											  		 onfocus="if(value=='${edtItem.id}') value = ''">
				</div>

				<div class="group fixed">
					<label>Item Type</label>
					<select style="opacity: 0;" onchange="showField()" name="slbType" id="slbType">
						<option value="null">Select option</option>
						<!-- Loop user -->
						<% 
						ClassItemWValue edt_item = null;
						boolean isEdit = false;
						if(session.getAttribute("edtItem")!=null)
							edt_item = (ClassItemWValue) session.getAttribute("edtItem");
						
						for (ItemTypeEnum i : ItemTypeEnum.values()){
						%>
							<option value="<%=i.getId()%>" 
							
								<% 
									if(edt_item!=null){
										if(edt_item.getTypeName().equals(i.getValue())){
											if(edt_item.getTypeId()==3)
												isEdit = true;
								%>
											selected
								<%
										}
									}
								%> 
							>
							<%=i.getValue()%></option>
						<%	
						}
						%>
						<!-- End loop -->
					</select>
				</div>
				
				<div class="group fixed" id="overlay"  
					<%
						if(!isEdit || edt_item==null){
							%>
								style="display:none;"
							<%	
						}
					%>
				>
					<label>Description</label> <input type="text" 
													  id="txtDescript" 
													  name="txtDescript" 
													  value="${edtItem.valueUnit}"
													  onblur="if(value=='') value = '${edtItem.valueUnit}'"
													  onfocus="if(value=='${edtItem.valueUnit}') value = ''">
				</div>
				
				<div>
					<a href="#openModal" class="button-blue">Update</a>  
					<a href="<c:url value="/menu2/${menuId}/${currentCls.id}"/>" class="button-white">Back</a>
					<div id="openModal" class="modalDialog">
						<div>
							<a href="#" title="Close" class="close">X</a>
							<h2>Warning</h2>
							<p style="color:black;font-size: 15px;"><i>Do you want to preview form data before saving?</i></p>
							<div><a href="javascript:submitForm('preview')" class="button-pink">Preview
									<img src="<c:url value='/css/images/icon-star-white.png'/>" alt="">
								 </a>  
								 <a href="javascript:submitForm('add')" class="button-blue">Saving without preview !</a>
							</div>
						</div>
					</div>
				</div>

			</form>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Tab Panel -->
	<div class="shadow"></div>
</div>

<c:if test="${not empty err_item}">
	<div class="notice error"> 
		<span>
			<strong>Error:</strong> ${err_item}
		</span> 
	</div>
</c:if>


<div class="panel-wrapper">
	<!-- Table Panel -->
	<div class="panel">
		<div class="title">
			<h4>${currentCls.name} - Item Table &nbsp;&nbsp;<a href="<c:url value='/preview'/>">Preview Items</a></h4>
			<div class="collapse" id="387">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->
			<table id="sample-table-sortable" class="sortable resizable">
				<thead>
					<tr>
						<th style="width: 114px;" class="header headerSortUp"></th>
						<th class="header" style="width: 150px;">Item Name</th>
						<th class="header" style="width: 150px;">Item Type</th>
						<th class="header" style="width: 150px;">Decription (for value type)</th>
					</tr>
				</thead>
				<tbody>
				<% 
					Classification2 lstClass = (Classification2) session.getAttribute("currentCls");
					List<ClassItemWValue> lstItem = (List<ClassItemWValue>) lstClass.getItems();
					if(lstItem.size() >0){
						for(int i=0;i<lstItem.size();i++){
				%>
							<tr 
								<% 
									if(edt_item!=null && lstItem.get(i).getId() == edt_item.getId()){
								%>
									style='background-color: #FAEBD7;'
								<%
									}
								%>
							>
								<td>
									<a href="<c:url value='/editItem/'/><%=lstItem.get(i).getId() %>" class="button-white"> <img
											src="<c:url value="/css/images/b_edit.png"/>" alt="">
									</a> 
									<a href="#openModal<%=lstItem.get(i).getId() %>" class="button-white"> <img
											src="<c:url value="/css/images/b_drop.png"/>" alt="">
									</a>
								</td>
		
								<td><%=lstItem.get(i).getName() %></td>
								<td><%=lstItem.get(i).getTypeName() %></td>
								<td><%=lstItem.get(i).getValueUnit() %></td>
							</tr>
							<div id="openModal<%=lstItem.get(i).getId() %>" class="modalDialog">
								<div>
									<a href="#" title="Close" class="close">X</a>
									<h2 style="color:black;">Warning</h2>
									<p style="color:black;font-size: 15px;"><i>Do you want to delete this item ?</i></p>
									<div>
										 <a href="<c:url value='/deleteItem/p/'/><%=lstItem.get(i).getId() %>" class="button-pink">Preview
											<img src="<c:url value='/css/images/icon-star-white.png'/>" alt="">
										 </a>  
										 <a href="<c:url value='/deleteItem/wp/'/><%=lstItem.get(i).getId() %>" class="button-blue">Delete without preview!
											<img src="<c:url value='/css/images/icon-star-white.png'/>" alt="">
										 </a>  
									</div>
								</div>
							</div>
			 		
		 		<% 
						}
					}
		 		%>
				</tbody>
			</table>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Table Panel -->
	<div class="shadow"></div>
</div>

