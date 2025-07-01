// Scott Schmidlin
// 08/1/2024
// CSE 122
// PO: Culminating Project 2: File Process
// TA's: Chloe Mi Cartier, Marcus Sanchez
import java.util.*;
import java.io.*;

// The Taekwonscanner class gives users the functionality to filter and organize
//the data of USA Taekwondo sparring athletes. This data was last updated as of
//Spring 2024. Users can view athlete information, and filter through it as they
//please. 
public class Taekwonscanner {
    private List<String> fullName;
    private List<String> gender;
    private List<String> belt;
    private List<Integer> memNum;
    private List<String> age;
    private List<String> div;
    private List<String> weightRange;
    private List<Double> points;

    // Behavior:
    //      - Creates a new Taekwonscanner instance that parses the USATRankings.txt
    //        file and fills array lists with the information in the file to represent
    //        the athletes.
    // Parameters:
    //      - Scanner fileScan: a scanner to parse the file USATRankings.txt
    public Taekwonscanner(Scanner fileScan) {
        String titles = fileScan.nextLine();

        fullName = new ArrayList<>();
        gender = new ArrayList<>();
        belt = new ArrayList<>();
        memNum = new ArrayList<>();
        age = new ArrayList<>();
        div = new ArrayList<>();
        weightRange = new ArrayList<>();
        points = new ArrayList<>();

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);

            fullName.add(lineScan.next() + " " + lineScan.next());
            gender.add(lineScan.next());
            belt.add(lineScan.next());
            memNum.add(lineScan.nextInt());
            age.add(lineScan.next());
            div.add(lineScan.next());
            weightRange.add(lineScan.next());
            points.add(lineScan.nextDouble());
        }
    }

    // Behavior:
    //      - Returns a string representation of all athletes.
    public String getAthletes() {
        String result = "";
        for (int i = 0; i < fullName.size(); i++) {
            result += toString(i) + "\n";
        }
        return result;
    }

    // Behavior:
    //      - Returns a string representation of an athlete at a given index in
    //        the array lists.
    private String toString(int i) {
        return fullName.get(i) + ", " + gender.get(i) + ", " + belt.get(i) + ", " + 
                memNum.get(i) + ", " + age.get(i) + ", " + div.get(i) + ", " + 
                weightRange.get(i) + ", " + points.get(i);
    }

    // Behavior:
    //      - Filters the athletes in USATRankings.txt by an inputted gender. 
    // Parameters:
    //      - Scanner console: a scanner so the user can input a gender to filter by.
    public void filterGender(Scanner console) {
        String input = console.nextLine();
        while(!gender.contains(input)) {
            System.out.println("There are no athletes with these specifications. ");
            System.out.print("Please try again: ");
            input = console.nextLine();
        }

        List<String> fullName2 = new ArrayList<>();
        List<String> gender2 = new ArrayList<>();
        List<String> belt2 = new ArrayList<>();
        List<Integer> memNum2 = new ArrayList<>();
        List<String> age2 = new ArrayList<>();
        List<String> div2 = new ArrayList<>();
        List<String> weightRange2 = new ArrayList<>();
        List<Double> points2 = new ArrayList<>();

        while (gender.contains(input)) {
            for (int i = 0; i < gender.size(); i++) {
                if (gender.get(i).equals(input)) {
                    fullName2.add(fullName.remove(i));
                    gender2.add(gender.remove(i));
                    belt2.add(belt.remove(i));
                    memNum2.add(memNum.remove(i));
                    age2.add(age.remove(i));
                    div2.add(div.remove(i));
                    weightRange2.add(weightRange.remove(i));
                    points2.add(points.remove(i));
                }
            }
        }

        fullName.clear();
        gender.clear();
        belt.clear();
        memNum.clear();
        age.clear();
        div.clear();
        weightRange.clear();
        points.clear();

        while (gender2.contains(input)) {
            for (int i = 0; i < gender2.size(); i++) {
                fullName.add(fullName2.remove(i));
                gender.add(gender2.remove(i));
                belt.add(belt2.remove(i));
                memNum.add(memNum2.remove(i));
                age.add(age2.remove(i));
                div.add(div2.remove(i));
                weightRange.add(weightRange2.remove(i));
                points.add(points2.remove(i));
            }
        }
    }

    // Behavior:
    //      - Filters the athletes in USATRankings.txt by an inputted belt level.
    // Parameters:
    //      - Scanner console: a scanner so the user can input a belt level to filter by.
    public void filterBelt(Scanner console) {
        String input = console.nextLine();
        while(!belt.contains(input)) {
            System.out.println("There are no athletes with these specifications. ");
            System.out.print("Please try again: ");
            input = console.nextLine();
        }

        List<String> fullName2 = new ArrayList<>();
        List<String> gender2 = new ArrayList<>();
        List<String> belt2 = new ArrayList<>();
        List<Integer> memNum2 = new ArrayList<>();
        List<String> age2 = new ArrayList<>();
        List<String> div2 = new ArrayList<>();
        List<String> weightRange2 = new ArrayList<>();
        List<Double> points2 = new ArrayList<>();

        while (belt.contains(input)) {
            for (int i = 0; i < belt.size(); i++) {
                if (belt.get(i).equals(input)) {
                    fullName2.add(fullName.remove(i));
                    gender2.add(gender.remove(i));
                    belt2.add(belt.remove(i));
                    memNum2.add(memNum.remove(i));
                    age2.add(age.remove(i));
                    div2.add(div.remove(i));
                    weightRange2.add(weightRange.remove(i));
                    points2.add(points.remove(i));
                }
            }
        }

        fullName.clear();
        gender.clear();
        belt.clear();
        memNum.clear();
        age.clear();
        div.clear();
        weightRange.clear();
        points.clear();

        while (belt2.contains(input)) {
            for (int i = 0; i < belt2.size(); i++) {
                fullName.add(fullName2.remove(i));
                gender.add(gender2.remove(i));
                belt.add(belt2.remove(i));
                memNum.add(memNum2.remove(i));
                age.add(age2.remove(i));
                div.add(div2.remove(i));
                weightRange.add(weightRange2.remove(i));
                points.add(points2.remove(i));
            }
        }
    }

    // Behavior:
    //      - Filters the athletes in USATRankings.txt by an inputted weight division. 
    // Parameters:
    //      - Scanner console: a scanner so the user can input a weight division to
    //        filter by.
    public void filterWeight(Scanner console) {
        String input = console.nextLine();
        while(!weightRange.contains(input)) {
            System.out.println("There are no athletes with these specifications. ");
            System.out.print("Please try again: ");
            input = console.nextLine();
        }

        List<String> fullName2 = new ArrayList<>();
        List<String> gender2 = new ArrayList<>();
        List<String> belt2 = new ArrayList<>();
        List<Integer> memNum2 = new ArrayList<>();
        List<String> age2 = new ArrayList<>();
        List<String> div2 = new ArrayList<>();
        List<String> weightRange2 = new ArrayList<>();
        List<Double> points2 = new ArrayList<>();

        while (weightRange.contains(input)) {
            for (int i = 0; i < weightRange.size(); i++) {
                if (weightRange.get(i).equals(input)) {
                    fullName2.add(fullName.remove(i));
                    gender2.add(gender.remove(i));
                    belt2.add(belt.remove(i));
                    memNum2.add(memNum.remove(i));
                    age2.add(age.remove(i));
                    div2.add(div.remove(i));
                    weightRange2.add(weightRange.remove(i));
                    points2.add(points.remove(i));
                }
            }
        }

        fullName.clear();
        gender.clear();
        belt.clear();
        memNum.clear();
        age.clear();
        div.clear();
        weightRange.clear();
        points.clear();

        while (weightRange2.contains(input)) {
            for (int i = 0; i < weightRange2.size(); i++) {
                fullName.add(fullName2.remove(i));
                gender.add(gender2.remove(i));
                belt.add(belt2.remove(i));
                memNum.add(memNum2.remove(i));
                age.add(age2.remove(i));
                div.add(div2.remove(i));
                weightRange.add(weightRange2.remove(i));
                points.add(points2.remove(i));
            }
        }
    }

    // Behavior:
    //      - Prints the athlete information for an athlete with the inputted name. 
    // Parameters:
    //      - Scanner console: a scanner so the user can input an athletes name.
    public String filterName(Scanner console) {
        String input = console.nextLine();
        while (!input.equals("E")) {
            for (int i = 0; i < fullName.size(); i++) {
                if (fullName.get(i).equalsIgnoreCase(input)) {
                    return toString(i);
                }
            }
            System.out.println("Please enter a valid athlete: ");
            System.out.println("Or type \"E\" to exit");
            input = console.nextLine();
        }
        return "Exited.";
    }

    // Behavior:
    //      - Empties the arrays containing the athlete information.
    // Exceptions:
    //      - If arrays are already empty, throws an IllegalStateException.
    private void empty() {
        if (fullName.isEmpty()) {
            throw new IllegalStateException("Arrays must not be empty");
        }
        fullName.clear();
        gender.clear();
        belt.clear();
        memNum.clear();
        age.clear();
        div.clear();
        weightRange.clear();
        points.clear();
    }

    // Behavior:
    //      - Fills the arrays containing the athlete information.
    private void fill() throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("USATRankings.txt"));
        String titles = fileScan.nextLine();
        
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);

            fullName.add(lineScan.next() + " " + lineScan.next());
            gender.add(lineScan.next());
            belt.add(lineScan.next());
            memNum.add(lineScan.nextInt());
            age.add(lineScan.next());
            div.add(lineScan.next());
            weightRange.add(lineScan.next());
            points.add(lineScan.nextDouble());
        }
    }

    // Behavior:
    //      - Resets all filters.
    public void reset() throws FileNotFoundException{
        empty();
        fill();
    }

    // Behavior:
    //      - Organizes the athletes by greatest points to least points.
    public void organizePoints() {
        double pointTemp = 0;
        String nameTemp = "";
        String genderTemp = "";
        String beltTemp = "";
        int memNumTemp = 0;
        String divTemp = "";
        String weightRangeTemp = "";

        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (points.get(i) > points.get(j)) {
                    pointTemp = points.get(i);
                    points.set(i, points.get(j));
                    points.set(j, pointTemp);

                    nameTemp = fullName.get(i);
                    fullName.set(i, fullName.get(j));
                    fullName.set(j, nameTemp);

                    genderTemp = gender.get(i);
                    gender.set(i, gender.get(j));
                    gender.set(j, genderTemp);

                    beltTemp = belt.get(i);
                    belt.set(i, belt.get(j));
                    belt.set(j, beltTemp);

                    memNumTemp = memNum.get(i);
                    memNum.set(i, memNum.get(j));
                    memNum.set(j, memNumTemp);

                    divTemp = div.get(i);
                    div.set(i, div.get(j));
                    div.set(j, divTemp);

                    weightRangeTemp = weightRange.get(i);
                    weightRange.set(i, weightRange.get(j));
                    weightRange.set(j, weightRangeTemp);
                }
            }
        }    
    }
}
