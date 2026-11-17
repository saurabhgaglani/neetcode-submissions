class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        List<List<Integer>> sortInPlace = new ArrayList<>();
        int[] ans = new int[k];

        for(int i = 0; i <= nums.length; i++){
            sortInPlace.add(new ArrayList<>());
        }

        for(int i : nums){
            numCounts.putIfAbsent(i, 0);
            numCounts.put(i, numCounts.get(i)+1);
        }

        numCounts.forEach((key,value) -> {
            sortInPlace.get(value).add(key);
        });

        int ind = 0;
        for(int i = nums.length; i >= 1; i--){
            if(!sortInPlace.get(i).isEmpty()){
                for(int num : sortInPlace.get(i)){
                    ans[ind++] = num;
                    if(ind == k){return ans;}
                }
            }
        }

        return new int[]{0,0};
    }
}
