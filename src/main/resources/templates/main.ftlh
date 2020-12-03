<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sign Out"/>
        </form>
        <span><a href="/user">User list</a> </span>
    </div>
    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="text" name="text" placeholder="Введите сообщение"/>
            <input type="text" name="tag" placeholder="Тэг">
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter!}">
        <button type="submit">Найти по тегу</button>
    </form>
    <#list messages as messages>
        <div>
            <b>${messages.id}</b>
            <span>${messages.text}</span>
            <i>${messages.tag}</i>
            <strong>${messages.authorName}</strong>
            <div>
                <#if messages.filename??>
                    <img src="/img/${messages.filename}">
                </#if>
            </div>
        </div>
    <#else>
        No messages
    </#list>
</@c.page>