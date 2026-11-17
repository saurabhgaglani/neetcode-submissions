class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ga = new HashMap<>();
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            char[] freqs = new char[26];
            String enc = "";
            for(int j = 0; j < strs[i].length();j++){
                freqs[strs[i].charAt(j) - 'a']++;
            }
            for(int x : freqs){enc += x + '#';}
            ga.computeIfAbsent(enc, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(ga.values());
    }
}
