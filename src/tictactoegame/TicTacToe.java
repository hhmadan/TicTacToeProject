package tictactoegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {

    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> computerPos = new ArrayList<>();
    static char side;
    static int blockPosition;
    static int computerChoice;
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        startGame();
        secondGame();
    }
        public static void startGame(){
            char[][] ticTacToeBoard = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            showBoard(ticTacToeBoard);
            int turnResult=whoseTurn();
        if(turnResult==1){
            for(int i=1;i<=ticTacToeBoard.length;i++){
                System.out.println("Enter Position between 1-9 ");
                int playerChoice = sc.nextInt();

                while (playerPos.contains(playerChoice) || computerPos.contains(playerChoice)) {
                    System.out.println("Position is taken..! Please Enter free cell position");
                    playerChoice = sc.nextInt();
                }
                getMovesPlayer(side, playerChoice, ticTacToeBoard);
                String status=checkStatus();
                if(status.length()>0){
                    System.out.println(status);
                    secondGame();
                    break;
                }
                //Displaying current Game Board Position
                System.out.println("Current Game Board Position");
                showBoard(ticTacToeBoard);
                System.out.println("\n");

                Random rd = new Random();
                int computerChoice = rd.nextInt(9) + 1;
                while (playerPos.contains(computerChoice) || computerPos.contains(computerChoice)) {
                    //System.out.println("Position is taken..! Please Enter free cell position");
                    computerChoice = rd.nextInt(9) + 1;
                }
                getMovesComputer(side, ticTacToeBoard);

                //Displaying current Game Board Position
                System.out.println("Current Game Board Position");
                showBoard(ticTacToeBoard);
                System.out.println("\n");
                status=checkStatus();
                if(status.length()>0){
                    System.out.println(status);
                    secondGame();
                    break;
                }
            }
        }
        else{
            for(int i=1;i<=ticTacToeBoard.length;i++){
                Random rd = new Random();
                int computerChoice = rd.nextInt(9) + 1;
                while (playerPos.contains(computerChoice) || computerPos.contains(computerChoice)) {
                    computerChoice = rd.nextInt(9) + 1;
                }
                getMovesComputer(side, ticTacToeBoard);

                //Displaying current Game Board Position
                System.out.println("Current Game Board Position");
                showBoard(ticTacToeBoard);
                System.out.println("\n");
                String status=checkStatus();
                if(status.length()>0){
                    System.out.println(status);
                    secondGame();
                    break;
                }
                System.out.println("Enter Position between 1-9 ");
                int playerChoice = sc.nextInt();

                while (playerPos.contains(playerChoice) || computerPos.contains(playerChoice)) {
                    System.out.println("Position is taken..! Please Enter free cell position");
                    playerChoice = sc.nextInt();
                }
                side='O';
                getMovesPlayer(side, playerChoice, ticTacToeBoard);
                status=checkStatus();
                if(status.length()>0){
                    System.out.println(status);
                    secondGame();
                    break;
                }
                //Displaying current Game Board Position
                System.out.println("Current Game Board Position");
                showBoard(ticTacToeBoard);
                System.out.println("\n");
            }
        }
    }

    public static void showBoard ( char[][] ticTacToeBoard){
        for (char[] row : ticTacToeBoard) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    public static int whoseTurn(){
        Random random = new Random();
        int x = random.nextInt(2)+1;
        if (x==1){
            System.out.println("Its You to Play First..!");
            System.out.println("What you want==> X or O? Enter..");
            side = sc.next().charAt(0);
        }
        else
            System.out.println("Its Computer to Play First..!");
        return x;
    }
    public static void getMovesPlayer ( char letter, int playerChoice, char[][] ticTacToeBoard){
        playerPos.add(playerChoice);
        switch (playerChoice) {
            case 1:
                ticTacToeBoard[0][0] = letter;
                break;
            case 2:
                ticTacToeBoard[0][2] = letter;
                break;
            case 3:
                ticTacToeBoard[0][4] = letter;
                break;
            case 4:
                ticTacToeBoard[2][0] = letter;
                break;
            case 5:
                ticTacToeBoard[2][2] = letter;
                break;
            case 6:
                ticTacToeBoard[2][4] = letter;
                break;
            case 7:
                ticTacToeBoard[4][0] = letter;
                break;
            case 8:
                ticTacToeBoard[4][2] = letter;
                break;
            case 9:
                ticTacToeBoard[4][4] = letter;
                break;
            default:
                break;
        }
    }
    public static void getMovesComputer ( char letter, char[][] ticTacToeBoard) {
        char side = ' ';
        if (letter == 'X' || letter == 'x')
            side = 'O';
        else
            side = 'X';

        int winPosCompResult = normalWinPositionOfComputer(ticTacToeBoard,side);
        if(winPosCompResult>0){
            computerChoice = winPosCompResult;
            computerPos.add(computerChoice);
        }
        int blockMove = blockPlayer(ticTacToeBoard,letter,side);
        if(blockMove>0){
            computerChoice = blockPosition;
        }
        else{
            Random rd = new Random();
            computerChoice = rd.nextInt(9)+1;
            switch (computerChoice) {
                case 1:
                    ticTacToeBoard[0][0] = side;
                    break;
                case 2:
                    ticTacToeBoard[0][2] = side;
                    break;
                case 3:
                    ticTacToeBoard[0][4] = side;
                    break;
                case 4:
                    ticTacToeBoard[2][0] = side;
                    break;
                case 5:
                    ticTacToeBoard[2][2] = side;
                    break;
                case 6:
                    ticTacToeBoard[2][4] = side;
                    break;
                case 7:
                    ticTacToeBoard[4][0] = side;
                    break;
                case 8:
                    ticTacToeBoard[4][2] = side;
                    break;
                case 9:
                    ticTacToeBoard[4][4] = side;
                    break;
                default:
                    break;
            }
        }
        computerPos.add(computerChoice);
    }
    public static int normalWinPositionOfComputer(char[][]ticTacToeBoard, char side){
        int winPosOfComp;
        if ((ticTacToeBoard[0][2] == side && ticTacToeBoard[0][4] == side && ticTacToeBoard[0][0] == ' ') || (ticTacToeBoard[2][0] == side && ticTacToeBoard[4][0] == side && ticTacToeBoard[0][0] == ' ') || (ticTacToeBoard[2][2] == side && ticTacToeBoard[4][4] == side && ticTacToeBoard[0][0] == ' '))
        {
            ticTacToeBoard[0][0]=side;
            winPosOfComp = 1;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[0][0] == side && ticTacToeBoard[0][4] == side && ticTacToeBoard[0][2] == ' ') || (ticTacToeBoard[2][2] == side && ticTacToeBoard[4][2] == side && ticTacToeBoard[0][2] == ' '))
        {
            ticTacToeBoard[0][2] = side;
            winPosOfComp = 2;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[0][0] == side && ticTacToeBoard[0][2] == side && ticTacToeBoard[0][4] == ' ') || (ticTacToeBoard[4][0] == side && ticTacToeBoard[2][2] == side && ticTacToeBoard[0][4] == ' ') || (ticTacToeBoard[2][4] == side && ticTacToeBoard[4][4] == side && ticTacToeBoard[0][4] == ' '))
        {
            ticTacToeBoard[0][4] = side;
            winPosOfComp = 3;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[0][0] == side && ticTacToeBoard[4][0] == side && ticTacToeBoard[2][0] == ' ') || (ticTacToeBoard[2][2] == side && ticTacToeBoard[2][4] == side && ticTacToeBoard[2][0] == ' '))
        {
            ticTacToeBoard[2][0] = side;
            winPosOfComp = 4;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[0][2] == side && ticTacToeBoard[4][2] == side && ticTacToeBoard[2][2] == ' ') || (ticTacToeBoard[2][0] == side && ticTacToeBoard[2][4] == side && ticTacToeBoard[2][2] == ' ')
                || (ticTacToeBoard[0][0] == side && ticTacToeBoard[4][4]== side && ticTacToeBoard[2][2] == ' ') || (ticTacToeBoard[4][0] == side && ticTacToeBoard[0][4] == side && ticTacToeBoard[2][2] == ' '))
        {
            ticTacToeBoard[2][2] = side;
            winPosOfComp = 5;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[0][4] == side && ticTacToeBoard[4][4] == side && ticTacToeBoard[2][4] == ' ') || (ticTacToeBoard[2][0] == side && ticTacToeBoard[2][2] == side && ticTacToeBoard[2][4] == ' '))
        {
            winPosOfComp = 6;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[0][0] == side && ticTacToeBoard[2][0] == side && ticTacToeBoard[4][0] == ' ') || (ticTacToeBoard[4][2] == side && ticTacToeBoard[4][4] == side && ticTacToeBoard[4][0] == ' ') || (ticTacToeBoard[2][2] == side && ticTacToeBoard[0][4] == side && ticTacToeBoard[4][0] == ' '))
        {
            ticTacToeBoard[4][0] = side;
            winPosOfComp = 7;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[4][0] == side && ticTacToeBoard[4][4] == side && ticTacToeBoard[4][2] == ' ') || (ticTacToeBoard[0][2] == side && ticTacToeBoard[2][2] == side && ticTacToeBoard[4][2] == ' '))
        {
            ticTacToeBoard[4][2] =side;
            winPosOfComp = 8;
            return winPosOfComp;
        }
        else if ((ticTacToeBoard[0][0] == side && ticTacToeBoard[2][2] == side && ticTacToeBoard[4][4] == ' ') || (ticTacToeBoard[4][0] == side && ticTacToeBoard[4][2] == side && ticTacToeBoard[4][4] == ' ') || (ticTacToeBoard[2][4] == side && ticTacToeBoard[0][4] == side && ticTacToeBoard[4][4] == ' '))
        {
            ticTacToeBoard[4][4] =side;
            winPosOfComp = 9;
            return winPosOfComp;
        }
        return 0;
    }
    public static int blockPlayer(char[][]ticTacToeBoard, char letter, char side){
        if ((ticTacToeBoard[0][2] == letter && ticTacToeBoard[0][4] == letter && ticTacToeBoard[0][0] == ' ') || (ticTacToeBoard[2][0] == letter && ticTacToeBoard[4][0] == letter && ticTacToeBoard[0][0] == ' ') || (ticTacToeBoard[2][2] == letter && ticTacToeBoard[4][4] == letter && ticTacToeBoard[0][0] == ' '))
        {
            ticTacToeBoard[0][0]=side;
            blockPosition = 1;
            return blockPosition;
        }
        else if ((ticTacToeBoard[0][0] == letter && ticTacToeBoard[0][4] == letter && ticTacToeBoard[0][2] == ' ') || (ticTacToeBoard[2][2] == letter && ticTacToeBoard[4][2] == letter && ticTacToeBoard[0][2] == ' '))
        {
            ticTacToeBoard[0][2] = side;
            blockPosition = 2;
            return blockPosition;
        }
        else if ((ticTacToeBoard[0][0] == letter && ticTacToeBoard[0][2] == letter && ticTacToeBoard[0][4] == ' ') || (ticTacToeBoard[4][0] == letter && ticTacToeBoard[2][2] == letter && ticTacToeBoard[0][4] == ' ') || (ticTacToeBoard[2][4] == letter && ticTacToeBoard[4][4] == letter && ticTacToeBoard[0][4] == ' '))
        {
            ticTacToeBoard[0][4] = side;
            blockPosition = 3;
            return blockPosition;
        }
        else if ((ticTacToeBoard[0][0] == letter && ticTacToeBoard[4][0] == letter && ticTacToeBoard[2][0] == ' ') || (ticTacToeBoard[2][2] == letter && ticTacToeBoard[2][4] == letter && ticTacToeBoard[2][0] == ' '))
        {
            ticTacToeBoard[2][0] = side;
            blockPosition = 4;
            return blockPosition;
        }
        else if ((ticTacToeBoard[0][2] == letter && ticTacToeBoard[4][2] == letter && ticTacToeBoard[2][2] == ' ') || (ticTacToeBoard[2][0] == letter && ticTacToeBoard[2][4] == letter && ticTacToeBoard[2][2] == ' ')
                || (ticTacToeBoard[0][0] == letter && ticTacToeBoard[4][4]== letter && ticTacToeBoard[2][2] == ' ') || (ticTacToeBoard[4][0] == letter && ticTacToeBoard[0][4] == letter && ticTacToeBoard[2][2] == ' '))
        {
            ticTacToeBoard[2][2] = side;
            blockPosition = 5;
            return blockPosition;
        }
        else if ((ticTacToeBoard[0][4] == letter && ticTacToeBoard[4][4] == letter && ticTacToeBoard[2][4] == ' ') || (ticTacToeBoard[2][0] == letter && ticTacToeBoard[2][2] == letter && ticTacToeBoard[2][4] == ' '))
        {
            blockPosition = 6;
            return blockPosition;
        }
        else if ((ticTacToeBoard[0][0] == letter && ticTacToeBoard[2][0] == letter && ticTacToeBoard[4][0] == ' ') || (ticTacToeBoard[4][2] == letter && ticTacToeBoard[4][4] == letter && ticTacToeBoard[4][0] == ' ') || (ticTacToeBoard[2][2] == letter && ticTacToeBoard[0][4] == letter && ticTacToeBoard[4][0] == ' '))
        {
            ticTacToeBoard[4][0] = side;
            blockPosition = 7;
            return blockPosition;
        }
        else if ((ticTacToeBoard[4][0] == letter && ticTacToeBoard[4][4] == letter && ticTacToeBoard[4][2] == ' ') || (ticTacToeBoard[0][2] == letter && ticTacToeBoard[2][2] == letter && ticTacToeBoard[4][2] == ' '))
        {
            ticTacToeBoard[4][2] =side;
            blockPosition = 8;
            return blockPosition;
        }
        else if ((ticTacToeBoard[0][0] == letter && ticTacToeBoard[2][2] == letter && ticTacToeBoard[4][4] == ' ') || (ticTacToeBoard[4][0] == letter && ticTacToeBoard[4][2] == letter && ticTacToeBoard[4][4] == ' ') || (ticTacToeBoard[2][4] == letter && ticTacToeBoard[0][4] == letter && ticTacToeBoard[4][4] == ' '))
        {
            ticTacToeBoard[4][4] =side;
            blockPosition = 9;
            return blockPosition;
        }
        return 0;
    }
    public static String checkStatus(){
        List firstRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List lastRow = Arrays.asList(7, 8, 9);
        List firstCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List lastCol = Arrays.asList(3, 6, 9);
        List diagonal1 = Arrays.asList(1, 5, 9);
        List diagonal2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(firstRow);
        winning.add(midRow);
        winning.add(lastRow);
        winning.add(firstCol);
        winning.add(midCol);
        winning.add(lastCol);
        winning.add(diagonal1);
        winning.add(diagonal2);

        for(List list : winning) {
            if (playerPos.containsAll(list)) {
                return "CONGRATULATIONS..! YOU WON";
            } else if (computerPos.containsAll(list)) {
                return "COMPUTER WON..!";
            } else if (computerPos.size()+playerPos.size()==9) {
                return "ITS A TIE..!";
            }
        }
        return "";
    }
    public static void secondGame(){
        System.out.println("You Want to Play Again..? Press Y for Yes or N for No");
        char playAgainChoice = sc.next().charAt(0);
        while (true){
        if(playAgainChoice == 'Y' || playAgainChoice =='y'){
            startGame();
            secondGame();
            break;
        }
        else if(playAgainChoice == 'N' || playAgainChoice =='n'){
            System.exit(0);
        }
    }
}}


