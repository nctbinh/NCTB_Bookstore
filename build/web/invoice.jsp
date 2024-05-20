<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Invoice</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
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
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                margin: 20px auto;
                max-width: 800px;
            }
            .invoice-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            .invoice-table th, .invoice-table td {
                border: 1px solid #ccc;
                padding: 8px;
                text-align: left;
            }
            .invoice-table th {
                background-color: #f2f2f2;
            }
            label {
                font-weight: bold;
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
        <header>
            <h1>Invoice</h1>
        </header>
        <nav>
            <ul>
                <li><a href="MainController?action=shop" class="nav-btn">Shop</a></li>
                <li><a href="MainController?action=aboutUs">About Us</a></li>
            </ul>
        </nav>

        <a href="MainController?action=Logout" class="logout-btn">Logout</a> <br> <br>
        <div class="container">
            <h2>Check out successfully, here is your INVOICE:</h2>
            <table class="invoice-table">
                <thead>
                    <tr>
                        <th>Book Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessionScope.ITEMS_LIST}" var="item">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.price} VND</td>
                            <td>${item.quantity}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>Total: ${sessionScope.TOTAL} VND</td>
                    </tr>
                </tbody>
            </table>
            <label>Your phone number: </label>${sessionScope.PHONE} <br>
            <label>Your address: </label>${sessionScope.ADDRESS} <br>
        </div>
    </body>
    <footer>
        Phone: 0388111669 <br>
        FB: abcxyz <br>
        Address: 123/123/123 <br>
    </footer>
</html>
