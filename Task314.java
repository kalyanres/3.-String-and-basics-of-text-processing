package by.epam.task3;
import java.util.Scanner;

public class Task314 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();

        // поиск количества чисел, разделенных с двух сторон пробелами
        int c = 0;
        int counter = 0;
        char[] ch = st.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if ((Character.isDigit(ch[i]) && i == 0)
            || (Character.isDigit(ch[i]) && Character.isWhitespace(ch[i - 1]))) {
                while (Character.isDigit(ch[i])) {
                    c++;
                    i++;
                }
                if (c != 0 && Character.isWhitespace(ch[i]))
                    counter++;
            }
        }
        System.out.println("counter = " + counter);
    }
}
