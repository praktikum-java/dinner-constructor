package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dinnersByType = new HashMap<>();
    Random random = new Random();

    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishesForType;

        if (dinnersByType.containsKey(dishType)) {
            dishesForType = dinnersByType.get(dishType);
        } else {
            dishesForType = new ArrayList<>();
            dinnersByType.put(dishType, dishesForType);
        }

        dishesForType.add(dishName);
    }

    public ArrayList<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<String> combos = new ArrayList<>();
        for (int i = 0; i <= comboNumber; i++) {
            ArrayList<String> combo = generateCombo(dishTypes); //одна комбинация блюд генерируется в отдельном методе
            combos.add(combo);
        }
        return combos;
    }


    //метод для проверки дубликатов блюд
    public boolean checkType(String type) {
        return dinnersByType.containsKey(type); //если хранилище уже содержит такое блюдо - вернём true
    }

    private ArrayList<String> generateCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();
        for (String dishType: dishTypes) {
            ArrayList<String> availableDishes = dinnersByType.get(dishType);
            String selectedDish = getRandomDish(availableDishes);
            selectedDishes.add(selectedDish);
        }
        return selectedDishes;
    }

    private String getRandomDish(ArrayList<String> availableDishes) {
        int numberOfDishesForType = availableDishes.size();
        int dishIndex = random.nextInt(numberOfDishesForType);
        return availableDishes.get(dishIndex);
    }
}
