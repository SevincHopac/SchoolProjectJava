package SchoolProjectApp;

import java.util.Scanner;

public class Homepage {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";

    static Scanner scan = new Scanner(System.in);

    public static void homepageMenu() {

        System.out.println(YELLOW+"---------------# SCHOOL HOMEPAGE #---------------");

        System.out.println(GREEN+
                        "1. Student Operations\n" +
                        "2. Teacher Operations\n" +
                        "Q. Exit\n");

        homepageSelection();
    }

    public static void homepageSelection() {

        System.out.println(PURPLE+"Select the action you want to take:");

        String choice = scan.next().toUpperCase();

        switch (choice) {

            case "1":
                Student.studentMenu();
                break;
            case "2":
                Instructor.instructorMenu();
                break;
            case "Q":
                System.out.println(BLUE+"Thank you for choosing us. Goodbye!");
                break;
            default:
                System.out.print(RED+"Invalid login! Try again.\n");
                homepageSelection();
        }
    }
}
