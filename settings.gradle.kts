rootProject.name = "pProjectSelenide"
include("src:test:selenide")
findProject(":src:test:selenide")?.name = "selenide"
