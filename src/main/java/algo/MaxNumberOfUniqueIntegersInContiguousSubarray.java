package algo;

import java.util.*;

public class MaxNumberOfUniqueIntegersInContiguousSubarray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int maxCount = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (map.get(num) == null || map.get(num) == 0) {
                count++;
            }
            map.put(num, (map.get(num) == null ? 0 : map.get(num)) + 1);
            deque.addLast(num);
            if (deque.size() > m) {
                Integer head = (Integer) deque.removeFirst();
                map.put(head, Math.max(map.get(head) - 1, 0));
                if (map.get(head) == 0) {
                    count--;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }
}
