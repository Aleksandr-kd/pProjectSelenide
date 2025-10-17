import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTests {

    @Test
    void successfulLoginTest(){
        open("https://www.google.com/");

        $(By.xpath("//span[text()='Режим ИИ']")).shouldHave(Condition.text("Режим ИИ"));;
        $(By.xpath("//textarea[@title='Поиск']")).setValue("красотка").pressEnter();

    }
}
