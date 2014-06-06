<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html dir="ltr" lang="en-US" xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hugelist Management</title>
<!-- 1140px Grid styles for IE -->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" /><![endif]-->
<!-- The 1140px Grid -->
<link rel="stylesheet" href="<c:url value="/css/1140.css"/>"  type="text/css" media="screen">
<link rel="stylesheet" href="<c:url value="/css/styles.css"/>" type="text/css" media="screen">
<!--css3-mediaqueries-js - http://code.google.com/p/css3-mediaqueries-js/ - Enables media queries in some unsupported browsers-->
<script type="text/javascript" src="<c:url value="/css/css3-mediaqueries.js"/>"></script>
<!-- Fonts -->
<link href="<c:url value="/css/css"/>" rel="stylesheet" type="text/css">
<!-- Scripts -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!-- WYSISYG Editor -->
<script type="text/javascript" src="<c:url value="/css/nicEdit.js"/>"></script>
<!-- Forms Elemets -->
<script type="text/javascript" src="<c:url value="/css/jquery.uniform.min.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/uniform.default.css"/>" type="text/css" media="screen">
<!-- Table sorter -->
<script type="text/javascript" src="<c:url value="/css/jquery.tablesorter.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/css/resizable.tables.js"/>"></script>
<script type="text/javascript" src="<c:url value="/css/custom.js"/>"></script>



<script type="text/javascript">
function initMenu() {
	$.ajax({ 
		type: "get",
		url: '<c:url value="/initMenu"/>',  
		context: document.body,
		dataType: "text",
		success : function(data) {  
			if(data=="true"){
				window.location='<c:url value="/default"/>';		
			} 
	}});
};
</script>
</head>

<body>
	
	<!-- Menu top -->
	<div id="header-wrapper" class="container">
		<div id="user-account" class="row">
			<div class="threecol"></div>
			<div class="ninecol last">				
				<!-- 
				May be using this declare for hyperlink 				
					<c:url var="thisURL" value="homer.jsp">
					  <c:param name="iq" value="${homer.iq}"/>
					  <c:param name="checkAgainst" value="marge simpson"/>
					</c:url>
				-->
				<a href="<c:url value="/logout"/>">Logout</a>
				<span>|</span> 
				<span>Welcome, <strong>${user.userName}!</strong></span>
			</div>
		</div>
		<div id="user-options" class="row">
			<div class="threecol">
				<a href="#">
					<img class="logo" src="<c:url value="/css/images/back-logo.png"/>" style="opacity: 1;"/>
				</a>
			</div>
			<div>
				<ul class="nav-user-options">
					<li ${menu_stt=="statistic"?"class='active'":""}>
						<a href="#">
							<img src="<c:url value="/css/images/icon-graph-white.png"/>"/>&nbsp; Statistics
							<img class="pin" src="<c:url value="/css/images/back-nav-sub-pin.png"/>"/>
						</a>
						<ul>
							<li class="first"><a href="<c:url value='/userSttInfo'/>">User info</a></li>
							<li class="last"><a href="<c:url value='/contractSttInfo'/>">Contract info</a></li>
							<li class="pin"></li>
						</ul>
					</li>
				
						<li ${menu_stt=="classification"?"class='active'":""}>
							<a href="<c:url value='/default'/>">
								<img src="<c:url value="/css/images/icon-list-white.png"/>">&nbsp; Classification
							</a>
						</li>
					
					<c:if test="${fn:toLowerCase(user.userName)  == fn:toLowerCase('admin') }">
						<li ${menu_stt=="edit_manager"?"class='active'":""}>
							<a href="<c:url value='/manager'/>">
								<img src="<c:url value="/css/images/icon-menu-profile.png"/>"/>&nbsp; Manage Users
							</a>
						</li>
					</c:if>
					
					<li>
						<a href="#">
							<img src="<c:url value="/css/images/icon-menu-settings.png"/>" alt="Settings"/> Settings 
							<img class="pin" src="<c:url value="/css/images/back-nav-sub-pin.png"/>"/>
						</a>
						<ul>
							<li class="first"><a href="<c:url value="/changePass"/>">Change password</a></li>														
							<li class="pin"></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- End Menu top -->	
	
	<div class="container">
		<div class="row">
			
			<!-- Left menu -->
			<div id="sidebar" class="threecol">
				<ul id="navigation">
					<li class="first ${menuId==0?'active':''}"><a alt="Create Tab Contract" href="<c:url value='/menu/0'/>">Dashboard<span class="icon-dashboard"></span></a></li>
				
					<c:forEach items="${lstMenu}" varStatus="status" var="lst">					
						<c:if test="${fn:toLowerCase(lst.name)  != fn:toLowerCase('Group list') }">
							
							<li class="${fn:length(lstMenu) == status.count? 'last ' : ''}
									   ${fn:length(lstClass) >0 ? 'sub ':''}
									   ${menuId == lst.id?'active':''}">
									   
								<a href="<c:url value='/menu/'/>${lst.id}">${lst.name}
									<c:if test="${menuId==lst.id && fn:length(lstClass) >0 }">
										<img src="<c:url value="/css/images/back-nav-sub-pin.png"/>" alt=""/>		
									</c:if>		
									<span class="icon-forms"></span>
								</a>
									
								<c:if test="${menuId==lst.id && fn:length(lstClass) >0 }">
									<ul>
										<c:forEach items="${lstClass}" varStatus="statusCls" var="lstCls">
											<li class="${fn:length(lstClass) == statusCls.count? 'last ' : ''}
													   ${currentCls.id == lstCls.id ? 'active':''}
											">
												<span>
													<a href="<c:url value='/menu2/'/>${lst.id}/${lstCls.id}" style="font-size:12px;
																													${currentCls.id == lstCls.id ? 'color: white;font-style:italic;':''}
													">${lstCls.name}</a>
												</span>
											</li>
										</c:forEach>
									</ul>
								</c:if>
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<!-- End Left menu -->
			
			<!-- Main Content -->
			<div id="content" class="ninecol last">
				<div class="panel-wrapper fixed">					
					<jsp:include page="${requestScope.body}" />			
				</div>
			</div>
			<div name="tempDiv" id="tempDiv"></div> 
			<!-- End Main Content -->
		</div>
	</div>
</body>
</html>