class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        List<List<Integer>> freqs_array = new ArrayList<>();
        int[] ans = new int[k];

        for(int i = 0; i <= nums.length; i++){
            freqs_array.add(i, new ArrayList<Integer>());
        }

        for(int i : nums){
            freqs.put(i, freqs.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> el : freqs.entrySet()){
            int val = el.getValue();
            freqs_array.get(val).add(el.getKey());
        }
        int index = 0;
        for(int x = nums.length; x>= 0; x--){
            if(!freqs_array.get(x).isEmpty()){
                for(int n : freqs_array.get(x)){
                    ans[index++] = n;
                    if(index == k){return ans;}
                }
            }
        }
        return ans;
    }
}
