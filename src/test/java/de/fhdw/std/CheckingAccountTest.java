package de.fhdw.std;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {

    @Test
    void succeedingTest() {
        Assertions.assertEquals(0.1, 0.1, "Should be equal!");
    }

    @Test
    void failingTest() {
        Assertions.assertEquals(42, 23, "Should be equal!");
    }
}