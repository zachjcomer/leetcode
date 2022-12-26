/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

hash the words in words -> use fixed window to track words -> compare window hash to words hash after each window shift
s may not match valid words (eg s(0, k) != a word but s(1, k+1) is) -> shift start point k times to hit all possible words

time: O(|w| + k|s|) -> build words hash O(|w|) -> for each letter shift O(k) -> slide window O(|s|/k) times -> generate comparison string O(k)
space: O(nk) -> n words in words -> n words allowed in the hash maps O(n) -> words are k characters long O(k)
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> out = new LinkedList<>();

        int k = words[0].length();
        int n = words.length;
        int w = n * k;
        
        char[] s_char = s.toCharArray();
        Map<String, Integer> w_count = new HashMap<>();

        for (String word : words) {
            w_count.put(word, w_count.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            Map<String, Integer> s_count = new HashMap<>();
            for (int j = i; j < s.length(); j += k) {
                String sWord = new String(Arrays.copyOfRange(s_char, j, j + k));
                s_count.put(sWord, s_count.getOrDefault(sWord, 0) + 1);

                int jExit = j - n * k;
                if (jExit >= 0) {
                    String sBackWord = new String(Arrays.copyOfRange(s_char, jExit, jExit + k));
                    s_count.put(sBackWord, s_count.get(sBackWord) - 1);
                    s_count.remove(sBackWord, 0);
                }

                if (s_count.equals(w_count)) {
                    out.add(jExit + k);
                }
            }
        }
        return out;
    }
}
