<#include "common.ftl">
<#include "menu.ftl">

<#foreach item in requests>
    <tr class="RequestsWithUser">
        <div class="img-container">
            <img src="${item.sender.avatar}" alt="sender">
            <a>${item.text}</a>
            <br />
            <form method="post" action="/app/requests/${item.requestId}/approve">
                <button type="submit">
                    Approve
                </button>
            </form>
            <br />
            <form method="post" action="/app/requests/${item.requestId}/reject">
                <button type="submit">
                    Reject
                </button>
            </form>

        </div>
    </tr>
</#foreach>

<a href = "/app/menu"> Back</a>
