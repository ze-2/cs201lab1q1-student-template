
import java.util.*;

public class NumbersArray {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 1, 5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));

        System.out.println();

        input = new Integer[]{1, 2, 3, 4, 1, 2, 5, 3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));
    }

    // Write your methods here
    public static int findMax(Integer[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static Integer[] findDuplicates(Integer[] numbers) {
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countOccurrences(numbers).entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates.toArray(Integer[]::new);
    }

    public static Integer[] findUnique(Integer[] numbers) {
        List<Integer> unique = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countOccurrences(numbers).entrySet()) {
            if (entry.getValue() == 1) {
                unique.add(entry.getKey());
            }
        }
        return unique.toArray(Integer[]::new);
    }

    private static Map<Integer, Integer> countOccurrences(Integer[] numbers) {
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        for (Integer number : numbers) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }
        return counts;
    }
}
