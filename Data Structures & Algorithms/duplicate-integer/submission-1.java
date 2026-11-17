class Solution {
    public boolean hasDuplicate(int[] nums) {

        Set<Integer> un = new HashSet<>();

        for(int i = 0; i<nums.length; i++){
            if(!un.add(nums[i])){
                return true;
            }
        }

        return false;
    }
}