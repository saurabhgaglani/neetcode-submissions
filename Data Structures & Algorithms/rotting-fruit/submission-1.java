class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenCords = new LinkedList<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 2) rottenCords.offer(new int[]{i,j});
            }
        }

        int minutes = 0;
        while(!rottenCords.isEmpty()){
            int s = rottenCords.size();

            for(int i = 0; i < s; i++){
                int[] cord = rottenCords.poll();
                int row = cord[0];
                int col = cord[1];
                if(row+1 < rowLen && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    rottenCords.offer(new int[]{row+1, col});
                }
                if(row-1 >= 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    rottenCords.offer(new int[]{row-1, col});
                }
                if(col-1 >= 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    rottenCords.offer(new int[]{row, col-1});
                }
                if(col+1 < colLen && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    rottenCords.offer(new int[]{row, col+1});
                }
            }
            if(!rottenCords.isEmpty()) minutes++;

        }
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] != 2 && grid[i][j] != 0) return -1;
            }
        }
        return minutes;
    }
}
