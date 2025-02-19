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
        Sequence<String> testA = new Sequence1L<>();
        Sequence<String> testB = new Sequence1L<>();

        SimpleWriter out = new SimpleWriter1L();

        add(playlistA, "x");
        testA.add(0, "x");
        add(playlistB, "y");
        add(playlistB, "z");
        testB.add(0, "y");
        testB.add(1, "z");

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

        removeAny(playlistA);
        removeAny(playlistB);

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

        playlistB.add(0, "a");
        testA.add(1, "a");

        add(playlistA, playlistB);

        if (playlistA.equals(testA)) {
            out.println("add() other playlist Test1 Passed");
        } else {
            out.println("add() other playlist Test1 Failed");
        }

        playlistA.clear();
        playlistB.clear();
        testA.clear();

        playlistA.add(0, "a");
        playlistA.add(1, "b");

        playlistB.add(0, "c");

        testA.add(0, "a");
        testA.add(1, "b");
        testA.add(2, "c");

        add(playlistA, playlistB);

        if (playlistA.equals(testA)) {
            out.println("add() other playlist Test2 Passed");
        } else {
            out.println("add() other playlist Test2 Failed");
        }

        playlistA.clear();
        playlistB.clear();

        playlistA.add(0, "a");
        playlistA.add(1, "b");

        playlistB.add(0, "a");

        if (isSubPlaylist(playlistA, playlistB)) {
            out.println("isSubPlaylist() Test1 Passed");
        } else {
            out.println("is SubPlaylist() Test1 Failed");
        }

        playlistA.clear();
        playlistB.clear();

        playlistA.add(0, "a");
        playlistA.add(1, "b");

        playlistB.add(0, "c");

        if (!isSubPlaylist(playlistA, playlistB)) {
            out.println("isSubPlaylist() Test1 Passed");
        } else {
            out.println("is SubPlaylist() Test1 Failed");
        }

        playlistA.clear();
        playlistB.clear();
        testA.clear();
        testB.clear();

        out.close();
    }
}
