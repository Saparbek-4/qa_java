package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalParameterizedTest {

    static Stream<Arguments> provideAnimalData() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideAnimalData")
    @DisplayName("getFood() should return valid list of foods")
    public void testGetFoodSuccess(String animalKind, List<String> expectedFoodList) throws Exception {
        Animal animal = new Animal();
        List<String> actualFoodList = animal.getFood(animalKind);
        assertEquals(expectedFoodList, actualFoodList);

    }
}
