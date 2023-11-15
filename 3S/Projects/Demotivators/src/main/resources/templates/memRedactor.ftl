<!DOCTYPE html>
<html>
<head>
    <style>
        <#include "css/mystyle.css">
    </style>
</head>

<div class="img-container">
    <img src="./images/${mem.picture}" alt="your_mem">
</div>

<#if isHaveRights>
    <form method="Post" action="">
        <#if mem.commentsAllowed>
            <input type="checkbox" name="isCommentsAllowed" checked>
        <#else>
            <input type="checkbox" name="isCommentsAllowed">
        </#if>
        <label for="isCommentsAllowed"> Are comments allowed?</label><br>

        <input type="checkbox" name="deleteMem">
        <label for="deleteMem">Delete mem?</label><br>



        <textarea name="description" rows="4" cols="50">${mem.description}</textarea>
        <textarea name="tags" rows="4" cols="50">${mem.tags} </textarea>

        <input type="submit" value="Upload"/>
    </form>
<#else>
    <a> ${mem.description} </a>
    <br />

    <a> ${mem.tags} </a>
    <br />
</#if>