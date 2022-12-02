/*
https://leetcode.com/problems/generate-parentheses/

approach 1: generate all possible parenthesis and check using a stack
approach 2: use backtracking and generate combos based on counts of (, )

time: O(4^n / n^1/2) (Catalan Number) -> 2^2n (=4^n) possible strings where n^-/2 comes from the pruning
space: O(4^n / n^1/2) -> must generate all of the valid parenthesis
*/

class Solution {
    List<String> sols = new LinkedList<>();
    int max;
    int max_2;

    public List<String> generateParenthesis(int n) {
        max = 2 * n;
        max_2 = n;
        char[] str = new char[2 * n];

        gen(str, 0, 0, 0);
        return sols;
    }
    
    private void gen(char[] str, int n, int l, int r) {
        if (n == max) {
            sols.add(new String(str));
        }

        else {
            if (l < max_2) {
                str[n] = '(';
                gen(str, n + 1, l + 1, r);
            }
            if (r < l){
                str[n] = ')';
                gen(str, n + 1, l, r + 1);
            }
        }
    }
}
