<%-- 
    Document   : logout
    Created on : 3 Apr, 2014, 5:47:14 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    //  System.out.print( session.getAttribute("name1"));
    
    response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility

    session.invalidate();
    response.sendRedirect("index.jsp");
  
%>




