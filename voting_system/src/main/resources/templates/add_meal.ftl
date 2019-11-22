
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Add meal</title>
</head>
<body>
<#if dishes??>
<table>
    <thead>
    <tr>
        <th>название блюда</th>
        <th>цена</th>
    </tr>
    </thead>
    <tbody>
    <#list dishes as dish>
        <tr>
            <td>${dish.id}</td>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td>${dish.date}</td>
            <td>${dish.restaurant.name}</td>
            <td>
                <a href="/deleteDish/${dish.id}">delete</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
</#if>
<form method = "post">
    <input type="text" name="name" placeholder="Название">
    <input type="text" name="price" placeholder="Цена">
    <button type="submit">Добавить</button>
</form>
<div>
    <#if message??>
        ${message}
    </#if>
</div>

</body>
</html>