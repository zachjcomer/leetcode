/*
https://leetcode.com/problems/zigzag-conversion/description/

init row lists -> map each char in s to its row -> add to row list -> concat row lists -> concat rows

time O(|s|): row list init O(r) -> map chars in s O(|s|) -> concat all O(|s|)
space: O(|s|): max rows O(|s|) -> sum of chars in all rows O(|s|)
*/

public class Solution {
    public string Convert(string s, int numRows) {
        List<List<char>> rowMap = new List<List<char>>();
        
        for (int i = 0; i < numRows; i++) {
            rowMap.Add(new List<char>());
        }

        int z = 2 * (numRows - 1);
        for (int i = 0; i < s.Length; i++) {
            int mod = 0;
            if (z != 0) mod = i % z;

            if (mod < numRows) {
                rowMap[mod].Add(s[i]);
            } else {
                int rev = z - mod;
                rowMap[rev].Add(s[i]);
            }
        }

        return rowMap.Aggregate("", (accOut, x) => 
            String.Concat(
                accOut,
                x.Aggregate(
                    "", (accIn, y) => String.Concat(accIn, y)
                )
            )
        );
    }
}
