/*
https://leetcode.com/problems/word-pattern/description/

bijection: char a <-> string A -> if F: a -> A DOESNT match current OR current is already mapped to different char, not a bijection, otherwise add to map -> return false if any non-bijection is found

time: O(|s| + |p|) -> split string O(|s|) -> for each word, add char/string to maps O(1) -> check all words until not bijection O(|p|)
space: O(SIGMA * max(L)) -> bijection from chars => alphabet # of mappings O(SIGMA) -> each letter in alphabet mapped to words of max length L
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        char[] pat = pattern.toCharArray();
        String[] words = s.split(" ");

        if (pat.length != words.length) return false;

        for (int i = 0; i < pat.length; i++) {
            if (map.containsKey(pat[i])) {
                if (!map.get(pat[i]).equals(words[i])) {
                    return false;
                }
            }
            else if (map.containsValue(words[i])) {
                return false;
            }
            map.put(pat[i], words[i]);
        }

        return true;
    }
}
