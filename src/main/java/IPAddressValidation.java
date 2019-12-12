import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//TODO need more test and validation
public class IPAddressValidation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int addressesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> addresses = IntStream.range(0, addressesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = validateAddresses(addresses);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'validateAddresses' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY addresses as parameter.
     */

    public static List<String> validateAddresses(List<String> addresses) {
        List<String> resultList = new ArrayList<String>(addresses.size());

        for (int i = 0; i < addresses.size(); i++) {
            if (isIPV4(addresses.get(i))) {
                resultList.set(i, "IPV4");
            } else if (isIPV6(addresses.get(i))) {
                resultList.set(i, "IPV6");
            } else {
                resultList.set(i, "Neither");
            }
        }
        return resultList;
    }

    private static boolean isIPV6(String address) {
        String[] testParts = address.split("::");
        if (testParts.length != 2) return false;
        String[] parts = address.split(":");

        try {
            for (int i = 0; i < parts.length; i++) {
                int value = Integer.parseInt(parts[i],16);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private static boolean isIPV4(String address) {
        String[] parts = address.split(".");
        if (parts.length == 4) {
            for (int i = 0; i < parts.length; i++) {
                int value = Integer.getInteger(parts[i]);
                if (value > 7) {
                    if (parts[i].startsWith("0")) return false;
                    else return true;
                } else if (value < 256) return true;
            }
        }
        return false;
    }
}
