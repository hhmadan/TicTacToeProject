package tictactoegame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class TicTacToe {
    static int x;
    static char letter;
    final static Scanner sc = new Scanner(System.in);
    static int computerChoiceMove;
    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> computerPos = new ArrayList<>();

    public static void main(String[] args) {
        char[][] ticTacToeBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        int turnResult=whoseTurn();

        while(true){
            if(turnResult==1){              //Player's Turn
                System.out.println("Its Your Turn..! Enter position to mark: ");
                int playerChoice = sc.nextInt();
                while (playerPos.contains(playerChoice) || computerPos.contains(playerChoice)){
                    System.out.println("Position is Taken..! Enter free Cell");
                    playerChoice = sc.nextInt();
                }
                playerMoves(playerChoice, letter,ticTacToeBoard);
                //CHECK WIN TIE OR CHANGE TURN...

                System.out.println("Current Positions of Game Board is...");
                showBoard(ticTacToeBoard);
                System.out.println("\n");

                System.out.println("COMPUTER PLAYING.....");              //Computer's Turn
                getComputerMoves(letter,ticTacToeBoard);
            while (playerPos.contains(computerChoiceMove) || computerPos.contains(computerChoiceMove)){
                getComputerMoves(letter,ticTacToeBoard);
            }
                System.out.println("Current Positions of Game Board is...");
                showBoard(ticTacToeBoard);
            }
            else{
                System.out.println("COMPUTER PLAYING...");          //Computer's Turn
                getComputerMoves(letter,ticTacToeBoard);

                while (playerPos.contains(computerChoiceMove) || computerPos.contains(computerChoiceMove)){
                    getComputerMoves(letter,ticTacToeBoard);
                }
                System.out.println("Current Positions of Game Board is");
                showBoard(ticTacToeBoard);

                System.out.println("Its Your Turn..! Enter position to mark: ");
                int playerChoice = sc.nextInt();
                letter = 'O';
                while (playerPos.contains(playerChoice) || computerPos.contains(playerChoice)){
                    System.out.println("Position is Taken..! Enter free Cell");
                    playerChoice = sc.nextInt();
                }
                playerMoves(playerChoice, letter,ticTacToeBoard);
            }
            System.out.println("Current Positions of Game Board is...");
            showBoard(ticTacToeBoard);
        }
    }
    public static void showBoard (char[][] ticTacToeBoard){
        for (char[] row : ticTacToeBoard) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    public static int whoseTurn(){
        Random random = new Random();
        x = random.nextInt(2)+1;
        if (x==1){
            System.out.println("Its You to Play First..!");
            System.out.println("What you want==> X or O? Enter..");
            letter = sc.next().charAt(0);
        }
        else
            System.out.println("Its Computer to Play First..!");
        return x;
    }
    public static void playerMoves(int playerChoice, char letter, char[][]ticTacToeBoard){
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
    public static void getComputerMoves(char letter, char[][]ticTacToeBoard){
        char side = ' ';
        if (letter == 'X' || letter == 'x')
            side = 'O';
        else
            side = 'X';

        Random rd = new Random();
        int ch = rd.nextInt(9)+1;
        switch (ch) {
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
