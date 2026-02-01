

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
    <title>Login and Logout Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
   


    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .form-register {
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }
        .form-register .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
		
		.sign-in{
			padding: 10px 0 0 0;
		}
		.sign-in a{
			text-decoration:none;
		}
    </style>
</head>
<body>
    <div class="container">
        
        <!-- Login Form -->
        <form class="form-register" method="post" action="/register">
            <h2 class="mb-3">Register</h2>
          
			<div class="mb-3">
			       <label for="name" class="form-label">Name</label>
			       <input type="text" id="name" name="name" class="form-control" required>
			</div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="text" id="age" name="age" class="form-control" required>
            </div>
			<div class="mb-3">
			                <label for="email" class="form-label">Email</label>
			                <input type="email" id="email" name="email" class="form-control" required>
			            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <button class="btn btn-primary" type="submit">Sign up</button>
			<h6 class="sign-in">If you have account <a href="/login">Sign in</a></h6>
        </form>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>