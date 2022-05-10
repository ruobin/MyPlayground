package algo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeatingCharactersSolution {

    /**
     * problem 2 - brutal force
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return chars.length;
        }

        int result = 1;
        Map map = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            if (result > chars.length - i)
                break;
            map.clear();
            map.put(chars[i], null);
            for (int j = i + 1; j < chars.length; j++) {
                if (map.containsKey(chars[j])) {
                    if (map.size() > result) {
                        result = map.size();
                    }
                    break;
                } else {
                    map.put(chars[j], null);
                    if (map.size() > result) {
                        result = map.size();
                    }
                }
            }
        }
        return result;
    }

    /**
     * problem 2 - sliding window
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_SlidingWindow(String s) {
        int stringLength = s.length();
        if (stringLength <= 1) {
            return stringLength;
        }

        int result = 1;
        Map map = new HashMap();
        int i = 0;
        int j = 1;
        map.put(s.charAt(i), i);
        map.put(s.charAt(j), j);
        while (i < stringLength && j < stringLength) {
            if (!map.containsKey(s.charAt(j++))) {

            } else {
                int duplicateIndex = (Integer) map.get(s.charAt(j));
                i = duplicateIndex;
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
