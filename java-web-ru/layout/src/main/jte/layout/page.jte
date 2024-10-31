@import gg.jte.Content
@param Content content

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="http://localhost:7070" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="http://localhost:7070/users" class="nav-link">Users</a></li>
            </ul>
        </header>
        ${content}
        <footer class="py-3 my-4">
            <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                <li class="nav-item"><a href="http://localhost:7070" class="nav-link px-2 text-muted">Home</a></li>
                <li class="nav-item"><a href="http://localhost:7070/users" class="nav-link px-2 text-muted">Users</a></li>
            </ul>
            <p class="text-center text-muted">© 2024 My first page</p>
        </footer>
    </main>
</div>
</body>
</html>
