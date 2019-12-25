<#import "parts/common.ftlh" as c>

<@c.page>
<div>
    <form method="post">
        <input type="text" name="name" placeholder="Название">
        <input type="text" name="phoneNumber" placeholder="Телефон">
        <input type="text" name="email" placeholder="Почта">
        <input type="text" name="contactName" placeholder="Контактное лицо">
        <input type="text" name="indexStr" placeholder="Коэффициент">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<h4>Список Поставщиков</h4>
<div>
    <table border="1">
        <thead>
        <tr>
            <th>Название</th>
            <th>Телефон</th>
            <th>Почта</th>
            <th>Контактное лицо</th>
            <th>Козффициент</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
       <#list suppliers as supplier>
            <tr>
                <td>${supplier.name}</td>
                <td>${supplier.phoneNumber}</td>
                <td>${supplier.email}</td>
                <td>${supplier.contactName}</td>
                <td>${supplier.index!}</td>
                <td>
                    <button><a href="/editSupplier/${supplier.id}">edit</a></button>
                    <button><a href="/deleteSupplier/${supplier.id}">delete</a></button>
                </td>
            </tr>
       </#list>

        </tbody>
    </table>
</div>
    ${message!}
<br>
<button><a href="/start">Вернуться к списку запчастей</a></button>
</@c.page>
