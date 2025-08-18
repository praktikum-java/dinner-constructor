package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DinnerConstructor {
    Random rand = new Random();
    HashMap<String, ArrayList<String>> dinner = new HashMap<>();

    public void addDish(String type, String name) {
        String typeLC = type.toLowerCase();
        if (!dinner.containsKey(typeLC)) {
            dinner.put(typeLC, new ArrayList<>());
        }
        dinner.get(typeLC).add(name);
    }

    public ArrayList<ArrayList<String>> getRandomDinner(int number, ArrayList<String> types) {
        ArrayList<ArrayList<String>> dinnerNames = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                ArrayList<String> list = dinner.get(type);
                int random = rand.nextInt(list.size());
                combo.add(list.get(random));
            }
            dinnerNames.add(combo);
        }
        return dinnerNames;

    }

    boolean checkType(String type) {
        return dinner.containsKey(type);
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }

}
