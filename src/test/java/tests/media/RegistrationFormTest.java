package tests.media;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTest extends TestBase {

    @Test
    void fillFormTest() {
        step("Open and fill Registration form", () -> {

            String name = "Irwing";
            String lastName = "Price";
            String mobile = "1111222234";
            String email = "gvladovsky@gmail.com";

                        open("/automation-practice-form");
                        $("#firstName").setValue(name);
                        $("#lastName").setValue(lastName);
                        $("#userEmail").setValue(email);
                        $("#genterWrapper").$(byText("Male")).click();
                        $("#userNumber").setValue(mobile);
                        $("#dateOfBirthInput").click();
                        $(".react-datepicker__month-select").selectOption("April");
                        $(".react-datepicker__year-select").selectOption("1996");
                        $(".react-datepicker__day--008:not(.react-datepicker__day--selected").click();
                        $("#hobbiesWrapper").$(byText("Reading")).click();

                        $("#subjectsInput").setValue("English").pressEnter();
                        $("#uploadPicture").uploadFromClasspath("img/image.png");
                        $("#currentAddress").setValue("address 1");
                        $("#state").click();
                        $("#stateCity-wrapper").$(byText("NCR")).click();
                        $("#city").click();
                        $("#stateCity-wrapper").$(byText("Delhi")).click();
                        $("#submit").click();
                    });

                step("Check Registration form", () -> {
                    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
                    $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Irwing Price"));
                    $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("gvladovsky@gmail.com"));
                    $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Male"));
                    $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("1111222234"));
                    $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("08 April,1996"));
                    $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("English"));
                    $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Reading"));
                    $$(".table-responsive").findBy(text("Picture")).shouldHave(text("image.png"));
                    $$(".table-responsive").findBy(text("Address")).shouldHave(text("address 1"));
                    $$(".table-responsive").findBy(text("State and City")).shouldHave(text("NCR Delhi"));
                });
            }
    }
