<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f0f5f9;
            }

            header {
                background-color: #007bff;
                color: #fff;
                padding: 10px;
                text-align: center;
            }

            .content {
                padding: 20px;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            .book-image {
                max-width: 80px;
                max-height: 80px;
            }

            form {
                margin: 0;
            }

            input[type="text"], input[type="number"] {
                width: calc(100% - 20px);
                padding: 8px;
                border: 1px solid #ccc;
            }

            input[type="submit"] {
                padding: 8px 16px;
                background-color: #007bff;
                color: #fff;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }

            .logout-btn {
                float: right;
                margin-top: 10px;
                margin-right: 20px;
                color: #fff;
                text-decoration: none;
                padding: 5px 10px;
                background-color: #4e7cbf;
                border-radius: 5px;
            }

            .logout-btn:hover {
                background-color: #3574a0;
            }

        </style>
    </head>
    <body>
        <c:if test="${sessionScope.USER != null && sessionScope.USER.role == 2}">
            <header>
                <h1>Admin Page</h1>
            </header>
            <a href="MainController?action=Logout" class="logout-btn">Logout</a> <br> <br>
            <div class="content">
                <h2>Manage Books</h2>   
                <form action="MainController" method="POST">
                    <input type="text" id="search" name="search" value="${sessionScope.SEARCH_PARAM}">
                    <input type="submit" value="Search Books" name="action">
                </form>
                <table>
                    <tr>
                        <th>No</th>
                        <th>Book ID</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Published Date</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Status</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${sessionScope.BOOK_LIST}" var="b" varStatus="counter">
                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td><input type="text" value="${b.bookID}" name="bookID" readonly=""/></td>
                                <td><input type="text" value="${b.name}" name="name"/></td>
                                <td><input type="text" value="${b.author}" name="author"/></td>
                                <td><input type="text" value="${b.publishDate}" name="publishDate"/></td>
                                <td><input type="text" value="${b.image}" name="image"/></td>
                                <td><input type="number" value="${b.price}" name="price"/></td>
                                <td><input type="number" value="${b.quantity}" name="quantity"/></td>
                                <td><input type="text" value="${b.status}" name="status"/></td>
                                <td><input type="submit" value="Update" name="action"/></td>
                                <td><input type="submit" value="Delete" name="action"/></td>
                            </tr>
                        </form>
                    </c:forEach>

                </table>
                <form action="MainController">
                    <input type="submit" value="Add a new product" name="action"/>
                </form>
            </div>
        </c:if>
    </body>
</html>
