<%@page import="com.hugelist.client.entities.Classification2"%>
<%@page import="com.hugelist.client.entities.ItemTypeEnum"%>
<%@page import="com.hugelist.client.entities.ClassItemWValue"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Chart 
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="<c:url value="/css/js/attc.googleCharts.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/AttC-css/attc.css"/>">	
End Chart -->

<!-- paging -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="<c:url value="/css/js/smartpaginator.js"/>"
	type="text/javascript"></script>
<link href="<c:url value="/css/smartpaginator.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {
					$('#green').smartpaginator({
						totalrecords : '${sizeOfItemStt}',
						recordsperpage : 10,
						datacontainer : 'AttendancePercentages',
						dataelement : 'tr',
						initval : 0,
						next : 'Next',
						prev : 'Prev',
						first : 'First',
						last : 'Last',
						theme : 'green'
					});
					
					$("#slMonth").change(function() {
						//debugger;
						var link = '<c:url value="/userParamsSttInfo"/>';
						var year = $("#slYear").val();
						var month = $("#slMonth").val();
						$.ajax({
							type : "post",
							url : link,
							data : {
								"year" : year,
								"month" : month
							},
							success : function(data) {
								if (data == 'success')
									window.location = '<c:url value="/userRSttInfo"/>';
							}
						});
					});
					
					$("#AttendancePercentages a")
					.click(function(e) {
						//debugger;
						var link = '<c:url value="/showMessageUserStt"/>';
						var aid = $(this).attr('aid');
						var name = $(this).text();
						var year = $("#slYear").val();
						var month = $("#slMonth").val();
						$.ajax({
							type : "post",
							url : link,
							data : {
								"aid" : aid,
								"year" : year,
								"month" : month,
								"name" : name
							},
							success : function(data) {
								if (data == 'success')
									window.location = '<c:url value="/usermessagestt"/>';
							}
						});
					});
				
/*
					$("#datetype").change(function() {
						var datetype = $("#datetype").val();
						var $select = $('#mydate').empty();

						$.ajax({
							type : "post",
							url : '<c:url value="/getTypeDataC"/>',
							data : {
								"type" : datetype
							},
							success : function(data) {
								if (data != null
										&& data.length > 0) {
									$('#mydate')
											.show();

									if (datetype == 'month') {
										for ( var i = 0; i < data.length; i++) {
											var o = $(
													'<option/>',
													{
														value : i
													})
													.text(
															data[i])
													.prop(
															'selected',
															i == 0);
											o
													.appendTo($select);
										}
									} else if (datetype == 'year') {
										for ( var i = 0; i < data.length; i++) {
											var o = $(
													'<option/>',
													{
														value : data[i]
													})
													.text(
															data[i])
													.prop(
															'selected',
															i == 0);
											o
													.appendTo($select);
										}
									}
								} else {
									$('#mydate')
											.hide();
								}
							}
						});
					});

					$("#mydate").change(function() {
						var datetype = $("#datetype").val();
						var mydate = $("#mydate").val();

						$.ajax({
							type : "post",
							url : '<c:url value="/getContentChart"/>',
							data : {
								"type" : datetype,
								"dateValue" : mydate
							},
							success : function(data) {
								("#chart_content").load("<c:url value='/statistic'/>")
							}
						});
					});
*/
});
</script>
<!-- end paging -->

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>
				User info &nbsp;&nbsp; 
				<select id="slYear">
					<c:if test="${fn:length(yearStt) >0 }">
						<c:forEach items="${yearStt}" varStatus="statusYearStt" var="itYear">
							<option value="${itYear}" ${itYear==varYearStt?"selected":''}">
								${itYear}
							</option>	
						</c:forEach>
					</c:if>
				</select> 
				<select id="slMonth">
					<option value="-1" ${varMonthStt=='-1'?"selected":""}>All</option>
					<c:if test="${fn:length(monthStt) >0 }">
						<c:forEach items="${monthStt}" begin="0" end="${fn:length(monthStt)}" varStatus="statusMonthStt" var="itMonth">
							<option value="${statusMonthStt.index}" ${statusMonthStt.index==varMonthStt?"selected":''}>
								${itMonth}
							</option>	
						</c:forEach>
					</c:if>
				</select>
			</h4>
			<div class="collapse">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->
			<table id="AttendancePercentages" class="sortable resizable">
				<thead>
					<tr>
						<th></th>
						<th class="header">Total Downloaded</th>
						<th class="header">Total Uploaded</th>
						<th class="header">Total Sent message</th>
						<th class="header">Total recieved message</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(lstItemStt) >0 }">
						<c:forEach items="${lstItemStt}" varStatus="statusUserStt" var="lstUsers">
							<tr>
								<td><a aid="${lstUsers.AID}" href="JavaScript:void(0);">
										${lstUsers.derivaName}</a></td>
								<td>${lstUsers.totalDownloaded}</td>
								<td>${lstUsers.totalUploaded}</td>
								<td>${lstUsers.sentMessages}</td>
								<td>${lstUsers.receivedMessages}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<div id="green" style="margin: auto;"></div>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Tab Panel -->
	<div class="shadow"></div>
</div>

<!-- 
<div class="panel-wrapper">
	<!-- Table Panel 
	<div class="panel">
		<div class="title">
			<h4>Statistic</h4>
			<div class="collapse" id="387">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  
			<c:choose>
				<c:when test="${not empty chr_mess}">
					<div id="chart_content">
						<b>${chr_mess}</b>
					</div>
				</c:when>

				<c:otherwise>
					<b>Default content.</b>
				</c:otherwise>
			</c:choose>

			<!-- ## / Panel Content  
		</div>
	</div>
	<!-- End Table Panel 
	<div class="shadow"></div>
</div>
 -->
