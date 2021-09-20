package dgg.com;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropGitTests {

        @BeforeAll
        static void beforeAll() {
            Configuration.startMaximized = true;
        }

        @Test
        void gitHubWikiTest(){
            open("https://github.com/selenide/selenide");
            $("#wiki-tab").click();
            $(".wiki-more-pages-link .btn-link").scrollTo().click();
            $(".wiki-more-pages").shouldBe(visible);
            $("#wiki-pages-box").$(byText("SoftAssertions")).click();
            $("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"));
        }

        @Test
        void dndTesting(){
            open("https://the-internet.herokuapp.com/drag_and_drop");
            $("#column-a").dragAndDropTo("#column-b");
            $("#column-a").shouldHave(text("b"));
        }
    }

