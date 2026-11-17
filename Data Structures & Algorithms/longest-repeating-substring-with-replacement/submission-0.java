class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];
        int left = 0;
        int maxCount = 0;
        int runCount = 0; 
        int maxSub = 0;
        int n = s.length();
        for(int right = 0; right < n; right++){
            char curr = s.charAt(right);
            freqs[curr - 'A']++;
            //Extract most common frequency in sub 
            for(int max : freqs){
                maxCount = Math.max(maxCount, max); 
            }
            if( ((right - left) + 1) - maxCount <= k){
                    maxSub = Math.max(maxSub, (right-left)+1);
            }
            else{
                    freqs[s.charAt(left) - 'A']--;
                    left++;
            }
        }
        return maxSub;
    }
}
