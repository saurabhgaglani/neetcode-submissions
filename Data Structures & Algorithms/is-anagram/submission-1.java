class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freqs = new int[26];
        int[] freqs2 = new int[26];

        int n = s.length();

        for(int i = 0; i < n; i++){
            freqs[s.charAt(i)-'a']++;
            freqs2[t.charAt(i)-'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freqs[i] != freqs2[i]) return false;
        }

        return true;
    }
}
