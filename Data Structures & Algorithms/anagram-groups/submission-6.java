class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> freqIndex = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            String freqsString = "";
            int[] freqs = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                freqs[strs[i].charAt(j) - 'a']++;
            }
            for(int k : freqs){freqsString += k + '#';}
            freqIndex.computeIfAbsent(freqsString, k -> new ArrayList<Integer>()).add(i);
        }

        int index = 0;
        for(List<Integer> i : freqIndex.values()){
            res.add(new ArrayList<String>());
            for(int x : i){
                res.get(index).add(strs[x]);
            }
            index++;
        }


        return res; 
    }
}
