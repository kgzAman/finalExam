<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>create Place</title>
</head>
<body>
<div>
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