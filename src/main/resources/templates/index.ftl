<!DOCTYPE html>
<html>
    <head>
        <title>Todo list</title>
    </head>
    <body>
        <h1>${model.name}</h1>
        <table>
            <tr>
                <th></th><th>Task</th><th>Done</th><th>Change "done" mark</th><th>Index</th>
            </tr>
            <#list model.tasks?keys as index>
            <#assign task=model.tasks[index]>
                <tr>
                    <td>
                        <form action="remove.html" method="post">
                            <input type="hidden" name="id" value="${index}"/>
                            <input type="submit" value="Remove">
                        </form>
                    </td>
                    <td>${task.name?html}</td><td>${task.done?string('yes', 'no')}</td>
                    <td>
                        <form action="changeDoneMark.html" method="post">
                            <input type="hidden" name="id" value="${index}"/>
                            <input type="submit" value="Change \"done\" Mark">
                        </form>
                    </td>
                    <td>"${index}"</td>
                </tr>
            </#list>
        </table>
        <form action="add.html" method="post">
            <input type="text" name="newTaskName"/>
            <input type="submit" value="   Add   " />
        </form>
    </body>
</html>
