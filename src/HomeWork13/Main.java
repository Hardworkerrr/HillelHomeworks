package HomeWork13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку цифр : ");
        NumberGraphics.printNumbers(in.nextLine().replaceAll("[^\\d-]", ""));
    }
}
