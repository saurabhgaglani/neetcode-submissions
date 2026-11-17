class Solution {
    Integer[] memo;
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        memo = new Integer[nums.length];

        if(nums.length == 1) return nums[0];
        
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, dp(nums, i));
        }

        return max;
    }

    public int dp(int[] nums, int i){
        if(i == 0) return nums[i];
        if(memo[i] != null) return memo[i];

        memo[i] = Math.max(nums[i] + dp(nums, i-1), nums[i]);

        return memo[i];
        
    }
}
