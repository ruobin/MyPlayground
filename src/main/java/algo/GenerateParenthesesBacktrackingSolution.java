package algo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesBacktrackingSolution {
    List resultsList = new ArrayList();
    char[] current;

    public List<String> generateParenthesis(int n) {
        current = new char[n * 2];
        generateAll(current, 0, 0, 0, n);
        System.out.println(current);
        return resultsList;
    }

    private void generateAll(char[] current, int currentPosition, int openCount, int closeCount, int n) {
        if (currentPosition >= 2 * n) {
            resultsList.add(new String(current));
            return;
        }
        if (openCount < n) {
            current[currentPosition] = '(';
            generateAll(current, currentPosition + 1, openCount + 1, closeCount, n);
        }
        if (openCount > closeCount) {
            current[currentPosition] = ')';
            generateAll(current, currentPosition + 1, openCount, closeCount + 1, n);
        }
    }
}
