package by.epam.task3;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3210 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter text: ");
        //String st = in.nextLine();
        String st = "There is a notion that a lot of people working in the IT industry often copyright." +
                "To access these controls, verify the cockpit-network manager and cockpit-firewall packages" +
                " are installed! To start, log into the Cockpit UI and select the Networking menu option?";
        int counter = 0;
        //System.out.println(st);

        String index = "[.!?]";
        Pattern pattern = Pattern.compile(index);
        Matcher m = pattern.matcher(st);

        while (m.find()) {
            counter++;
        }
/*
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '.' || st.charAt(i) == '!' || st.charAt(i) == '?') {
                counter++;
            }
        }

 */
        System.out.println("The number of sentences is " + counter);
    }
}
