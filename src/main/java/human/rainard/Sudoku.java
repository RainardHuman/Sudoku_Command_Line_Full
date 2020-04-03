import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Sudoku{
    static int[][] localBoard = new int[9][9];
    static int[][] localBoardSolution = new int[9][9];
    static int localBoardNum = 0, hints = 0, moves = 0;;
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("Sudoku - Rainard Human");
        String[] input = {"","",""};
        
        String move = "";
        Scanner scanner = new Scanner(System.in);
        
        localBoardNum = random.nextInt(46);
        Pattern p = Pattern.compile("^[A-I],[1-9],[1-9]$");
        readGame(loadGame(localBoardNum));
        readSolution();
        drawBoard();
        
        
        while(move != "exit"){
        System.out.println("Input:");
        move = scanner.next();
        Matcher matcher = p.matcher(move);
    
        
    
        input = move.split(",");

            if (move.equals("exit") || move.equals("new") || move.equals("hint") || move.equals("help")){
                switch (move) {
                    case "exit": System.exit(1);
                    break;
                    case "new": localBoardNum = random.nextInt(46); readGame(loadGame(localBoardNum)); moves = 0;
                    break;
                    case "help": printHelp();
                    break;
                    case "hint": hints++; randomHint();
                    break;
                    default:
                    break;
                }
            }

            if(matcher.matches()){

                if(testInput(input)){
                    moves++;
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

                    if(moves > 40)
                    if (testWin()){
                        drawBoard();
                        System.out.println("\nCongratulations, well done!\n\n");
                        System.exit(1);
                    }

                }
            }
            
              drawBoard();
              System.out.println(localBoardNum);
    
                System.out.println("Error: Incorrect input, please read manual.");

    }
        scanner.close();
    }
        public static boolean testWin(){
            
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(localBoard[i][j] == 0 || localBoard[i][j] != localBoardSolution[i][j]) 
                    return false;
                }
            }
            
        return true;
        }

        public static boolean testInput(String[] input){
            int x = 0;
            switch(input[0]) {
                case "A": x = 0;
                break;
                case "B": x = 1;
                break;
                case "C": x = 2;
                break;
                case "D": x = 3;
                break;
                case "E": x = 4;
                break;
                case "F": x = 5;
                break;
                case "G": x = 6;
                break;
                case "H": x = 7;
                break;
                case "I": x = 8;
                break;
              } 
              int[] inputI = {x,Integer.parseInt(input[1])-1,Integer.parseInt(input[2])}; 
              //test lines 
              for (int i = 0; i < 9; i++) {
                  if(inputI[2] == localBoard[inputI[0]][i]){
                  System.out.println("Cant insert, dubble in row");
                  return false;
                  }
                  if(inputI[2] == localBoard[i][inputI[1]]){
                  System.out.println("Cant insert, dubble in colum");
                  return false;
                  }
              }
              return true;
            
        }
        public static void drawBoard(){
            char[] alpha = {'A','B','C','D','E','F','G','H','I'};
            System.out.println("\nMoves: " + moves);
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
            File folder = new File("Games/sudokus");
            File[] files = folder.listFiles();
            for (File file : files)
            {
                matchGame++;
                if(gameNum == matchGame)
                game = file.getName();
            }
            return  new File("Games/sudokus/" + game); 
        }

        public static void readGame(File file){
            String[] parts;
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

        public static void readSolution(){
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
                 
                for (int line = 0; line < 9; line++) {
                    
                    st = br.readLine();
                    
                    if(line == 3 || line == 6 ){
                    st = br.readLine();
                    }

                    substr = st.substring(0, 21);
                    st = substr.replaceAll("\\|", "");
                    substr = st.replaceAll("\\s", "");
                    parts = substr.split("");
                    
                        if(st != null)
                            for (int i = 0; i < 9; i++) {
                                localBoardSolution[line][i] = Integer.parseInt(parts[i]);
                            }                 

                
                }
                br.close();
                
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }


        }

        public static void randomHint(){
            if(hints <= 3){
            moves++;
            int x , y;
            x = random.nextInt(9);
            y = random.nextInt(9);
            
            while(localBoard[x][y] != 0){
            x = random.nextInt(9);
            y = random.nextInt(9);               
            }

            localBoard[x][y] = localBoardSolution[x][y];
            System.out.println("" + (3-hints) + " Hints are left!");
            }
            else{
                System.out.println("No more hints left!");
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
            
            System.out.println(
                "\nThe Rules of Sudoku" +
                
                "\n\nThe classic Sudoku game involves a grid of 81 squares. The grid is divided into nine blocks, each containing nine squares." +
                "\nThe rules of the game are simple: each of the nine blocks has to contain all the numbers 1-9 within its squares. Each number can only appear once in a row, column or box." + 
                "\nThe difficulty lies in that each vertical nine-square column, or horizontal nine-square line across, within the larger square, must also contain the numbers 1-9, without repetition or omission." +
                "\nEvery puzzle has just one correct solution.\n" +
                
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
                "\n  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"
                
                
            );
        }

}
