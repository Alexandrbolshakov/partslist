<#import "parts/common.ftlh" as c>

<@c.page>
    <form method="post" action="/editSupplier">
        <input type="hidden" name="id" value="${supplier.id}">
        <label for="name">Наименование</label>
        <input type="text" name="name" value="${supplier.name}">
        <label for="phoneNumber">Телефон</label>
        <input type="text" name="phoneNumber" value="${supplier.phoneNumber}">
        <label for="email">Почта</label>
        <input type="email" name="email" value="${supplier.email}">
        <label for="contactName">Контактное лицо</label>
        <input type="number" name="contactName" value="${supplier.contactName}">
        <label for="indexStr">Коэффициент</label>
        <input type="text" name="indexStr" value="${supplier.index!}">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Сохранить</button>
    </form>
</@c.page>