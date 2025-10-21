package tests;

import org.junit.jupiter.api.Test;
import testData.TestData;


public class AutomationPracticeFormTestCase extends TestBase {

    TestData testData = new TestData();

    @Test
    void fillFormTest() {

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
                .submitForm()
        ;

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userCellNumber)
                .verifyResult("Date of Birth", testData.dateOfBirth)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Picture", testData.fileName)
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", testData.state + " " + testData.city)
        ;
    }
}