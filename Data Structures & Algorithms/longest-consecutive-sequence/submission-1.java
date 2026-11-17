class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){return 0;}
        int maxStreak = 1; 

        Set<Integer> vals = new HashSet<>();

        for (int i: nums){
            vals.add(i);
        }

for (int i : vals) {

    // Only start if i is the BEGINNING of a sequence
    if (!vals.contains(i - 1)) {

        int curr = i;
        int currStreak = 1;

        // Keep walking forward
        while (vals.contains(curr + 1)) {
            curr++;
            currStreak++;
        }

        maxStreak = Math.max(maxStreak, currStreak);
    }
}
        
        return maxStreak;
    }
}
