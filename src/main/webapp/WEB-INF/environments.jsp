<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="guest.*"%>
 
<jsp:useBean id="environmentDao" type="guest.EnvironmentDao" scope="request" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Environment</title>
    </head>
 
    <body>
        <form method="POST" action="environments.html">
            Environment Name: <input type="text" name="envName" />
            Active: <input type="text" name="isActive" />
            Env Description: <input type="text" name="envDesc" />
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> 
        <% for (Environment env: environmentDao.getAllEnvironments()) { %>
            <li> <%= env %> </li>
        <% } %>
        </ol><hr>
	</body>
</html>