<#include "common.ftl">
<#include "menu.ftl">

<form method="POST" enctype='multipart/form-data'>
    <input type="file" name="file" />

    <input type="checkbox"  name="isCommentsAllowed">
    <label for="isCommentsAllowed"> Are comments allowed?</label><br>

    <a>Description</a>
    <textarea name="description" rows="4" cols="50"> </textarea>

    <br />

    <a>Tags</a>
    <textarea name="tags" rows="4" cols="50"> </textarea>


    <input type="submit" value="Upload" />


</form>

