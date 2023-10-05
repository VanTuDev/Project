
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registration</title>
        <!-- Link to Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">Registration</h2>
                        </div>
                        <div class="card-body">
                            <form action="signup" method="POST" onsubmit="return validateForm()">
                                <div class="form-group">
                                    <label for="username">Username:</label>
                                    <input type="text" class="form-control"  name="user" required>
                                </div>



                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input type="password" class="form-control"  name="pass" required>
                                </div>
                                <div class="form-group">
                                    <label for="gmail">Gmail:</label>
                                    <input type="email" class="form-control"  name="gmail" required>
                                </div>

                                <div class="form-group">
                                    <label for="confirm_password">Confirm Password:</label>
                                    <input type="password" class="form-control"  name="repass" required>
                                    <small id="passwordMatchError" class="text-danger d-none">Passwords do not match.</small>
                                </div>

                                <!--Thêm dropdown cho loại người dùng--> 
<!--                                <div class="form-group">
                                    <label for="user_type">Choose User Type:</label>
                                    <select class="form-control" id="user_type" name="user_type" required>
                                        <option value="1">Người Thuê</option>
                                        <option value="2">Người Cho Thuê</option>
                                    </select>
                                </div>-->

                                <button type="submit" class="btn btn-primary btn-block">Register</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Link to Bootstrap JS and jQuery (if needed) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <script>
                                function validateForm() {
                                    var password = document.getElementById("password").value;
                                    var confirm_password = document.getElementById("confirm_password").value;
                                    var passwordMatchError = document.getElementById("passwordMatchError");

                                    if (password !== confirm_password) {
                                        passwordMatchError.classList.remove("d-none");
                                        return false; // Prevent form submission
                                    } else {
                                        passwordMatchError.classList.add("d-none");
                                        return true; // Allow form submission
                                    }
                                }
        </script>
    </body>
</html>
