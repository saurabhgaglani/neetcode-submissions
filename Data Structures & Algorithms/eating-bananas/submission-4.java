class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        int maxVal = 0;
        for(int i : piles){
            sum+= i;
            maxVal = Math.max(maxVal, i);
        }
        int minVal = (int) Math.ceil(((double)sum / h));
        if (minVal < 1) minVal = 1; 

        int minK = Integer.MAX_VALUE;
        while(minVal <= maxVal){
            int mid = minVal + (maxVal-minVal) / 2;
            int hours = 0;
            for(int i : piles){
                hours += (int) Math.ceil((double) i / mid);
            }
            if(hours > h){
                minVal = mid + 1;
            }
            else{
                minK = Math.min(minK, mid);
                maxVal = mid-1;
            }
        }


        return minK;
    }
}
