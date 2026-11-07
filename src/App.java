
import java.util.Scanner;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Halloween myHalloween = new Halloween();

        myHalloween.singSong();

         String[] gifts = {
            "hershey's bar",
            "cats",
            "bloody knives",
            "jolly ranchers",
            "kit kats",
            "hershey kisses",
            "skeletons holding brooms"
        };
        // initialize a Halloween object with these gifts
        Halloween myHalloween2 = new Halloween(gifts);
        // could also use the default constructor to make new ones

        // uncomment for bonus task below
       String s = new String("bat");
        String recursiveResult = replace(s, 0); // recursive
        String iterativeResult = replaceIterative(s);
        System.out.println(recursiveResult);
        System.out.println(iterativeResult);
    
    }

    // BONUS TASK: fix the bug!
    public static String replaceIterative(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + 1);
        }
        return new String(chars);
    }

    public static String replace(String s, int i) {
        if (i == s.length()) {
            return s; // all done!
        } else {
            char replaced = (char) (s.charAt(i) + 1);
            s = s.substring(0, i) + replaced + s.substring(i + 1);
            return replace(s, i + 1);
        }
    }
}
