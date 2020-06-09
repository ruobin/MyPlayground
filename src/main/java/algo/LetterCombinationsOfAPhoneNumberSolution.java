package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberSolution {

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return output;
        backtrackNumbers("", digits);
        return output;
    }

    private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public void backtrackNumbers(String firstPart, String secondPart) {
        if (secondPart.length() == 0) {
            output.add(firstPart);
            return;
        }
        String prefixNum = secondPart.substring(0, 1);
        String letters = phone.get(prefixNum);
        for (int i = 0; i < letters.length(); i++) {
            backtrackNumbers(firstPart + letters.charAt(i), secondPart.substring(1));
        }
    }
}
