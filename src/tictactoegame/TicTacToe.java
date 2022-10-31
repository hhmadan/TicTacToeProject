package tictactoegame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> computerPos = new ArrayList<>();
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] ticTacToeBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        showBoard(ticTacToeBoard);
        System.out.println("What you want==> X or O? Enter..");
        char letter = sc.next().charAt(0);

        for(int i=1;i<ticTacToeBoard.length;i++){
            System.out.println("Enter Position between 1-9 ");
            int playerChoice = sc.nextInt();

            while (playerPos.contains(playerChoice) || computerPos.contains(playerChoice)) {
                System.out.println("Position is taken..! Please Enter free cell position");
                playerChoice = sc.nextInt();
            }
            getMovesPlayer(letter, playerChoice, ticTacToeBoard);

            //Displaying current Game Board Position
            System.out.println("Current Game Board Position");
            showBoard(ticTacToeBoard);
            System.out.println("\n");

            Random rd = new Random();
            int computerChoice = rd.nextInt(9) + 1;
            while (playerPos.contains(computerChoice) || computerPos.contains(computerChoice)) {
                System.out.println("Position is taken..! Please Enter free cell position");
                computerChoice = rd.nextInt(9) + 1;
            }
            getMovesComputer(letter, computerChoice, ticTacToeBoard);

            //Displaying current Game Board Position
            System.out.println("Current Game Board Position");
            showBoard(ticTacToeBoard);
            System.out.println("\n");

            // isFull(ticTacToeBoard);
        }
        System.out.println("Game Board is Full..!");
    }

    public static void showBoard ( char[][] ticTacToeBoard){
        for (char[] row : ticTacToeBoard) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
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
    public static void getMovesComputer ( char letter, int computerChoice, char[][] ticTacToeBoard){
        computerPos.add(computerChoice);
        char side = ' ';
        if (letter == 'X' || letter == 'x')
            side = 'O';
        else
            side = 'X';
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
}
