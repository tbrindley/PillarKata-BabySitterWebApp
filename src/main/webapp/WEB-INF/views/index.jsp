<%--
  Created by IntelliJ IDEA.
  User: travis
  Date: 7/21/2017
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Babysitter Time Clock</title>

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
        <h1 align="center">Baby Sitter Timeclock</h1>
        <h4 align="center">Base Salary: $12hr | After Bedtime Salary: $8hr | After Midnight Salary: $16hr</h4>
    </div>

    <form name="timeclock" action="getRate"  method="post">
        <div class="container">
            <label>Start Date</label>
            <input type="date" name="startDate" id="startDate" class="form-control" onchange="getDate()" required>
        </div>
        <div class="container">
            <br><label>Start Time</label>
            <select name="startTime" id="startTime" class="form-control" onchange="getQuitTime()" required>
                <option disabled selected value> Select a start time</option>
                <option value="17">5:00 PM</option>
                <option value="18">6:00 PM</option>
                <option value="19">7:00 PM</option>
                <option value="20">8:00 PM</option>
                <option value="21">9:00 PM</option>
                <option value="22">10:00 PM</option>
            </select>
        </div>
        <div class="container">
            <br><label>Child's Typical Bed Time</label>
            <select name="bedTime" id="bedTime" class="form-control" required>
                <option disabled selected value> Select bed time</option>
                <option value="18">6:00 PM</option>
                <option value="19">7:00 PM</option>
                <option value="20">8:00 PM</option>
                <option value="21">9:00 PM</option>
                <option value="22">10:00 PM</option>
                <option value="23">11:00 PM</option>
            </select>
        </div>
        <div class="container">
            <br><label>End Time</label>
            <select name="endTime" class="form-control" required>
                <option disabled selected value> Select end time</option>
                <option value="18">Date1 - 6pm</option>
                <option value="19">Date1 - 7pm</option>
                <option value="20">Date1 - 8pm</option>
                <option value="21">Date1 - 9pm</option>
                <option value="22">Date1 - 10pm</option>
                <option value="23">Date1 - 11pm</option>
                <option value="24">Date1 - 12am</option>
                <option value="25">Date2 - 01am</option>
                <option value="26">Date2 - 02am</option>
                <option value="27">Date2 - 03am</option>
                <option value="28">Date2 - 04am</option>
            </select>
        </div>
        <div class="form-actions">
            <p></p>
            <p> <input type="submit" value="Get Rate" class="btn btn-large btn-primary"> </p>
        </div>
    </form>
</div>
<script src="../../webresources/js/formValidation.js"> </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
