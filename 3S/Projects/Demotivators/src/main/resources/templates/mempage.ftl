<!DOCTYPE html>
<html>
<head>
    <style>
        <#include "css/mystyle.css">
    </style>
</head>
<body>


<div class="img-container">
    <img src="/app/${mem.path}" alt="your_mem">
</div>

<a>${mem.description}</a>
<br/>
<a>${mem.tags}</a>

<br />

<#foreach item in comments>
    <div class = "comment">
        <a>${item.text}</a>
        <br/>
        <a>${item.userId}</a>
    </div>
</#foreach>


<form method="POST">
    <a>Your comment</a>
    <textarea name="comment" rows="4" cols="50"> </textarea>
    <input type="submit" value="enter">
</form>
