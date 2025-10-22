package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private static final String TITLE_TEXT = "Student Registration Form";
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            hobbyInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture");


    @Step("Открываем главную страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove();$('#adplus-anchor').remove();$('footer').remove();");

        return this;
    }
    @Step("Устанавливаем имя {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Устанавливаем фамилию {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String month, String year, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String path) {
        pictureInput.uploadFromClasspath(path);

        return this;
    }

    public RegistrationPage checkFormTitle(String value) {
        $("#userForm").parent().$("h5").shouldHave(text(value));

        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue("" + value.charAt(0)).click();
        $("#react-select-2-option-0").shouldBe(visible).shouldBe(text(value)).click();

        return this;
    }

    public void submitForm() {
        $("#submit").click(); // Doesnt work!!!
//        $("#subjectsInput").pressEnter();
    }
}