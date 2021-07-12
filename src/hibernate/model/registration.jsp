<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User Registration</title>
        <link rel="shortout icon" type="image/x-icon" href="images/register-icon.png">
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/styling.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="cont">
    <div class="sub-cont">
          <div class="img">
        <div class="img-text m-up">
          <h2>One of Us?</h2>
          <p>Already have an account !!!</p>
          <div class="img-btn"><a href="signIn.jsp">Sign In</a>
        </div>         
        </div>
      </div>
          </div>
            <div class="regbox box">
                <img class="avatar" src="images/avatar.svg">
                <h1>New User </h1>
                <form action="register" method="post">
                   <p>Username</p>
                   <input type="text" placeholder="username" name="name" required>
                   <p>Account Number</p>
                   <input type="text" placeholder="account number" name="accountnumber" required>
                   <p>Email Address</p>
                   <input type="text" placeholder="email" name="email" required>
                   <p>Password</p>
                   <input type="password" placeholder="password" name="password" required>
                   <input type="submit" value="Sign Up">
                   
                </form>
             </div>
        </div>
     </body>
</html>
