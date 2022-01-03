<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
 </head>

<body>
<p>HTML page after parsing</p>

<a href="hello">Нажми сюда...</a>
<a href="user">Spring MVC</a>

<p style="text-align: center"><button>Parse</button>


<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Sign Up!
    </div>
    <form method="post" action="/parseUsers">
            <label for="firstName">First Name
                <input class="input-field" type="text" id="firstName" name="firstName">
            </label>
            <label for="lastName">Last Name
                <input class="input-field" type="text" id="lastName" name="lastName">
            </label>
            <input type="submit" value="Parse">
        </form>
</div>


<div class="form-style-2">
    <div class="form-style-2-heading">
        Already in System!
    </div>
    <table>
        <tr>
            <th>Name</th>
            <th>Teach id</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.fio_teach}</td>
                <td>${user.id_teach}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

