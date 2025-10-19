package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class FillFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.headless = false;
    }

    @Test
    void fillFormTest() {
        String firstName = "Alex";
        String lastName = "Alex D";
        String email = "email@mail.ru";

        open("/automation-practice-form");

        $x("//input[@id='firstName']").setValue(firstName);
        $x("//input[@id='lastName']").setValue(lastName);
        $x("//label[@for='gender-radio-1']").click();
        $x("//input[@id='userNumber']").setValue("88888888888");
        $x("//button[@id='submit']").click();

        $x("//tr[td[text()='Student Name']]/td[2]")
                .shouldHave(exactText(firstName + " " + lastName));
        $x("//button[@id='closeLargeModal']").click();


    }
}
