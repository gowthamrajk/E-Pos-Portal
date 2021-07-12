<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Account Statement Transcription - Index</title>
  <link rel="shortout icon" type="image/x-icon" href="images/dashboard-icon.png">
  <link href="dashboardStyling.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
</head>
<body>
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center">
      <h1 class="logo mr-auto"><a href="index.html">E-Pos Portal</a></h1>
      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="dashboard.jsp">Home</a></li>
          <li><a href="#services">Services</a></li>
        </ul>
      </nav>
      <a href="#about" class="get-started-btn">View Transaction</a>
    </div>
  </header>
  <section id="hero" class="d-flex align-items-center">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1">
          <h1>Transcription Statements of Your Account</h1>
          <h2>Upload your Transactions !! Get your Account Statements Anytime !!!</h2>
          <div class="d-lg-flex">
            <a href="DirectTransaction.jsp" class="btn-get-started1">Direct Transaction</a>
			<a href="upload.jsp" class="btn-get-started2">Upload files</a>      
          </div>
        </div>
        <div class="col-lg-6 order-1 order-lg-2">
          <img src="images/OnlineBanking.png" class="img-fluid animated" alt="">
        </div>
      </div>
    </div>
  </section>
  <main id="main">
    <section id="services" class="services section-bg">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Our Services</h2>
          <p>We Provide our best services for you</p>
        </div>
        <div class="row">
          <div class="col-lg-3">
            <div class="icon-box">
              <h3><a href="">Transaction</a></h3>
              <p>Get Transaction History for your Account on Uploading the E-statements</p>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="icon-box">
              <h3><a href="">Balance</a></h3>
              <p>Get your Account Running Balance with your Transaction Details</p>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="icon-box">
              <h3><a href="">Print</a></h3>
              <p>Get the Printable copy of your Account Transcripted Statements </p>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="icon-box">
              <h3><a href="">Security</a></h3>
              <p>High Security is provided for your Account statements and Account Details</p>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
</body>
</html>