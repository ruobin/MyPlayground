/**
 * Created by Ruobin Wang on 2019-08-31.
 */
public class TryCatchTest {
    public static void main(String[] args) {
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[2]);
            return;
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }

    }
}
