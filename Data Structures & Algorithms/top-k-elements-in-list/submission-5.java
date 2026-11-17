class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] ans = new int[k];

        for(int i : nums){
            freqs.put(i, freqs.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> el : freqs.entrySet()){
            heap.offer(new int[]{el.getValue(), el.getKey()});
            if(heap.size() > k) heap.poll();
        }

        for(int i = 0; i < k; i++){
            ans[i] = heap.poll()[1];
        }

        return ans; 
    }
}
