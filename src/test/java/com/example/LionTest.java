package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    @Mock
    private Feline feline;

    @Test
    @DisplayName("getKittens() should return feline default value -> 1")
    public void testGetKittensDefaultValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    @DisplayName("getFood() should return expected meat list")
    public void testGetFoodSuccess() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedMeats = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedMeats);

        assertEquals(expectedMeats, lion.getFood());
    }

    @Test
    @DisplayName("getFood() should throw Exception when feline fails")
    public void testGetFoodThrowsException() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenThrow(new Exception("Feline Error"));

        Exception expectedException = assertThrows(
                Exception.class,
                lion::getFood
        );

        assertEquals("Feline Error",expectedException.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    @DisplayName("doesHaveMane() returns expected values")
    public void testDoesHaveManeSucceeds(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    @DisplayName("Lion Constructor throws exception when value is not valid")
    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
        Exception expectedException = assertThrows(
                Exception.class,
                () -> new Lion("Not Defined", feline)
        );

        assertEquals("Используйте допустимые значения пола животного - самей или самка",expectedException.getMessage());
    }

}
