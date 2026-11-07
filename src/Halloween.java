import java.io.IOException;
import java.util.Scanner;

public class Halloween {
    int days;
    String[] gifts; 
    static Scanner sc = new Scanner(System.in);

    Halloween(String[] gifts) {
        days = gifts.length;
        this.gifts = gifts;
    }

    Halloween() {
        System.out.println("How many days of halloween are you celebrating?");
        days = getUserInt();
        sc.nextLine(); // skip enter
        gifts = new String[days];
        for (int d = 0; d < days; d++) {
            System.out.println(
                    "You get a gift on day " + (d + 1) + " of Halloween. You get " + (d + 1)
                            + " of this gift. What shall it be?");
            String s = sc.nextLine();
            gifts[d] = s;
            System.out.println("Thank you!");
        }
        sc.close();
    }

    /*
     * TASK: How do would you call this recursively and loop until the user
     * finally puts an integer in?
     * Hint: use hasNextInt() to check if what is typed next is an integer. 
     * Another hint: if sc.hasNextInt() is false, 
     * you need to call sc.next() to throw out the non-integer the user typed. 
     */
   
    public static int getUserInt() {
        while (!sc.hasNextInt()) {
            if (sc.hasNext()) {
                int i = sc.nextInt();
                if (i > 0 ) {
                    return i;
                } else {
                    System.out.println("Please enter a positive integer.");
                    return getUserInt();
                }
            }
            System.out.println("Please enter a valid integer.");
            sc.next(); // discard the invalid input
        }
        return sc.nextInt();
    }

    public int getDays() {
        return days;
    }

    public String[] getGifts() {
        return gifts;
    }

    public void singSong() {
        System.out.println("OK! I've made you a song to celebrate halloween!");

        System.out.println("On day 1 of halloween my true love gave to me: ");
        System.out.println("a " + gifts[0] + "!");
        for (int d = 1; d < days; d++) {
            System.out.println("On day " + (d +1) + " of halloween my true love gave to me:");
            // iterative solution
            // System.out.println(gifts[d] + ",");
            // for (int e = d - 1; e >= 0; e--) {
            //     if (e == 0) {
            //         System.out.println("and a " + gifts[e] + "!");
            //     } else {
            //         System.out.println(gifts[e] + ",");
            //         // System.out.println(e++);
            //     }
            // }

            // recursive solution
            printDay(gifts, d-1);
        }
    }

    public void printDay(String[] gifts, int day) {
        if (day == 0) {
            // we are done!
            System.out.println("and a " + gifts[0] + "!");
        } else {
            System.out.println(gifts[day] + ",");
            printDay(gifts, day - 1);
        }
    
    }

    // invoke the 'say' command on Mac (sorry windows users)
    // you can use this method to make your program speak the song
    public void speak(String text) {
        try { 
            ProcessBuilder processBuilder = new ProcessBuilder("say", text);
            processBuilder.inheritIO();
            processBuilder.start();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
}
}