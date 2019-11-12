package by.epam.task3;
import java.util.Scanner;

public class Task315 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter text: ");
        String st = "In the  last    article, we   saw   how"; //in.nextLine();
        System.out.println(st);

        // переменная подсчета лишних пробелов
        int c = 0;
        char[] ch = st.toCharArray();
        // поиск количества лишних пробелов
        for (int i = 0; i < ch.length; i++) {
            if (Character.isWhitespace(ch[i])) {
                // считаем количетсво пробелов
                while (Character.isWhitespace(ch[i])) {
                    c++;
                    i++;
                }
                // оставляем один пробел
                c--;
            }
        }
        System.out.println("counter = " + c);
        // создаем новый массив с учетом лишних пробелов
        int size = ch.length - c;
        char[] ch_new = new char[size];
        // переменная смещения для игнорирования лишних пробелов
        c = 0;
        for (int i = 0; i < size; i++) {
            if (Character.isWhitespace(ch[i + c])) {
                while (Character.isWhitespace(ch[i + c])) {
                    c++;
                }
                c--;
            }
            ch_new[i] = ch[i + c];
        }
        st = new String(ch_new);
        System.out.println(st);
    }
}
