package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testData.TestData;

import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class AutomationPracticeFormTestCase extends TestBase {

    TestData testData = new TestData();

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Регистрация пользователя", () -> {
        registrationPage.openPage()
                .checkFormTitle("Student Registration Form")
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setPhone(testData.userCellNumber)
                .setBirthDate(testData.dayMonthYear[0], testData.dayMonthYear[1], testData.dayMonthYear[2])
                .setHobby(testData.hobby)
                .setState(testData.state)
                .setCity(testData.city)
                .setPicture(testData.filePath)
                .setSubject(testData.subject)
                .submitForm();
        });


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userCellNumber)
                .verifyResult("Date of Birth", testData.dateOfBirth)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Picture", testData.filePath)
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", testData.state + " " + testData.city)
        ;
    }
}