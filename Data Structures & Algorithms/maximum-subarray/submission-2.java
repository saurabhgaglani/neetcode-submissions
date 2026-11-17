class Solution {
    Integer[] memo; 
    public int maxSubArray(int[] nums) {
        memo = new Integer[nums.length];
        int max = nums[0];
        memo[0] = nums[0];
        for(int i =0; i<nums.length; i++){
            max = Math.max(max, dp(nums, i));
        }
        return max;
    }

    public int dp(int[] nums, int i){
        if(i == 0) return nums[0];
        if(memo[i]!=null) return memo[i];

        memo[i] = Math.max(nums[i], nums[i] + dp(nums, i-1));

        return memo[i];
         
    }
}
