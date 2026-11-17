class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int left = 0; left < nums.length-2; left++){
            if((left > 0) && nums[left-1] == nums[left]) continue;
            int right = nums.length-1;
            for(int mid = left+1; mid < right;){
                if(nums[left] + nums[mid] + nums[right] > 0) right--;
                else if(nums[left] + nums[mid] + nums[right] < 0) mid++;
                else{
                    ans.add(new ArrayList<>(List.of(nums[left], nums[mid], nums[right])));
                    while (mid < right && nums[mid] == nums[mid + 1]) mid++;
                    while (mid < right && nums[right] == nums[right - 1]) right--;
                    mid++;
                    right--;
                }
            }
        }

        return ans;
    }
}
