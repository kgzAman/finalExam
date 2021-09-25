<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Places</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        [data-href] { cursor: pointer; }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Cofe Critic</a>
        <#if principal??>
            <form class="d-flex" style="margin-left: auto">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <p>Hello ${principal.getName()}</p>
            <a href="/place/create"> Add new place</a>
            <form action="/logout">
                <button type="submit">logout</button>
            </form>
            <#else>
                <form action="/login">
                    <button type="submit">login</button>
                </form>
        </#if>
        </div>
    </div>
</nav>
<div class="tit" style="margin: 20px">
    <h1 style="text-align: center"> All Places</h1>
</div>

    <div class="row row-cols-1 row-cols-md-3 g-4" style="display: flex; flex-wrap: wrap; padding-left: 1rem" >
        <#list places as place>
        <div class="card" style="width: 18rem;" data-href onclick="window.location='/place/${place.id}'">
            <img class="card-img-top" src="/img/${place.mainPhotoPath}" alt="Card image cap">
            <div class="car" style=" padding-left: 1rem">
                <p class="card-text">${place.nameOfPlace}</p>
            </div>
            <div class="car" style=" padding-left: 1rem">
                <p class="card-text">${place.counter}</p>
            </div>
            <div class="car" style=" padding-left: 1rem">
                <p class="card-text">${place.getComment()?size}</p>
            </div>
            <div class="car" style=" padding-left: 1rem">
                <p class="card-text">${place.getPhotos()?size}</p>
            </div>
        </div>
        </#list>
    </div>
</body>
</html>
