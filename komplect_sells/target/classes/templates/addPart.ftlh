<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form method="post">
            <input type="text" name="partNumber" placeholder="Part number">
            <input type="text" name="name" placeholder="Наименование">
            <input type="number" name="quantityStr" placeholder="Колличество">
            <input type="text" name="priceStr" placeholder="Цена">
            <input type="text" name="supplier" placeholder="Поставщик">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
        ${message!}
</@c.page>