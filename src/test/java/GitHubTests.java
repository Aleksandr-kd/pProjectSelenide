import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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
//        search.click();
//        search.setValue("selenide").pressEnter();

        $(By.xpath("//a[@href='/selenide/selenide']"))
                .shouldHave(Condition.text("selenide/selenide"));

    }
}
