package tictactoegame;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] ticTacToeBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        showBoard(ticTacToeBoard);
    }
    public static void showBoard(char [][] ticTacToeBoard){
        for(char[] row : ticTacToeBoard){
            for(char column : row){
                System.out.print(column);
            }
            System.out.println();
        }
    }
}
