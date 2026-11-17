class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> vals = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!vals.add(nums[i])) return true;
        }

        return false;
    }
}