<#import "parts/common.ftlh" as c>
    <#import "parts/pager.ftlh" as p>

<@c.page>

    <h4>Список запчастей</h4>
    <div class="form-row">
        <div>
            <button class="my-1"><a href="/supplier" class="form-control">Добавить поставщика</a></button>

            <button><a href="/addPart" class="form-control">Добавить запчасть</a></button>
        </div>
    </div>
    <div>
        <form method="get" action="/start">
            <input class="my-1" type="text" name="filter"value="${filter!}">
            <button type="submit">Найти</button>
        </form>
        </div>
    <@p.pager url page/>
    <div>
        <table border="1">
            <thead>
            <tr>
                <th>Каталожный номер</th>
                <th>Наименование</th>
                <th>Колличество</th>
                <th>цена закупки</th>
                <th>цена продажи</th>
                <th>Поставщик</th>
                <th>Дата изменения</th>
                <th>Действие</th>
            </tr>
            </thead>
            <tbody>
            <#list page.content as part>
                <tr>
                    <td>${part.partNumber}</td>
                    <td>${part.name}</td>
                    <td>${part.quantity}</td>
                    <td>${part.price}</td>
                    <td>${part.priceOut()}</td>
                    <td><button><a href="/supplier">${part.supplierName}</a></button></td>
                    <td>${part.dateTime!}</td>
                    <td>
                        <button><a href="/edit/${part.id}">edit</a></button>
                        <button><a href="/delete/${part.id}">delete</a></button>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <@p.pager url page/>
    ${message!}
</@c.page>