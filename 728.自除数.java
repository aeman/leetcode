import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividing(int num) {
        int temp = num;
        while (temp > 0) {
            int i = temp % 10;
            if (i == 0 || num % i != 0) {
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }
}
// @lc code=end

