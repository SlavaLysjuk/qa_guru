import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://www.google.com/");
        // Ввести Selenide в поиск
        //$("name=\"q\"").sendKeys("Selenide");
        $(byName("q")).setValue("Selenide").pressEnter();

        sleep(5000);
        // Проверить, что Selenide появился в результатах поиска
        $("#search").shouldHave(text("selenide.org"));
    }
}
