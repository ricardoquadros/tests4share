import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class shows 2 different ways to count the number of
 * the same words in an array
 * Ex. "the dog got the bone
 * the - 2x
 * dog - 1x
 * got - 1x
 * bone- 1x
 */
public class CountWordFrequencies {

    public static void main(String[] args) {
        String[] words = {"the", "dog", "got", "the", "bone"};
        int[] frequencies1 = countFrequencies1(words);
        int[] frequencies2 = countFrequencies2(words);

        for (int freq : frequencies1) {
            System.out.print(freq + " ");
        }
        for (int freq : frequencies2) {
            System.out.print(freq + " ");
        }
    }

    /* First review */
    public static int[] countFrequencies1(String[] words) {
        Map<String, Integer> wordCountMap = new TreeMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        int[] frequencies = new int[wordCountMap.size()];
        int index = 0;

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            frequencies[index++] = entry.getValue();
        }

        return frequencies;
    }

    /* Second review */
    public static int[] countFrequencies2(String[] words) {

        return Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, TreeMap::new, Collectors.summingInt(word -> 1)))
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
