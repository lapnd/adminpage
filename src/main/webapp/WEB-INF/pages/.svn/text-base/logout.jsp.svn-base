<%@page import="java.util.Collections"%>

<%
for (Object name : Collections.list(session.getAttributeNames())) {
    session.removeAttribute((String)name);
}

response.sendRedirect("/dtweb/login");
%>
