class Solution {
    int[] memo;
    public int trap(int[] height) {
        int n = height.length;
        int[] maxHeightFromLeft = new int[n];
        int[] maxHeightFromRight = new int[n];

        memo = new int[n];
        int sum = 0;

        for(int i = 0; i < n; i++){
            maxHeightFromLeft[i] = maxHelperLeft(height, i);
        }
        Arrays.fill(memo, 0);
        for(int j = n-1; j>0; j--){
            maxHeightFromRight[j] = maxHelperRight(height, j);
        }

        for(int x = 1; x < n; x++){
            sum += Math.min(maxHeightFromLeft[x], maxHeightFromRight[x]) - height[x];
        }

        return sum;
    }

    public int maxHelperLeft(int[] height, int i){
        if(i == 0) return height[0];
        if(memo[i] > 0) return memo[i];

        memo[i] = Math.max(height[i], maxHelperLeft(height, i-1));

        return Math.max(height[i], memo[i]);
    }

    public int maxHelperRight(int[] height, int i){
        if(i == height.length-1) return height[height.length-1];
        if(memo[i] > 0) return memo[i];

        memo[i] = Math.max(height[i], maxHelperRight(height, i+1));

        return Math.max(height[i], memo[i]);
    }

    
}
