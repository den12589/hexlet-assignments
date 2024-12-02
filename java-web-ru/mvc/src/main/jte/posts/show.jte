@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content = @`
        <main>
            <div class="mx-auto p-4 py-md-5">
                <h1>${page.getPost().getName()}</h1>
            </div>

            <div class="mx-auto p-4 py-md-5">
                ${page.getPost().getBody()}
            </div>
            <!-- BEGIN -->
            <div>
                <form method="get" action="${NamedRoutes.editPostPath(page.getPost().getId())}" >
                    <input type="submit" class="btn btn-primary" value="Редактировать"  />
                </form>
            </div>
            <!-- END -->
        </main>
    `
)
