package algo;
import java.util.List;
import java.util.ArrayList;

public class MatchedContactSolution {
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    public String solution(String[] A, String[] B, String P) {
        // write your code in Java SE 8
        List<String> matches = new ArrayList<String>();
        for (int i = 0; i < B.length; i++) {
            if (B[i].contains(P)) {
                matches.add(A[i]);
            }
        }
        if (matches.size() > 0) {
            String smallestString = matches.get(0);
            for (int i = 1; i < matches.size(); i++) {
                if (smallestString.compareTo(matches.get(i)) > 0) {
                    smallestString = matches.get(i);
                }
            }
            return smallestString;
        } else {
            return "NO CONTACT";
        }
    }
}
