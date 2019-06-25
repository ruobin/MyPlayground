import java.sql.Array;
import java.util.ArrayList;

public class IntegerToRomanSolution {

    public String intToRoman(int num) {
        ArrayList numDigits = new ArrayList<Integer>();

        while(num % 10>0) {
            numDigits.add(num % 10);
            num = num/10;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numDigits.size()-1; i >0; i--) {
            int m =(Integer)numDigits.get(i);
            if (m == 0) {
                continue;
            } else if (m < 4) {
                for (int j = 0; j < m; j++) {
                    if (i==0) {
                        stringBuilder.append('I');
                    } else if(i==1) {
                        stringBuilder.append('X');
                    } else if(i==2) {
                        stringBuilder.append('C');
                    } else if(i==3) {
                        stringBuilder.append('M');
                    }
                }
            } else if (m==4) {
                if (i==0) {
                    stringBuilder.append('I');
                    stringBuilder.append('V');
                } else if(i==1) {
                    stringBuilder.append('X');
                    stringBuilder.append('L');
                } else if(i==2) {
                    stringBuilder.append('C');
                    stringBuilder.append('D');
                }
            }
        }



        return "";
    }
}
