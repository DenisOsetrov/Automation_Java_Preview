package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    // маємо 1 клас і 4 методи: 1-конфігурація, 2-запуск веб сторінки. 3-чистимо кукі, оновлюємо, запускаємо пусту сторінку, 4-закриваємо веб драйвер
    // перевіряємо на EmptyTest!
    @BeforeClass
    public void configuration () {
        Configuration.holdBrowserOpen = false; // закрити браузер
        Configuration.startMaximized = false;  // на весь екран
        Configuration.timeout = 10000;         // час завантаження елемента (4 по default)
        Configuration.screenshots = false;     // try - зберігає скрін, коли тест впав - папка reports
        Configuration.savePageSource = false;  // по дефолту - try, збірігає html розмітку під час падіння тесту
        Configuration.pageLoadTimeout = 10000; // відкриття сторінки в браузері (30с по дефолту)
    }

    @BeforeMethod
    public void setup () {
        Selenide.open("https://www.google.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanDriver () {
        Selenide.clearBrowserCookies();  // - чисте файли кукі
        Selenide.refresh();              // - використовується для оновлення (перезавантаження) поточної сторінки веб-додатку
        Selenide.open("about:blank");  // - відкриває пусту сторінку
    }

    @AfterClass
    public void tearDown () {
        Selenide.closeWebDriver();
    }
}
