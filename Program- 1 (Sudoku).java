1. Sudoku

Class SudokuPluzze {

public boolean checkValidity(int sudoku[][], int row, int column, int digit){

	// row has the unique (row-clash) 
        for (int d = 0; d < board.length; d++) {   // if the number we are trying to place is already present in that row, return false
            if (board[row][d] == num) { 
                return false; 
            } 
        } 

	 // column has the unique numbers (column-clash)
	 for (int r = 0; r < board.length; r++) {    // if the number we are trying to  place is already present in that column, return false
		if (board[r][col] == num) { 
                return false; 
            } 
        } 

	 // corresponding square has unique number (box-clash) 
	int sqrt = (int)Math.sqrt(sudoku.length); 
        int boxRowStart = row - row % sqrt; 
        int boxColStart = col - col % sqrt; 

	for (int r = boxRowStart; 
             r < boxRowStart + sqrt; r++) { 
            for (int d = boxColStart; 
                 d < boxColStart + sqrt; d++) { 
                if (board[r][d] == num) { 
                    return false; 
                } 
            } 
        } 
	// if there is no clash, it's safe 
        return true; 
    } 

public static boolean solveSudoku( 
        int[][] board, int n) 
    { 
        int row = -1; 
        int col = -1; 
        boolean isEmpty = true; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
                if (board[i][j] == 0) { 
                    row = i; 
                    col = j; 
                    isEmpty = false;  // missing values in Sudoku 
                    break; 
                } 
            } 
            if (!isEmpty) { 
                break; 
            } 
        } 
  
        // no empty space left 
        if (isEmpty) { 
            return true; 
        } 
  
        // else for each-row backtrack 
        for (int num = 1; num <= n; num++) { 
            if (isSafe(board, row, col, num)) { 
                board[row][col] = num; 
                if (solveSudoku(board, n)) { 
                    // print(board, n); 
                    return true; 
                } 
                else { 
                    // replace it 
                    board[row][col] = 0; 
                } 
            } 
        } 
        return false; 
    } 

public static void print( 
        int[][] board, int N) 
    { 
        
        for (int r = 0; r < N; r++) { 
            for (int d = 0; d < N; d++) { 
                System.out.print(board[r][d]); 
                System.out.print(" "); 
            } 
            System.out.print("\n"); 
  
            if ((r + 1) % (int)Math.sqrt(N) == 0) { 
                System.out.print(""); 
            } 
        } 
    } 
  

public static void main(String args[])
{
	int[][] sudoku = new int[][] { 
            { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
            { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
            { 0, 9, 8, 0, 0, 0, 0, 6, 0 }, 
            { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
            { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
            { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, 
            { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
            { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
            { 0, 0, 0, 0, 8, 0, 0, 7, 9 } 
        }; 
	 int N = sudoku.length; 
  
        if (solveSudoku(sudoku, N)) { 
            // print solution 
            print(board, N); 
        } 
        else { 
            System.out.println("No solution"); 
        } 

}
}