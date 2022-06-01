package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {


    @Test
    void successfulTest() {
        String name = "Alex";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("alex@egorov.com");
        $("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Another address 2");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(name), text("alex@egorov.com"),
                text("Some address 1"), text("Another address 2"));
    }
}
