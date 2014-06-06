<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
	<title>Deriva Trust Management</title>
	<link rel="stylesheet" href="<c:url value="/css/login-style.css"/>" type="text/css" media="screen, projection" />
	
</head>
<body>
	<form action="<c:url value="/login"/>" method="post">
	    <div class="outer-wrapper">
			<!--Top-->
	        <div id="topContent"></div>    
	        <!--End Top-->
		
			<div class="clear" />			
			<div id="grayLine"></div>			
			<div class="clear" />
			
			<!-- Login -->
			<div id="loginPanel">
				<div id="content">
					<table>
						<tr>
							<td>
								<c:if test="${not empty err_name}">
								   <span class="error">*</span>
								</c:if>
							</td>
							<td class="lbLogin">user name</td>
							<td><input type="text" name="username" id="username" class="txtInput"></td>
							<td></td>
						</tr>
						<tr>
							<td>
								<c:if test="${not empty err_pwd}">
								   <span class="error">*</span>
								</c:if>
							 </td>
							<td class="lbLogin">password</td>
							<td><input type="password" name="pwd" id="pwd" class="txtInput"></td>
							<td>
								<input type="submit" value=" Go " id="btLogin">
							</td>
						</tr>
						
						<!-- Error messages -->
						<tr>
							<td class="lbLogin" colspan="4">${err_name}</td>
						</tr>
						
						<tr>
							<td class="lbLogin" colspan="4">${err_pwd}</td>
						</tr>
						<!-- End error messages -->			
					</table>
				</div>
			</div>
			<!-- End Login -->
			
			<div class="clear" />
			
			<!-- Bottom -->
			<div id="botContent"></div>
			<!-- End Bottom -->
			
			
		</div>
	</form>
</body>

</html>