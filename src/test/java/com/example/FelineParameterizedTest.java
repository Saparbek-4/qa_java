package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {
    @ParameterizedTest
    @DisplayName("getKittens(int kittensCount) should return expected amounts")
    @CsvSource({
            "1, 1",
            "3, 3",
            "5, 5"
    })
    public void testGetKittensWithParams(int input, int expected) {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}
