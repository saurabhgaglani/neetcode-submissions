class Solution {
    public int lengthOfLongestSubstring(String s) {

        List<Character> alphs = new ArrayList<>();

        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < s.length(); right++) {

            char curr = s.charAt(right);

            if (alphs.contains(curr)) {
                int clashIndex = alphs.lastIndexOf(curr);

                if (clashIndex >= left) {
                    left = clashIndex + 1;
                }
            }

            alphs.add(curr);

            int runnCount = right - left + 1;
            maxCount = Math.max(maxCount, runnCount);
        }

        return maxCount;
    }
}
