package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, List<String>> menu = new HashMap<>();
    Random random = new Random();

    public List<List<String>> generateCombos(List<String> dishTypes, int count) {
        List<List<String>> combos = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            combos.add(getDishesCombo(dishTypes));
        }
        return combos;
    }

    private List<String> getDishesCombo(List<String> dishTypes) {
        List<String> comboDinner = new ArrayList<>();
        for (int i = 0; i < dishTypes.size(); i++) {
            String dishType = dishTypes.get(i);
            if (checkType(dishType)) {
                List<String> dishes = menu.get(dishType);
                int upperBound = random.nextInt(dishes.size());
                comboDinner.add(dishes.get(upperBound));
            }
        }
        return comboDinner;
    }

    private boolean checkType(String dishType) {
        return menu.containsKey(dishType);
    }
}
