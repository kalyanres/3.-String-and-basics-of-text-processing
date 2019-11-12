package by.epam.task3;
import java.util.Scanner;

public class Task3205 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();

        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == 'a') {
                count++;
            }
        }
        System.out.println("letter \"a\" was met " + count + " times");
    }
}
