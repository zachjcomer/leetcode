/*
https://leetcode.com/problems/letter-tile-possibilities/description/

count the chars in tiles -> dfs over the remaining char count -> for each letter, generate a combo/decrease count -> recurse on decreased count -> increment count

time: O(26^|s|) -> count tiles in O(|S|) -> for each non-zero letter, generate a new sequence O(26) -> longest sequence can be O(|S|)
space: O(1) -> counter for tile values O(1) -> sum O(1)
*/

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }

        return dfs(count);
    }

    private int dfs(int[] count) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            sum++;
            count[i]--;
            sum += dfs(count);
            count[i]++;
        }

        return sum;
    }
}
