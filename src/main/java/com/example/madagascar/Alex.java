package com.example.madagascar;

import com.example.Feline;
import com.example.Lion;

import java.util.List;

public class Alex extends Lion {


    public Alex(String sex, Feline feline) throws Exception {
        super(sex, feline);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глории", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
