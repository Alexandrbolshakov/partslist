<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Komplect</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/start">Parts list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addPart">Add part</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/supplier">Supplier list</a>
            </li>
           <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
           </#if>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
            </#if>
        </ul>
    </div>
    <div>
        <@l.logout/>
    </div>
</nav>