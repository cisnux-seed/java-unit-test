package dev.cisnux.unittest;

import org.junit.jupiter.api.*;

//@TestMethodOrder(value = MethodOrderer.MethodName.class)
//@TestMethodOrder(value = MethodOrderer.Random.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
//@TestInstance(value = TestInstance.Lifecycle.PER_METHOD)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class OrderedTest {
    private int count = 0;

    @BeforeAll
    void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    void afterAll() {
        System.out.println("after all");
    }

    @Order(2)
    @Test
    void test1() {
        count++;
        System.out.println(count);
    }

    @Order(3)
    @Test
    void test2() {
        count++;
        System.out.println(count);
    }

    @Order(1)
    @Test
    void test3() {
// PER METHOD
//        OrderedTest test3 = new OrderedTest();
//        test3.test3();
//
//        OrderedTest test2 = new OrderedTest();
//        test2.test2();
//
//        OrderedTest test1 = new OrderedTest();
//        test1.test1();

// PER CLASS
//        OrderedTest test = new OrderedTest();
//        test.test3();
//        test.test2();
//        test.test1();
        count++;
        System.out.println(count);
    }
}
