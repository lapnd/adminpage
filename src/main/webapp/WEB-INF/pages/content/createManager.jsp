<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>Create manager</h4>
			<div class="collapse">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->	
			<form method="post" action="<c:url value="/addManager"/>">
				
				<div class="group fixed">
					<label>User Name </label> <input type="text" id="txtName" name="txtName" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''">
				</div>
				<div class="group fixed" style="padding: 0;">
					<label> </label> <label style="width: 80%;">It needs at least 3 characters of (a-z, A-Z, 0-9, _, .)</label>
				</div>
				
				<div class="group fixed">
					<label>Password</label> <input type="password" id="txtPassword" name="txtPassword" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''">
				</div>
				<div class="group fixed" style="padding: 0;">
					<label> </label> <label style="width: 80%;">It needs to contain uppercase letter, lowercase letter, number, and at least 5 characters</label>
				</div>
				
				<div class="group fixed">
					<label>Confirm Password</label> <input type="password" id="txtConfirmPassword" name="txtConfirmPassword" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''">
				</div>
				
				<div class="group fixed"> 
					<label>Group</label> 
					<select name="slbGroups" multiple="yes" size="5" style="width: 300px;background-color: white;">
					  <option value="null">--- no select any group ---</option>
					  <c:forEach items="${lstMenu}" varStatus="status" var="lst">					
						<c:if test="${fn:toLowerCase(lst.name)  != fn:toLowerCase('Group list') }">
							<option value="${lst.id}">${lst.name}</option>
						</c:if>
					  </c:forEach>
					</select>
				</div>
				
				<div><a href="#" class="button-blue submit">Add Manager</a></div>
				
			</form>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Tab Panel -->
	<div class="shadow"></div>
</div>

<c:if test="${not empty err_mg}">
	<div class="notice error"> 
		<span>
			<strong>Error:</strong> ${err_mg}
		</span> 
	</div>
</c:if>

<c:if test="${not empty success_mg}">
	<div class="notice success"> 
		<span>
			<strong>Success:</strong> ${success_mg}
		</span> 
	</div>
</c:if>

<div class="panel-wrapper">
	<!-- Table Panel -->
	<div class="panel">
		<div class="title">
			<h4>Manager - Table</h4>
			<div class="collapse" id="387">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->
			<table id="sample-table-sortable" class="sortable resizable">
				<thead>
					<tr>
						<th style="width: 20%;" class="header"><div style="position:relative;height:100%;width:100%"><div style="position:absolute;height:100%;width:6px;right:-11px;top:0px;cursor:w-resize;z-index:10;"></div></div></th>
						<th class="header headerSortDown" style="width: 40%;"><div style="position:relative;height:100%;width:100%">Manager</div></th>
						<th class="header" style="width: 40%;"><div style="position:relative;height:100%;width:100%"> Group</div></th>
					</tr>
				</thead>
				<tbody>
					
					<c:if test="${fn:length(managers) >0}">
				 		<c:forEach items="${managers}" varStatus="status" var="lst_managers">		
				 			<c:if test="${fn:toLowerCase(lst_managers.account.derivaName)  != 'admin'}">
								<tr>
									<td>
										<a href="<c:url value="/editmanager/${lst_managers.account.AID}"/>" class="button-white">
											<img src="<c:url value="/css/images/b_edit.png"/>" alt="">
										</a> 
										
										<a href="#openModal${lst_managers.account.AID}" class="button-white">
											<img src="<c:url value="/css/images/b_drop.png"/>" alt="">
										</a>
										<div id="openModal${lst_managers.account.AID}" class="modalDialog">
											<div>
												<a href="#" title="Close" class="close">X</a>
												<h2 style="color:black;">Warning</h2>
												<p style="color:black;font-size: 15px;"><i>Do you want to delete this manager ?</i></p>
												<div><a href="<c:url value="/deletemanager/${lst_managers.account.AID}"/>" class="button-pink">Yes, I do!
														<img src="<c:url value='/css/images/icon-star-white.png'/>" alt="">
													 </a>  
													 <a href="#" class="button-blue">Cancel</a>
												</div>
											</div>
										</div>
									</td>
									
									<td>${lst_managers.account.derivaName}</td>
									<td>
										<c:if test="${fn:length(lst_managers.groups) >0}">
											<c:forEach items="${lst_managers.groups}" varStatus="status_groups" var="lst_groups">
												<c:if test="${fn:toLowerCase(lst_groups.name)  != fn:toLowerCase('Group list')}">
													${lst_groups.name},
												</c:if>
											</c:forEach>
										</c:if>
									
									</td>
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