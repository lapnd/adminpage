<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>Classification</h4>
			<div class="collapse">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->	
			<form method="post" action="<c:url value="/addClass"/>">
				<div class="group fixed">
					<label>Classification Name</label> <input name="txtClassName" type="text" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''" style="width: 50%;margin-right: 10px;">
					<a href="#" class="button-blue submit">Add Classification</a>
				</div>
			</form>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Tab Panel -->
	<div class="shadow"></div>
</div>

<c:if test="${not empty err_cls}">
	<div class="notice error"> 
		<span>
			<strong>Error:</strong> ${err_cls}
		</span> 
	</div>
</c:if>

<c:if test="${not empty success_cls}">
	<div class="notice success"> 
		<span>
			<strong>Success:</strong> ${success_cls}
		</span> 
	</div>
</c:if>

<div class="panel-wrapper">
	<!-- Table Panel -->
	<div class="panel">
		<div class="title">
			<h4>${menuName} - Classification Table</h4>
			<div class="collapse">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->
			<table id="sample-table-sortable" class="sortable resizable">
				<thead>
					<tr>
						<th class="header headerSortUp" style="width: 332px;"></th>
						<th class="header" style="width: 350px;">Classification Name</th>
					</tr>
				</thead>
				
				<tbody>
				 	<c:if test="${fn:length(lstClass) >0 }">
				 		<c:forEach items="${lstClass}" varStatus="statusCls" var="lstCls">
						 	<tr>
								<td>
									<a href="<c:url value="/editClass/${lstCls.id}"/>" class="button-white"> Edit Class
										<img src="<c:url value="/css/images/b_edit.png"/>" alt="">
									</a>
									<a href="<c:url value="/menu2/${menuId}/${lstCls.id}"/>" class="button-white"> Edit Items
										<img src="<c:url value="/css/images/b_edit.png"/>" alt="">
									</a>
									<a href="#openModal${lstCls.id}" class="button-white"> Del Class
										<img src="<c:url value="/css/images/b_drop.png"/>" alt="">
									</a>
									<div id="openModal${lstCls.id}" class="modalDialog">
										<div>
											<a href="#" title="Close" class="close">X</a>
											<h2 style="color:black;">Warning</h2>
											<p style="color:black;font-size: 15px;"><i>If this class is deleted, all class items of this class will be deleted. Do you want to delete this class ?</i></p>
											<div><a href="<c:url value="/deleteClass/${lstCls.id}"/>" class="button-pink">Delete !
													<img src="<c:url value='/css/images/icon-star-white.png'/>" alt="">
												 </a>  
												 <a href="#" class="button-blue">Cancel</a>
											</div>
										</div>
									</div>
								</td>
								<td>${lstCls.name}</td>
							</tr>
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