import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int i = squareSum(n);
            if (!set.add(i)) return false;
            n = i;
        }

        return true;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }
}
// @lc code=end

