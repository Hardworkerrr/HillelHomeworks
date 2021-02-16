package HomeWork16;

import java.util.Scanner;

public class ATMThread extends Thread {
    ATM atm;

    public ATMThread(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        System.out.println("Здравствуйте " + atm.getUser().getFullName() + " !");
        System.out.println("Ваш персональный номер : " + atm.getUser().getId());
        System.out.println("Количество денег на счету : " + atm.getUser().getMoneyAmount());
        try {
            condition();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void condition() throws InterruptedException {
        System.out.println("Выберите операцию с банковским аккаунтом : просмотр баланса, снятие наличных, пополнение счета");
        sleep(2000);
        switch (new Scanner(System.in).nextLine().toLowerCase()) {
            case "просмотр баланса":
                atm.getMoneyBalance();
                break;
            case "снятие наличных":
                atm.withdrawMoney();
                break;
            case "пополнение счета":
                atm.putMoney();
                break;
            default:
                System.out.println("Неверная опперация, введите еще раз");
                condition();
        }
    }
}
