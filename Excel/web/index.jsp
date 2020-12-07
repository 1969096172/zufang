<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.li.ers.model.User" %>

<c:if test="${sessionScope['userid'] ne null}">

  <%
    int userid = (int) session.getAttribute("userid");
    System.out.println(userid);
    response.sendRedirect(request.getContextPath()+"/homeServlet?method=getgoods&userid="+userid);
  %>
</c:if>
<c:if test="${sessionScope['userid'] eq null}">
  <% response.sendRedirect(request.getContextPath()+"/homeServlet?method=getgoods");%>
</c:if>
