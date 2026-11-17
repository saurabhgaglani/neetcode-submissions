class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> pairs = new HashMap<>();
        
        int n = strs.length;

        for(int i = 0; i < n; i++){
            int[] counts = new int[26];
            String res = "";
            for(int j = 0; j < strs[i].length(); j++){
                counts[strs[i].charAt(j) - 'a']++;
            }
            for(int c : counts){res += c + "#";}
            pairs.putIfAbsent(res, new ArrayList<>());
            pairs.get(res).add(strs[i]);
        } 

        return new ArrayList<>(pairs.values());

    }
}
