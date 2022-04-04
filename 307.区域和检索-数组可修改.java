/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    private int[] nums;
    private int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            insert(i + 1, nums[i]);
        }
    }

    private void insert(int index, int val) {
        while (index < tree.length) {
            tree[index] = tree[index] + val;
            index += lowbit(index);
        }
    }

    private int lowbit(int index) {
        return index & -index;
    }

    public void update(int index, int val) {
        int x = index + 1;
        while (x < tree.length) {
            // 减去之前nums[index]的值, 加上新的值
            tree[x] = tree[x] - nums[index] + val;
            x += lowbit(x);
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private int query(int index) {
        int ans = 0;
        while (index != 0) {
            ans += tree[index];
            index -= lowbit(index);
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end
