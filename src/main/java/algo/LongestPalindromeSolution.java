package algo;

public class LongestPalindromeSolution {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <=1) {
            return s;
        }
        String longestPalindrome = "";
        int length1 = 2, start1=0, end1=0;
        int length2=0 ,start2=0,end2 = 0;
        for (int i=0; i<length; i++) {
            int m = i;
            if (m+1<length && s.charAt(m) == s.charAt(m+1)) {
                if (start1+end1 ==0) {
                    start1 = m;
                    end1 = m + 1;
                }
                m++;
                while (m+1<length && 2*i-m>=0 && s.charAt(m+1) == s.charAt(2*i-m)) {

                    if (m+1 - (2*i-m) +1>length1) {
                        length1 = m+1 - (2*i-m) +1;
                        start1 = 2*i-m;
                        end1 = m+1;
                    }
                    m++;
                }
            }

            int n = i;
            while (2*i-n-1>=0 && n+1<length && s.charAt(n+1) == s.charAt(2*i-n-1)) {
                if (n+1-(2*i-n-1) + 1>length2) {
                    length2 = n+1-(2*i-n-1) + 1;
                    start2 = 2*i-n-1;
                    end2 = n+1;
                }
                n++;
            }
        }
        int start, end;
        if (length1 > length2) {
            start = start1;
            end = end1;
        } else {
            start = start2;
            end = end2;
        }
        longestPalindrome = s.substring(start, end+1);
        return longestPalindrome;
    }
}
