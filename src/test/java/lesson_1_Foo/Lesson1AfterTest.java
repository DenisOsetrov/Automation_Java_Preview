package lesson_1_Foo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.BaseTest;
import org.testng.annotations.*;

public class Lesson1AfterTest extends BaseTest {
//    @BeforeSuite
//    public void beforeSuiteTest () {
//        System.out.println("BeforeSuiteTest");
//
//    }
//    @BeforeClass
//    public void beforeClassTest () {
//        System.out.println("BeforeClassTest");
//    }
//    @BeforeTest
//    public void beforeTest () {
//        System.out.println("BeforeTest");
//    }
//    @BeforeMethod
//    public void beforeMethodTest () {
//        System.out.println("BeforeMethod");
//    }
//    @Test
//    public void test (){
//    System.out.println("Test");
//    }
//    @AfterMethod
//    public void afterMethodTest () {
//        System.out.println("AfterMethodTest");
//    }
//    @AfterTest
//    public void afterTest () {
//        System.out.println("AfterTest");
//    }
//    @AfterClass
//    public void afterClassTest () {
//        System.out.println("AfterClassTest");
//    }
//    @AfterSuite
//    public void afterSuiteTest () {
//        System.out.println("AfterSuiteTest");
//    }
//    @Test
//    public void test2 () {
//        System.out.println("Test 2");
//    }

   // робота з веб сторінкою
//    @Test
//    public void test () {
//        // mvn test '-Dtest=lesson_1_Foo.*Test' - запуск через термінал всіх тестів з цього пекедж
//        // mvn test '-Dtest=.*Test' - запуск всіх тестів, без різниці, де знаходяться
//        // $ mvn test '-Dtest=Lesson1AfterTest' - запуск з терміналу
//        Configuration.holdBrowserOpen = true;
//        Selenide.open("www.google.com");
//    }

    @BeforeTest
    public void setup () {
        //Configuration.browser = "edge";
        Configuration.holdBrowserOpen = false; // закрити браузер
        Configuration.startMaximized = false;  // на весь екран
        //Configuration.browserSize = "1200x1024";
        Configuration.headless = false;        // при try працюватиме під капотом, без браузера
        Configuration.timeout = 10000;         // час завантаження елемента (4 по default)
        Configuration.pageLoadStrategy = "normal"; // "eager" - швидке завантаження сторінки
        Configuration.screenshots = false;     // try - зберігає скрін, коли тест впав - папка reports
        Configuration.savePageSource = false;  // gпо дефолту - try, збірігає html розмітку під час падіння тесту
        Configuration.pageLoadTimeout = 10000; // відкриття сторінки в браузері (30с по дефолту)




            }
    @Test
    public void pageTest () {
        Selenide.open("https://www.google.com/");
        Selenide.sleep(3000); // затримка
    }

    @Test
    public void tearDown () {
        Selenide.clearBrowserCookies();  // - чисте файли кукі
        Selenide.refresh();              // - використовується для оновлення (перезавантаження) поточної сторінки веб-додатку
        Selenide.open("about:blank");  // - відкриває пусту сторінку
    }
}
