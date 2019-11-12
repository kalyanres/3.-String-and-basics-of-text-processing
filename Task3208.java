package by.epam.task3;
import java.util.Scanner;

public class Task3208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();
        //String st = "There is a notion that a lot of people working in the IT industry often copyright";
        int max = 0;
        int index = 0;
        int max_begin = 0;

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == ' ' || st.charAt(i) == '\n') {
                if (max < (i - index)) {
                    max = i - index;
                    max_begin = index;
                }
                i++;
                index = i;

            }
        }
        // Если самое большое слово окажется последним
        if (max < st.length() - 1 - index) {
            max = st.length() - 1 - index;
            max_begin = index;
        }

        // Выделяем самое большое слово из предложения
        char[] ch = st.toCharArray();
        StringBuilder stb = new StringBuilder();
        stb = stb.append(ch, max_begin, max);
        System.out.println(stb);
    }
}
