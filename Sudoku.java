import java.io.*;
import java.util.*;

public class Sudoku{
    static int[][] localBoard = new int[9][9];
    public static void main(String[] args) {
        //readGame(loadGame(6));
        loadGame(6);
        drawBoard();
        printHelp();
        }
        public static void drawBoard(){
            System.out.println("Sudoku - Rainard Human");
            for(int x = 0; x<=8 ; x++){
                if ( x == 0 ||x == 3 || x == 6)
                System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
                System.out.println("▓|" + localBoard[x][0] + "|" + localBoard[x][1] + "|" + localBoard[x][2] + "|▓|" + localBoard[x][3] + "|" + localBoard[x][4] + "|" + localBoard[x][5] + "|▓|" + localBoard[x][6] + "|" + localBoard[x][7] + "|" + localBoard[x][8] + "|▓");
            }
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        }

        public static void loadGame(int gameNum) {
            int matchGame = 0;
            String game = "";
            File folder = new File("Games\\sudokus");
            File[] files = folder.listFiles();
            for (File file : files)
            {
               // matchGame++;
                //if(gameNum == matchGame)
                System.out.println(file.getName());
            }
           // return  new File("Games/sudokus/" + game); 
        }

        public static void readGame(File file){
            String[] parts;
            int line = 0;
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            String st; 
            while ((st = br.readLine()) != null){
                parts[line] = string.split(" ");
                line++;
            }
        }

        public static void printHelp(){
            
            final String ANSI_RESET  = "\u001B[0m";

            final String ANSI_BLACK  = "\u001B[30m";
            final String ANSI_RED    = "\u001B[31m";
            final String ANSI_GREEN  = "\u001B[32m";
            final String ANSI_YELLOW = "\u001B[33m";
            final String ANSI_BLUE   = "\u001B[34m";
            final String ANSI_PURPLE = "\u001B[35m";
            final String ANSI_CYAN   = "\u001B[36m";
            final String ANSI_WHITE  = "\u001B[37m";
            
            System.out.println(ANSI_RED +
                "\nThe Rules of Sudoku" +
                ANSI_YELLOW +
                "\n\nThe classic Sudoku game involves a grid of 81 squares. The grid is divided into nine blocks, each containing nine squares." +
                "\nThe rules of the game are simple: each of the nine blocks has to contain all the numbers 1-9 within its squares. Each number can only appear once in a row, column or box." + 
                "\nThe difficulty lies in that each vertical nine-square column, or horizontal nine-square line across, within the larger square, must also contain the numbers 1-9, without repetition or omission." +
                "\nEvery puzzle has just one correct solution.\n" +
                ANSI_GREEN +
                "\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+
                "\n▓|8|3|2|▓|4|5|6|▓|7|9|1|▓"+
                "\n▓|9|5|7|▓|1|8|2|▓|4|6|3|▓"+
                "\n▓|4|1|6|▓|9|7|3|▓|2|5|8|▓"+
                "\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+
                "\n▓|6|7|9|▓|5|4|1|▓|8|3|2|▓"+
                "\n▓|5|2|3|▓|7|6|8|▓|1|4|9|▓"+
                "\n▓|1|8|4|▓|3|2|9|▓|5|7|9|▓"+
                "\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+
                "\n▓|7|6|1|▓|8|3|4|▓|9|2|5|▓"+
                "\n▓|2|9|5|▓|6|1|7|▓|3|8|4|▓"+
                "\n▓|3|4|8|▓|2|9|5|▓|6|1|7|▓"+
                "\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"
                
            );
        }

}
