package algo;

import java.util.*;

public class IsPalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        List<Integer> list = new ArrayList<Integer>();
        while (x / 10 > 0) {
            list.add(Integer.valueOf(x % 10));
            x = x / 10;
        }
        list.add(Integer.valueOf(x % 10));

        for (int i = 0; i < list.size()/2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        isPalindrome(121211);
    }
}