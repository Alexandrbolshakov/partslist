<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>Spring Security Example </title>
</head>
<body>
Add new user
${message!}
<form action="/registration" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>

<#--    <#list roles as role>-->
<#--        <div>-->
<#--            <label><input type="checkbox" name="${role}">${role}</label>-->
<#--        </div>-->
<#--    </#list>-->
<#--&lt;#&ndash; &ndash;&gt;-->
    <input type="hidden" name="_csrf"value="${_csrf.token}"/>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>