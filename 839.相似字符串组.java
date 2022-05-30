/*
 * @lc app=leetcode.cn id=839 lang=java
 *
 * [839] 相似字符串组
 */

// @lc code=start
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length, groups = n;
        int[] fathers = new int[n];
        for (int i = 0; i < n; i++) {
            fathers[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (similar(strs[i], strs[j]) && union(fathers, i, j)) {
                    groups--;
                }
            }
        }

        return groups;
    }

    private boolean similar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        return diff <= 2;
    }

    private boolean union(int[] fathers, int i, int j) {
        int fatherI = findFather(fathers, i);
        int fatherJ = findFather(fathers, j);
        if (fatherI != fatherJ) {
            fathers[fatherI] = fatherJ;
            return true;
        }
        return false;
    }

    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }
}
// @lc code=end
