package com.example.madagascar;


import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AlexTest {
    @Mock
    private Feline feline;

    @Test
    @DisplayName("getFriends() should return Alex's friends")
    public void testGetFriends() throws Exception {
        Alex alex = new Alex("Самец", feline);
        List<String> expectedFriends = List.of("Марти", "Глории", "Мелман");

        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    @DisplayName("getPlaceOfLiving() should return Alex's living place - 'Нью-Йоркский зоопарк'")
    public void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex("Самец", feline);

        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    @DisplayName("getKittens() should return zero")
    public void testGetKittensReturnsZero() throws Exception {
        Alex alex = new Alex("Самец", feline);

        assertEquals(0, alex.getKittens());
    }

    @Test
    @DisplayName("Constructor with invalid sex should throw exception")
    public void testAlexConstructorInvalidSexThrowsException() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Alex("Неизвестно", feline)
        );

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
