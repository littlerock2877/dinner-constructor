package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, List<String>> menu = new HashMap<>();
    private Random random = new Random();
    private static final int GENERATE_ATTEMPTS = 50;

    public List<List<String>> generateCombos(List<String> dishTypes, int count) {
        List<List<String>> combos = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            addUniqueCombo(combos, dishTypes);
        }
        return combos;
    }

    private List<String> getDishesCombo(List<String> dishTypes) {
        List<String> comboDinner = new ArrayList<>();
        for (int i = 0; i < dishTypes.size(); i++) {
            String dishType = dishTypes.get(i);
            if (checkType(dishType)) {
                List<String> dishes = menu.get(dishType);
                int dishIndex = random.nextInt(dishes.size());
                comboDinner.add(dishes.get(dishIndex));
            }
        }
        return comboDinner;
    }

    private boolean checkType(String dishType) {
        return menu.containsKey(dishType);
    }

    private void addUniqueCombo(List<List<String>> listOfCombos, List<String> dishTypes) {
        List<String> combo;
        for (int i = 0; i < GENERATE_ATTEMPTS; i++) {
            combo = getDishesCombo(dishTypes);
            if (listOfCombos.contains(combo)) {
                continue;
            }
            listOfCombos.add(combo);
            return;
        }
        System.out.println("Не удалось сформировать комбо обед по заданным данным");
    }
}
