/*
https://leetcode.com/problems/generate-parentheses/

approach 1: generate all possible parenthesis and check using a stack
approach 2: use backtracking and generate combos based on counts of (, )

time: O(4^n / n^1/2) (Catalan Number) -> 2^2n (=4^n) possible strings where n^-/2 comes from the pruning
space: O(4^n / n^1/2) -> must generate all of the valid parenthesis
*/

// approach 1
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

// approach 2
class Solution {
    List<String> sols = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        gen(true, 2 * n, "");
        return sols;
    }

    public void gen(boolean push, int n, String str) {
        if (n == 0 && push) {
            if (isValid(str)) sols.add(str);
        }

        else if (n > 0) {
            if (push) {
                str = str + "(";
            }
            else {
                str = str + ")"; 
            }
            gen(push, n - 1, str);
            gen(!push, n - 1, str);
        }
    }

    private boolean isValid(String str) {
        Stack<Character> check = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                check.push(str.charAt(i));
            }
            else if (!check.empty()) {
                check.pop();
            }
            else {
                return false;
            }
        }
        return (check.empty()) ? true : false;
    }
}
