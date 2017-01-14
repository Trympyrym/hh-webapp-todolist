<!DOCTYPE html>
<html>
    <head>
        <title>Todo list</title>
    </head>
    <body>
        <h1>Edit</h1>
        <p>Old name: ${model.taskName?html}</p><br>
        <p>New name:</p><br>
        <form action="rename.html" method="post">
            <input type="hidden" name="id" value="${model.index}">
            <input type="text" name="newName">
            <input type="submit" value="Rename">
        </form>
    </body>
</html>
