package org.example.fourth;

public class SomeTest {

    @Test
    public static boolean firstTest() {
        System.out.println("@Test");
        return true;
    }

    @Test
    public static boolean secondTest() {
        System.out.println("@Test");
        return true;
    }

    @Before
    public static void beforeTest() {
        System.out.println("@Before");
    }

    @After
    public static void afterTest() {
        System.out.println("@after");
    }
}
