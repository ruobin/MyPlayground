package algo;

public class ThreeSum {
    public static String intToRoman(int num) {
        String numStr = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        char[] map = new char[7];
        map[0] = 'I';
        map[1] = 'V';
        map[2] = 'X';
        map[3] = 'L';
        map[4] = 'C';
        map[5] = 'D';
        map[6] = 'M';

        int slen = numStr.length(), i = slen * 2, strI = 0;

        while ((i -= 2) >= 0) {
            int digit = numStr.charAt(strI++) - '0';
            if (digit % 5 == 4)
                sb.append(map[i]).append(map[i + digit / 5 + 1]);
            else {
                if (digit >= 5)
                    sb.append(map[i + 1]);
                digit %= 5;
                while (digit-- > 0)
                    sb.append(map[i]);
            }
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(intToRoman(27));

    }
}
