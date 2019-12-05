<html>
<head>
    <title>restaurant list</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>название ресторана</th>
        <th>рейтинг</th>
    </tr>
    </thead>
    <tbody>
    <#if restaurants??>
    <#list restaurants as r>
    <tr>
        <td>${r.name}</td>
        <td>${r.rating}</td>
        <td>
            <a href="/edit/${r.id}">edit</a>
            <a href="/delete/${r.id}">delete</a>
            <a href="/add_meal/${r.id}">Добавить меню</a>
        </td>
    </tr>
    </#list>
    </#if>
    </tbody>
</table>
<form method="get">
    <input type="hidden" name="_csrf"value="${_csrf.token}"/>
    <button type="submit">Обновить рейтинг</button>
</form>
<br>
<a href="/userList">user list</a>
<div></div>
<a href="/votingList">список голосов</a>
<div></div>
<a href="/mealList">меню</a>
<br>
<a href="/add">Добавить ресторан</a>

<div>
    <#if message??>
        ${message}
    </#if>
</div>
</body>
</html>