<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${backToAuthorisation}">Home</a>
            <a class="nav-item nav-link" href="${toScroll}">To Scroll</a>
            <a class="nav-item nav-link" href="${toFriendsScroll}">To Friends Scroll</a>
            <a class="nav-item nav-link" href="${toMemUpload}">To Mem upload</a>
            <a class="nav-item nav-link" href="${toRequest}">To requests</a>
            <a class="nav-item nav-link" href="${toCollections}">To collection</a>
            <a class="nav-item nav-link" href="${toAddCollections}">To add to collection</a>
            <a class="nav-item nav-link" href="${toFriends}">To friends</a>
            <#if x = 1>
                <a class="nav-item nav-link" href="${toUsers}">To users</a>
            </#if>
        </div>
    </div>
</nav>