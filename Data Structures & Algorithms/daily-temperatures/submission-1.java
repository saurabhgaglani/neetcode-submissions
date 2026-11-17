class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> tempratureIndices = new Stack<>();
        for(int i = 0; i < n; i++){
            ans[i] = 0;
        }

        for(int i = 0; i < n; i++){
            while(!tempratureIndices.isEmpty() && temperatures[tempratureIndices.peek()] < temperatures[i]){
                ans[tempratureIndices.peek()] = i - tempratureIndices.pop();
            }
            tempratureIndices.push(i);
        }

        return ans;
        
    }
}
