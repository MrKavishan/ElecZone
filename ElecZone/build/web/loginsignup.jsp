<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login & Registration Form</title>
  <link rel="stylesheet" href="css/loginsignup.css">
</head>
<body>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Login</header>
      <form action="#" id="login-form">
        <input type="text" placeholder="Enter your email" id="login-email">
        <input type="password" placeholder="Enter your password" id="login-password">
        <a href="#">Forgot password?</a>
        <input type="button" class="button" value="Login" onclick="submitLoginForm();">
      </form>
      <div class="signup">
        <span class="signup">Don't have an account?
         <label for="check">Signup</label>
        </span>
      </div>
    </div>
    <div class="registration form">
      <header>Signup</header>
      <form action="#" id="signup-form">
        <input type="text" placeholder="Enter your email" id="signup-email">
        <input type="password" placeholder="Create a password" id="signup-password">
        <input type="password" placeholder="Confirm your password" id="confirm-password">
        <input type="button" class="button" value="Signup" onclick="submitSignupForm();">
      </form>
      <div class="signup">
        <span class="signup">Already have an account?
         <label for="check">Login</label>
        </span>
      </div>
    </div>
  </div>
</body>
</html>