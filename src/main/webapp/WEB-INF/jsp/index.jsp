<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Libraries</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <h1>Libraries</h1>
        <table border="1">
            <tr>
                <th class="red">Name</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
            <c:forEach var="library" items="${libraries}">
                <tr>
                    <td>${library.name}</td>
                    <td>${library.address}</td>
                    <td>
                        <a href="view/${library.id}">view</a>
                        <a href="delete/${library.id}">delete</a>
                        <a href="update/${library.id}">update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="add">Add New Library</a>
        </p>
    </body>
</html>
