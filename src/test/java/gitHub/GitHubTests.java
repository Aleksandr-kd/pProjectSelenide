package gitHub;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubTests {

    @Test
    void git() {
        open("https://www.github.com/");

        $(By.xpath("//span[@class='flex-1']")).click();
        $(By.xpath("//input[@id='query-builder-test']")).setValue("selenide").pressEnter();
        $(By.xpath("//a[@href='/selenide/selenide']"))
                .shouldHave(Condition.text("selenide/selenide"));

    }
}
