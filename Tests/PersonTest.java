import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person p1;
    private Person p2;
    private Person p3;

    @BeforeEach
    void SUGetAge() {
        LocalDate now = LocalDate.now();
        LocalDate birthday1 = now.minusYears(25).minusDays(1);
        LocalDate birthday2 = now.minusYears(25);
        LocalDate birthday3 = now.minusYears(25).plusDays(1);

        p1 = new Person("T1", birthday1);
        p2 = new Person("T2", birthday2);
        p3 = new Person("T3", birthday3);
    }

    @Test
    @DisplayName("Test age of person whose birthday was yesterday 25 years ago. EXPECTED: 25")
    void getAgeT1() {
        // ARRANGE -> Creating of the test objects and setting values. This is a bit done in the SetUp
        // This is already done in the SUGetAge (Set Up)

        // ACT -> Here goes the actual calls of the tested methods
        int age = p1.getAge();

        // ASSERT -> Compare expected value with actual value
        Assertions.assertEquals(25, age, "This sucks, the test failed. Age should be 25");
    }

    @Test
    @DisplayName("Test age of person whose birthday is today. EXPECTED: 25")
    void getAgeT2() {
        // ARRANGE

        // ACT
        int age = p2.getAge();

        // ASSERT
        Assertions.assertEquals(25, age, "This sucks, the test failed. Age should be 25");
    }

    @Test
    @DisplayName("Test age of person whose birthday is tomorrow 25 years ago. EXPECTED: 24")
    void getAgeT3() {
        int age = p3.getAge();

        Assertions.assertEquals(24, age, "This sucks, the test failed. Age should be 24");
    }

    @Test
    @DisplayName("Create a clone of person 1 and compare them.")
    void eqpalPersonTest() {
        Person p4 = new Person(p1.getName(), p1.getDateOfBirth());

        Assertions.assertEquals(p1, p4, "Compared persons are not the same");
        Assertions.assertSame(p1, p4, "Should be same reference");
    }

    @Test
    @DisplayName("Test adding a child to the parent")
    void addChild() {
        Person parent = new Person("Parten", LocalDate.of(1965, 12, 5));
        List<String> children = new ArrayList<>(Arrays.asList("Job" , "Klaas" , "Zoef"));

        // ACT
        for(String child: children){
            parent.addChild(child);
        }

        List<String> childOfParent = parent.getChildren();

        // ASSERT
        assertEquals(3, childOfParent.size());
        assertIterableEquals(children, childOfParent);
    }
}