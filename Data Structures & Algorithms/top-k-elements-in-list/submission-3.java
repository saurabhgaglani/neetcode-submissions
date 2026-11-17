class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqs = new HashMap<>();
        List<List<Integer>> groupedFreqs = new ArrayList<>();
        int n = nums.length;
        int[] ans = new int[k];

        for(int i : nums){
            freqs.put(i, freqs.getOrDefault(i,0)+1);
        }

        for(int i = 0; i <= nums.length; i++) groupedFreqs.add(new ArrayList<>());

        for(Map.Entry<Integer, Integer> entry : freqs.entrySet()){
            groupedFreqs.get(entry.getValue()).add(entry.getKey());
        }
        int index = 0;
        for(int i = n; i >=0; i--){
            if(groupedFreqs.get(i) != null){
                for(int x : groupedFreqs.get(i)){ 
                    if(index >= k) break;
                    ans[index++] = x;
                } 
            }
        }

        return ans;
    }
}
