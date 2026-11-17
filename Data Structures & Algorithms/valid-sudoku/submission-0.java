class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean res = true;
        int switchFlag = 3;
        int initialFlag = 0;

        for(int i = 0; i < 9; i++){
            Set<Character> r = new HashSet<>();
            Set<Character> c = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] !='.' && !r.add(board[i][j])){return false;}
                if(board[j][i] !='.' && !c.add(board[j][i])){return false;}
            }
        }

        for (int rowStart = 0; rowStart < 9; rowStart += 3) {
            for (int colStart = 0; colStart < 9; colStart += 3) {

                Set<Character> nines = new HashSet<>();

                for (int i = rowStart; i < rowStart + 3; i++) {
                    for (int j = colStart; j < colStart + 3; j++) {
                        if (board[i][j] != '.' && !nines.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }


        return res; 
    }
}
