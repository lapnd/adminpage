<%@page import="com.hugelist.client.entities.Classification2"%>
<%@page import="com.hugelist.client.entities.ItemTypeEnum"%>
<%@page import="com.hugelist.client.entities.ClassItemWValue"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
						var link = '<c:url value="/contractParamsSttInfo"/>';
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
									window.location = '<c:url value="/contractRSttInfo"/>';
							}
						});
					});
					
					$("#AttendancePercentages a")
					.click(function() {
						//debugger;
						var link = '<c:url value="/showContractStt"/>';
						var cid = $(this).attr('cid');
						var name = $(this).text();
						var year = $("#slYear").val();
						var month = $("#slMonth").val();
						$.ajax({
							type : "post",
							url : link,
							data : {
								"cid" : cid,
								"year" : year,
								"month" : month,
								"name" : name
							},
							success : function(data) {
								if (data == 'success')
									window.location = '<c:url value="/contractddetailstt"/>';
								else
									window.location = '<c:url value="/logout"/>';
							}
						});
					});
					
					$("#AttendancePercentages a[dwid]").click(function() {
						var link = '<c:url value="/showContractStt"/>';
						var cid = $(this).attr('dwid');
						var name = $(this).attr('dwtitle');
						var year = $("#slYear").val();
						var month = $("#slMonth").val();
						$.ajax({
							type : "post",
							url : link,
							data : {
								"cid" : cid,
								"year" : year,
								"month" : month,
								"name" : name
							},
							success : function(data) {
								if (data == 'success')
									window.location = '<c:url value="/contractddetailstt"/>';
								else
									window.location = '<c:url value="/logout"/>';
							}
						});
					});
					
					$("#AttendancePercentages a[msid]").click(function() {
						var link = '<c:url value="/showMessageContractStt"/>';
						var cid = $(this).attr('msid');
						var name = $(this).attr('dwtitle');
						var year = $("#slYear").val();
						var month = $("#slMonth").val();
						$.ajax({
							type : "post",
							url : link,
							data : {
								"cid" : cid,
								"year" : year,
								"month" : month,
								"name" : name
							},
							success : function(data) {
								if (data == 'success')
									window.location = '<c:url value="/contractmdetailstt"/>';
								else
									window.location = '<c:url value="/logout"/>';
							}
						});
					});
});
</script>
<!-- end paging -->

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>
				Contract info &nbsp;&nbsp; 
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
						<th class="header">Total Download</th>
						<th class="header">Total Message</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(lstItemStt) >0 }">
						<c:forEach items="${lstItemStt}" varStatus="statusContractStt" var="itContract">
							<tr>
								<td><a cid="${itContract.CID}" href="JavaScript:void(0);">
										${itContract.title}</a></td>
								<td>
									<a dwid="${itContract.CID}" dwtitle="${itContract.title}" href="JavaScript:void(0);">
										${itContract.noDownload}
									</a>
								</td>
									
								<td>
									<a msid="${itContract.CID}" dwtitle="${itContract.title}" href="JavaScript:void(0);">
										${itContract.noMessage}
									</a>
								</td>
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
