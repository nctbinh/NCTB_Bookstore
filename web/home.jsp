<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Book Store Home</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #3574a0;
                color: #fff;
                padding: 10px;
                text-align: center;
            }

            nav {
                background-color: #4e7cbf;
                padding: 10px;
                text-align: center;
            }

            nav ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
            }

            nav ul li {
                display: inline;
                margin-right: 20px;
            }

            nav ul li a {
                text-decoration: none;
                color: #fff;
                padding: 5px 10px;
                border-radius: 5px;
            }

            nav ul li a:hover {
                background-color: #3574a0;
            }

            .container {
                padding: 20px;
            }

            .product {
                display: inline-block;
                margin: 10px;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                text-align: center;
                width: 300px;
            }

            .product img {
                max-width: 150px;
                max-height: 150px;
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

            .welcome-container {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: #f2f2f2;
                padding: 20px;
                border-radius: 5px;
                margin-bottom: 20px;
            }

            .welcome-text {
                flex: 1;
                padding: 0 20px;
                text-align: center;
            }

            .welcome-img {
                flex: 1;
                text-align: center;
            }

            .welcome-img img {
                max-width: 50%;
                max-height: 50%;
            }
            a {
                text-decoration: none;
                color: #333;
            }

            footer {
                background-color: #4e7cbf;
                color: #fff;
                padding: 10px;
                text-align: center;
            }

        </style>
    </head>
    <body>
        <header>
            <h1>NCTB BOOKSTORE</h1>
        </header>

        <nav>
            <ul>
                <li><a href="MainController?action=shop" class="nav-btn">Shop</a></li>
                <li><a href="MainController?action=aboutUs">About Us</a></li>
            </ul>
        </nav>
        <a href="MainController?action=Logout" class="logout-btn">Logout</a> <br> <br>
        <div class="container">
            <div class="welcome-container">
                <div class="welcome-text">
                    <h2>Welcome ${sessionScope.USER.fullName} to NCTB Book Shop</h2>
                    <p>This bookstore provides a wide variety range of books in many categories with the MINIMUM PRICE!</p>
                </div>
                <div class="welcome-img">
                    <img src="https://baoxaydung.com.vn/stores/news_dataimages/vananh/082021/24/10/in_article/5325_image002.jpg" alt="${book.name}">
                </div>
            </div>

            <h2>Featured Products</h2>
            <c:forEach var="book" items="${sessionScope.BOOK_LIST}" step="1" begin="1" end="4">
                <div class="product">
                    <img src="${book.image}" alt="${book.name}">
                    <h3><a href="MainController?action=bookDetail&bookID=${book.bookID}">${book.name}</a></h3>
                    <p>${book.author}</p>
                    <p>${book.price} VND</p>
                </div>
            </c:forEach>
        </div>
    </body>
    <footer>
        Phone: 0388111669 <br>
        FB: abcxyz <br>
        Address: 123/123/123 <br>
    </footer>
</html>
