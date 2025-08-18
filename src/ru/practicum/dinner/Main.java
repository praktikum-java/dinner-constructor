package ru.practicum.dinner;

import java.util.ArrayList;
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
        dc.addDish(dishType, dishName);
        System.out.println("Добавлено блюдо: " + dishName + " Тип: " + dishType);
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        ArrayList<String> types = new ArrayList<>();
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        String numberOfCombos = scanner.nextLine();
        while (!dc.isNumber(numberOfCombos)) {
            System.out.println("Нужно ввести число!");
            numberOfCombos = scanner.nextLine();
        }
        //scanner.nextLine();
        int numberOfCombosint = Integer.parseInt(numberOfCombos);
        if (numberOfCombosint <= 0) {
            System.out.println("Число должно быть больше 0!");
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        while (true) {
            String nextItem = scanner.nextLine().toLowerCase();
            if (nextItem.isEmpty()) {
                break;
            }
            if (dc.checkType(nextItem)) {
                types.add(nextItem);
            } else {
                System.out.println("Нет такого типа блюда");
            }
        }
        int numberOfList = 0;
        for (ArrayList<String> list : dc.getRandomDinner(numberOfCombosint, types)) {
            System.out.println("Комбо " + (++numberOfList));
            System.out.println(list);
        }


//        //реализуйте ввод типов блюд
//        while (!nextItem.isEmpty()) {
//            dishes.add(nextItem);
//        }

        // сгенерируйте комбинации блюд и выведите на экран

    }


}
