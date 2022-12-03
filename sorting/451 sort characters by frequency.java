/*
https://leetcode.com/problems/sort-characters-by-frequency/description/

approach 1: custom comparator to sort by a particular character's count in the input string

time: O(n log n) -> count chars in O(n) -> generate pairs in O(n) -> sort via comparator in O(n log n) -> convert to char array in O(n)
space: O(n) -> char array
*/

class freq_comp implements Comparator<Pair<Character, Integer>> {
    @Override
    public int compare(Pair<Character, Integer> a, Pair<Character, Integer> b) {
        if (!a.getKey().equals(b.getKey())) {
            if (a.getValue() > b.getValue()) {
                return -1;
            }
            else if (a.getValue() < b.getValue()) {
                return 1;
            }
            else {
                return a.getKey().compareTo(b.getKey());
            }
        }
        else {
            return 0;
        }
    }
}

class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] s_chars = s.toCharArray();

        for (char c : s_chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Pair<Character, Integer>[] s_pairs = new Pair[s.length()];

        for (int i = 0; i < s.length(); i++) {
            s_pairs[i] = new Pair(s_chars[i], map.get(s_chars[i]));
        }
    
        Arrays.sort(s_pairs, new freq_comp());

        char[] s_out = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            s_out[i] = s_pairs[i].getKey();
        }

        return new String(s_out);
    }
}
