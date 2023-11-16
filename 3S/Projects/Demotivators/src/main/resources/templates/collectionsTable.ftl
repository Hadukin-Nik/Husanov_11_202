<style>
    table, th, td {
        border:1px solid black;
    }
</style>

<form method="POST">
    <a>Name</a>
    <textarea name="name" rows="4" cols="50"> </textarea>

    <br/>
    <a>Description</a>
    <textarea name="description" rows="4" cols="50"> </textarea>

    <br/>
    <input type="checkbox"  name="isPrivate">
    <label for="isPrivate"> is it private?</label><br>

    <input type="submit" value="Upload" />
</form>

<table>
    <tr class="Collection">
        <th>Name</th>
        <th>Description</th>
        <th>Collection_id</th>
        <th>Creator_id</th>
    </tr>
    <#foreach item in collections>
        <tr class="Collection">
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.id} </td>
            <td>${item.creatorId} </td>
        </tr>
    </#foreach>
</table>