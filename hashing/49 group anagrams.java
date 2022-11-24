/*
https://leetcode.com/problems/group-anagrams/submissions/
java Arrays.sort(arr) is IN-PLACE: https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/

hash strings to correct list -> sort string to create hash key -> iterate over hash values (List<String>'s') and add to List<List<String>>

time: O(n log n) -> O(n log n) to sort string -> O(1) to add string to list via hashing -> O(n) to add lists to output
space: O(n) -> O(n) keys => 1 entry in list // O(1) keys => n entries in list
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap();
        String key;

        for (String s : strs) {
            key = sorted(s);

            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(s);
        }

        for (List<String> list : map.values()) {
            out.add(list);
        }

        return out;
    }

    private String sorted(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
