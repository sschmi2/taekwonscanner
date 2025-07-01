// Scott Schmidlin
// 08/1/2024
// CSE 122
// PO: Culminating Project 2: File Process
// TA's: Chloe Mi Cartier, Marcus Sanchez
import java.util.*;
import java.io.*;

// This class processes data on USA Taekwondo athletes and allows client to 
//retrieve relevant athlete information, as well as sort by desired information.
public class Client {
    public static void main(String[] args) throws FileNotFoundException{
        // javac *.java
        // java Client

        System.out.println("USA Taekwondo Sparring Rankings: ");
        System.out.println("These rankings are of the Senior category (ages 18 - 32)");
        intro();

        Taekwonscanner tkdScan = new Taekwonscanner (new Scanner(new File("USATRankings.txt")));
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        while (!input.equalsIgnoreCase("Q")) {
            System.out.println();
            if (input.equalsIgnoreCase("G")) {
                System.out.print("Enter \"Male\" or \"Female\" to filter: ");
                tkdScan.filterGender(console);
            } else if (input.equalsIgnoreCase("B")) {
                System.out.println("Enter one of the following (case sensitive) belt levels to filter: ");
                System.out.println("Black");
                System.out.println("Red");
                System.out.println("Blue");
                System.out.println("Green");
                System.out.println("Yellow");
                tkdScan.filterBelt(console);
            } else if (input.equalsIgnoreCase("W")) {
                System.out.println("Enter one of the following weight divisions to filter: ");
                System.out.println();
                System.out.println("For Women");
                System.out.println("Under-46kg");
                System.out.println("46.1kg-49kg");
                System.out.println("49.1kg-53kg");
                System.out.println("53.1kg-57kg");
                System.out.println("57.1kg-62kg");
                System.out.println("62.1kg-67kg");
                System.out.println("67.1kg-73kg");
                System.out.println("Over-73kg");
                System.out.println();
                System.out.println("For Men: ");
                System.out.println("Under-54kg");
                System.out.println("54.1kg-58kg");
                System.out.println("58.1kg-63kg");
                System.out.println("63.1kg-68kg");
                System.out.println("68.1kg-74kg");
                System.out.println("74.1kg-80kg");
                System.out.println("80.1kg-87kg");
                System.out.println("Over-87kg");
                tkdScan.filterWeight(console);
            } else if (input.equalsIgnoreCase("N")) {
                System.out.print("Enter an athletes name: ");
                System.out.println(tkdScan.filterName(console));
            } else if (input.equalsIgnoreCase("E")) {
                tkdScan.organizePoints();
                System.out.println("The athlete information presented is as follows:");
                System.out.println("First Name, Last Name, Gender, Belt, Membership Number," +
                        " Age Division, Weight Range, Total Points");
                System.out.println();
                System.out.println(tkdScan.getAthletes());
            } else if (input.equalsIgnoreCase("R")) {
                tkdScan.reset();
                System.out.println("Filters have been reset.");
            }
            intro();
            input = console.nextLine();
        }
    }

    // Behavior:
    //      - Gives an introduction menu to the user.
    // Parameters:
    //      - None
    // Returns:
    //      - None
    public static void intro() {
        System.out.println();
        System.out.println("To filter rankings, input one of the following:");
        System.out.println("(G)ender, (B)elt, (W)eight, (N)ame");
        System.out.println();
        System.out.println("To see athletes type (E)nter, to reset filters type"
                + " (R)eset, to end the program type (Q)uit");
    }
}
