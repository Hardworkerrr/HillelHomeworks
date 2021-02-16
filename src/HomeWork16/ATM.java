package HomeWork16;

import java.util.Scanner;

public class ATM {
    User user;
    private static int maxMoneyAmount = 1000000000;


    public ATM(User user) {
        this.user = user;
    }

    public ATM() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void putMoney() {
        System.out.println("Введите сумму пополнения : ");
        int moneyIn = new Scanner(System.in).nextInt();
        user.setMoneyAmount(user.getMoneyAmount() + moneyIn);
        System.out.println(Thread.currentThread().getName());
        System.out.println("Вы пополнили счёт на : " + moneyIn + " грн" + "\n" +
                "Ваш текущий баланс :" + user.getMoneyAmount() + " грн");
        System.out.println("=====================================");

    }

    public void getMoneyBalance() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Ваш баланс : " + user.getMoneyAmount());
        System.out.println("=====================================");
    }

    public void withdrawMoney() {
        System.out.println("Введите сумму снятия : ");
        int moneyIn = new Scanner(System.in).nextInt();
        if(moneyIn>user.getMoneyAmount()){
            System.out.println("У вас недостаточно средств для вывода...");
            System.out.println("=====================================");
            return;
        }
        user.setMoneyAmount(user.getMoneyAmount() - moneyIn);
        System.out.println(Thread.currentThread().getName());
        System.out.println("Вы сняли со счета: " + moneyIn + " грн" + "\n" +
                "Ваш текущий баланс :" + user.getMoneyAmount() + " грн");
        System.out.println("=====================================");
    }
}
