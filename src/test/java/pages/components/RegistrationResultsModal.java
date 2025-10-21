package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
//    public void verifyModalAppears() {
//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//    }
//
//    public void verifyResult(String key, Condition value) {
//        SelenideElement modal = $("[role=dialog]");
//        modal.shouldBe(visible);
//
//        SelenideElement tableTBody = modal.$("table tbody");
//
//        tableTBody.$(byText(key)).parent()
//                .$("td", 1)
//                .shouldBe(value);
//    }

    private final SelenideElement
            modal = $(".modal-content"),
            table = $(".table-responsive"),
            closeBtn = $("#closeLargeModal"),
            modalTitle = $("#example-modal-sizes-title-lg");

    public void verifyModalAppears() {
        modal.should(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));
    }


//    public void verifyResult() {
//        modal.should(appear);
//    }

    public RegistrationResultsModal verifyResult(String key, String value) {
        table.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public void closeModal() {
        closeBtn.click();
    }
}