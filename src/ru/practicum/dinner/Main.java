package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //static DinnerConstructor dc;
    static Scanner scanner;
    static Random random;
    static DinnerConstructor dinnerConstructor = new DinnerConstructor();

    public static void main(String[] args) {
        // dc = new DinnerConstructor();
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
                    generateDishCombo(setDefaultDishTypes()); //TODO
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
        /*System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dinnerConstructor.setDishes(dishType, dishName);// добавьте новое блюдо*/
        dinnerConstructor.setDefaultDishes();
    }

    private static void generateDishCombo(ArrayList<String> list) {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList<String> inputtedItems = list;//new ArrayList<>();

        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            inputtedItems.add(nextItem);
            nextItem = scanner.nextLine();
        }
        System.out.println(inputtedItems);
        // сгенерируйте комбинации блюд и выведите на экран

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : inputtedItems) {
                int bound = random.nextInt(dinnerConstructor.dishes.get(type).size());
                combo.add(dinnerConstructor.dishes.get(type).get(bound));
            }
            System.out.printf("Комбо %d \n %s \n", (i + 1), combo);//dinnerConstructor.dishes.values());
        }
    }

    private static ArrayList<String> setDefaultDishTypes() {
        ArrayList<String> inputtedDishes = new ArrayList<>();
        inputtedDishes.add("Первые блюда");
        inputtedDishes.add("Напитки");
        inputtedDishes.add("Вторые блюда");
        inputtedDishes.add("Гарниры");
        return inputtedDishes;
    }
}
