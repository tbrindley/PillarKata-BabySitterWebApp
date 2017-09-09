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
        <select name="startTime">
            <option value="17">5:00 PM</option>
            <option value="18">6:00 PM</option>
            <option value="19">7:00 PM</option>
            <option value="20">8:00 PM</option>
            <option value="21">9:00 PM</option>
            <option value="22">10:00 PM</option>
            <option value="23">11:00 PM</option>
            <option value="00">12:00 AM</option>
            <option value="01">01:00 AM</option>
            <option value="02">02:00 AM</option>
            <option value="03">03:00 AM</option>
        </select>
    </div>
    <div>
        <label>Child's Bed Time</label>
        <select name="bedTime">
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
        <select name="endTime">
            <option value="1">Date1 - 7pm</option>
            <option value="2">Date1 - 8pm</option>
            <option value="3">Date1 - 9pm</option>
            <option value="4">Date1 - 10pm</option>
            <option value="5">Date1 - 11pm</option>
            <option value="6">Date2 - 12am</option>
            <option value="7">Date2 - 01am</option>
            <option value="8">Date2 - 02pm</option>
            <option value="9">Date2 - 03pm</option>
            <option value="10">Date2 - 04pm</option>
        </select>
    </div>

    <input type="submit" value="Get Rate">
</form>
</body>
</html>
