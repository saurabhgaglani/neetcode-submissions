class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> freq_string = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){  //act
            int[] pairs = new int[26];
            String freqs = "";
            for(int j = 0; j < strs[i].length(); j++){  //a
                pairs[strs[i].charAt(j) - 'a']++; //[1 0 1]
            }
            for(int c : pairs){
                freqs += c + '#'; //101
            }
            if(!freq_string.containsKey(freqs)){
                freq_string.put(freqs, new ArrayList<>());
            }
            freq_string.get(freqs).add(strs[i]);           
        }
        return new ArrayList<>(freq_string.values());
    }
}
