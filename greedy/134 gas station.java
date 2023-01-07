/*
https://leetcode.com/problems/gas-station/description/

check if no cycle is possible, when net gas is negative -> find the last gas station with net negative gas -> b/c station has possible cycle (net positive), SOME station must begin a net positive run

time: O(n) -> impossible cycle check O(n) -> best starting point check O(n)
space: O(1) -> accumulator and value for gas station O(1)
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int t = 0;
        int s = 0;

        for (int i = 0; i < gas.length; i++) {
            t += gas[i] - cost[i];
        }

        if (t < 0) return -1;
        t = 0; 

        for (int i = 0; i < gas.length; i++) {
            t += gas[i] - cost[i];
            if (t < 0) {
                t = 0;
                s = i + 1;
            }
        }   
        return s;
    }
}
