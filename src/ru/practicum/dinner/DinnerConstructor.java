package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private HashMap<String, ArrayList<String>> dishes;
    private Random random;

    public DinnerConstructor() {
        dishes = new HashMap<>();
        random = new Random();
    }

    // Method to add a new dish
    public void addDish(String type, String name) {
        dishes.putIfAbsent(type, new ArrayList<>());
        dishes.get(type).add(name);
    }

    // Method to check if a dish type exists
    public boolean checkType(String type) {
        return dishes.containsKey(type);
    }

    // Method to generate dish combinations
    public ArrayList<ArrayList<String>> generateCombinations(int numberOfCombos, ArrayList<String> types) {
        ArrayList<ArrayList<String>> combinations = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                if (checkType(type)) {
                    ArrayList<String> dishesOfType = dishes.get(type);
                    if (!dishesOfType.isEmpty()) {
                        String dish = dishesOfType.get(random.nextInt(dishesOfType.size()));
                        combo.add(dish);
                    }
                } else {
                    System.out.println("Тип блюда " + type + " не существует. Введите другой тип.");
                }
            }
            combinations.add(combo);
        }
        return combinations;
    }
}
