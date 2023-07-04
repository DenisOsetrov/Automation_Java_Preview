package lesson_1.testPackage;// import org.testng.annotations.Test;  // - можемо замінити на всі імпорти анотацій *
import org.testng.annotations.*;

public class FirstTest {
@BeforeSuite
@BeforeClass
@BeforeMethod
    @Test
    public void test() {
        System.out.println("Our first test!");


    }
}
