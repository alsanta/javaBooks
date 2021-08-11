<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                crossorigin="anonymous">
            <link rel="stylesheet" href="/css/style.css" />
            <title>Insert title here</title>
        </head>

        <body>
            <h1>All Books</h1>
            <table class="table table-striped border">
                <thead>
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Description</th>
                        <th scope="col">Language</th>
                        <th scope="col">Number of Pages</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td><c:out value="${book.title}" /></td>
                            <td><c:out value="${book.description}" /></td>
                            <td><c:out value="${book.language}" /></td>
                            <td><c:out value="${book.numberOfPages}" /></td>
                            <td><a href="/book/edit/${book.id}">Edit</a> | 
                                <a href="/book/delete/${book.id}">Delete</a> | 
                                <a href="/book/view/${book.id}">View</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/books/new">New Book</a>
        </body>

        </html>