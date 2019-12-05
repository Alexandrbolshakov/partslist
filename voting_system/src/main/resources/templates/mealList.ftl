<html>
<body>

<div>Меню</div>

<form method="get" action="/mealList">

    <#if filter??>
        <label>
            <input type="text" name="filter" value="${filter}">
        </label>
    </#if>
    <button type="submit">Найти</button>
</form>
<table>
    <thead>
    <tr>
        <th>название блюда</th>
        <th>цена</th>
        <th>Дата создания</th>
        <th>Ресторан</th>
    </tr>
    </thead>
    <tbody>
    <#list dishes as dish>
        <tr>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td>${dish.date}</td>
            <td>${dish.restaurant.name}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>