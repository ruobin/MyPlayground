package bofa;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectDiffer {

    public static Map<String, Object> diffObjects(Object obj1, Object obj2) {

        Map<String, Object> diffResult = new HashMap<>();

        if (obj1.getClass() != obj2.getClass()) {
            String remark = "Objects are of different types, cannot compare.";
            diffResult.put("matches", false);
            diffResult.put("diffs", remark);
            System.out.println(remark);
            return diffResult;
        }

        Class<?> clazz = obj1.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        Boolean matches = true;
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                Method getter = clazz.getMethod("get" + capitalize(fieldName));
                Object value1 = getter.invoke(obj1);
                Object value2 = getter.invoke(obj2);

                if (!value1.equals(value2)) {
                    String remark = "Difference found in field: " + fieldName + "\n" + "Value in obj1: " + value1 + "\n" + "Value in obj2: " + value2 + "\n";
                    sb.append(remark);
                    matches = false;
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        diffResult.put("matches", matches);
        diffResult.put("diffs", sb.toString());
        System.out.println(sb);
        return diffResult;
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    // Example usage
    public static void main(String[] args) {
        // Create two sample objects for comparison
        SampleObject obj1 = new SampleObject("John", 30, "Engineer");
        SampleObject obj2 = new SampleObject("John", 35, "Developer");

        // Compare the objects
        diffObjects(obj1, obj2);
    }
}

class SampleObject {
    private String name;
    private int age;
    private String occupation;

    public SampleObject(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
}
