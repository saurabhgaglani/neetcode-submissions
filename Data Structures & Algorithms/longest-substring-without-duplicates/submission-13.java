class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0; 
        int runMax = 0;
        int curMax = 0;

        for(int right = 0; right < s.length(); right++){
            if(window.add(s.charAt(right))){
                runMax = Math.max((right - left)+1, runMax);
            }
            else{
                while(window.contains(s.charAt(right))){
                    window.remove(s.charAt(left));
                    left++;
                }
                window.add(s.charAt(right));
                curMax = Math.max(curMax, runMax);
                runMax = 0;
            }
        }

        for(char c: window) System.out.println(c);
        return Math.max(curMax,runMax);
    }
}
