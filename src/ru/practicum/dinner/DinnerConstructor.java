package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishes = new HashMap<>();
    ArrayList<String> dishesNames;


    void setDishes(String dishType, String dishName) {
        dishesNames = dishes.get(dishType);
        if (dishesNames == null) {
            dishesNames = new ArrayList<>();
        }
        dishesNames.add(dishName);
        dishes.put(dishType, dishesNames);
    }

    void setDefaultDishes() { //TODO remove the method before review
        dishesNames = new ArrayList<>();
        dishesNames.add("Яблочный сок");
        dishesNames.add("Томатный сок");
        dishesNames.add("Черный чай");
        dishesNames.add("Зеленый чай");
        dishesNames.add("Американо");
        dishesNames.add("Капучино");
        dishes.put("Напитки", dishesNames);

        dishesNames = new ArrayList<>();
        dishesNames.add("Куриный суп");
        dishesNames.add("Борщ");
        dishesNames.add("Солянка");
        dishesNames.add("Харчо");
        dishesNames.add("Шурпа");
        dishesNames.add("Шулюм");
        dishes.put("Первые блюда", dishesNames);

        dishesNames = new ArrayList<>();
        dishesNames.add("Стейк Рибай");
        dishesNames.add("Котлеты рыбные");
        dishesNames.add("Котлета по-Киевски");
        dishesNames.add("Поджарка свиная");
        dishesNames.add("Печень по-Строгановски");
        dishesNames.add("Цыпленок Тапака");
        dishes.put("Вторые блюда", dishesNames);

        dishesNames = new ArrayList<>();
        dishesNames.add("Картофельное пюре");
        dishesNames.add("Гречка");
        dishesNames.add("Рис");
        dishesNames.add("Ризотто");
        dishesNames.add("Овощи гриль");
        dishesNames.add("Овощи на пару");
        dishes.put("Гарниры", dishesNames);

        System.out.println(dishes);
        System.out.println("-------");

    }
}
