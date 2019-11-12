package by.epam.task3;
import java.util.Scanner;

public class Task312 {
    public static void main(String[] args) {
        // переменная, для подсчета вхождения искомых слов
        int count = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();
        String st1 = "word";
        String st2 = "letter";

        // переводим строки в массивы char[]
        char[] ch = st.toCharArray();
        char[] ch1 = st1.toCharArray();
        char[] ch2 = st2.toCharArray();

        // определяем количество слов, которые нужно заменить
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ch1[0]) {
                for (int k = 0; k < ch1.length; k++) {
                    if (ch[i + k] != ch1[k]) {
                        break;
                    }
                    if (k == ch1.length - 1) {
                        count++;
                        i += ch1.length;
                    }
                }
            }
        }
        int j = 0;
        // создаем массив номеров начала слов, которые необходимо заменить
        int[] entry = new int[count + 1];
        count = 0;
        // снова проверяем на необходимые слова и заносим их координаты в entry[]
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ch1[0]) {
                for (int k = 0; k < ch1.length; k++) {
                    if (ch[i + k] != ch1[k]) {
                        break;
                    }
                    if (k == ch1.length - 1) {
                        count++;
                        entry[j] = i;
                        j++;
                        i += ch1.length;
                    }
                }
            }
        }
        j = 0;
        // если искомые слова присутствуют в тексте
        if (count != 0) {
            // создаем новый массив с размером, учитывающим размер новых слов
            int size = ch.length + count * (ch2.length - ch1.length);
            char[] ch_new = new char[size];
            // производим копирование в новый массив с одновременной заменой
            for (int i = 0; i < size; i++) {
                if (i == entry[j] + j * (ch2.length - ch1.length)) {
                    for (int k = 0; k < ch2.length; k++) {
                        ch_new[i + k] = ch2[k];
                    }
                    j++;
                    i += ch2.length;
                }
                ch_new[i] = ch[i - j * (ch2.length - ch1.length)];
            }
            // записываем новый массив в строку
            st = new String(ch_new);
        }
        System.out.println(st);
    }
}
