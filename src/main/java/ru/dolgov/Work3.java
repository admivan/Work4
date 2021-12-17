package ru.dolgov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Work3 {
    private static final char DOT_X = 'X';
    private static final char DOT_O = '0';
    public static char[][] map;
    public static int SIZE = 3;
    public static final char DOT_EMRTY = '-';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        humanPlayer();
        printMap();
        aiPlayer();
        printMap();
    }

    public static void humanPlayer () {
        int x;
        int y;

        do {
            x=scanner.nextInt()-1;
            y=scanner.nextInt()-1;
        }while (!isCellValid(x,y));
        map[x][y]=DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x<0||x>=SIZE||y<0||y>=SIZE){
            return false;
        }
        if(map[x][y]==DOT_EMRTY){
            return true;
        }
        return false;
    }

    public static void aiPlayer () {
        int x;
        int y;
        do {
            x= random.nextInt(SIZE);
            y= random.nextInt(SIZE);
        }while (!isCellValid(x,y));
        map[x][y]=DOT_O;
    }

    private static void printMap() {
        System.out.print("  ");
        for (int i = 1; i<=SIZE; i++){

            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMRTY;
            }
        }
    }
}
