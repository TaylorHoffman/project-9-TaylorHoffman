import java.io.*;
import java.io.IOException;
import java.util.*;

public class NBA {

    public static int Compare(ArrayList<NBAstat> arr, Comparator<NBAstat> c, int first, int second) {
        return c.compare(arr.get(first), arr.get(second));
    }
    public static ArrayList<NBAstat> NBAplayers = new ArrayList<NBAstat>();
    public static void main(String[] args) throws IOException {
        // Ask for input file
        Scanner scnr = new Scanner(System.in);
        System.out.println("filename?: ");
        String inputFileName = "src/" + scnr.nextLine(); // ask for file name

        // For file input
        String fileName;
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        // Pokemon ArrayList (PokeDex)
        ArrayList<NBAstat> NBAplayers = new ArrayList<NBAstat>(); // array list

        // Read in file and store data in Pokemon ArrayList
        while (inputFileNameScanner.hasNext()) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");
            NBAstat mon = new NBAstat(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),Integer.parseInt(parts[7]), Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),Integer.parseInt(parts[10]));
            NBAplayers.add(mon); // adds the object with all the variables
        }
        inputFileNameStream.close(); // because I care
        Collections.sort(NBAplayers, new ComparePoints());

        NBAstat b = new NBAstat();
        BufferedWriter output = new BufferedWriter(new FileWriter("src/sortedDataset2.txt")); // print using to String to sortedDataset.txt
        for (int k = 0; k < NBAplayers.size(); k++) {
            String output2 = b.toString(NBAplayers.get(k));
            output.write(output2 + "\n");
        }
        output.close();

        long startTime = System.nanoTime(); // used Nanoseconds because dataset was only 500 entries long
        long totalTime = (System.nanoTime() - startTime);
        System.out.println(totalTime);
    }
}
