package lesson_1_Foo;

import config.BaseTest;
import org.testng.annotations.Test;

// Відкриває гугл, закриває, чисте, відкриває пусту і закриває браузер! Виводить в термінал "My empty test!"
@Test
public class EmptyTest extends BaseTest {
    public void emptyTest () {
        System.out.println("My empty test!");
    }

}
