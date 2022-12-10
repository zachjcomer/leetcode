/*
https://leetcode.com/problems/pascals-triangle/description/

pascal's triangle.

time: O(n^2) -> # computations ~ # of rows
space: O(n^2) -> # values ~ # of rows
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row =  new LinkedList<>();
            
            // row 1 (boundary cond.)
            if (i == 0) {
                row.add(1);
                out.add(row);
            }
            // all other rows
            else {
                for (int j = 0; j <= i; j++) {
                    List<Integer> last = out.get(i - 1);
                    if (j == 0 || j == i) {
                        row.add(1);
                    }
                    else {
                        row.add(last.get(j) + last.get(j - 1));
                    }
                }
                out.add(row);
            }   
        }
        return out;
    }
}
