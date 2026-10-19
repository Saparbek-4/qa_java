package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {
    @Mock
    private Feline feline;

    @InjectMocks
    private Cat cat;

    @Test
    @DisplayName("getSound() should return 'Мяу'")
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    @DisplayName("getFood() should return meat list when feline succeeds")
    public void testGetFoodSuccess() throws Exception {
        List<String> expectedMeats = List.of("Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expectedMeats);

        assertEquals(expectedMeats, cat.getFood());
    }

    @Test
    @DisplayName("getFood() should throw Exception when feline fails")
    public void testGetFoodThrowsException() throws Exception {
        Mockito.when(feline.eatMeat()).thenThrow(new Exception("Predator error"));

        Exception expectedException = assertThrows(
                Exception.class,
                () -> cat.getFood()
        );

        assertEquals("Predator error",expectedException.getMessage());
    }
}
