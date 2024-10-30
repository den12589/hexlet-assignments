@import exercise.dto.users.UsersPage
@param UsersPage usersPage

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <table class="table table-success table-hover table-striped table-borderless table-sm"><h2>Пользователи</h2>
            <thead>
            <tr class="table-secondary ">
                <th class="table-secondary" scope="col">ID</th>
                <th class="table-secondary" scope="col">FirstName</th>
                <th class="table-secondary" scope="col">LastName</th>
                <th class="table-secondary" scope="col">Email</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : usersPage.getUsers())
                <tr>
                    <th scope="row"><a href="/users/${user.getId()}">${user.getId()}</a></th>
                    <td class="table-active">${user.getFirstName()}</td>
                    <td class="table-active">${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    </main>
</div>
</body>
</html>