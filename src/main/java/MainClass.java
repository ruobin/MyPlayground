import algo.MinimumTreesShortenedForAestheticallyPleasing;
import algo.ReformatPhoneNumberSolution;
import basics.ListNode;

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            basics.ListNode l1 = stringToListNode(line);
//            line = in.readLine();
//            basics.ListNode l2 = stringToListNode(line);
//
//            basics.ListNode ret = new Solution().addTwoNumbers(l1, l2);
//
//            String out = listNodeToString(ret);
//
//            System.out.print(out);
//        }

//        new Solution().lengthOfLongestSubstring("au");

//        new algo.LongestPalindromeSolution().longestPalindrome("aaaa");

//        boolean isMatch = new algo.RegularExpressionMatchingSolution().isMatch("aaa", "ab*a");
//        System.out.println("algo.RegularExpressionMatchingSolution.isMatch is " + isMatch);

//        int[] nums = {1,1,-2};
//        List<List<Integer>> result = new algo.ThreeSumSolution().threeSum(nums);

//        new algo.GenerateParenthesesBacktrackingSolution().generateParenthesis(3);

//        basics.ListNode head = MainClass.stringToListNode("[1,2,3,4]");
//        new algo.SwapNodesInPairsSolution().swapPairs(head);

//        new algo.DivideTwoIntegersSolution().divide(2147483647,3);

//        Integer[] A = {8, 5, 66, 7, 5, 8};
//        new algo.SmallestPositiveIntegerSolution().solution(A);
//        List<Integer> list = Arrays.asList(A);
//        algo.FirstTwoItemsWithoutPairSolution.getFirstTwoItemsWithoutPair(list);
        int[] A = {3, 7, 4, 5};
//        new algo.SmallestPositiveIntegerSolution().solution(A);

//        new algo.IndicesDistanceSolution().solution(A);

//        new algo.NextPermutationSolution().nextPermutation(A);

        String result = new ReformatPhoneNumberSolution().solution("555372654");
        System.out.println(result);

    }
}