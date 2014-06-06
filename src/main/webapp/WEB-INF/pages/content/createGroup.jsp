<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>Create Group</h4>
			<div class="collapse" >collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->	
			<form method="post" action="<c:url value="/addGroup"/>">
				<div class="group fixed">
					<label>Group Name </label> <input name="txtGroupName" type="text" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''">
				</div>
				
				<div class="group fixed"> 
					<label>Select Manager</label> 
					<select style="opacity: 0;" name="slbManager">
						<option value="null">Select option</option>
						
						<!-- Loop user -->
						<c:forEach items="${managers}" varStatus="status" var="lst">
							<c:if test="${fn:toLowerCase(lst.account.userName)  != 'admin'}">
								<option value="${lst.account.aid}">${lst.account.userName}</option>
							</c:if>
						</c:forEach> 
						<!-- End loop -->
						
					</select>
				</div>
				<div><a href="#" class="button-blue submit">Add Group</a></div>
				
			</form>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Tab Panel -->
	<div class="shadow"></div>
</div>

<c:if test="${not empty err_grp}">
	<div class="notice error"> 
		<span>
			<strong>Error:</strong> ${err_grp}
		</span> 
	</div>
</c:if>

<c:if test="${not empty success_grp}">
	<div class="notice success"> 
		<span>
			<strong>Success:</strong>${success_grp}
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
								<tr>
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
									<td>${lst.accountName}</td>
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