package com.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TexttBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        String name = "Slava";

        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("name");
        $("#userEmail").setValue("slava@test.com");
        $("#currentAddress").setValue("Dnipro");
        $("#permanentAddress").setValue("Polya");
        $("#submit").click();

        $("#output").shouldHave(text("name"), text("slava@test.com"));
    }

    @Test
    void practiceFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Slava");
        $("#lastName").setValue("Slava");
        $("#userEmail").setValue("slava@qwerty.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567898");

        //dateOfBirth form
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select option:nth-child(10)").click();
        $(".react-datepicker__year-select option:nth-child(87)").click();
        $(".react-datepicker__week:nth-child(5) > div.react-datepicker__day--026").click();

        $("#subjectsInput").setValue("Simply subject");
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("selenide-logo-big.png");
        $("#currentAddress").setValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pretium.\n" +
                "\n");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
        $("#submit").click();

        //assert final table
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Student Name " + "Slava Slava"),
                text("Student Email " + "slava@qwerty.com"),
                text("Mobile " + "1234567898"),
                text("Date of Birth " + "26 October,1986"),
                text("Hobbies " + "Sports"),
                text("Address " + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pretium."),
                text("State and City " + "Uttar Pradesh Merrut"));




        sleep(3000);








//        $("#subjectsContainer").setValue("maybe empty?)");
//        $("#hobbies-checkbox-1").
    }
//
////    @Test
////    void TestStructure() {
////        //arrange | given//
////        // act   | when//
////        //assert | then
////    }
 }
