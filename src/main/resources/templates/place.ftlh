<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>create Place</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div>
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
    <div class="title" style="text-align: center; margin: 20px">
        <h1>
            Add new place
        </h1>
    </div>

    <div class="main">
        <form enctype="multipart/form-data" action="/place/create" method="post">
            <div class="title" style="margin: 20px">
                <p style="width: 50%">Title</p>
            <label>
                <input type="text" name="nameOfPlace" placeholder="add name of place">
            </label>
            </div>
            <div class="description" style="margin: 20px">
                <p style="width: 50%">Description</p>
                <label>
                        <input type="text" name="description" placeholder="add description">
                </label>
            </div>
            <div class="photo" style="margin: 20px">
                <p style="width: 50%">Main Photo</p>
                <label>
                        <input type="file" name="file" placeholder="add description">
                </label>
            </div>
            <button type="submit">Submit new Place</button>

        </form>

    </div>


</div>

</body>
</html>