/*
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/

sliding window -> add vowels to set -> window of size k -> check leading/trailing edge -> compare max w/ each window count

time: O(|s|) -> each char checked as leading and trailing O(|s|)
space: O(A) -> set of chars used for checking O(A) -> count number O(1)
*/

public class Solution {
    private bool LeadingEdge(int idx, string s, HashSet<char> set) {
        return set.Contains(s[idx]);
    }
    
    private bool TrailingEdge(int idx, string s, HashSet<char> set) {       
        return (idx >= 0 && set.Contains(s[idx]));
    }

    public int MaxVowels(string s, int k) {
        HashSet<char> vowels = new HashSet<char>(){'a', 'e', 'i', 'o', 'u'};

        int count = 0;
        int max = 0;

        for (int i = 0; i < s.Length; i++) {
            if (LeadingEdge(i, s, vowels)) {
                count++;
            }

            if (TrailingEdge(i - k, s, vowels)) {
                count--;
            }

            max = Math.Max(max, count);
        }

        return max;
    }
}
