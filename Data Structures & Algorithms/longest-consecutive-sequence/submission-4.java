class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> unique_nums = new HashSet<Integer>();
        int count = 0; 
        int maxCount = -1;

        for(int i : nums){unique_nums.add(i);}

        for(int i = 0; i < nums.length; i++){
            if(unique_nums.contains(nums[i]-1)){
                continue;
            }
            int currentNum = nums[i];
            while(unique_nums.contains(currentNum)){
                currentNum++;
                count++;
            }
            maxCount = Math.max(count, maxCount);
            count = 0;
        }

        return maxCount == -1 ? 0 : maxCount;
    }
}
