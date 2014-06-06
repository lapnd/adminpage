<%@page import="com.hugelist.entities.Manager"%>
<%@page import="com.hugelist.client.entities.WManager"%>
<%@page import="com.hugelist.services.ManagerServiceWeb"%>
<%@page import="com.hugelist.entities.Category"%>
<%@page import="com.hugelist.utils.Common"%>
<%@page import="java.util.List"%>

<%
	Manager user = (Manager) session.getAttribute("user");
	if (user == null)
		response.sendRedirect("/hlstatistics/login");

	List<Category> lstMenu = ManagerServiceWeb.getInstance()
			.getCategoriesByAID(user.getAid(), user.getToken());
	session.setAttribute("lstMenu", lstMenu);

	if (user.getIsAdmin()) {
		if (session.getAttribute(Common.MANAGER_LIST) == null) {

			List<WManager> managers = ManagerServiceWeb
					.getInstance()
					.getManagerWithGroup(user.getAid(), user.getToken());
			
			if (managers.size()>0) {
				session.setAttribute(Common.MANAGER_LIST,managers);
			}
		}
		request.setAttribute("body",
				"/WEB-INF/pages/content/createGroup.jsp");
	} else {
		if (lstMenu.size() > 0)
			response.sendRedirect("/hlstatistics/menu/"
					+ lstMenu.get(0).getId());
		else
			response.sendRedirect("/hlstatistics/changePass");
	}
%>

<jsp:include page="/WEB-INF/pages/template/dt-template.jsp" />