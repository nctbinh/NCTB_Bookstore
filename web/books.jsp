<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Shop Page</title>
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

            .product-list {
                display: grid;
                grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            }

            .product {
                background-color: #f2f2f2;
                padding: 10px;
                border-radius: 5px;
                text-align: center;
                max-width: 300px;
            }

            .product img {
                width: 100px;
                height: 150px;
                border-radius: 5px;
            }

            .product h3 {
                margin-top: 10px;
            }

            .product p {
                margin: 5px 0;
            }

            a {
                text-decoration: none;
                color: #333;
            }

            .product form {
                margin-top: 10px;
            }

            .product form input[type="number"] {
                width: 50px;
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 3px;
                margin-right: 10px;
            }

            .product form button[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 8px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .product form button[type="submit"]:hover {
                background-color: #45a049;
            }

            label[for="search"] {
                margin-right: 10px;
            }

            input[type="text"] {
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 3px;
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

            .product form input[type="submit"]:hover,
            form input[type="submit"]:hover {
                background-color: #45a049;
            }

            form input[type="submit"]#search-button {
                background-color: #3574a0;
                color: white;
                padding: 8px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            form input[type="submit"]#search-button:hover {
                background-color: #305a80;
            }

            footer {
                background-color: #4e7cbf;
                color: #fff;
                padding: 10px;
                text-align: center;
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

    </style>
</head>
<body>
    <header>
        <h1>Shop Page</h1>
    </header>
    <nav>
        <ul>
            <li><a href="MainController?action=home">Home</a></li>
            <li><a href="MainController?action=aboutUs">About Us</a></li>
            <li><a href="MainController?action=viewCart"><i class="fa fa-shopping-cart"></i> View Cart <span class="cart-count">${sessionScope.CART.cart.size()}</span></a></li>
        </ul>
    </nav>


    <a href="MainController?action=Logout" class="logout-btn">Logout</a> <br> <br>
    <div class="container">
        <h2>Our Products</h2>
        <form action="MainController" method="POST">
            <label for="search">Search:</label>
            <input type="text" id="search" name="search">
            <input type="submit" value="Search" name="action">
        </form>
        <div class="product-list">
            <c:forEach var="book" items="${sessionScope.BOOK_LIST}">
                <div class="product">
                    <img src="${book.image}" alt="${book.name}">
                    <h3><a href="MainController?action=bookDetail&bookID=${book.bookID}">${book.name}</a></h3>
                    <p>${book.author}</p>
                    <p>${book.price} VND</p>
                    <form action="MainController" method="post">
                        <input type="hidden" name="bookID" value="${book.bookID}">
                        <label for="quantity${book.bookID}">Quantity:</label>
                        <input type="number" id="quantity${book.bookID}" name="quantity" value="1" min="1">
                        <input type="submit" value="Add to cart" name="action">
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
<footer>
    Phone: 0388111669 <br>
    FB: abcxyz <br>
    Address: 123/123/123 <br>
</footer>
</html>
