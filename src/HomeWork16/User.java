package HomeWork16;

import java.util.List;

public class User {
    private String fullName;
    private int id = (int) (Math.random() * 10000);
    private int moneyAmount;

    public User() {
        this.id++;
    }

    public User(String fullName, int moneyAmount) {
        this.fullName = fullName;
        this.moneyAmount = moneyAmount;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public static List<User> createUsersList() {
        return List.of(new User("Барыгин Н.А", 16000),
                new User("Верищагин И.О", 200000),
                new User("Теплов А.В", 11500),
                new User("Васильев О.А", 5400));
    }

    @Override
    public String toString() {
        return "User{fullName='" + fullName + '\'' +
                ", id=" + id +
                ", moneyAmount=" + moneyAmount +
                "}";
    }


}
