package com.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
    void TestStructure() {
        //arrange | given

        // act   | when

        //assert | then
    }
}
