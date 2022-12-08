package SchoolProjectApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlMethods {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    static Scanner input;

    public static String idControl() {
        input = new Scanner(System.in);
        System.out.println("Enter the person's identification number as 5 digits.");
        String id = input.next();
        String newId = id.replaceAll("\\d", "");

        if (id.length() != 5 || newId.length() > 0) {
            System.out.print("You have entered an invalid ID number! Try again");
            return idControl();
        } else {
            return id;
        }
    }

    public static String nameControl() {
        input = new Scanner(System.in);

        System.out.println(GREEN+"Please enter the person's first and last name");
        String fullName = input.nextLine();

        int uz = fullName.length();

        String adSoyad = fullName.replaceAll("\\D", "");

        if (uz > 5 && adSoyad.equals("")) {
            return fullName;
        } else {
            System.out.println(RED+"You have entered an invalid age range. Try again!");
            return nameControl();
        }
    }

    public static int ageControl() {

        input = new Scanner(System.in);

        int age = 0;

        try {
            System.out.println(GREEN+"Please enter the instructor's age:");
            age = input.nextInt();

            if (age > 13 && age < 65) {

            } else {
                System.out.println("You have entered an invalid age range. Try again!");
                return ageControl();
            }
        } catch (InputMismatchException e) {
            System.out.println("You have made an invalid entry. (Enter a number) ");
            input.nextLine();
            return ageControl();
        }
        return age;
    }

    public static void printTheMenu() {

        System.out.println("1. Addition\n" +
                "2. Search \n" +
                "3. Listing\n" +
                "4. Delete\n" +
                "5. Homepage\n" +
                "Q. Exit\n");
    }
}
