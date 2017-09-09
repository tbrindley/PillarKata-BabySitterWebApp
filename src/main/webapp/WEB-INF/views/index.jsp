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
</head>
<body>
${message}

<form name="timeclock" action="getRate" onsubmit="" method="post">
    <div>
        <label>Start Date</label>
        <input type="date" name="startDate">
    </div>
    <div>
        <label>Start Time</label>
        <select name="startTime" datatype="int">
            <option value="17">5:00 PM</option>
            <option value="18">6:00 PM</option>
            <option value="19">7:00 PM</option>
            <option value="20">8:00 PM</option>
            <option value="21">9:00 PM</option>
            <option value="22">10:00 PM</option>
        </select>
    </div>
    <div>
        <label>Child's Bed Time</label>
        <select name="bedTime" >
            <option value="18">6:00 PM</option>
            <option value="19">7:00 PM</option>
            <option value="20">8:00 PM</option>
            <option value="21">9:00 PM</option>
            <option value="22">10:00 PM</option>
            <option value="23">11:00 PM</option>
        </select>
    </div>
    <div>
        <label>End Time</label>
        <select name="endTime" >
            <option value="19">Date1 - 7pm</option>
            <option value="20">Date1 - 8pm</option>
            <option value="21">Date1 - 9pm</option>
            <option value="22">Date1 - 10pm</option>
            <option value="23">Date1 - 11pm</option>
            <option value="24">Date2 - 12am</option>
            <option value="25">Date2 - 01am</option>
            <option value="26">Date2 - 02pm</option>
            <option value="27">Date2 - 03pm</option>
            <option value="28">Date2 - 04pm</option>
        </select>
    </div>

    <input type="submit" value="Get Rate">
</form>
</body>
</html>
