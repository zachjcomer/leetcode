/*
https://leetcode.com/problems/permutation-in-string/description/

approach 1: track the net character matchings

tally the initial character matches between s1, s2 -> move the fixed window across the remainder of s2 and check the changes in s2's counts

time: O(|s1| + (|s2| - |s1|)) -> |s1| to get initial matchings, |s2| - |s1| to iterate over remainder of s2
space: O(1) -> counts ~ 26, match variable
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int match = 0;

        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                match++;
            }
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (match == 26) return true;

            int l = s2.charAt(i - s1.length()) - 'a';
            int r = s2.charAt(i) - 'a';

            if (count1[r] == count2[r]++) {
                match--;
            }
            else if (count1[r] == count2[r]) {
                match++;
            }

            if (count1[l] == count2[l]--) {
                match--;
            }
            else if (count1[l] == count2[l]) {
                match++;
            }

        }

        return match == 26;
    }
}

/*
approach 2, track individual character matching

time: O(|s1| + (|s2| - |s1|) -> same as approach 1 but * checking ~ 26 b/c checking all characters, not net similarity
space: O(1) -> arrays for character tracking ~ 26
*/

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }
    
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
