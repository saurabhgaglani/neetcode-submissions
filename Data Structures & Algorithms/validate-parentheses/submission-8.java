class Solution {
    public boolean isValid(String s) {
        if(s.length() < 2) return false;
        Map<Character, Character> brackets = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>(); 

        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        for(char c : s.toCharArray()){
            if(brackets.containsKey(c)){
                if(!stack.isEmpty() && stack.pop() == brackets.get(c)) continue;
                else return false;
            }
            stack.push(c);
        }

        return stack.isEmpty() ? true : false;
    }
}
