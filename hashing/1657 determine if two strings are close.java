/*
https://leetcode.com/problems/determine-if-two-strings-are-close/description/

count char frequencies in array hash -> check words use the same characters -> check relative frequency of letters are the same

time: O(|word1|) -> if not same length, cant be close, count chars over word1 length O(|word1|), sorting array hash T ~ (26 log 26), check char existence and frequency in O(1)
space: O(|word1|) -> char arrays for words O(|word1|), word hashes ~ 26
*/
class Solution {
    public boolean closeStrings(String word1, String word2) { 
        if (word1.length() != word2.length())
            return false;

        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            count1[char1[i] - 'a']++;
            count2[char2[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0 ^ count2[i] == 0)
                return false;
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i])
                return false;
        }

        return true;
    }
}
