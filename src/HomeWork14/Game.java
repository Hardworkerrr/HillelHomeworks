package HomeWork14;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        RPSGame.gameStart();
        System.out.println(RPSGame.getResult());
    }
}
