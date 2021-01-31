class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        
        //Step1-Crush: If there are 3 or more horizontal or vertical candies then we mark then by doing -
        //Step2- Gravity: We start from the bottom of every column. If a grid is -ve then we put candies above it down.
        
        int R = board.length;
        int C = board[0].length;
        
        boolean todo = false;
        
        //We will check whether there are 3 or more candies in each row
        for(int r = 0; r < R; r++){
            
            for(int c = 0; c < C - 2; c++){
                
                //We use abs cuz the number might be -ve because it was marked -ve by us
                int v = Math.abs(board[r][c]);
                
                //If the number is equal to neighboring 2 grids to right
                if(v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])){
                    
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
                    todo = true;
                }
            }
        }
        
        //We will check whether there are 3 or more candies in each column
        for(int r = 0; r < R - 2; r++){
            
            for(int c = 0; c < C; c++){
                
                int v = Math.abs(board[r][c]);
                
                //If the number is equal to neighboring 2 grids to bottom
                if(v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])){
                    
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
                    todo = true;
                }
            }
        }
        
        //We will replace all the negative grids with the one above it
        for(int c = 0; c < C; c++){
            
            //Points to bottom of row
            int wr = R - 1;
            
            //We will start from bottom and move upwards
            for(int r = R - 1; r >= 0; r--){
                
                //If any grid is negative that means it has to be removed
                if(board[r][c] > 0){
                    
                    //We will put the grid elements in its correct position
                    board[wr--][c] = board[r][c];
                }   
            }
            
            //If wr has not reached the top ie first row that means all the elements from wr to 0 has been put down.
            while(wr >= 0){
                
                //We have to make it empty
                board[wr--][c] = 0;
            }
        }
        
        return todo ? candyCrush(board) : board;
        
    }
}
