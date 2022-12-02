/*
https://leetcode.com/problems/reorder-data-in-log-files/description/

custom Comparator: sort words lexicographically, if equal, sort by identifier, digits have no sort ordering, maintain stable order

time: O(mn log n) -> sorting in O(n log n) -> each comparison takes O(m) time to split strings and O(m) compare them
space: O(m log n) -> comparisons must store strings of length m -> arrays.sort is quicksort which needs O(m log n) space for sorting
*/

class logs_sort implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        String[] a_split = a.split(" ", 2);
        String[] b_split = b.split(" ", 2);

        boolean a_is_digit = Character.isDigit(a_split[1].charAt(0));
        boolean b_is_digit = Character.isDigit(b_split[1].charAt(0));

        if (!a_is_digit && !b_is_digit) {
            int comp = a_split[1].compareTo(b_split[1]);
            if (comp != 0) {
                return comp;
            }
            else return a_split[0].compareTo(b_split[0]);
        }

        if (a_is_digit && !b_is_digit) {
            return 1;
        }
        else if (!a_is_digit && b_is_digit) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new logs_sort());
        return logs;
    }
}
