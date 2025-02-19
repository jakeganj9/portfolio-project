import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class ProofOfConcept {

    public static void add(Sequence<String> playlist1, String song) {
        playlist1.add(playlist1.length(), song);
    }

    public static String removeAny(Sequence<String> playlist1) {
        return playlist1.remove(playlist1.length() - 1);
    }

    public static int size(Sequence<String> playlist1) {
        return playlist1.length();
    }

    public static void add(Sequence<String> playlist1,
            Sequence<String> playlist2) {
        playlist1.append(playlist2);
    }

    public static boolean isSubPlaylist(Sequence<String> playlist1,
            Sequence<String> playlist2) {
        int length1 = playlist1.length();
        int length2 = playlist2.length();
        boolean isSub = true;
        int i = 0;

        while (i < playlist1.length() && isSub) {
            boolean found = false;
            for (int j = 0; j < length2; j++) {
                if (playlist1.entry(i).equals(playlist2.entry(i))) {
                    found = true;
                }
            }
            if (!found) {
                isSub = false;
            }
            i++;
        }
        return isSub;
    }

    public static void main(String args[]) {
        Sequence<String> playlistA = new Sequence1L<>();
        Sequence<String> playlistB = new Sequence1L<>();
        Sequence<String> testA = new Sequence1L();
        Sequence<String> testB = new Sequence1L();



        SimpleWriter out = new SimpleWriter1L();

        add(playlistA, "x");
        testA.add(0, "x");
        add(playlistB, "y");
        add(playlistB, "z");
        testB.add(0, "y");
        testB.add(0, "z");

        if (playlistA.equals(testA)) {
            out.println("add() Test 1 Passed");
        } else {
            out.println("add() Test 1 Failed");
        }

        if (playlistB.equals(testB)) {
            out.println("add() Test 2 Passed");
        } else {
            out.println("add() Test 2 Failed");
        }

        String raT1 = removeAny(playlistA);
        String raT2 = removeAny(playlistB);

        if (playlistA.length() == 0) {
            out.println("removeAny() Test 1 Passed");
        } else {
            out.println("removeAny() Test 1 Failed");
        }

        if (playlistB.length() == 1) {
            out.println("removeAny() Test 1 Passed");
        } else {
            out.println("removeAny() Test 1 Failed");
        }

        if (size(playlistA) == 0) {
            out.println("size() Test 1 Passed");
        } else {
            out.println("size() Test 1 Failed");
        }

        if (size(playlistB) == 1) {
            out.println("size() Test 2 Passed");
        } else {
            out.println("size() Test 2 Failed");
        }


        playlistA.clear();
        testA.clear();
        playlistB.clear();
        testB.clear();

        playlistB.add(0,"a");
        testA.add(0,"a");

        add(playlistA, playlistB);

        if (playlistA.equals(testA)) {
            out.println("add() Test1 Passed");
        } else {
            out.println("add() Test1 Failed")
        }

        playlistA.clear();
        playlistB.clear();

        playlistA.add(0,"a");
        playlistA.add(0,"b");

        playlistB.add(0,"")



    }
}
