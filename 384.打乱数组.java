import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {
    private int[] origin;
    private int[] shuffle;

    public Solution(int[] nums) {
        this.origin = nums;
        this.shuffle = new int[nums.length];
        System.arraycopy(origin, 0, shuffle, 0, origin.length);
    }
    
    public int[] reset() {
        System.arraycopy(origin, 0, shuffle, 0, origin.length);
        return shuffle;
    }
    
    public int[] shuffle() {
        int[] temp = new int[shuffle.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < shuffle.length; i++) {
            list.add(shuffle[i]);
        }

        Random random = new Random();
        for (int i = 0; i < shuffle.length; i++) {
            int index = random.nextInt(list.size());
            temp[i] = list.remove(index);
        }

        System.arraycopy(temp, 0, shuffle, 0, shuffle.length);
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

