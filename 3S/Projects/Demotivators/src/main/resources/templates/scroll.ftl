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
                <a href = "${item.URL}"> ${item.description}</a>
            </div>
        </div>
    </tr>
</#foreach>

</body>
</html>