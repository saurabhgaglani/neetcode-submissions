class Solution {
    public boolean isPalindrome(String s) {
        String stripped = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0;
        int end = stripped.length()-1;
        
        while(start < end){
            System.out.println(stripped.charAt(start)+" == "+ stripped.charAt(end));
            if(stripped.charAt(start) == stripped.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}
