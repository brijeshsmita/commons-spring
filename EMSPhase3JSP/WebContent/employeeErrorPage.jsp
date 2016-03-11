<%@page isErrorPage="true" %>
<h1 style="color:red">Sorry......Something went wrong!!</h1>
<h3>
<span style="color:red"><%=exception.getMessage() %></span>
</h3>
<hr>
<!-- <a href="05pageContext.jsp">Next</a> -->