<#import "parts/common.ftlh" as c>

<@c.page>
    List of user
    <table border="1">
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
</@c.page>