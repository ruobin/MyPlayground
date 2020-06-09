package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruobin Wang on 2019-08-31.
 */
public class FirstTwoItemsWithoutPairSolution {

    public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list) {
        final List outputList = new ArrayList(2);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(list.size());

        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            if (map.get(list.get(i)) != null) {
                sum = map.get(list.get(i));
            }
            sum++;
            map.put(list.get(i), sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == 1) outputList.add(entry.getKey());


        return outputList;

    }
}
