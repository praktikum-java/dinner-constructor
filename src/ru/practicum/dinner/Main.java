package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //static DinnerConstructor dc;
    static Scanner scanner;
    static Random random;
    static DinnerConstructor dinnerConstructor;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);
        random = new Random();

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
                case "4": //TODO remove the command before review
                    addNewDishFromDatasets();
                case "5"://TODO remove the command before review
                    generateDishComboFromDatasets(setDefaultDishTypes());
                default:
                    System.out.println("Выберите команду из списка");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
        System.out.println("4 - Использовать готовые наборы данных (категории и блюда)"); //TODO remove the command before review
        System.out.println("5 - Использовать готовый набор категорий для формирования комбоВ:)");//TODO remove the command before review
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dinnerConstructor.setDishes(dishType, dishName);
    }

    private static void addNewDishFromDatasets() {
        dinnerConstructor.setDefaultDishes();
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> inputtedItems = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            inputtedItems.add(nextItem);
            nextItem = scanner.nextLine();
        }
        System.out.println(inputtedItems);
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : inputtedItems) {
                int bound = random.nextInt(dinnerConstructor.dishes.get(type).size());
                combo.add(dinnerConstructor.dishes.get(type).get(bound));
            }
            System.out.printf("Комбо %d \n %s \n", (i + 1), combo);
        }
    }

    private static void generateDishComboFromDatasets(ArrayList<String> list) { //TODO remove the method before review
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        System.out.println(list);
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : list) {
                int bound = random.nextInt(dinnerConstructor.dishes.get(type).size());
                combo.add(dinnerConstructor.dishes.get(type).get(bound));
            }
            System.out.printf("Комбо %d \n %s \n", (i + 1), combo);
        }
    }
    private static ArrayList<String> setDefaultDishTypes() { //TODO remove the method before review
        ArrayList<String> inputtedDishes = new ArrayList<>();
        inputtedDishes.add("Первые блюда");
        inputtedDishes.add("Напитки");
        inputtedDishes.add("Вторые блюда");
        inputtedDishes.add("Гарниры");
        return inputtedDishes;
    }
}
