import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class WordUnscrambler {

    // Load dictionary and map sorted character signature to list of words
    public static Map<String, List<String>> loadDictionary(String path) throws Exception {
        return Files.lines(Paths.get(path))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(WordUnscrambler::sortedChars));
    }

    // Sort characters in a word to create a signature
    private static String sortedChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Unscramble each word in the input
    public static List<String> unscramble(String scrambledText, Map<String, List<String>> dictionaryMap) {
        return Arrays.stream(scrambledText.split("\\s+"))
                .map(word -> dictionaryMap.getOrDefault(sortedChars(word.toLowerCase()), List.of("[" + word + "]")))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        String scrambled = "csary yarm ate areffet"; // Example input
        String dictionaryPath = "dictionary.txt"; // Path to your dictionary file

        Map<String, List<String>> dictionaryMap = loadDictionary(dictionaryPath);
        List<String> result = unscramble(scrambled, dictionaryMap);

        System.out.println("Unscrambled: " + String.join(" ", result));
    }
}