package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        if (!dc.menu.containsKey(dishType)) {
            System.out.printf("Добавляем новый тип блюд \"%s\" и новое блюдо в нее \"%s\"\n", dishType, dishName);
            List<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dc.menu.put(dishType, dishes);
        } else if (!dc.menu.get(dishType).contains(dishName)){
            System.out.printf("Добавляем блюдо \"%s\" в существующий тип блюд \"%s\"\n", dishName, dishType);
            dc.menu.get(dishType).add(dishName);
        } else {
            System.out.printf("Блюдо \"%s\" уже находится в категории \"%s\"\n", dishName, dishType);
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        List<String> dishTypes = new ArrayList<>();
        while (true) {
            String nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                break;
            }
            dishTypes.add(nextItem);
        }
        printCombos(dc.generateCombos(dishTypes, numberOfCombos));
    }

    private static void printCombos(List<List<String>> combos) {
        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(combos.get(i));
        }
    }
}
