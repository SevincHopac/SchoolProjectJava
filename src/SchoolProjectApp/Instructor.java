package SchoolProjectApp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Instructor {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";

    static Scanner input = new Scanner(System.in);
    public static HashMap<String, InstructorPojo> instructorMap = new HashMap<>();



    public static void instructorMenu() {

        System.out.println(YELLOW+"------Instructor Operations------");
        ControlMethods.printTheMenu();
        instructorMenuSelection();
    }

    private static void instructorMenuSelection() {

        System.out.println(PURPLE+"Select the action you want to take:");
        String choice = input.next().toUpperCase();

        switch (choice) {
            case "1":
                addInstructor();
                break;
            case "2":
                searchInstructor();
                break;
            case "3":
                listInstructor();
                break;
            case "4":
                deleteInstructor();
                break;
            case "5":
                Homepage.homepageMenu();
                break;
            case "Q":
                System.out.println(
                        BLUE+"Thank you for choosing us. Goodbye!");
                break;
            default:
                System.out.println(RED+"Invalid login! Try again.\n");
                instructorMenuSelection();
        }

    }

    private static void deleteInstructor() {

        System.out.println(YELLOW+"------ Delete Instructor -------");

        String id = ControlMethods.idControl();

        if (instructorMap.containsKey(id)) {
            instructorMap.remove(id);
            System.out.println(GREEN+"Your deletion was successful.");
            System.out.println("-----------------------------");
            instructorEndOfProcessSelection();
        }
    }

    private static void listInstructor() {
        Collection<InstructorPojo> instructorValues = instructorMap.values();

        if (instructorMap.isEmpty()) {
            System.out.println(WHITE+"Your instructor list is empty");
        } else {

            System.out.println(YELLOW+"------- Instructor List -------\n");
            System.out.println(GREEN+"Identification number     Name Surname         Old      Registration Number    Department");
            for (InstructorPojo w : instructorValues) {
                System.out.printf(GREEN+"%-26s %-20s %-15s %-15s %-19s\n", w.getIdNo(), w.getNameSurname(),w.getOld(), w.getRegistrationNumber(), w.getDepartment());
            }
        }

        System.out.println(WHITE+"-----------------------------");
        instructorEndOfProcessSelection();
    }

    private static void searchInstructor() {

        System.out.println(YELLOW+"Welcome to the instructor search page!");

        String id = ControlMethods.idControl();

        if (instructorMap.containsKey(id)) {
            System.out.println(instructorMap.get(id));
            System.out.println("-----------------------------");
        } else {
            System.out.println(RED+"We do not have a instructor with this ID number.");
        }
        System.out.println(WHITE+"-----------------------------");
        instructorEndOfProcessSelection();
    }

    private static void addInstructor() {

        String adsoyad = ControlMethods.nameControl();
        int yas = ControlMethods.ageControl();
        String kimlikNo = ControlMethods.idControl();
        int sicilNo = (int) (Math.random() * 30000);
        String bolum = instructorDepartmen();

        InstructorPojo ogretmenPojo = new InstructorPojo(kimlikNo, adsoyad, yas, sicilNo, bolum);
        instructorMap.put(kimlikNo, ogretmenPojo);

        System.out.println(
                GREEN+"Adding instructors successfully.\n" +
                        "To continue processing 1\n" +
                        "Press any key for other operations");
        String scm = input.next();
        if (scm.equals("1")) {
            addInstructor();
        } else {
            System.out.println(WHITE+"-----------------------------");
            instructorEndOfProcessSelection();
        }
    }

    private static void instructorEndOfProcessSelection() {

        System.out.println(
                WHITE+
                        "2 for Instructor Menu\n" +
                        "3 for main menu\n" +
                        "Q for Exit\n"
        );

        String choice = input.next().toUpperCase();

        switch (choice) {

            case "2":
                Instructor.instructorMenu();
                break;
            case "3":
                Homepage.homepageMenu();
                break;
            case "Q":
                System.out.println(BLUE+"Thank you for choosing us. Goodbye!");
                break;
            default:
                System.out.println(RED+"Invalid login! Try again.\n");
                System.out.println("-----------------------------");
                instructorEndOfProcessSelection();
        }
    }
    private static String instructorDepartmen() {

        System.out.print("Enter the instructor's department:");
        String department = input.next();
        return department;
    }
}