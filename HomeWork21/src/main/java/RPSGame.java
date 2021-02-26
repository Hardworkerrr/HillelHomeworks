import java.io.*;
import java.nio.file.FileSystems;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RPSGame {
    private static RPSEnum[] rpsPlayerEnum;
    private static int rpsPlayerIndex;
    private static int rpsPcIndex;
    private static RPSEnum[] rpsPcEnum;
    private static String playerName;
    private static int gameCount;
    private static int currentGameCount = 0;
    private static String result = "=========================================" + "\n";
    private static ResourceBundle resourceBundle;

    public RPSGame() {

    }

    public static void gameStart() throws IOException {
        chooseLang();
        Scanner in = new Scanner(System.in);
        System.out.println(resourceBundle.getString("print_name"));
        playerName = in.nextLine();
        System.out.println(resourceBundle.getString("print_count"));
        gameCount = in.nextInt();
        System.out.println(resourceBundle.getString("start"));
        rpsPlayerEnum = new RPSEnum[gameCount];
        rpsPcEnum = new RPSEnum[gameCount];
        while (currentGameCount < gameCount) {
            condition();
        }
    }

    public static void condition() throws IOException {
        System.out.println(resourceBundle.getString("choose"));
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.equals(resourceBundle.getString("rock"))) {
            rpsPlayerEnum[currentGameCount] = RPSEnum.ROCK;
            rpsPlayerIndex = 0;
        } else {
            if (str.equals(resourceBundle.getString("scissors"))) {
                rpsPlayerEnum[currentGameCount] = RPSEnum.SCISSORS;
                rpsPlayerIndex = 1;
            } else {
                if (str.equals(resourceBundle.getString("paper"))) {
                    rpsPlayerEnum[currentGameCount] = RPSEnum.PAPER;
                    rpsPlayerIndex = 2;
                } else {
                    System.out.println(resourceBundle.getString("wrong_choose"));
                    condition();
                    return;
                }
            }
        }
        whoWins();
    }

    public static void whoWins() throws IOException {
        int[][] resultsMatrix = {
                {3, 1, 2},
                {2, 3, 1},
                {1, 2, 3}
        };

        String currGameRes = "";
        switch ((int) (Math.random() * 3)) {
            case 0:
                rpsPcEnum[currentGameCount] = RPSEnum.ROCK;
                rpsPcIndex = 0;
                break;
            case 1:
                rpsPcEnum[currentGameCount] = RPSEnum.SCISSORS;
                rpsPcIndex = 1;
                break;
            case 2:
                rpsPcEnum[currentGameCount] = RPSEnum.PAPER;
                rpsPcIndex = 2;
                break;
            default:
        }
        if (resultsMatrix[rpsPlayerIndex][rpsPcIndex] == 1) {
            currGameRes += resourceBundle.getString("player_won") + playerName + "\n" +
                    resourceBundle.getString("player_choice") + rpsPlayerEnum[currentGameCount] + "\n" +
                    resourceBundle.getString("pc_choice") + rpsPcEnum[currentGameCount] + "\n";
        } else {
            if (resultsMatrix[rpsPlayerIndex][rpsPcIndex] == 2) {
                currGameRes += resourceBundle.getString("pc_won") + "\n" +
                        resourceBundle.getString("player_choice") + rpsPlayerEnum[currentGameCount] + "\n" +
                        resourceBundle.getString("pc_choice") + rpsPcEnum[currentGameCount] + "\n";
            } else {
                System.out.println(resourceBundle.getString("continue_choose"));
                condition();
                return;
            }
        }

        result += currGameRes;
        result += "=========================================" + "\n";
        currentGameCount++;
        System.out.println(currGameRes);
        if (currentGameCount == gameCount) {
            saveRes();
        }
        if (currentGameCount < gameCount) {
            if (!endGame()) {
                System.out.println(getResult());
                saveRes();
                System.exit(1);
            }
        }
    }

    public static boolean endGame() throws IOException {
        System.out.println(resourceBundle.getString("continue_play"));
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.equals(resourceBundle.getString("yes"))) {
            return true;
        } else {
            if (str.equals(resourceBundle.getString("no"))) {
                return false;
            } else {
                System.out.println(resourceBundle.getString("wrong"));
                return endGame();
            }
        }
    }


    public static void saveRes() throws IOException {
        System.out.println(FileSystems.getDefault().getPath("").toString());
        File file = new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString()+"/result.txt");
        if (file.exists()) {
            try (FileWriter save = new FileWriter(file, true)) {
                save.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileWriter save = new FileWriter(file);
            save.write(result);
            save.close();
        }
    }

    public static void chooseLang() {
        System.out.println("Здравствуйте, ваша локация : " + Locale.getDefault().getDisplayCountry() + "\n" +
                "Язык системы : " + Locale.getDefault().getDisplayLanguage());
        System.out.println("Вы можете выбрать язык на котором, мы будем с вами общаться : " + "\n" +
                "1-Английский, 2-Русский, 3-Украинский");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                resourceBundle = ResourceBundle.getBundle("messagesBundle.Lang", new Locale("en"));
                break;
            case 2:
                resourceBundle = ResourceBundle.getBundle("messagesBundle.Lang", new Locale("ru"));
                break;
            case 3:
                resourceBundle = ResourceBundle.getBundle("messagesBundle.Lang", new Locale("ua"));
                break;
            default:
                System.out.println("Вы выбрали несуществующий вариант...");
                chooseLang();
        }
    }

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public static String getResult() {
        return result;
    }

}



