@import exercise.dto.users.UsersPage
@param UsersPage usersPage

@template.layout.page(
content = @`
    <main>
        <form action="/users" method="get">
            <input type="search" required name="term">
            <input type="submit" value="Искать">
        </form>
        @if(!usersPage.getUsers().isEmpty())
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
        @endif
    </main>
`)
