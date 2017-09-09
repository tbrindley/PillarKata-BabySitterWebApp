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
    <title>Results</title>
</head>
<body>
<p>Start Time: ${startDay} at ${startTime}</p>
<p>Bed Time: ${bedTime}</p>
<p>End Time: ${endDate}</p>
<hr>
<p>Base Salary Earned ($12 per hr): $${baseSalary}.00</p>
<p>Post Bedtime Salary Earned ($8 per hr): $${postBedSalary}.00</p>
<p>After Midnight Salary Earned ($16 per hr): $${midnightSalary}.00</p>
<p>Nightly Wage: $${totalSalary}.00</p>
</body>
</html>
