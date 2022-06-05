package algo;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static int climbStairs(int n) {
        if (map.containsKey(Integer.valueOf(n)))
            return (int) (map.get(n));

        int step;
        if (n == 1) {
            step = 1;
        } else if (n == 2) {
            step = 2;
        } else {
            step = climbStairs(n - 1) + climbStairs(n - 2);
        }

        map.put(Integer.valueOf(n), Integer.valueOf(step));
        return step;
    }

    public static void main(String[] args) {
        int m = climbStairs(2);
        System.out.println(m);
    }
}
