<!DOCTYPE html>
<html>
<head>
    <style>
        <#include "css/mystyle.css">
    </style>
</head>
<body>

<#foreach item in memes>
    <tr class="MemWithUser">
        <div class="img-container">
            <img src="${item.path}" alt="your_mem">
            <img src="${item.user.avatar}" alt="creator">

            <div class="img-text">
                <a href = "/app/memes/${item.mem_id}/comments"> ${item.description}</a>
            </div>

            <#if user_id == item.user_id || isAdmin>
                <div class="img-button">
                    <a href="/app/memes/${item.mem_id}/edit">Edit</a>
                </div>
            </#if>
        </div>
    </tr>
</#foreach>

</body>
</html>