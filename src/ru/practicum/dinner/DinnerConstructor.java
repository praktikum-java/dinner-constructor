package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class DinnerConstructor {

    private final DinnerDao dao;
    private final Random random;

    public DinnerConstructor(DinnerDao dao) {
        this.dao = dao;
        this.random = new Random();
    }

    public void save(String dishType, String dishName) {
        dao.save(dishType, dishName);
        System.out.printf("новое блюдо %s добавлено в тип %s\n", dishName, dishType);
    }

    public Map<String, List<String>> generateDishCombo(List<String> dishTypes, int numberOfCombos) {
        Map<String, List<String>> dishesByTypes = dao.getAllDishesByTypes(dishTypes);
        Map<String, List<String>> combos = new HashMap<>();

        IntStream.range(0, numberOfCombos)
                .forEach(i -> {
                    List<String> comboDishes = new ArrayList<>();
                    dishesByTypes.values().forEach(dishList -> {
                        String randomDish = dishList.get(random.nextInt(dishList.size()));
                        comboDishes.add(randomDish);
                    });
                    combos.put("Комбо " + (i + 1), comboDishes);
                });
        return combos;
    }

    public boolean isNotContainsTypes(List<String> dishTypes) {
        boolean result = false;
        List<String> notContainsTypes = dao.isNotContainsTypes(dishTypes);
        if (!notContainsTypes.isEmpty()) {
            System.out.printf("Вы ввели несуществующий тип: %s", notContainsTypes.get(0));
            System.out.println();
            System.out.println("Введите список существующих типов:");
            result = true;
        }
        return result;
    }

    public void printDishCombos(Map<String, List<String>> combos) {
        combos.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    String key1 = e1.getKey().replaceAll("\\D", "");
                    String key2 = e2.getKey().replaceAll("\\D", "");
                    return Integer.compare(Integer.parseInt(key1), Integer.parseInt(key2));
                })
                .forEach((e) -> System.out.println(e.getKey() + "\n" + e.getValue()));
    }
}
