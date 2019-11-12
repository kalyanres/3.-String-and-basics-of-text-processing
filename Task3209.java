package by.epam.task3;
import java.util.Scanner;

public class Task3209 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();
        //String st = "There is a notion that a lot of people working in the IT industry often copyright";

        int low = 0;
        int up = 0;
        char[] ch = st.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) {
                up++;
            }
            if (Character.isLowerCase(ch[i])) {
                low++;
            }
        }
        System.out.println("Upper case: " + up);
        System.out.println("Lower case: " + low);
    }
}
