package lesson_1.testPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyMethodTest {
    @BeforeMethod
    public void testBeforeMethod() {
        System.out.println("Our test before method!");
    }
    @AfterMethod
    public void MyAfterMethod () {
        System.out.println("Camon, after go!"); // Виконався останнім, бо має анотацію after!
    }
    @Test
    public void MytestMethod() {
        System.out.println("Test method!");
    }
}

