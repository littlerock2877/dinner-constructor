package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DinnerConstructor {
    private HashMap<String, List<String>> menu = new HashMap<>();
    private Random random = new Random();

    public List<List<String>> generateCombos(List<String> dishTypes, int count) {
        List<List<String>> combos = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            combos.add(getDishesCombo(dishTypes));
        }
        return combos;
    }

    public void addNewDish(String dishType, String dishName) {
        if (!menu.containsKey(dishType)) {
            System.out.printf("Добавляем новый тип блюд \"%s\" и новое блюдо в нее \"%s\"\n", dishType, dishName);
            List<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            menu.put(dishType, dishes);
        } else if (!menu.get(dishType).contains(dishName)){
            System.out.printf("Добавляем блюдо \"%s\" в существующий тип блюд \"%s\"\n", dishName, dishType);
            menu.get(dishType).add(dishName);
        } else {
            System.out.printf("Блюдо \"%s\" уже находится в категории \"%s\"\n", dishName, dishType);
        }
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
}
