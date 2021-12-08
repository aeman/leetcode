/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    int[] ans;

    public int climbStairs(int n) {
        // if(n == 1){return 1;}
        // if(n == 2){return 2;}
        // int a = 1, b = 2, temp;
        // for(int i = 3; i <= n; i++){
        //     temp = a;
        //     a = b;
        //     b = temp + b;
        // }
        // return b;   
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
// @lc code=end

