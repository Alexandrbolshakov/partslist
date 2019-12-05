<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Add restaurant</title>
</head>
<body>

<form method = "post">
<input type="text" name="name" placeholder="Название">
<input type="text" name="rating" placeholder="Рейтинг">
    <input type="hidden" name="_csrf"value="${_csrf.token}"/>
<button type="submit">Добавить</button>
</form>
<div>
    <#if message??>
    ${message}
    </#if>
</div>

</body>
</html>