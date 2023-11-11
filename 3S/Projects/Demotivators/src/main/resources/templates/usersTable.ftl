<table>
    <tr class="User">
        <th>Name</th>
        <th>Date</th>

    </tr>
    <#foreach item in users>
        <tr class="User">
            <td>${item.name}</td>
            <td>${item.date}</td>
        </tr>
    </#foreach>
</table>