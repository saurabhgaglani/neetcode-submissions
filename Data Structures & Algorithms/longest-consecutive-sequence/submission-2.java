class Solution {
    public int longestConsecutive(int[] nums) {
        int left = 0; 
        int offset = 0;
        int max = -1;
        Arrays.sort(nums);

        for(int right = 1; right < nums.length; right++){
            if(nums[right-1] + 1 == nums[right]) continue;
            if(nums[right-1] == nums[right]){
                offset++;
                continue;
            }
            max = Math.max(max, (right-left-offset));
            left=right;
            offset = 0;
        }

        return Math.max(max, (nums.length - left) - offset);
    }
}
