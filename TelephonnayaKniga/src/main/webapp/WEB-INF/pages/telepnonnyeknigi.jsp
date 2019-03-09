<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Telephonnaya Kniga Page</title>

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
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Telephonnaya-Kniga Redlina List</h1>

<c:if test="${!empty listTelephonnayaKniga}">
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
            <th width="60">Edit</th>
            <th width="60">Delete</th>

        </tr>
        <c:forEach items="${listTelephonnayaKniga}" var="telephonnaya_kniga">
            <tr>
                <td>${telephonnaya_kniga.id}</td>
                <td><a href="/telephonnayaknigadata/${telephonnaya_kniga.id}" target="_blank">${telephonnaya_kniga.login}</a></td>
                <td>${telephonnaya_kniga.passwordd}</td>
                <td>${telephonnaya_kniga.FIO}${telephonnaya_kniga}.FIO}</td>
                <td><a href="<c:url value='/edit/${telephonnaya_kniga.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${telephonnaya_kniga.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a novaya Telephonnaya_Kniga</h1>

<c:url var="addAction" value="/telephonnaya_kniga/add"/>


<form:form action="${addAction}" commandName="telephonnaya_kniga">
    <table>
        <jsp:useBean id="telephonnaya_kniga" scope="request" type="net.prosetyle.telephonnayakniga.controller.entity.Telephonnaya_Kniga"/>
        <c:if test="${!empty telephonnaya_kniga.login}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="login">
                    <spring:message text="login"/>
                </form:label>
            </td>
            <td>
                <form:input path="login"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="passwordd">
                    <spring:message text="passwordd"/>
                </form:label>
            </td>
            <td>
                <form:input path="passwordd"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="FIO">
                    <spring:message text="FIO"/>
                </form:label>
            </td>
            <td>
                <form:input path="FIO"/>
            </td>
        </tr>
        <tr>

            <td>
                <form:label path="store_information">
                    <spring:message text="store_information"/>
                </form:label>
            </td>
            <td>
                <form:input path="store_information"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="surname">
                    <spring:message text="surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="surname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="namee">
                    <spring:message text="namee"/>
                </form:label>
            </td>
            <td>
                <form:input path="namee"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="third_name">
                    <spring:message text="third_name"/>
                </form:label>
            </td>
            <td>
                <form:input path="third_name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="mobile_phone">
                    <spring:message text="mobile_phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="mobile_phone"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="home_phone">
                    <spring:message text="home_phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="home_phone"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="e_mail">
                    <spring:message text="e_mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="e_mail"/>
            </td>
        </tr>
        <tr>
        
            <td colspan="2">
                <c:if test="${!empty telephonnaya_kniga.login}">
                    <input type="submit"
                           value="<spring:message text="Edit Telephonnaya_Kniga"/>"/>
                </c:if>
                <c:if test="${empty telephonnaya_kniga.passwordd}">
                    <input type="submit"
                           value="<spring:message text="Add Telephonnaya_Kniga"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>