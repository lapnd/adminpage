<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>Change Password</h4>
			<div class="collapse" id="780.777777671814">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->	
			<form method="post" action="<c:url value="/changePassword"/>">
				<div class="group fixed">
					<label>Old Password </label> <input id="oldPass" name="oldPass" type="password" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''">
				</div>

				<div class="group fixed">
					<label>New Password </label> <input id="newPass1" name="newPass1" type="password" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''">
				</div>
				<div class="group fixed" style="padding: 0;">
					<label> </label> <label style="width: 80%;">It needs to contain uppercase letter, lowercase letter, number, and at least 5 characters</label>
				</div>
				<div class="group fixed">
					<label>Confirm New Password </label> <input id="newPass2" name="newPass2" type="password" value="..." onblur="if(value=='') value = '...'" onfocus="if(value=='...') value = ''">
				</div>
				<div><a href="#" class="button-blue submit">Save</a></div>				
			</form>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Tab Panel -->
	<div class="shadow"></div>
</div>	
<c:choose>
	<c:when test="${not empty err_name && err_name != 'Success'}">
		<div class="notice error"> 
			<span>
				<strong>Error:</strong> ${err_name}
			</span> 
		</div>
	</c:when>
	<c:when test="${err_name == 'Success'}">
		<div class="notice success"> 
			<span>
				<strong>Success:</strong> Change password successfully!
			</span> 
		</div>
	</c:when>
</c:choose>