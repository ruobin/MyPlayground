package algo;

import java.util.*;
import java.util.stream.Collectors;

public class SecretStringWithTripletsSolution {

    public static void main(String[] argv) {

//        char[][] triplets = {
//                {'t','u','p'},
//                {'w','h','i'},
//                {'t','s','u'},
//                {'a','t','s'},
//                {'h','a','p'},
//                {'t','i','s'},
//                {'w','h','s'}
//        };

        char[][] triplets = {
                {'t','s','f'},
                {'a','s','u'},
                {'m','a','f'},
                {'a','i','n'},
                {'s','u','n'},
                {'m','f','u'},
                {'a','t','h'},
                {'t','h','i'},
                {'h','i','f'},
                {'m','h','f'},
                {'a','u','n'},
                {'m','a','t'},
                {'f','u','n'},
                {'h','s','n'},
                {'a','i','s'},
                {'m','s','n'},
                {'m','s','u'}
        };

        System.out.println(recoverSecret(triplets));
    }

    public static String recoverSecret(char[][] triplets) {
        Map<String, Character> relationMap = transformToMap(triplets);
        Collection<Character> firstCharacterCollection = relationMap.values();
        StringBuffer resultStringBuffer = new StringBuffer();
        Iterator<Character> firstCharacterIterator = firstCharacterCollection.iterator();
        Set<String> keySet = relationMap.keySet();

        //keep finding the characters according to the sequence, i.e., the first, second, third...
        while (firstCharacterIterator.hasNext()) {
            char cursor = firstCharacterIterator.next();

            if (isFirstCharacter(keySet, cursor)) {
                if (relationMap.size() > 1) {
                    //the last two characters need to be handled specially
                    resultStringBuffer.append(cursor);
                } else {
                    resultStringBuffer.append(keySet.iterator().next());
                }
                relationMap = removeUselessElements(relationMap, cursor);
                firstCharacterIterator = relationMap.values().iterator();
                keySet = relationMap.keySet();
            }
        }
        return resultStringBuffer.toString();
    }

    /**
     * find out if a character is the first one in the sequence of the relation set
     *
     * @param relationSet
     * @param character
     * @return true if it is the first character
     */
    private static boolean isFirstCharacter(Set<String> relationSet, Character character) {
        Iterator<String> iterator = relationSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().endsWith(Character.toString(character))) {
                return false;
            }
        }
        return true;
    }

    /**
     * remove already processed elements which are no use in the future
     *
     * @param relationMap
     * @param character
     * @return a Map<String, Character>
     */
    private static Map<String, Character> removeUselessElements(Map<String, Character> relationMap, Character character) {
        return relationMap.entrySet().stream().filter(c -> !c.getKey().startsWith(Character.toString(character))).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    }

    /**
     * transform the triplets into map, every two characters as keys, and the one in the front as values,
     * for example, {'t','u','p'} will transform to 2 key-value pairs, i.e. 'tu'->'t' and 'up'->'u'
     * It also remove duplicates keys automatically
     *
     * @param triplets
     * @return a Map<String, Character>
     */
    private static Map<String, Character> transformToMap(char[][] triplets) {
        Map<String, Character> relationMap = new HashMap();
        for (int i = 0; i < triplets.length; i++) {
            for(int j = 0; j < 3; j++) {
                relationMap.put(Character.toString(triplets[i][0]) + Character.toString(triplets[i][1]), triplets[i][0]);
                relationMap.put(Character.toString(triplets[i][1]) + Character.toString(triplets[i][2]), triplets[i][1]);
            }
        }
        return relationMap;
    }

}



