package SchoolProjectApp;

import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    static Scanner input = new Scanner(System.in);
    static int schoolNumber = 100;
    public static HashMap<String, StudentPojo> studentMap = new HashMap<>();

    public static void studentMenu() {

        System.out.println(YELLOW+"------Student Operations------");
        ControlMethods.printTheMenu();
        studentMenuSelection();
    }

    private static void studentMenuSelection() {

        System.out.println(PURPLE+"Select the action you want to take:");
        String choice = input.next().toUpperCase();

        switch (choice) {
            case "1":
                addStudent();
                break;
            case "2":
                searchStudent();
                break;
            case "3":
                listStudent();
                break;
            case "4":
                deleteStudent();
                break;
            case "5":
                Homepage.homepageMenu();
                break;
            case "Q":
                System.out.println(BLUE+"Thank you for choosing us. Goodbye!");
                break;
            default:
                System.out.println(RED+"Invalid login! Try again.\n");
                studentMenuSelection();
        }

    }

    private static void deleteStudent() {

        System.out.println(YELLOW+"------ Delete Student -------");

        String id = ControlMethods.idControl();

        if (studentMap.containsKey(id)) {
            studentMap.remove(id);
            System.out.println(GREEN+"Your deletion was successful.");
            System.out.println("-----------------------------");
            studentEndOfProcessSelection();
        }
    }

    private static void addStudent() {

        String fullName = ControlMethods.nameControl();

        int old = studentAgeControl();

        int classCategory=classification(old);

        String idNo = ControlMethods.idControl();

        if (studentMap.containsKey(idNo)) {
            System.out.println(RED+"Your student with this ID number is registered.\n" + "Try again.");
            idNo = ControlMethods.idControl();
        }

        int schoolNo = schoolNumber++;

        StudentPojo studentPojo = new StudentPojo(idNo, fullName, old, classCategory, schoolNo);

        studentMap.put(idNo, studentPojo);

        System.out.println(GREEN+"Adding students successfully.\n" +
                            "To continue processing 1\n" +
                            "Press any key for other operations"
                       );
        String choice = input.next();

        if (choice.equals("1")) {
            addStudent();
        } else {
            System.out.println(WHITE+"-----------------------------");
            studentEndOfProcessSelection();
        }

    }

    private static int studentAgeControl() {

        input = new Scanner(System.in);

        int age = 0;

        try {
            System.out.println(GREEN+"Enter the age of the student:");
            age = input.nextInt();

            if (age > 14 && age < 19) {

                classification(age);

            } else {
                System.out.println(RED+"You have entered an invalid age range. Try again!");
                return studentAgeControl();
            }
        } catch (InputMismatchException e) {
            System.out.println("You have made an invalid entry. (Enter a number) ");
            input.nextLine();
            return studentAgeControl();
        }
        return age;
    }


    public static int classification(int old) {

        int classCategory;

        switch (old) {
            case 15:
                classCategory = 9;
                break;
            case 16:
                classCategory = 10;
                break;
            case 17:
                classCategory = 11;
                break;
            case 18:
                classCategory = 12;
                break;
            default:
                System.out.println("Our school provides education to students aged 15-18.\n" +
                                   "The age you entered is invalid. Try again");
                return classification(studentAgeControl());
        }
        return classCategory;
    }

    private static void listStudent() {
        Collection<StudentPojo> studentValues = studentMap.values();

        if (studentMap.isEmpty()) {
            System.out.println(WHITE+"Your student list is empty");
        } else {

            System.out.println(YELLOW+"------- Student List -------\n");
            System.out.println(GREEN+"Identification number     Name Surname       Old        School Number       Class Category");
            for (StudentPojo w : studentValues) {
                System.out.printf(GREEN+"%-25s %-19s %-18s %-18s %-18s\n", w.getIdNo(), w.getNameSurname(), w.getOld(), w.getSchoolNumber(), w.getClassCategory());
            }
        }

        System.out.println(WHITE+"------------------------");
        studentEndOfProcessSelection();
    }

    private static void searchStudent() {

        System.out.println(YELLOW+"Welcome to the student search page!");

        String id = ControlMethods.idControl();

        if (studentMap.containsKey(id)) {
            System.out.println(studentMap.get(id));
            System.out.println("-----------------------------");
        } else {
            System.out.println(RED+"We do not have a student with this ID number.");
        }
        System.out.println(WHITE+"-----------------------------");
        studentEndOfProcessSelection();
    }

    private static void studentEndOfProcessSelection() {

        System.out.println(WHITE+
                        "2 for Student Menu\n" +
                        "3 for main menu\n" +
                        "Q for Exit\n"
                       );

        String choice = input.next().toUpperCase();

        switch (choice) {

            case "2":
                Student.studentMenu();
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
                studentEndOfProcessSelection();
        }
    }


}
