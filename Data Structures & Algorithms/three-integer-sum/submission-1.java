class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n-2; i++){
            int left = i+1; 
            int right = n-1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while(left<right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }
                else{
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while(left<right && nums[left-1] == nums[left]){left++;}
                    while(left<right && nums[right+1] == nums[right]){right--;}
                }
            } 
        }

        return ans;
    }
}
