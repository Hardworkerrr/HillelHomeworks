package HomeWork16;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<User> users = User.createUsersList();
        List<ATMThread> threads = new ArrayList<>();
        for (User us : users) {
            threads.add(new ATMThread(new ATM(us)));
        }
        for (ATMThread thread : threads) {
            thread.start();
            thread.join();
        }
        System.out.println("=====================================");
        System.out.println("Результат:");
        users.forEach(user -> System.out.println(user.toString()));
    }
}
