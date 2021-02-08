package HomeWork14;

import java.io.*;
import java.util.Scanner;

public class RPSGame {
    private static RPSEnum[] rpsPlayerEnum;
    private static RPSEnum[] rpsPcEnum;
    private static String playerName;
    private static int gameCount;
    private static int currentGameCount = 0;
    public static String result = "=========================================" + "\n";

    public RPSGame() {

    }

    public static void gameStart() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите своё имя : ");
        playerName = in.nextLine();
        System.out.println("Введите сколько раз вы хотите ссыграть : ");
        gameCount = in.nextInt();
        System.out.println("Да начнётся игра...");
        rpsPlayerEnum = new RPSEnum[gameCount];
        rpsPcEnum = new RPSEnum[gameCount];
        while (currentGameCount < gameCount) {
            condition();
        }
    }

    public static void condition() throws IOException {
        System.out.println("Напишите, что вы хотите поставить: ножницы, бумага, камень");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        switch (str.toLowerCase()) {
            case "ножницы":
                rpsPlayerEnum[currentGameCount] = RPSEnum.SCISSORS;
                break;
            case "камень":
                rpsPlayerEnum[currentGameCount] = RPSEnum.ROCK;
                break;
            case "бумага":
                rpsPlayerEnum[currentGameCount] = RPSEnum.PAPER;
                break;
            default:
                System.out.println("Вы ввели название с ошибкой...");
                return;
        }
        whoWins();
    }

    public static void whoWins() throws IOException {
        String currGameRes = "";
        switch ((int) (Math.random() * 3)) {
            case 0:
                rpsPcEnum[currentGameCount] = RPSEnum.SCISSORS;
                break;
            case 1:
                rpsPcEnum[currentGameCount] = RPSEnum.ROCK;
                break;
            case 2:
                rpsPcEnum[currentGameCount] = RPSEnum.PAPER;
                break;
            default:
        }
        if (rpsPlayerEnum[currentGameCount] == rpsPcEnum[currentGameCount]) {
            System.out.println("У вас ничья, продолжайте выбор : ножницы, бумага, камень");
            condition();
            return;
        }
        if (rpsPlayerEnum[currentGameCount] == RPSEnum.ROCK && rpsPcEnum[currentGameCount] == RPSEnum.SCISSORS) {
            currGameRes += "Игрок: " + playerName + " выиграл!" + "\n" +
                    "Выбор игрока :" + rpsPlayerEnum[currentGameCount] + "\n" +
                    "Выбор компьютера :" + rpsPcEnum[currentGameCount] + "\n";
        }
        if (rpsPlayerEnum[currentGameCount] == RPSEnum.ROCK && rpsPcEnum[currentGameCount] == RPSEnum.PAPER) {
            currGameRes += "Компьютер выиграл!" + "\n" +
                    "Выбор игрока :" + rpsPlayerEnum[currentGameCount] + "\n" +
                    "Выбор компьютера :" + rpsPcEnum[currentGameCount] + "\n";
        }
        if (rpsPlayerEnum[currentGameCount] == RPSEnum.PAPER && rpsPcEnum[currentGameCount] == RPSEnum.ROCK) {
            currGameRes += "Игрок: " + playerName + " выиграл!" + "\n" +
                    "Выбор игрока :" + rpsPlayerEnum[currentGameCount] + "\n" +
                    "Выбор компьютера :" + rpsPcEnum[currentGameCount] + "\n";
        }
        if (rpsPlayerEnum[currentGameCount] == RPSEnum.PAPER && rpsPcEnum[currentGameCount] == RPSEnum.SCISSORS) {
            currGameRes += "Компьютер выиграл!" + "\n" +
                    "Выбор игрока :" + rpsPlayerEnum[currentGameCount] + "\n" +
                    "Выбор компьютера :" + rpsPcEnum[currentGameCount] + "\n";
        }
        if (rpsPlayerEnum[currentGameCount] == RPSEnum.SCISSORS && rpsPcEnum[currentGameCount] == RPSEnum.PAPER) {
            currGameRes += "Игрок: " + playerName + " выиграл!" + "\n" +
                    "Выбор игрока :" + rpsPlayerEnum[currentGameCount] + "\n" +
                    "Выбор компьютера :" + rpsPcEnum[currentGameCount] + "\n";
        }
        if (rpsPlayerEnum[currentGameCount] == RPSEnum.SCISSORS && rpsPcEnum[currentGameCount] == RPSEnum.ROCK) {
            currGameRes += "Компьютер выиграл!" + "\n" +
                    "Выбор игрока :" + rpsPlayerEnum[currentGameCount] + "\n" +
                    "Выбор компьютера :" + rpsPcEnum[currentGameCount] + "\n";
        }
        result += currGameRes;
        result += "=========================================" + "\n";
        currentGameCount++;
        System.out.println(currGameRes);
        if (currentGameCount == gameCount) {
            saveRes();
        }
        if (currentGameCount < gameCount) {
            if (!endGame())
                System.exit(1);
        }
    }

    public static boolean endGame() throws IOException {
        System.out.println("Хотите ли вы продолжить игру: да, нет ?");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        switch (str.toLowerCase()) {
            case "да":
                return true;
            case "нет":
                saveRes();
                return false;
            default:
                System.out.println("Вы написали неверно");
                endGame();
                return true;
        }
    }


    public static void saveRes() throws IOException {
        File file = new File("C:/Users/bully/IdeaProjects/HillelHomeworks/src/HomeWork14/savings.txt");
        if (file.exists()) {
            try (FileWriter save = new FileWriter(file, true)) {
                save.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            FileWriter save = new FileWriter(file);
            save.write(result);
            save.close();
            System.out.println("dog");
        }

    }

}

