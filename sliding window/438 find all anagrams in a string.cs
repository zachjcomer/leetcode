/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

map chars in p to their count -> check all windows of size |p| in s -> if char count matches, add left edge index to output

time: O(|s|) -> count p, but p length upper bounded by s O(|s|) -> add/remove edges of window over s O(|s|)
space: O(|SIGMA|) -> p count alphabet size O(|SIGMA|) -> s window alphabet size O(|SIGMA|)
*/

public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        IList<int> list = new List<int>();

        var pDict = new Dictionary<char, int>();
        var sDict = new Dictionary<char, int>();

        for (int i = 0; i < p.Length; i++) {
            if (!pDict.ContainsKey(p[i])) {
                pDict.Add(p[i], 1);
            } else {
                pDict[p[i]]++;
            }
        }

        int match = 0;
        for (int l = -1, r = 0; r < s.Length; r++, l = r - p.Length) {
            if (!sDict.ContainsKey(s[r])) {
                sDict.Add(s[r], 1);
            } else {
                sDict[s[r]]++;
            }

            if (pDict.ContainsKey(s[r])) {
                if (sDict[s[r]] == pDict[s[r]]) match++;
                else if (sDict[s[r]] == pDict[s[r]] + 1) match--;
            }

            if (l >= 0) {
                sDict[s[l]]--;

                if (pDict.ContainsKey(s[l])) {
                    if (sDict[s[l]] == pDict[s[l]]) match++;
                    else if (sDict[s[l]] == pDict[s[l]] - 1) match--;
                }
            }

            if (match == pDict.Count) {
                list.Add(l + 1);
            }
        }

        return list;
    }
}
