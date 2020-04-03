package human.rainard;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Sudoku {
    static int[][] localBoard = new int[9][9];
    static int[][] localBoardSolution = new int[9][9];
    static int localBoardNum = 0;

    public static void main(String[] args) {
        String[] input = {"","",""};
        
        String move = "";
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        localBoardNum = random.nextInt(46);
        Pattern p = Pattern.compile("^[A-I],[1-9],[1-9]$");
        readGame(loadGame(localBoardNum));
        System.out.println("Game Number: " + localBoardNum);
       // readSolution();
        drawBoard();
        //printHelp();
        
        while(move != "exit"){
        System.out.println("Input:");
        move = scanner.next();
        Matcher matcher = p.matcher(move);
    
        if(matcher.matches() || move.equals("exit") || move.equals("new")){
            input = move.split(",");
                switch (move) {
                    case "exit": System.exit(1);
                    break;
                    case "new": localBoardNum = random.nextInt(46); readGame(loadGame(localBoardNum)); System.out.println("LocalBoardNum:" + localBoardNum);
                    break;
                    default:
                    break;
                }
                switch(input[0]) {
                case "A": localBoard[0][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "B": localBoard[1][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "C": localBoard[2][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "D": localBoard[3][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "E": localBoard[4][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "F": localBoard[5][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "G": localBoard[6][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "H": localBoard[7][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
                case "I": localBoard[8][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
                break;
              } 
            
              drawBoard();
        
        }
        else
        System.out.println("Error: Incorrect input, please read manual.");
    }
        scanner.close();
    }
        public static void drawBoard(){
            char[] alpha = {'A','B','C','D','E','F','G','H','I'};
            System.out.println("Sudoku - Rainard Human");
            System.out.println("\n    1 2 3   4 5 6   7 8 9  ");
            for(int x = 0; x<=8 ; x++){
                if ( x == 0 ||x == 3 || x == 6)
                System.out.println("  █████████████████████████");
                System.out.println(
                    alpha[x] + 
                    " █|"  + (localBoard[x][0] == 0 ? " " : localBoard[x][0]) + 
                    "|"   + (localBoard[x][1] == 0 ? " " : localBoard[x][1]) + 
                    "|"   + (localBoard[x][2] == 0 ? " " : localBoard[x][2]) + 
                    "|█|" + (localBoard[x][3] == 0 ? " " : localBoard[x][3]) + 
                    "|"   + (localBoard[x][4] == 0 ? " " : localBoard[x][4]) + 
                    "|"   + (localBoard[x][5] == 0 ? " " : localBoard[x][5]) + 
                    "|█|" + (localBoard[x][6] == 0 ? " " : localBoard[x][6]) + 
                    "|"   + (localBoard[x][7] == 0 ? " " : localBoard[x][7]) + 
                    "|"   + (localBoard[x][8] == 0 ? " " : localBoard[x][8]) + 
                    "|█");
            }
            System.out.println("  █████████████████████████");
        }

        public static File loadGame(int gameNum) {
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
            return new File("Games/sudokus/" + game);
        }

        public static void readGame(File file){
            String[] parts;
            //int line = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(file)); 
                String st; 
                for (int line = 0; line < 9; line++) {
                    st = br.readLine();
                    parts = st.split(" ");
                    if(st != null)
                    for (int i = 0; i < 9; i++) {
                        localBoard[line][i] = Integer.parseInt(parts[i]);
                    }
                }
                br.close();
               
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            
            
        }

       /* public static void readSolution(){
            int matchGame = 0;
            String st, substr ,game = "";
            String[] parts;
            File folder = new File("Games/solutions");
            File[] files = folder.listFiles();


            for (File file : files)
            {
                matchGame++;
                if(localBoardNum == matchGame)
                game = file.getName();
            }
            
            try {
                BufferedReader br = new BufferedReader(new FileReader("Games/solutions/" + game)); 
                 
                for (int line = 0; line < 11; line++) {
                    st = br.readLine();
                    if(line != 4){
                        substr = st.substring(0, 21);
                        System.out.println("substr: " + substr);
                        st = substr.replaceAll("\\|", "");
                        System.out.println("st: " + st);
                        substr = st.replaceAll("\\s", "");
                        System.out.println("substr: " + substr);
                        parts = substr.split("");
                        System.out.println("part: " + parts[1]);

                        if(st != null)
                            for (int i = 0; i < 9; i++) {
                                localBoardSolution[line][i] = Integer.parseInt(parts[i]);
                            }
                    }
                
                }
                br.close();
                System.out.println("A1: " + localBoardSolution[1][1]);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }


        }*/
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
                "\n    1 2 3   4 5 6   7 8 9  "+
                "\n  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+
                "\nA ▓| | | |▓|4|5|6|▓|7|9|1|▓"+
                "\nB ▓|9|5|7|▓|1|8|2|▓|4|6|3|▓"+
                "\nC ▓|4|1|6|▓|9|7|3|▓|2|5|8|▓"+
                "\n  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+ 
                "\nD ▓|6|7|9|▓|5|4|1|▓|8|3|2|▓"+
                "\nE ▓|5|2|3|▓|7|6|8|▓|1|4|9|▓"+
                "\nF ▓|1|8|4|▓|3|2|9|▓|5|7|9|▓"+
                "\n  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+
                "\nG ▓|7|6|1|▓|8|3|4|▓|9|2|5|▓"+
                "\nH ▓|2|9|5|▓|6|1|7|▓|3|8|4|▓"+
                "\nI ▓|3|4|8|▓|2|9|5|▓|6|1|7|▓"+
                "\n  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+
                ANSI_RESET
                
            );
        }

}
