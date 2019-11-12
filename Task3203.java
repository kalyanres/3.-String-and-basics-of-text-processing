package by.epam.task3;
import java.util.Scanner;

public class Task3203 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();
        boolean flag = false;

        for (int i = 0; i < st.length() / 2; i++) {
            if (st.charAt(i) != st.charAt(st.length() - 1 - i)){
                flag = false;
                break;
            }
            flag = true;
        }
        if (flag)
            System.out.println(st + " is a palindrome");
        else
            System.out.println(st + " isn't a palindrome");
    }
}
