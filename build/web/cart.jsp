<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shopping Cart</title>
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
            .cart-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            .cart-table th, .cart-table td {
                border: 1px solid #ccc;
                padding: 8px;
                text-align: left;
            }
            .cart-table th {
                background-color: #f2f2f2;
            }
            .cart-item-img {
                width: 100px;
                height: 100px;
                border-radius: 5px;
            }
            .cart-item-title {
                font-weight: bold;
            }

            .x {
                text-decoration: none;
                text-align: center;
                color: red;
            }

            .container {
                padding: 20px;
                text-align: center;
            }


            input[type="text"] {
                padding: 8px;
                margin: 8px 0;
                width: 50%;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 5px;
            }


            input[type="submit"] {
                background-color: #3574a0;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            input[type="submit"]:hover {
                background-color: #2a588b;
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
    </head>
    <body>
        <c:if test="${sessionScope.USER != null}">


            <header>
                <h1>Shopping Cart</h1>
            </header>
            <nav>
                <ul>
                    <li><a href="MainController?action=home">Home</a></li>
                    <li><a href="MainController?action=shop">Shop</a></li>
                    <li><a href="MainController?action=aboutUs">About Us</a></li>
                </ul>
            </nav>

            <a href="MainController?action=Logout" class="logout-btn">Logout</a> <br> <br>

            <c:if test="${empty sessionScope.CART.cart}">
                <h1> Your carts is empty </h1>
                <a href="MainController?action=shop">Back to shopping page?</a>
            </c:if>
            <c:set var="total" value="0" />
            <c:if test="${not empty sessionScope.CART.cart}">
                <form action="MainController" method="POST">
                    <div class="container">
                        <table class="cart-table">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${sessionScope.CART.cart}">
                                    <tr>
                                        <td>
                                            <img class="cart-item-img" src="${item.value.getImage()}" alt="${item.value.getImage()}">
                                            <span class="cart-item-title">${item.value.getName()}</span>
                                        </td>
                                        <td>${item.value.getPrice()} VND</td>
                                        <td>
                                            <label for="quantity${item.value.getBookID()}">Quantity:</label>
                                            <input type="number" id="quantity${item.value.getBookID()}" name="quantity${item.value.getBookID()}" value="${item.value.getQuantity()}" min="1">
                                        </td>
                                        <td>${item.value.getQuantity() * item.value.getPrice()} VND</td>
                                        <td><a href="MainController?action=remove&bookID=${item.value.getBookID()}" class="x">X</a></td>
                                    </tr>
                                    <c:set var="total" value="${total + item.value.getQuantity() * item.value.getPrice()}" />
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <h2>Total: ${total}</h2>
                    <div class="container">
                        <h2>Checkout</h2>
                        <label for="phone">Phone Number:</label>
                        <input type="text" id="phone" name="userphone" required>
                        <br>
                        <label for="address">Address:</label>     
                        <input type="text" id="address" name="useraddress"  required>
                        <br>
                        <input type="hidden" name="total" value="${total}">
                        <input type="submit" value="Check out" name="action">
                    </div>
                </form>
            </c:if>

        </c:if>
    </body>
    <footer>
        Phone: 0388111669 <br>
        FB: abcxyz <br>
        Address: 123/123/123 <br>
    </footer>

</html>
