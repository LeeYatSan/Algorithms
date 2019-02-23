class NumArray {
    int[] nums;
    int[] memo;

    public NumArray(int[] nums) {
        this.nums = nums;
        int len = this.nums.length;
        memo = new int[len+1];
        memo[0] = 0;
        for(int i = 0; i < len; ++i)
            memo[i+1] = memo[i]+this.nums[i];
    }

    public int sumRange(int i, int j) {
        if(nums.length == 0)
            return 0;
        else return (memo[j+1] - memo[i]);

    }
}