<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope['userid'] ne null}">

    <%
        int userid = (int) session.getAttribute("userid");
        System.out.println(userid);
        response.sendRedirect(request.getContextPath()+"/homeServlet?method=gatfang");
    %>
</c:if>
<c:if test="${sessionScope['userid'] eq null}">
    <% response.sendRedirect(request.getContextPath()+"/homeServlet?method=gatfang");%>
</c:if>

<%--<% response.sendRedirect(request.getContextPath()+"/homeServlet?method=gatfang");%>--%>
