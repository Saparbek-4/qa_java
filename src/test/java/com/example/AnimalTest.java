package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    private Animal animal;

    @BeforeEach
    public void setUp() {
        animal = new Animal();
    }

    @Test
    @DisplayName("getFood() should throw Exception for invalid kind")
    public void testGetFoodThrowsException() {
        Exception exception = assertThrows(
                Exception.class,
                () -> animal.getFood("Undefined")
        );

        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    @DisplayName("getFamily() should return full family")
    public void testGetFamily() {
        String expectedMessage = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedMessage, animal.getFamily());
    }
}