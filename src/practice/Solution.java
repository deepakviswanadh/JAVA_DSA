package practice;

class Solution {
    public void solve(char[][] board) {
        //capture unsurrounded O to T
        //capture surrounded O to X
        //uncapture surrounded T to O

        capture1(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    public void capture1(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; i++) {
                if (board[i][j] == 'O' && (i == 0 || i == board.length - 1) || (
                        j == 0 || j == board[0].length - 1
                )) {
                    transfer(i, j, board);
                }
            }
        }
    }

    public void transfer(int i, int j, char[][] board) {
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        transfer(i - 1, j, board);
        transfer(i + 1, j, board);
        transfer(i, j - 1, board);
        transfer(i, j + 1, board);
    }
}