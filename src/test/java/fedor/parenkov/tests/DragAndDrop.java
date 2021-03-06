package fedor.parenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Point;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void DragDropTest() {

        // ACTION: перетащить квадрат A на квадрат B
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));

        // CHECK: квадраты поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


        // с помощью actions() не работает :( Пробовал такие варианты:

//        actions().moveByOffset(475, 87).clickAndHold().moveByOffset(690, 87).release().perform();
//        actions().moveByOffset(315, 87).clickAndHold().moveByOffset(530, 87).release().perform();
//
//        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
//
//        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
    }
}
