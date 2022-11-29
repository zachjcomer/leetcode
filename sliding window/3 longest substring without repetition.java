/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

track the most recent incident of repeated char -> length is current index - last repeat -> take max

time: O(n) -> single pass 
space: O(n) -> char array for performance (also max, rep index O(1))
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int max = 0;
        int rep = -1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!seen.containsKey(c)) {
                seen.put(c, i);
            }
            else {
                rep = Math.max(rep, seen.get(c));
                seen.put(c, i);
            }
            max = Math.max(max, i - rep);
        }

        return max;
    }
}
