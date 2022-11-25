/*
https://leetcode.com/problems/valid-sudoku/

hash with array to count instances of chars -> check every row, col, and box -> if tallying char w/ count 1, not valid sodoku

time: O(n^2) -> check every row, column, and box once
space: O(n) -> counter for a row, col, or box
*/

class Solution {
    char[][] pub_board;
    public boolean isValidSudoku(char[][] board) {
        pub_board = board;

        // validate rows and columns
        for (int i = 0; i < board.length; i++) {
            if (!validate_line(i)) return false;
        }

        // validate boxes
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if (!validate_box(i, j)) return false;
            }
        }

        return true;
    }

    private boolean validate_line(int head) {
        int[] count_row = new int[9];
        int[] count_col = new int[9];
        for (int i = 0; i < pub_board.length; i++) {
            char c_row = pub_board[head][i];
            char c_col = pub_board[i][head];

            if (c_row != '.') {
                count_row[c_row - '1']++;
                if (count_row[c_row - '1'] > 1) {
                    return false;
                }
            }

            if (c_col != '.') {
                count_col[c_col - '1']++;
                if (count_col[c_col - '1'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // top left corner index
    private boolean validate_box(int i_box, int j_box) {
        int[] count = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = pub_board[i_box + i][j_box + j];
                if (c != '.') {
                    count[c - '1']++;
                    if (count[c - '1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
