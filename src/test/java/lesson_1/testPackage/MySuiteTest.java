package lesson_1.testPackage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MySuiteTest {

    @BeforeSuite
    public void setUpSuite() {
        // Виконується перед виконанням всього тестового набору
        System.out.println("Підготовка перед запуском тестового набору...");
    }

    @Test
    public void testMethod1() {
        // Тестовий метод 1
        System.out.println("Виконується тестовий метод 1");
    }

    @Test
    public void testMethod2() {
        // Тестовий метод 2
        System.out.println("Виконується тестовий метод 2");
    }
}
