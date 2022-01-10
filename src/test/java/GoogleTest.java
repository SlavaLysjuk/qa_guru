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
        $(byName("q")).setValue("fantasy premier league").pressEnter();

        sleep(5000);
        // Проверить, что fantasy.premierleague.com появился в результатах поиска
        $("#search").shouldHave(text("fantasy.premierleague.com"));
    }
}
