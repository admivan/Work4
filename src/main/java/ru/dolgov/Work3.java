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
    public static int DOT_WIN = 3;

    public static void main(String[] args) {

        startGame();
    }

    private static void restarGame() {
        int i;
        System.out.println("Хотите начать сначала 0-нет выйти 1- да начать");
        i=scanner.nextInt();
        if(1==i){
            startGame();
        }
    }

    private static void startGame() {
         /*
        Запрос размера поля
        */
        System.out.println("Ведите размерность поля");
        SIZE = scanner.nextInt();
        /*
        Запрос количество фишек для победы
        на данный момент работает не коректно
        */
        System.out.println("Ведите количество фишек для победы");
        DOT_WIN = scanner.nextInt();
        initMap();// инцилизация поля
        printMap();// печать поля
        while (true) {
            humanPlayer();
            printMap();// печать поля
            if (checkWin(DOT_X)) { //проверка победы человека
                System.out.println("Победил человек");
                break;
            }
            if (mapFull()) {// проверка ничьей
                System.out.println("Ничья");
                break;
            }
            aiPlayer();
            printMap();// печать поля
            if (checkWin(DOT_O)) {//проверка пк
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (mapFull()) {// проверка ничьей
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
        restarGame();// перезапуск победы
    }

    /**
     * Проверка победы циклами
     * @param symb принимаем символ
     * @return возвращаем true and false
     */

    // TODO на большее головы не хватает походу глупенький(
    private static boolean checkWin(char symb) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j && map[i][j] == symb) {
                    counter++;
                }
            }
        }
        if (counter == SIZE) {
            return true;
        } else {
            counter = 0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == SIZE - 1 - i && map[i][j] == symb) {
                    counter++;
                }
            }
        }

        if (counter == SIZE) {
            return true;
        } else {
            counter = 0;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    counter++;

                }
            }
            if (counter == SIZE) {
                return true;
            } else {
                counter = 0;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    counter++;
                }
            }
            if (counter == SIZE) {
                return true;
            } else {
                counter = 0;
            }
        }
        return false;
    }


    /**
     * Проверяем есть ли место куда можно поставить символ
     * @return возвращаем true and false
     */
    public static boolean mapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMRTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * получаем x, y с консоли и ставим в эти кординаты X
     */
    public static void humanPlayer() {
        int x;
        int y;

        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y)&&!emtyCell(x,y));
        map[x][y] = DOT_X;
    }

    /**
     * Проверяем x,y в пределах поля или нет и стоит ли символ в данных кординатах
     * @param x принимем кординату x
     * @param y принимем кординату y
     * @return возвращаем true and false
     */
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return false;
    }

    public static boolean emtyCell(int x, int y){
        return map[x][y] == DOT_EMRTY;
    }

    /**
     * получаем x, y рандомно и ставим в эти кординаты X
     */
    public static void aiPlayer() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!emtyCell(x, y));
        map[x][y] = DOT_O;
    }

    /**
     * Печатаем поле
     */
    private static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {

            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Инцилизируем поле
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMRTY;
            }
        }
    }
}
