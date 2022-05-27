import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        // 1.位运算
        // int xorsum = 0;
        // for (int num : nums) {
        //     xorsum ^= num;
        // }
        // // 防止溢出
        // int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        // int type1 = 0, type2 = 0;
        // for (int num : nums) {
        //     if ((num & lsb) != 0) {
        //         type1 ^= num;
        //     } else {
        //         type2 ^= num;
        //     }
        // }
        // return new int[] { type1, type2 };

        // 2.哈希表
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        Iterator<Integer> iter = set.iterator();
        int i1 = iter.next(), i2= iter.next();
        return new int[] { i1, i2 };
    }
}
// @lc code=end
