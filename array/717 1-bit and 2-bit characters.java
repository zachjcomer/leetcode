/*
https://leetcode.com/problems/1-bit-and-2-bit-characters/description/

follow the start of bits through the array -> if ends on a single bit, return true

time: O(n) -> single pass
space: O(1) -> index
*/

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 2) {
            if (bits[i] == 1) i += 2;
            else i += 1;
        }

        System.out.printf("%d", i);
        return bits[i] == 0;
    }
}
