import java.util.*;
import java.util.stream.Collectors;

public class Anagram {

    public static void main(String[] args) {
        List<String> str = List.of("ate", "eat", "test", "cooc", "oocc");
        //First way
        System.out.println(getAnagramOne(str));
        //Second way
        System.out.println(getAnagramTwo(str));
    }

    private static List<String> getAnagramOne(List<String> str) {
        return str.stream().collect(Collectors.groupingBy(word -> {;
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values().stream()
                .filter(group -> group.size() > 1)
                .flatMap(Collection::stream)
                .toList();
    }

    private static List<String> getAnagramTwo(List<String> str) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : str) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
//            map.merge(key, new ArrayList<>(List.of(word)), (oldList, newList) -> {
//                oldList.addAll(newList);
//                return oldList;
//            });
        }
        return map.values().stream()
                .filter(group -> group.size() > 1)
                .flatMap(Collection::stream)
                .toList();
    }
}
