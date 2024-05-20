<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Book Detail</title>
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
                text-align: center; /* Center align content */
            }
            .book-details {
                max-width: 600px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f2f2f2;
            }
            .book-details img {
                width: 300px;
                height: auto;
                border-radius: 5px;
            }
            .book-details h2 {
                margin-top: 10px;
            }
            .book-details p {
                margin: 5px 0;
            }

            .product form input[type="submit"],
            form input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 8px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
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
            <h1>Book Detail</h1>
        </header>
        <nav>
            <ul>
                <li><a href="MainController?action=home">Home</a></li>
                <li><a href="MainController?action=aboutUs">About Us</a></li>
            </ul>
        </nav>
        
        <a href="MainController?action=Logout" class="logout-btn">Logout</a> <br> <br>
        <div class="container">
            <div class="book-details">
                <img src="${sessionScope.BOOK.image}" alt="${sessionScope.BOOK.name}">
                <h2>${sessionScope.BOOK.name}</h2>
                <p><strong>Author:</strong> ${sessionScope.BOOK.author}</p>
                <p><strong>Published Date:</strong> ${sessionScope.BOOK.publishDate}</p>
                <p><strong>Price:</strong> ${sessionScope.BOOK.price} VND</p>
                <p><strong>Quantity:</strong> ${sessionScope.BOOK.quantity}</p>
                <p><strong>Status:</strong> ${sessionScope.BOOK.status ? 'Available' : 'Out of stock'}</p>
                <form action="MainController" method="post">
                    <input type="hidden" name="bookID" value="${sessionScope.BOOK.bookID}">
                    <label for="quantity${sessionScope.BOOK.bookID}">Quantity:</label>
                    <input type="number" id="quantity${sessionScope.BOOK.bookID}" name="quantity" value="1" min="1">
                    <input type="submit" value="Add to cart" name="action">
                </form>
            </div>
        </div>
    </body>
    <footer>
        Phone: 0388111669 <br>
        FB: abcxyz <br>
        Address: 123/123/123 <br>
    </footer>
</html>
