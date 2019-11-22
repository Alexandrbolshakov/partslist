
<html>
<body>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf"value="${_csrf.token}"/>
        <input type="submit" value="Sign Out"/>
    </form>
</div>

<div>Список ресторанов</div>
<form method="post" action="filter">
    <input type="text" name="filter"/>
    <input type="hidden" name="_csrf"value="${_csrf.token}"/>
    <button type="submit">Найти</button>
</form>
<table>
    <tr>
        <th>Название ресторана</th>
        <th>рейтинг</th>
    </tr>
    <#list restaurants as restaurant>
        <tr>
            <td>${restaurant.id}</td>
            <td>${restaurant.name}</td>
            <td>${restaurant.rating}</td>
            <td>
                <a href="/menuList/${restaurant.id}">Посмотреть меню</a>
                <a href="/vote/${restaurant.id}">Проголосовать</a>
            </td>

        </tr>
    </#list>
</table>
</body>
</html>