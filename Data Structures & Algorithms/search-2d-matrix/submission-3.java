class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int down = 0; int up = rows-1;
        int targetRow = 0;

        while(down <= up){
            int mid = down + (up-down) / 2;
            if(matrix[mid][0] <= target && matrix[mid][columns-1] >= target){
                targetRow = mid;
                break;
            }
            if(matrix[mid][0] > target){
                up = mid -1;
            }
            else{
                down = mid + 1;
            }
        }

        int left = 0; int right = columns - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[targetRow][mid] == target){
                return true;
            }
            else if(matrix[targetRow][mid] < target){
                left = mid+1;
            }
            else{
                right = mid - 1;
            }
        }

        return false;
    }    
}
