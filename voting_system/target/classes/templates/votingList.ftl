<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Voting</title>
</head>
<body>
<#if filter??>
<form method = "get" action="/votingList">
    <input type="text" name="filter" value="${filter}">
    <button type="submit">Найти</button>
</form>
</#if>
<#if reviews??>
    <table>
        <thead>
        <tr>
            <th>Пользователь</th>
            <th>Ресторан</th>
            <th>Оценка</th>
            <th>Дата</th>
        </tr>
        </thead>
        <tbody>
        <#list reviews as review>
            <tr>
                <td>${review.user.username}</td>
                <td>${review.restaurant.name}</td>
                <td>${review.scope}</td>
                <td>${review.dateTime}</td>
                <td>
                    <a href="/deleteReview/${review.id}">delete</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</#if>
<#if message??>
    <div>
        ${message}
    </div>
</#if>
<form method = "post">
    <input type="text" name="restaurant" placeholder="Ресторан">
    <input type="text" name="scope" placeholder="Оценка">
    <input type="hidden" name="_csrf"value="${_csrf.token}"/>
    <button type="submit">Проголосовать</button>
</form>
<div>
    <#if message??>
        ${message}
    </#if>
</div>

</body>
</html>