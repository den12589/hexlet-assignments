@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page
@template.layout.page(content = @`

    @if(page != null)
        <h4>${page.getError()}</h4>
    @endif
    <main>
        <form action="${NamedRoutes.loginPath()}" method="post">
            <label>Имя
                <input type="text" name="name"/>
            </label>
            <label>Пароль
                <input type="text" name="password"/>
            </label>
            <input type="submit" value="Зарегистрироваться"/>
        </form>
    </main>

`)