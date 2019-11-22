
<html>
<body>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf"value="${_csrf.token}"/>
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<div>
    <form method="post">
        <input type="text" name="name" placeholder="введите название"/>
        <input type="text" name="rating" placeholder="rating">
        <input type="hidden" name="_csrf"value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список ресторанов</div>
<form method="post" action="filter">
    <input type="text" name="filter"/>
    <input type="hidden" name="_csrf"value="${_csrf.token}"/>
    <button type="submit">Посмотреть</button>
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
                <a href="/menuList/${restaurant.id}">Посмотреть меню/отредактировать меню</a>
            </td>

        </tr>
    </#list>
</table>
</body>
</html>