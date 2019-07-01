import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruobin Wang on 2019-07-01.
 */
public class GenerateParenthesesSolution {

    List resultsList = new ArrayList();
    char[] current;
    int openCount = 0;
    int closeCount = 0;

    public List<String> generateParenthesis(int n) {
        current = new char[n*2];
        generateAll(current, 0, n);
        System.out.println(current);
        return resultsList;
    }

    private void generateAll(char[] array, int currentPosition, int n) {
        if(currentPosition<n*2) {
            current[currentPosition] = '(';
            openCount++;
            generateAll(current, currentPosition + 1, n);
            current[currentPosition] = ')';
            closeCount++;
            generateAll(current, currentPosition + 1, n);
        } else {
            if (isValid(current))
                resultsList.add(new String(current));
        }
    }

    private boolean isValid(char[] result) {
        int balance = 0;
        for (int i = 0; i < result.length; i++) {
            if(result[i] == '(') balance++;
            else balance--;
            if (balance<0) return false;
        }
        return balance==0;
    }

}
