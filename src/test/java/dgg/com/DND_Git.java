package dgg.com;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DND_Git {

        @BeforeAll
        static void beforeAll() {
            Configuration.startMaximized = true;
        }

        @AfterEach
        void afterEach() {
            Selenide.closeWebDriver();
        }

        @Test
        void gitHubWikiTest(){
            open("https://github.com/selenide/selenide");
            $("#wiki-tab").click();
            $("#wiki-body .markdown-body ul").$(byText("Soft assertions")).click();
            $("#wiki-content").shouldHave(text("Using JUnit5"));
        }

        @Test
        void dndTesting(){
            open("https://the-internet.herokuapp.com/drag_and_drop");
            $("#column-a").dragAndDropTo("#column-b");
            $("#column-a").shouldHave(text("b"));
        }


    }

