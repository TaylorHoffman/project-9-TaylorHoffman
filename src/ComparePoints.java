import java.util.ArrayList;
import java.util.Comparator;

public class ComparePoints implements Comparator<NBAstat> { // compare two objects
    public int compare(NBAstat a, NBAstat b) {
            return a.getPoints() - b.getPoints();// sort by speed
}
//    public static void Sort(ArrayList<NBAstat> NBAplayers, int n) { // sort method
//        boolean notSorted = true;
//        while (notSorted) {
//            notSorted = false;
//            for (int i = 0; i < n - 1; i++) {
//                if (NBA.Compare(NBAplayers, new ComparePoints(), i, i + 1) > 0) {
//                    swap(NBAplayers, i, i + 1);
//                    notSorted = true;
//                }
//            }
//        }
//    }
//    public static void swap(ArrayList<NBAstat> NBAplayers, int one, int two) { // swap
//        NBAstat temp = new NBAstat();
//        temp = NBAplayers.get(one);
//        NBAplayers.set(NBAplayers.get(one), NBAplayers.get(two));
//        NBAplayers.set(NBAplayers.get(two), temp);
//
//
//        NBAplayers.set(two, temp);
//    }
}

