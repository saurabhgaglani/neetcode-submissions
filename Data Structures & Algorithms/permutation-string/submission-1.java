class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freqs = new int[26];
        int[] s2Freqs = new int[26];
        int left = 0;

        for(char i : s1.toCharArray()){
            s1Freqs[i - 'a']++;
        }

        outer:for(int right = 0; right < s2.length(); right++){
            s2Freqs[s2.charAt(right) - 'a']++;
            if((right - left) + 1 == s1.length()){
                for(int i = 0; i < 26; i++){
                    if(s1Freqs[i] != s2Freqs[i]){
                        s2Freqs[s2.charAt(left) - 'a']--;
                        left++;
                        continue outer;
                    }
                }
                return true;
            }
        }

        return false;

    }
}
