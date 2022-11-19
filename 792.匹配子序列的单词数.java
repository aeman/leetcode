import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=792 lang=java
 *
 * [792] 匹配子序列的单词数
 */

// @lc code=start
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] q = new Queue[26];
        for (int i = 0; i < 26; i++) {
            q[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < words.length; i++) {
            q[words[i].charAt(0) - 'a'].offer(new int[] { i, 0 });
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int len = q[c - 'a'].size();
            while (len > 0) {
                int[] t = q[c - 'a'].poll();
                if (words[t[0]].length() - 1 == t[1]) {
                    ans++;
                } else {
                    t[1]++;
                    q[words[t[0]].charAt(t[1]) - 'a'].offer(t);
                }
                len--;
            }
        }
        return ans;
    }
}
// @lc code=end
