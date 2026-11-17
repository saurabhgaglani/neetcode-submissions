class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> tempsStack = new Stack<>();
        int[] ans = new int[n]; 

        for(int i = 0; i < n; i++){
            while(!tempsStack.isEmpty() && temperatures[i] > temperatures[tempsStack.peek()]){
                ans[tempsStack.peek()] = i - tempsStack.pop();
            }
            tempsStack.push(i);
        }

        return ans;
    }
}
