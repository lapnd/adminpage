<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>Edit Group</h4>
			<div class="collapse" >collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->	
			<form method="post" action="<c:url value="/UpdateGroup"/>" name="update_form_group">
				<div class="group fixed">
											   <input name="txtGroupId" type="hidden" readOnly="true" value="${edtGroup.id}" onblur="if(value=='') value = '${edtGroup.id}'" onfocus="if(value=='${edtGroup.id}') value = ''">
					<label>Group Name </label> <input name="txtGroupName" type="text" value="${edtGroup.name}" onblur="if(value=='') value = '${edtGroup.name}'" onfocus="if(value=='${edtGroup.name}') value = ''">
				</div>
				
				<div class="group fixed"> 
					<label>Select Manager</label> 
					<select style="opacity: 0;" name="slbManager">
						<option value="null">Select option</option>
						
						<!-- Loop user -->
						<c:forEach items="${managers}" varStatus="status" var="lst">
							<c:if test="${fn:toLowerCase(lst.account.derivaName)  != 'admin'}">
								<option value="${lst.account.AID}" 
									<c:if test="${edtGroup.managerAID==lst.account.AID}">selected</c:if>
								>${lst.account.derivaName}</option>
							</c:if>
						</c:forEach> 
						<!-- End loop -->
					</select>
				</div>
				<div>
					<a href="#openModal" class="button-blue">Update</a>
					<div id="openModal" class="modalDialog">
						<div>
							<a href="#" title="Close" class="close">X</a>
							<h2 style="color:black;">Warning</h2>
							<p style="color:black;font-size: 15px;"><i>Do you want to update group information ?</i></p>
							<div><a href="javascript:document.forms['update_form_group'].submit();" class="button-pink">Update
									<img src="<c:url value='/css/images/icon-star-white.png'/>" alt="">
								 </a>  
								 <a href="#" class="button-blue">Cancel !</a>
							</div>
						</div>
					</div>
					
					<a href="<c:url value='/menu/${menuId}'/>" class="button-white">Back</a>
				</div>
				
			</form>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Tab Panel -->
	<div class="shadow"></div>
</div>

<c:if test="${not empty err_editGrp}">
	<div class="notice error"> 
		<span>
			<strong>Error:</strong> ${err_editGrp}
		</span> 
	</div>
</c:if>



<div class="panel-wrapper">
	<!-- Table Panel -->
	<div class="panel">
		<div class="title">
			<h4>Group - Table</h4>
			<div class="collapse" id="387">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->
			<table id="sample-table-sortable" class="sortable resizable">
				<thead>
					<tr>
						<th style="width: 100px;"></th>
						<th class="header headerSortUp">Group Name</th>
						<th class="header"> Manager Name</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(lstMenu) >0 }">
				 		<c:forEach items="${lstMenu}" varStatus="status" var="lst">							
							<c:if test="${fn:toLowerCase(lst.name)  != fn:toLowerCase('Group list') }">
								<tr ${edtGroup.id==lst.id?"style='background-color: #FAEBD7;'":''}>
									<td>
										<a href="<c:url value="/editgroup/${lst.id}"/>" class="button-white">
											<img src="<c:url value="/css/images/b_edit.png"/>" alt="">
										</a> 
										
										<a href="#openModal${lst.id}" class="button-white">
											<img src="<c:url value="/css/images/b_drop.png"/>" alt="">
										</a>
										<div id="openModal${lst.id}" class="modalDialog">
											<div>
												<a href="#" title="Close" class="close">X</a>
												<h2 style="color:black;">Warning</h2>
												<p style="color:black;font-size: 15px;"><i>If this group is deleted, all classes and class items of this group will be deleted. Do you want to delete this group ?</i></p>
												<div><a href="<c:url value="/deletegroup/${lst.id}"/>" class="button-pink">Delete !
														<img src="<c:url value='/css/images/icon-star-white.png'/>" alt="">
													 </a>  
													 <a href="#" class="button-blue">Cancel</a>
												</div>
											</div>
										</div>
									</td>
									
									<td>${lst.name}</td>
									<td>${lst.managerName}</td>
								</tr>
							</c:if>
						</c:forEach>
				 	</c:if>
				</tbody>
			</table>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Table Panel -->
	<div class="shadow"></div>
</div>