package algo;

import java.lang.reflect.Array;

/***
 * NOT finished
 */
public class RegularExpressionMatchingSolution {

    public boolean isMatch(String s, String p) {

        int patternLength = p.length();
        int stringLength = s.length();
        char starChar = '*';
        char periodChar = '.';

        int j = 0;
        int i = 0;

        char[] patternCharArray = p.toCharArray();

        while (j<patternLength) {
            if(j> patternLength-1) {
                if (i> stringLength-1) {
                    return true;
                } else {
                    return false;
                }
            }

            if (i> stringLength-1 && j>patternLength-1) {
                return false;
            }

            if (i>=stringLength) return false;

            char patternChar = patternCharArray[j];
            if(patternChar == s.charAt(i)) {
                j++;
                i++;
                continue;
            } else if(patternChar == starChar) {
                if(j-1>=0 && (patternCharArray[j-1]==s.charAt(i) || patternCharArray[j-1] == periodChar)) {
                    i++;
                    j++;
                    continue;
                } else {
                    j++;
                }
            } else if(patternChar == periodChar) {
                j++;
                i++;
                continue;
            } else if(j+1<patternLength && patternCharArray[j+1] == starChar) {
                j=j+2;
                continue;
            } else {
                j++;
                continue;
            }

        }

        if(i>= stringLength) return true;

        if(j>=patternLength) return false;

        return true;
    }
}
