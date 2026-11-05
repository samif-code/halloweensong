
import java.util.Scanner;
import java.util.Random;

public class App {

    public static void main(String[] args){
        Halloween myHalloween = new Halloween();

        myHalloween.singSong();
        //String[] gifts = {
                //"hershey's bar",
                //"cats",
                //"bloody knives",
               // "jolly ranchers",
                //"kit kats",
                //"hershey kisses",
                //"skeletons holding brooms"
        };
        // initialize a Halloween object with these gifts
        // could also use the default constructor to make new ones

        // // uncomment for bonus task below
        // String s = "new string";
        // String m = replace(s, 0); // recursive
        // // String m = replaceIterative(s);
        // System.out.println(m);

    

    // BONUS TASK: fix the bug!
    // iterative - with a bug
    public static String replaceIterative(String s) {
        for (int i = 0; i < s.length(); i++) {
            char replaced = s.charAt(i);
            System.out.println("[debug] you are on iteration " + i);
            replaced += 1; // encode a string, shift it 1 char
            s = s.substring(0, i) + replaced + s.substring(i, s.length());
        }
        return s;
    }

    // recursive - with a bug
    public static String replace(String s, int i) {
        if (i == s.length()) {
            return s; // all done!
        } else {
            char replaced = s.charAt(i);
            replaced += 1;
            s = s.substring(0, i) + replaced + s.substring(i, s.length());
            return replace(s, i + 1);
        }
    }
}
