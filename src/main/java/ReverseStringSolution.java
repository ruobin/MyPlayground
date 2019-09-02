

/**
 * Created by Ruobin Wang on 2019-08-31.
 */
public class ReverseStringSolution {

    /*
     * Complete the 'reverseWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING inputWords as parameter.
     */

    public static String reverseWords(String inputWords) {
        StringBuilder outputWords = new StringBuilder();
        String[] wordsList = inputWords.split(" ");
        for (int i = wordsList.length-1; i >= 0; i--) {
            outputWords.append(wordsList[i]);
            if(i>0) {
                outputWords.append(" ");
            }
        }
        return outputWords.toString();

    }




}