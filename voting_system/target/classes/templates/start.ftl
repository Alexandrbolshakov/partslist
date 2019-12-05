<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3" lang="en">

<head>
        <title>Start Page</title>
</head>
<body>
<h3>Hello</h3>

<#if message??>
<h5>${message}</h5>
</#if>
<a href="/login">Sign in</a>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</div>

<a href="/user">Список пользователей</a>
<br>
<a href="/restaurantList">список ресторанов</a>
<br>
<a href="/votingList">Проголосовать</a>
</body>
</html>