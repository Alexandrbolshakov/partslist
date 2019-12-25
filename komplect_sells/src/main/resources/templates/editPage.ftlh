<#import "parts/common.ftlh" as c>

<@c.page>
    <form method="post" action="/edit">
        <input type="hidden" name="id" value="${part.id}">
        <label for="partNumber">Part number</label>
        <input type="text" name="partNumber" value="${part.partNumber}">
        <label for="name">Наименование</label>
        <input type="text" name="name" value="${part.name}">
        <label for="quantityStr">Колличество</label>
        <input type="number" name="quantityStr" value="${part.quantity}">
        <label for="priceStr">Цена</label>
        <input type="text" name="priceStr" value="${part.price?c}"/>
        <label for="supplier">Поставщик</label>
        <input type="text" name="supplier" value="${part.supplierName}">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Сохранить</button>
    </form>
</@c.page>