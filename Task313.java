package by.epam.task3;
import java.util.Scanner;

public class Task313 {
    public static void main(String[] args) {
        // переменная, для подсчета вхождения искомых слов
        int count = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();

        int c = 0;
        char[] ch = st.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i]))
                c++;
        }
        System.out.println("count = " + c);
    }
}
