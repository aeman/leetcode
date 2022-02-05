import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        List<List<Integer>> list = new ArrayList<>();
        return backtrack(0, num.length(), num, list);
    }

    private boolean backtrack(int idx, int n, String num, List<List<Integer>> list) {
        if (idx == n)
            return list.size() >= 3;
        int max = num.charAt(idx) == 'c' ? idx++ : n;
        List<Integer> cur = new ArrayList<>();

        for (int i = idx; i < max; i++) {
            cur.add(0, num.charAt(i) - '0');
            if (n < 2 || check(list.get(n - 2), list.get(n - 1), cur)) {
                list.add(cur);
                if (backtrack(i + 1, n, num, list))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    private boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> ans = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size())
                t += a.get(i);
            if (i < b.size())
                t += b.get(i);
            ans.add(t % 10);
            t /= 10;
        }
        if (t > 0)
            ans.add(t);
        boolean ok = c.size() == ans.size();
        for (int i = 0; i < c.size() && ok; i++) {
            if (c.get(i) != ans.get(i))
                ok = false;
        }
        return ok;
    }
}
// @lc code=end
