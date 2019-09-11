
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP file</title>
</head>
<body>
<h2>From JSP file</h2>
<h6>You can write java code here</h6>
<%
	int k =12;
	out.println("Java code inside the JSP file");
%>
<br>This is inside the body : <%=1+2 %>

<!-- declaration tag  - declare a method.  this method will be available to all script tags-->
<%!
public int add(int a, int b){
	return a+b;	
}
%>
<%
k = add(1234, 4394);
out.println("<br> this is by using a method, the value of k is " + k );
%>
</body>
</html>
