/*
https://leetcode.com/problems/word-pattern/description/

bijection: char a <-> string A -> add bijective map -> check that current char and string are appropriate transformations -> otherwise return false

time: O(|s| + |p|) -> split string O(|s|) -> for each word, add char/string to maps O(1) -> check all words until not bijection O(|p|)
space: O(SIGMA * max(L)) -> bijection from chars => alphabet # of mappings O(SIGMA) -> each letter in alphabet mapped to words of max length L
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> revMap = new HashMap<>();

        char[] pat = pattern.toCharArray();
        int p = 0;

        String[] words = s.split(" ");

        if (pat.length != words.length) return false;

        while (p < pat.length) {
            if (map.containsKey(pat[p]) ^ revMap.containsKey(words[p])) return false;
            
            if (!(map.containsKey(pat[p]) && revMap.containsKey(words[p]))) {
                map.put(pat[p], words[p]);
                revMap.put(words[p], pat[p]);
            }

            else if (!(map.get(pat[p]).equals(words[p]) && revMap.get(words[p]) == pat[p])) {
                return false;
            }
            p++;
        }

        return true;
    }
}
