class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        if(n == 0) return 0;

        double[][] speedPos = new double[n][3];

        Stack<Double> leaders = new Stack<>();

        for(int i = 0; i < n; i++){
            speedPos[i][0] = position[i];
            speedPos[i][1] = speed[i];
            speedPos[i][2] = (double) (target-position[i])/speed[i];
        }

        Arrays.sort(speedPos, (a,b) -> Double.compare(a[0],b[0]));

        int numfleets = 1;
        for(int i = n-1; i >=0; i--){
            if(!leaders.isEmpty() && speedPos[i][2] > leaders.peek()){
                leaders.push(speedPos[i][2]);
                numfleets += 1;
            }
            if(leaders.isEmpty()){
                leaders.push(speedPos[i][2]);
            }
        }
        return numfleets;
    }

}
