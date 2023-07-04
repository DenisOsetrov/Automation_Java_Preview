package lesson_1.testPackage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

// використання фреймворку Selenide
public class NewConfigurationTest {
    @BeforeClass  // Анотація @BeforeClass не робить сама Unit test class без @Test!
    public void testConfiguration() {
        Configuration.browser = "chrom";        // метод встановлює браузер за замовчуванням для тестування
        Configuration.holdBrowserOpen = true;   // метод вказує, що після завершення виконання тестів браузер буде залишений відкритим.
        Configuration.baseUrl = "https://example.com";// метод встановлює базовий URL для веб-сторінок, що використовуються у ваших тестах.
        // Можна встановити цей URL, і потім використовувати відносні шляхи для знаходження елементів на сторінці.
        Configuration.timeout = 5000;   // метод встановлює таймаут для очікування елементів на сторінці. За замовчуванням 4 секунд.
        Configuration.headless = true;  // метод дозволяє запускати браузер в безголовому режимі (headless mode).
        // В безголовому режимі браузер не відображається на екрані, це знижує навантаження на систему.
        Configuration.browserSize = "1366x768";       // метод дозволяє встановити розмір вікна браузера, в якому виконується тестування. За замовчуванням -повноекранний режим.
        Configuration.reportsFolder = "test-reports"; // метод встановлює шлях до папки, в якій будуть зберігатися звіти тестів. За замовчуванням Selenide зберігає звіти в папці "build/reports/tests"
        Configuration.screenshots = false;            // метод дозволяє вимкнути збереження скріншотів під час виконання тестів. За замовчуванням Selenide зберігає скріншоти в папці "build/reports/tests"
        Configuration.timeout = 10000;                 // очікування окремих елементів, за замовчеванням - 5 сек.
        Configuration.pageLoadStrategy = "normal"; // "eager" - швидке завантаження сторінки
        Configuration.savePageSource = false;  // збірігає html розмітку під час падіння тесту - рідко використовується try!
        Configuration.pageLoadTimeout = 10000; // час відкриття сторінки в браузері (30с по дефолту)



    }

    @Test
    public void testSomething() {
        System.out.println("My configuration test & method");
    }


    // 1. Перевірка наявності елемента на сторінці:
    @Test()
    public void testSomething1() {
        // Відкриття сторінки
        open("/home");

        // Перевірка наявності елемента з ідентифікатором "username"
        $(By.id("username")).shouldBe(visible);
    }


    // 2. Перевірка введення тексту в поле введення:
    @Test
    public void testSomething2() {
        // Відкриття сторінки
        open("/login");

        // Введення логіна та пароля
        $(By.id("username")).setValue("testuser");
        $(By.id("password")).setValue("password123");

        // Перевірка, що введений текст співпадає з очікуваним значенням
        $(By.id("username")).shouldHave(value("testuser"));
        $(By.id("password")).shouldHave(value("password123"));
    }


    // 3. Клік по елементу та перевірка результуючої сторінки:
    @Test
    public void testSomething3() {
        // Відкриття сторінки
        open("/home");

        // Клік по посиланню з текстом "Детальніше"
        $(By.linkText("Детальніше")).click();

        // Перевірка, що поточна URL сторінки містить певну частину
        String currentUrl = url();
        Assert.assertTrue(currentUrl.contains("details"));
    }


    // 4. Перевірка наявності елементів в таблиці:
    @Test
    public void testSomething4 () {
        // Відкриття сторінки
        open("/products");

        // Знаходження всіх елементів таблиці з класом "product"
        ElementsCollection products = $$(".product");

        // Перевірка, що кількість елементів відповідає очікуваній кількості
        Assert.assertEquals(products.size(), 10);

        // Перевірка, що всі елементи мають очікуваний текст
        for (SelenideElement product : products) {
            product.shouldHave(text("Product Name"));
        }
    }


}