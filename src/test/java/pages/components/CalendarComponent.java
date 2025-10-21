package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        final SelenideElement
                monthElement = $(".react-datepicker__month-select"),
                yearElement = $(".react-datepicker__year-select"),
                dayElement = $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)");

        monthElement.selectOption(month);
        yearElement.selectOption(year);
        dayElement.click();
    }
}