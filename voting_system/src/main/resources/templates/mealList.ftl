<html>
<body>

<div>Меню</div>

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
            <td>
                <a href="/add_meal/${dish.id}">edit</a>
                <a href="/deleteDish/${dish.id}">delete</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>