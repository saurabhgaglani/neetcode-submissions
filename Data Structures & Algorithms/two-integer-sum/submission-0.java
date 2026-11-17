class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pair = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(pair.containsKey(target - nums[i])){
                ans[0] = pair.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            else{
                pair.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
