import java.io.*;
import java.util.*;

public class Main {
    private final ArrayList<NBAstat> a;

    public Main(ArrayList<NBAstat> arrayToSort) {
        this.a = arrayToSort;
    }

    public ArrayList<NBAstat> getArrayAfterSorting() {
        return a;
    }

    //Method declarations
    public static ArrayList<NBAstat> transpositionSort(ArrayList<NBAstat> a, int size) {
        long startTime = System.nanoTime(); // used Nanoseconds because dataset was only 500 entries long
        boolean isSorted = false; // Initially array is unsorted//create an object of your comparator
        ComparePoints com = new ComparePoints();
        while (!isSorted) {
            isSorted = true;
            NBAstat temp;

            // Perform Bubble sort on odd indexed element

            // Perform Bubble sort on even indexed element

            for (int i = 0; i < size - 2; i = i + 2) {
                if ((com.compare(a.get(i), a.get(i + 1))) > 0) { // how do i compare arraylist of objects using comparator interface? same with below
                    temp = a.get(i + 1);
                    a.set(i + 1, a.get(i));
                    a.set(i, temp);
                    isSorted = false;
                }
            }
            for (int i = 1; i <= size - 2; i = i + 2) {
                if ((com.compare(a.get(i), a.get(i + 1))) > 0) { // how do i compare arraylist of objects using comparator interface? same with below
                    temp = a.get(i + 1);
                    a.set(i + 1, a.get(i));
                    a.set(i, temp);
                    isSorted = false;
                }
            }

        }
        return a;

    }

    public void mergeSortedLists(int left, int middle, int right) {
        ArrayList<NBAstat> tmp = new ArrayList<>();
        ComparePoints com2 = new ComparePoints();

        int getLeftIndex = left;
        int getRightIndex = middle + 1;

        while (getLeftIndex <= middle && getRightIndex <= right) {

            if (com2.compare(a.get(getLeftIndex), a.get(getRightIndex)) > 0) {

                tmp.add(a.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tmp.add(a.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= middle) {
            tmp.add(a.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= right) {
            tmp.add(a.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tmp.size(); left++) {
            a.set(left, tmp.get(i++));

        }

    }


    public void mergeSort(int indexStart, int indexEnd) {

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            mergeSort(indexStart, middleElement);
            mergeSort(middleElement + 1, indexEnd);

            mergeSortedLists(indexStart, middleElement, indexEnd);
        }
    }


    public static void main(String [] args) throws IOException {
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

        ArrayList<NBAstat> list=new ArrayList<NBAstat>();   // list to be sorted
        ArrayList<NBAstat> tmp=new ArrayList<NBAstat>();   // temporary workspace
        //fill list
        while (inputFileNameScanner.hasNext()) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");
            NBAstat mon = new NBAstat(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),Integer.parseInt(parts[7]), Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),Integer.parseInt(parts[10]));
            list.add(mon); // adds the object with all the variables
        }

        ComparePoints compare = new ComparePoints();
        compare.compare(list.get(1),list.get(2));

        inputFileNameStream.close();
        //....
        //...
        //Create a copy from list for Transition sort
        ArrayList <NBAstat> list2=new ArrayList<NBAstat>();
        for(int i=0;i<list.size();i++)
            list2.add(list.get(i));


       // sort list using mergesort
        Main ob = new Main(list);

        long startTime = System.nanoTime(); // used Nanoseconds because dataset was only 500 entries long
        ob.mergeSort(0, list.size() - 1);
        long totalTime = (System.nanoTime() - startTime);
        System.out.println(totalTime);

        System.out.println("");
        long startTime2 = System.nanoTime();
        // sort list2 using Bubble sort
        transpositionSort(list2, list2.size());
        long totalTime2 = (System.nanoTime() - startTime2);
        System.out.println(totalTime2);



           }
}
