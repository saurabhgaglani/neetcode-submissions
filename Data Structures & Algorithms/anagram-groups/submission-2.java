class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> char_freq = new HashMap<>();


        for(int i = 0; i < strs.length; i++){
            int[] pairs = new int[26];
            String key = "";
            for(int j= 0; j < strs[i].length(); j++){
                pairs[strs[i].charAt(j) - 'a']++;
            }
            for(int x : pairs){key += x + "#";}
            if(!char_freq.containsKey(key)){
                char_freq.put(key, new ArrayList<>());
            }
            char_freq.get(key).add(strs[i]);   
        }

        return new ArrayList<>(char_freq.values());
    }
}
