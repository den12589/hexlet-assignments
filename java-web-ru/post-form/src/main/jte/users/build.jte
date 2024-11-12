@template.layout.page(
content = @`
    <main>
        <h1>Регистрация</h1>
        <form action="/users" method="post">
            <label>Firstname
                <input type="text" name="firstName"/>
            </label>

            <label>Lastname
                <input type="text" name="lastName"/>
            </label>

            <label>
                Email
                <input type="email" required name="email"/>
            </label>

            <label>
                Пароль
                <input type="password" required name="password"/>
            </label>

            <input type="submit" value="Зарегистрировать"/>
        </form>
    </main>
`
)
