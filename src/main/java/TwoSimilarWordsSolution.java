import java.io.*;
import java.util.HashSet;
import java.util.Set;

//TODO
//need to validate with more test cases
public class TwoSimilarWordsSolution {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Set<Character> set = new HashSet();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        int count = 0;
        String wordsList = br.readLine();
        String[] wordsArray = wordsList.split(" ");
        for (int i = 0; i < wordsArray.length; i++) {
            if (isTwoWordsSimilar(set, wordsArray[i])) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isTwoWordsSimilar(Set characterSet, String word) {
        if (word == null || word.isEmpty()) return false;

        Set<Character> set = new HashSet();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        return characterSet.equals(set);
    }

}
