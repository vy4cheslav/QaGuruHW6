import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DragNDrop {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void solutionDragNDrop(){
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement column1 = $("#column-a");
        SelenideElement column2 = $("#column-b");
//        $("#column-a").shouldHave(Condition.text("A"));
//        $("#column-b").shouldHave(Condition.text("B"));
//        actions().clickAndHold(column1).moveToElement(column2).release().build().perform();

//        actions().dragAndDrop(column1, column2).build().perform();
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));



    }
}
