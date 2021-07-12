<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
        <link rel="shortout icon" type="image/x-icon" href="images/register-icon.png">
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
        <link href="loginStyling.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="cont">
    <div class="sub-cont">
          <div class="img">
        <div class="img-text m-up">
          <h2>New to Our Portal?</h2>
          <p>Create a New account !!!</p>
		  <p>Start Your Transactions !!!</p>
          <div class="img-btn"><a href="registration.jsp">Sign Up</a>
        </div>  
        <div class="alert">
        <img src="images/alert.gif" width="100px" height="100px">
		<p class="txt1">Please do not share your</p>
		<p class="txt2">Account details</p>
		</div>       
        </div>
      </div>
          </div>
            <div class="regbox box">
                <img class="avatar" src="images/login-avatar.png">
                <h1>Login Here </h1>
                <form action="loginServlet" method="post">
                   <p>Account Number</p>
                   <input type="text" placeholder="account number" name="accountnumber" required>
                   <p>Password</p>
                   <input type="password" placeholder="password" name="password" required>
                   <input type="submit" value="Sign In">
                </form>
             </div>
			 <div class="frame">
			 <div class="social-buttons">
      <a href="https://account.microsoft.com/account"><div class="btn1"><i class="fab fa-microsoft"></i></div></a>
      <a href="https://accounts.google.com/ServiceLogin/identifier?sacu=1&passive=1209600&acui=1&rrsp=1&flowName=GlifWebSignIn&flowEntry=AddSession&cid=3&TL=AM3QAYZbSmXccR9QlsodWRRr6KMnT-bjR7v8RHdF09VgzkyMnW0BPRf_-SRNxNTt"><div class="btn2"><i class="fab fa-google"></i></div></a>
      <a href="https://www.linkedin.com/"><div class="btn3"><i class="fab fa-linkedin-in"></i></div></a>
      <a href="https://www.facebook.com/"><div class="btn4"><i class="fab fa-facebook"></i></div></a>
	  </div>
	  </div>
        </div>
		
     </body>
</html>
