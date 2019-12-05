<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>

</head>
<body>
<table>
    <thead>
    <tr>
       <th>name</th>
        <th>role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
    </tbody>
    </table>
<form method = "post">
    <input type="text" name="name" placeholder="Имя">
    <input type="text" name="password" placeholder="Пароль">
    <input type="hidden" name="_csrf"value="${_csrf.token}"/>
    <button type="submit">Добавить</button>
</form>
</body>
</html>