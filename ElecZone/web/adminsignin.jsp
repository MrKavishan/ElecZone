<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="assets/img/logo.png">
  <link rel="icon" type="image/png" href="assets/img/logo.png">
  <title>Admin Sign In - Elec-Zone</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .container {
      margin-top: 100px;
    }
    .card {
      border: none;
      border-radius: 10px;
      box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.1);
    }
    .card-header h3 {
      text-align: center;
      font-weight: bold;
    }
    .form-control {
      border-radius: 20px;
    }
    .btn-primary {
      border-radius: 20px;
    }
    .btn-primary-btn-block-mt-3:hover {
      background-color: #FFD700;
      color: #020202;
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">
            <h3>Admin Sign In</h3>
          </div>
          <div class="card-body">
            <form id="adminSignInForm" role="form" class="text-start" action="AdminLoginServlet" method="post" onsubmit="return validateForm()">
              <div class="form-group">
                <input type="email" class="form-control" name="email" id="email" placeholder="Email" required>
              </div>
              <div class="form-group">
                <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
              </div>
                <center><button type="submit" class="btn-primary-btn-block-mt-3">Sign In</button></center>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
    function validateForm() {
      var email = document.getElementById('email').value;
      var password = document.getElementById('password').value;
      if (!email.includes('@')) {
        alert('Please enter a valid email address.');
        return false;
      }
      if (password.length < 6) {
        alert('Password must be at least 6 characters long.');
        return false;
      }
      return true;
    }
  </script>
</body>

</html>

