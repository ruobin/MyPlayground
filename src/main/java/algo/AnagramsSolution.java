package algo;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'funWithAnagrams' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY text as parameter.
     */

    public static List<String> funWithAnagrams(List<String> text) {
        List<String> resultList = new ArrayList<>();
        resultList.add(text.get(0));

        for (int i = 1; i<text.size(); i++) {
            boolean findAnagramInResult = false;
            for (int j = 0; j < resultList.size(); j++) {
                if (areAnagram(text.get(i), resultList.get(j))) {
                    findAnagramInResult = true;
                    break;
                }
            }
            if (!findAnagramInResult) {
                resultList.add(text.get(i));
            }

        }
        resultList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return resultList;
    }

    private static boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int value = 0;

        for (int i = 0; i < str1.length(); i++) {
            value = value ^ (int) str1.charAt(i);
            value = value ^ (int) str2.charAt(i);
        }

        return value == 0;
    }

}

public class AnagramsSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int textCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> text = IntStream.range(0, textCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.funWithAnagrams(text);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
