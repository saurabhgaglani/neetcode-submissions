class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freqs = new int[26];
        int[] freqsSub = new int[26];
        for(char c : s1.toCharArray()){
            freqs[c - 'a']++;
        }

        int left = 0;

        for(int right = 0; right < s2.length(); right++){
            freqsSub[s2.charAt(right) - 'a']++;
            if(right - left + 1 == n){
                boolean flag = true;
                for(int i = 0; i < 26; i++){
                    if(freqs[i] != freqsSub[i]){flag = false;}
                }
                if(flag){
                    return true;
                }
                else{
                    freqsSub[s2.charAt(left) - 'a']--;
                    left++;
                }
            }
        }

        return false; 
    }
}
