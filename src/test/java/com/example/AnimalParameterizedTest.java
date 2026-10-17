package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalParameterizedTest {
    @ParameterizedTest
    @CsvSource({
            "Травоядное, Трава",
            "Хищник, Животные"
    })
    @DisplayName("getFood() should return valid list of foods")
    public void testGetFoodSuccess(String animalKind, String expectedFirstItem) throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood(animalKind);
        assertEquals(expectedFirstItem, food.get(0));
    }
}
