<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>About Us</title>
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
            .about-section {
                padding: 20px;
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
            <h1>About Us</h1>
        </header>
        <nav>
            <ul>
                <li><a href="MainController?action=home">Home</a></li>
            </ul>
        </nav>

        <a href="MainController?action=Logout" class="logout-btn">Logout</a> <br> <br>
        <div class="container">
            <div class="about-section">
                <h2>Our Company</h2>
                <p>We are a leading online bookstore offering a wide range of books in various categories. Our mission is to provide our customers with the best selection of books at affordable prices.</p>
            </div>
            <div class="about-section">
                <h2>Our Team</h2>
                <p>Our team consists of dedicated professionals who are passionate about books and are committed to providing excellent customer service. We work hard to ensure that our customers have a pleasant shopping experience.</p>
            </div>
            <div class="about-section">
                <h2>Contact us</h2>
                <p>22/31/16 Harshaw Eve Toronto On</p>
                <p>0388111669</p>
            </div>
        </div>
    </body>
</html>
