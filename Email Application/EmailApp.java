package EmailApp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Email em1 = new Email("Niki", "Raykov");
        System.out.println(em1.showInfo());
    }
}
