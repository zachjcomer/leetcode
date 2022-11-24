/*
https://leetcode.com/problems/valid-palindrome/submissions/
had to look up regex to get alphanumeric string: https://www.geeksforgeeks.org/how-to-remove-all-non-alphanumeric-characters-from-a-string-in-java/

format string -> pointers at start and end -> while i < j, move pointers inward -> return false if chars not equal
faster to lower then regex a-z0-9, limits # chars that must be checked against to replace with "", other way would need regex a-zA-Z0-9

time: O(n) -> string formatting must check string, pointers go over half of char array each
space: O(n) -> string to char array (could do O(1) by using s.charAt(k), but requires linear time)
*/

class Solution {
    public boolean isPalindrome(String s) {
        char[] sC = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        if (sC.length == 0) return true;

        int i = 0;
        int j = sC.length - 1;

        while (i < j) {
            if (sC[i] != sC[j]) return false;
            i++;
            j--;
        }

        return true;
    }
}
