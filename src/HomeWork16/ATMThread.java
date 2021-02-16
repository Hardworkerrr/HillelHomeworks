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
        condition();

    }

    public void condition() {
        switch ((int) (Math.random() * 3)) {
            case 0:
                atm.getMoneyBalance();
                break;
            case 1:
                atm.withdrawMoney();
                break;
            case 2:
                atm.putMoney();
                break;
            default:
                System.out.println("Неверная опперация, введите еще раз");
                condition();
        }
    }
}
