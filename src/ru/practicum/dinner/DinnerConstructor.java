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
            ??? combo = generateCombo(dishTypes); //одна комбинация блюд генерируется в отдельном методе
            combos.add(combo);
        }
        return combos;
    }


    //метод для проверки дубликатов блюд
    public boolean checkType(String type) {
        return dinnersByType.containsKey(type); //если хранилище уже содержит такое блюдо - вернём true
    }

    //метод для генерирования одной комбинации блюд
    private generateCombo(??? dishTypes) {
        ??? selectedDishes = ???;
        for (??? dishType: dishTypes) {
            ??? availableDishes = dinnersByType.???(dishType); //достаём из хранилища варианты блюд по типу
            String selectedDish = ???(availableDishes); //полцчим произвольное блюдо
            selectedDishes.???(selectedDish); //добавим блюдо в подборку комбинацию
        }
        return selectedDishes;
    }

    private String getRandomDish(??? availableDishes) {
        int numberOfDishesForType = availableDishes.size(); //получаем общее количество доступных блюд этого типа
        int dishIndex = random.nextInt(numberOfDishesForType); //генерируем случайное число от 0 до (кол-во блюд - 1), чтобы выбрать случайное блюдо
        String selectedDish = availableDishes.???(dishIndex); //выберем произвольное блюдо по индексу
    }

}
