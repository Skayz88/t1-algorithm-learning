package org.t1.java;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> namesList = List.of("вася 5", "Петя 3", "АНЯ 5", "Тото");
        System.out.println(orderedNameToRating(namesList.stream()));
    }

    public static Map<Integer, List<String>> orderedNameToRating(Stream<String> names) {
        return names
                .map(String::trim)
                .filter(s -> !s.isEmpty()
                        && s.matches(".*\\s-?\\d+$"))
                .map(Main::getMyNameAndRating)
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        HashMap::new,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }

    public static Map.Entry<Integer, String> getMyNameAndRating(String s) {
        int indSplash = s.lastIndexOf(' ');
        String name = s.substring(0, indSplash).trim();
        int number = Integer.parseInt(s.substring(indSplash + 1).trim());
        name = name.substring(0, 1).toUpperCase(Locale.ROOT)
                + name.substring(1).toLowerCase(Locale.ROOT);
        return Map.entry(number, name);

    }


}