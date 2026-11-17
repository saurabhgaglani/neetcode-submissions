class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];
        int max = 0; 
        int left = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++){
            freqs[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freqs[s.charAt(right) - 'A']);

            if((right-left+1) - maxFreq > k ){
                freqs[s.charAt(left)-'A']--;
                left++;
            }

            max = Math.max(max, right-left+1);

        }

        return max;
    }
}
