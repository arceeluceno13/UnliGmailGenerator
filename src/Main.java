import classes.Gen;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter export amount: ");
        int exportAmount = scanner.nextInt();
        System.out.print("Enter email: ");
        String email = scanner.next();
        Gen.prefixGen(exportAmount, email);
    }
}