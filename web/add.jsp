<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add New Book</title>
        <style>
            /* CSS styles */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            form {
                margin: 20px;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            input[type="text"], input[type="date"], input[type="number"] {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #45a049;
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

        <h2>Add New Book</h2>

        <form action="MainController" method="post">
            <label for="bookID">Book ID:</label>
            <input type="text" id="bookID" name="bookID" required>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required>

            <label for="publishDate">Publish Date:</label>
            <input type="date" id="publishDate" name="publishDate" required>

            <label for="image">Image URL:</label>
            <input type="text" id="image" name="image" required>

            <label for="price">Price:</label>
            <input type="number" id="price" name="price" min="0" step="0.01" required>

            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="0" required>

            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="true">Available</option>
                <option value="false">Not Available</option>
            </select>

            <input type="submit" value="Add" name="action">
        </form>
        <a href="MainController?action=Back">Back</a> 
    </body>
</html>
