<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Cofe Critic</a>
        <form class="d-flex" style="margin-left: auto">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <#if principal??>
            <p>Hello ${principal.getName()}</p>
            <a href="/place/create"> Add new place</a>
        </#if>
    </div>
</nav>

<div class="body" style="margin: 40px">
    <div class="photo-title"  style="width: 100%;">
        <div style="display: flex">
            <div class="title" style=";width: 50%;height: auto;">
                <h2>${place.nameOfPlace}</h2>
                ${place.description}
            </div>
            <div class="title" style="width: 50%;height: auto;border-bottom: 1px solid black">
                <img src="/img/${place.mainPhotoPath}">
            </div>
        </div>
    </div>
    <div>
        <#list place.photos as photo>
            <img src="/img/${photo.photoNamePath}" class="img-thumbnail" style="height: 150px;width: auto; border-bottom: 1px solid black; padding: 10px">
        </#list>

        <div class="reat" style="border: 1px solid black; margin: 20px;margin-left: 0px">
            Rating ${place.counter}
        </div>

        <#list place.comment as comment>
            <p> On ${comment.createdDate},
                ${comment.user.name} said
            </p> <hr>
            ${comment.context}
        </#list>
    </div>
    Add review
    <div class="add-rewiev" style="border-bottom: 1px solid black">
        <form action="/place/addComment/${place.id}" method="post">
            <input type="text" name="id" hidden>
            <label for="w3review"></label>
            <textarea id="w3review" name="text" rows="4" cols="50"></textarea><hr>
            <div class="rating" style="display: flex">
                Rating <input type="number" id="tentacles" name="tentacles"
                              min="1" max="10">
                <button style="margin-left: auto" type="submit">Submit comment</button>
            </div>
        </form>
    </div>
    <div class="newPhoto">
        <h3> Upload new photo</h3><hr>
            <form enctype="multipart/form-data" action="/place/addPhoto/${place.id}" method="post">
                <div class="photo" style="margin: 20px;margin-left: 0px">
                    <p style="width: 50%">Main Photo</p>
                    <label>
                        <input type="file" name="file" placeholder="add description">
                    </label>
                </div>
                <button type="submit">Upload</button>
            </form>
    </div>
</div>

</body>
</html>