class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        List<Character> alphs = new ArrayList<>();
        int runnCount = 0;
        int maxCount = 0;

        for(int c = 0; c < s.length(); c++){
            //loop through list check if c exists 
            if(alphs.contains(s.charAt(c))){
                int clashIndex = alphs.indexOf(s.charAt(c));
                maxCount = Math.max(runnCount, maxCount);
                while(clashIndex >= 0){
                    alphs.remove(clashIndex);
                    runnCount--;
                    clashIndex--;
                }
            }
            alphs.add(s.charAt(c));
            runnCount++;
        }

        if(runnCount > maxCount) return runnCount;
        return maxCount;
    }
}
