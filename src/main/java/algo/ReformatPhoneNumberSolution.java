package algo;

public class ReformatPhoneNumberSolution {

    public String solution(String S) {
        // write your code in Java SE 8
        //remove all spaces and dashes
        String digitsOnly = S.replaceAll("[\\s\\-()]", "");
        int size = digitsOnly.length();
        int result = size%3;
        int groupsCount;
        StringBuilder stringBuilder = new StringBuilder();

        if (result == 1) {
            groupsCount = size/3 + 1;
            //if size equals 3*n + 1, then split to n-1 groups of 3, and 2 groups of 2
            for (int i = 1; i <= groupsCount; i++) {
                if (i < groupsCount-1) {
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 0));
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 1));
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 2));
                    stringBuilder.append('-');
                } else {
                    stringBuilder.append(digitsOnly.charAt((groupsCount-2)*3));
                    stringBuilder.append(digitsOnly.charAt((groupsCount-2)*3 + 1));
                    stringBuilder.append('-');

                    stringBuilder.append(digitsOnly.charAt((groupsCount-2)*3 + 2));
                    stringBuilder.append(digitsOnly.charAt((groupsCount-2)*3 + 3));
                    stringBuilder.append('-');
                    break;
                }
            }
        } else if (result == 2) {
            groupsCount = size/3 + 1;
            //if size equals 3*n + 2, then split to n groups of 3, and 1 group of 2
            for (int i = 1; i <= groupsCount; i++) {
                if (i < groupsCount) {
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 0));
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 1));
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 2));
                    stringBuilder.append('-');
                } else {
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 0));
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 1));
                    stringBuilder.append('-');
                }
            }
        } else {
            groupsCount = size/3;
            //if size equals 3*n, then split to n groups of 3
            for (int i = 1; i <= groupsCount; i++) {
                if (i <= groupsCount) {
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 0));
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 1));
                    stringBuilder.append(digitsOnly.charAt((i-1)*3 + 2));
                    stringBuilder.append('-');
                }
            }
        }

        stringBuilder.deleteCharAt(digitsOnly.length() + groupsCount - 1);

        return stringBuilder.toString();
    }
}
