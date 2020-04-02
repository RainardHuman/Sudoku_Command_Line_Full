public class Sudoku{
    public static void main(String[] args) {

        int[][] board = new int[9][9];

        for(int x = 0; x<=8 ; x++){
            for(int y = 0; y<=8 ; y++){
                board[x][y] = 6;
            }
        }

        drawBoard(board);
        }
        public static void drawBoard(int[][] board){
            int[][] num = board;
            System.out.println("Sudoku - Rainard Human");
            for(int x = 0; x<=8 ; x++){
                if ( x == 0 ||x == 3 || x == 6)
                System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
                System.out.println("▓|" + num[x][0] + "|" + num[x][1] + "|" + num[x][2] + "|▓|" + num[x][3] + "|" + num[x][4] + "|" + num[x][5] + "|▓|" + num[x][6] + "|" + num[x][7] + "|" + num[x][8] + "|▓");
            }
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        }
}
