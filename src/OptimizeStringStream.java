import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* This question was asked in UST Global interview
* input:= "P10, P101, P199, P12, P13, P11, R221, R22, R225, R223, R222, R224, B95, B49, B36"
* output:= "B36, 49, 95, P10-13, 101, 199, R22, 221-225"
* */
public class OptimizeStringStream {
    public static void main(String[] args) {
        String input = "P10, P101, P199, P12, P13, P11, R221, R22, R225, R223, R222, R224, B95, B49, B36";

        // Step 1: Stream of tokens
        Map<String, List<Integer>> prefixMap = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.groupingBy(
                        s -> s.replaceAll("[0-9]", ""), // prefix (like P, R, B)
                        Collectors.mapping(s -> Integer.parseInt(s.replaceAll("[^0-9]", "")),
                                Collectors.toList())
                ));

        // Step 2: Process each prefix group into compressed string
        String result = prefixMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // sort by prefix alphabetically
                .flatMap(entry -> {
                    String prefix = entry.getKey();
                    List<Integer> nums = entry.getValue().stream()
                            .sorted()
                            .collect(Collectors.toList());
                    List<String> compressed = compressRanges(nums);

                    // Add prefix only for the first element in each group
                    List<String> formatted = IntStream.range(0, compressed.size())
                            .mapToObj(i -> i == 0 ? prefix + compressed.get(i) : compressed.get(i))
                            .toList();

                    return formatted.stream();
                })
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    // Helper: Compress consecutive numbers into "start-end" or "single"
    private static List<String> compressRanges(List<Integer> nums) {
        if (nums.isEmpty()) return List.of();
        List<String> result = new ArrayList<>();
        int start = nums.get(0), prev = start;

        for (int i = 1; i < nums.size(); i++) {
            int curr = nums.get(i);
            if (curr != prev + 1) {
                result.add(start == prev ? String.valueOf(start) : start + "-" + prev);
                start = curr;
            }
            prev = curr;
        }
        result.add(start == prev ? String.valueOf(start) : start + "-" + prev);
        return result;
    }
}
