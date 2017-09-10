<%--
  Created by IntelliJ IDEA.
  User: Travis Brindley
  Date: 9/7/2017
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Babysitter Time Clock - Results</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script> -->
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 align="center">Baby Sitter Wage</h1>
    </div>
    <h3>Babysitting Info</h3>
    <p><strong>Start Time:</strong> ${startDay} at ${startTime}</p>
    <p><strong>Bed Time:</strong> ${bedTime}</p>
    <p><strong>End Time:</strong> ${endDate} at ${endTime}</p>
    <hr>
    <h3>Wage Breakdown</h3>
    <p><strong>Base Salary Earned ($12 per hr):</strong>$${baseSalary}.00</p>
    <p><strong>Post Bedtime Salary Earned ($8 per hr):</strong>$${postBedSalary}.00</p>
    <p><strong>After Midnight Salary Earned ($16 per hr):</strong>$${midnightSalary}.00</p>
    <hr>
    <h2 align="center">Nightly Wage: $${totalSalary}.00</h2>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
