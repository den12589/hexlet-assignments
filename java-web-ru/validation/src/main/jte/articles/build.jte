@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page
@template.layout.page(
    content = @`

    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div class="mb-3">
            <label class="form-label">
                Название
                <input class="form-control" type="title" name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Текст
                <textarea class="form-control"  name="content" >${page.getContent()}</textarea>
            </label>
        </div>
        <input type="submit" value="Создать статью" />
    </form>

`)
