package ru.dolgov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Work3 {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random= new Random();
    public static int SIZE=3;
    public static int DOTS_TO_WIN=3;
    public static final char DOT_EMPTY = '-';
    public static final char DOT_X='X';
    public static final char DOT_O='0';
    public static char[][] map= new char[SIZE][SIZE];
    public static void main(String[] args) {
        initMap();
        printMap();
        humanTurn();
        pcTurman();
        printMap();
    }

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты X,Y для хода");
                x=scanner.nextInt()-1;
                y=scanner.nextInt()-1;
        }while (isCellValid(x, y));
        map[y][x]=DOT_X;
    }

    public static void pcTurman(){
        int x;
        int y;
        do {
            x= random.nextInt(SIZE);
            y=random.nextInt(SIZE);
        }while (isCellValid(x, y));
        System.out.println("Компьютер сходил"+(x+1)+" "+(y+1));
        map[y][x]=DOT_O;
    }

    public static boolean isCellValid(int x, int y){
        if (x<0||x>=SIZE||y<0||y>=SIZE){
            return false;
        }else return map[y][x] != DOT_EMPTY;
    }

    private static void printMap() {
        for (int i=0; i<=SIZE;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i=0;i<SIZE;i++){
            System.out.print((i+1)+" ");
            for (int j=0;j<SIZE;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void initMap() {
        for (char[] chars : map) {
            Arrays.fill(chars, DOT_EMPTY);
        }
    }
}
