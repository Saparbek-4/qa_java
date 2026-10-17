package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {
    private Feline feline;

    @BeforeEach
    public void setUp() {
        feline = new Feline();
    }

    @Test
    @DisplayName("getFamily() should return 'Кошачьи'")
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    @DisplayName("getKittens() should return default value -> 1")
    public void testGetKittensDefaultValue() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    @DisplayName("eatMeat() should return expected predator meats")
    public void testEatMeat() throws Exception {
        List<String> expectedMeats = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedMeats, feline.eatMeat());
    }

}
