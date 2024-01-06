import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class Solution {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void solutionEnterprizeHover(){
      Selenide.open("https://github.com");
      $$(".HeaderMenu-link").filterBy(text("\n" +
              "        Solutions\n" +
              "        ")).first().hover();
      $$(".HeaderMenu-dropdown-link").filterBy(text("Enterprise")).first().click();
      $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));

    }
}
