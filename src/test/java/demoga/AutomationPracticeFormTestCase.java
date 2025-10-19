package demoga;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class AutomationPracticeFormTestCase extends TestBase {

    @Test
    void fillFormTest() {
        String userFirstname = "Aleks";
        String userSurname = "Affj ddj-df";
        String userEmail = "email@gmail.ru";
        String userNumber = "9991123453";
        String gender = "Female";
        String dayOfBirth = "08";
        String monthOfBirth = "January";
        String yearOfBirth = "1986";
        String hobby = "Sports";
        String imagePath = "test.png";
        String state = "NCR";
        String city = "Delhi";
        String subject = "Maths";

        registrationPage.openPage()
                .checkFormTitle("Student Registration Form")
                .setFirstName(userFirstname)
                .setLastName(userSurname)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setHobby(hobby)
                .setState(state)
                .setCity(city)
                .setPicture(imagePath)
                .setSubject(subject)
                .submitForm()
        ;


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", text(userFirstname + " " + userSurname))
                .verifyResult("Student Email", text(userEmail))
                .verifyResult("Gender", text(gender))
                .verifyResult("Mobile", text(userNumber))
                .verifyResult("Date of Birth", text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth))
                .verifyResult("Hobbies", text(hobby))
                .verifyResult("Subjects", text(subject))
                .verifyResult("Picture", text(imagePath))
                .verifyResult("Address", empty)
                .verifyResult("State and City", text(state + " " + city))
        ;
    }
}