/*
 * @lc app=leetcode.cn id=1460 lang=java
 *
 * [1460] 通过翻转子数组使两个数组相等
 */

// @lc code=start
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] newArr = new int[1001];

        for (int i = 0; i < target.length; i++) {
            newArr[target[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i]]--;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] != 0) return false;
        }

        return true;
    }
    
}
// @lc code=end

