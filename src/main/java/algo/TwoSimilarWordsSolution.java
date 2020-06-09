package algo;

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

        boolean[] sourceCharactorMapArray = new boolean[26];
        for (int i = 0; i < input.length(); i++) {
            int ascii = (int) input.charAt(i);
            sourceCharactorMapArray[ascii - 97] = true;
        }

        int count = 0;
        String wordsList = br.readLine();
        String[] wordsArray = wordsList.split(" ");
        for (int i = 0; i < wordsArray.length; i++) {
            if (isTwoWordsSimilarUsingBooleanArray(sourceCharactorMapArray, wordsArray[i])) {
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

    private static boolean isTwoWordsSimilarUsingBooleanArray(boolean[] characterMapArray, String target) {

        if (target == null || target.isEmpty()) return false;

        boolean[] targetCharacterMapArray = new boolean[26];
        for (int i = 0; i < target.length(); i++) {
            int ascii = (int) target.charAt(i);
            targetCharacterMapArray[ascii - 97] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (characterMapArray[i] == targetCharacterMapArray[i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
