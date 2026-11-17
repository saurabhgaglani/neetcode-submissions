class Solution {
    public int evalRPN(String[] tokens) {
        Set<Character> ops = new HashSet<>();
        Stack<Integer> nums = new Stack<>();
        ops.add('+');
        ops.add('-');
        ops.add('*');
        ops.add('/');
        int ans = 0;
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].length() > 1 || !ops.contains(tokens[i].charAt(0))){
                nums.push(Integer.parseInt(tokens[i]));
            }
            else{
                int[] twos = new int[2]; 
                for(int x = 0; x <= 1; x++){
                    twos[x] = nums.pop();
                }
                switch(tokens[i].charAt(0)){
                    case '+':
                    ans = twos[1] + twos[0];
                    break;
                    case '-':
                    ans = twos[1] - twos[0];
                    break;
                    case '*':
                    ans = twos[1] * twos[0];
                    break;
                    case '/':
                    ans = twos[1] / twos[0];
                    break;
                }
                nums.push(ans);
            }
        }

        return ans;
    }
}
