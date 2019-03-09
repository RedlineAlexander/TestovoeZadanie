<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Telephonnaya_Kniga Data</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>

</head>
<body>
<h1>Telephonnaya Kniga Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">login</th>
        <th width="120">password</th>
        <th width="120">FIO</th>
        <th width="60">store_information</th>
        <th width="60">surname</th>
        <th width="80">namee</th>
        <th width="120">third_name</th>
        <th width="120">mobile_phone</th>
        <th width="120">home_phone</th>
        <th width="60">address</th>
        <th width="60">e_mail</th>
    </tr>
    <tr>
        <td>${telephonnaya_kniga.id}</td>
        <td>${telephonnaya_kniga.login}</td>
        <td>${telephonnaya_kniga.passwordd}</td>
        <td>${telephonnaya_kniga.FIO}</td>
        <td>${telephonnaya_kniga.store_information}</td>
        <td>${telephonnaya_kniga.surname}</td>
        <td>${telephonnaya_kniga.namee}</td>
        <td>${telephonnaya_kniga.third_name}</td>
        <td>${telephonnaya_kniga.mobile_phone}</td>
        <td>${telephonnaya_kniga.home_phone}</td>
        <td>${telephonnaya_kniga.address}</td>
        <td>${telephonnaya_kniga.e_mail}</td>




    </tr>
</table>
</body>
</html>