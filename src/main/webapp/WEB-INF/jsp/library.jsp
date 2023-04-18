<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Library</title>
    </head>
    <body>
        <h1>Library ${library.name}</h1>
        <p>${library.address}</p>
        <h2>Books</h2>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Pages</th>
            </tr>
            <c:forEach var="book" items="${library.books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.pages}</td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="/addBook/${library.id}">Add New Book</a>
        </p>
    </body>
</html>