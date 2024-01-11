package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DinnerDao {

    private final Map<String, List<String>> dinnerDb;

    public DinnerDao(Map<String, List<String>> dinnerDb) {
        this.dinnerDb = dinnerDb;
    }

    public void save(String dishType, String dishName) {
        if (!dinnerDb.containsKey(dishType)) {
            List<String> dishList = new ArrayList<>();
            dinnerDb.put(dishType, dishList);
        }
        dinnerDb.get(dishType).add(dishName);
    }

    public Map<String, List<String>> getAllDishesByTypes(List<String> dishTypes) {
        return dishTypes.stream()
                .collect(Collectors.toMap(k -> k, dinnerDb::get));
    }

    public List<String> isNotContainsTypes(List<String> dishTypes) {
        return dishTypes.stream()
                .filter(k -> !dinnerDb.containsKey(k))
                .collect(Collectors.toList());
    }
}
