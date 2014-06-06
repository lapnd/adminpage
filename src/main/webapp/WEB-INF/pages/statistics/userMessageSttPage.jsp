<%@page import="com.hugelist.client.entities.Classification2"%>
<%@page import="com.hugelist.client.entities.ItemTypeEnum"%>
<%@page import="com.hugelist.client.entities.ClassItemWValue"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Chart -->
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="<c:url value="/css/js/attc.googleCharts.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/AttC-css/attc.css"/>">	
<!-- End Chart -->

<!-- paging -->
    <script src="<c:url value="/css/js/smartpaginator.js"/>" type="text/javascript"></script>
    <link href="<c:url value="/css/smartpaginator.css"/>" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        $(document).ready(function () {
            $('#green').smartpaginator({ totalrecords: '${sizeOfItemStt}', recordsperpage: 10, datacontainer: 'AttendancePercentages', dataelement: 'tr', initval: 0, next: 'Next', prev: 'Prev', first: 'First', last: 'Last', theme: 'green' });
        	
            $("#slMonth").change(function() {
				//debugger;
				var link = '<c:url value="/showMessageUserStt"/>';
				var aid = $("#slMonth").attr('aid');
				var name = '${nameStt}';
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
        
        });
    </script>
<!-- end paging -->

<div class="panel-wrapper">
	<!-- Tab Panel -->
	<div class="panel">
		<div class="title">
			<h4>${nameStt} message info &nbsp;&nbsp;
			    
				<select id="slYear">
					<c:if test="${fn:length(yearStt) >0 }">
						<c:forEach items="${yearStt}" varStatus="statusYearStt" var="itYear">
							<option value="${itYear}" ${itYear==varYearStt?"selected":''}">
								${itYear}
							</option>	
						</c:forEach>
					</c:if>
				</select> 
				<select id="slMonth" aid="${varID}">
					<option value="-1" ${varMonthStt=='-1'?"selected":""}>All</option>
					<c:if test="${fn:length(monthStt) >0 }">
						<c:forEach items="${monthStt}" begin="0" end="${fn:length(monthStt)}" varStatus="statusMonthStt" var="itMonth">
							<option value="${statusMonthStt.index}" ${statusMonthStt.index==varMonthStt?"selected":""}>
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
			<table  id="AttendancePercentages" 
		    		data-attc-createChart="true"
		    		data-attc-colDescription="pieDescription" 
		    		data-attc-colValues="areaSend,areaReceive" 
		    		data-attc-location="AttendancePercentagesPie" 
		    		data-attc-hideTable="false" 
		    		data-attc-type="area"
		    		data-attc-googleOptions='{"is3D":true}'
		    		data-attc-controls='{"showHide":false,"create":false,"chartType":false}'>
			<thead>
				<tr>
					<th id="pieDescription">${varMonthStt=='-1'?'Month':'Day'}</th>
					<th id="areaSend">Sent Messages</th>
					<th id="areaReceive">Received Messages</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${fn:length(lstItemStt) >0 }">
				<c:forEach items="${lstItemStt}" varStatus="statusUserMessStt" var="itemUserMessage">
					<tr>
						<td><fmt:formatDate pattern="${varMonthStt=='-1'?'MM, yyyy':'MM/dd, yyyy'}" value="${itemUserMessage.date}" /></td>
						<td>${itemUserMessage.sentNo}</td>
						<td>${itemUserMessage.receivedNo}</td>
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

<div class="panel-wrapper">
	<!-- Table Panel -->
	<div class="panel">
		<div class="title">
			<h4>Statistic</h4>
			<div class="collapse" id="387">collapse</div>
		</div>
		<div class="content">
			<!-- ## Panel Content  -->
			<div id="AttendancePercentagesPie"></div>
			<!-- ## / Panel Content  -->
		</div>
	</div>
	<!-- End Table Panel -->
	<div class="shadow"></div>
</div>

