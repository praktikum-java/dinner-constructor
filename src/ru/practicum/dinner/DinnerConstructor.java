package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
public class DinnerConstructor {
    HashMap<String, ArrayList<String>>dinner;
    public void addDish(String type, String name) {
        dinner = new HashMap<>();
        dinner.put(type, new ArrayList<>());
        dinner.get(type).add(name);
    }

}
