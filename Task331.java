package by.epam.task3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task331 {
    public static void main(String[] args) {
        String st = "One of the important features in any programming language is the use of names. When you" +
                "create an object, you give a name to a region of storage. A method is a name for an action." +
                "You refer to all objects and methods by using names. Well-chosen names create a system that" +
                "is easier for people to understand and change. It’s a lot like writing prose—the goal is to" +
                "communicate with your readers.\n" +
                "A problem arises when mapping the concept of nuance in human language onto a" +
                "programming language. Often, the same word expresses a number of different meanings—it’s" +
                "overloaded. This is useful, especially when it comes to trivial differences. You say, “Wash the" +
                "shirt,” “Wash the car,” and “Wash the dog.” It would be silly to be forced to say, “shirtWash" +
                "the shirt,” “carWash the car,” and “dogWash the dog” just so the listener doesn’t need to" +
                "make any distinction about the action performed. Most human languages are redundant, so" +
                "even if you miss a few words, you can still determine the meaning. You don’t need unique" +
                "identifiers—you can deduce meaning from context.\n" +
                "Most programming languages (C in particular) require you to have a unique identifier for" +
                "each method (often called functions in those languages). So you could not have one function" +
                "called print( ) for printing integers and another called print( ) for printing floats—each" +
                "function requires a unique name.\n" +
                "In Java (and C++), another factor forces the overloading of method names: the constructor." +
                "Because the constructor’s name is predetermined by the name of the class, there can be only" +
                "one constructor name. But what if you want to create an object in more than one way? For" +
                "example, suppose you build a class that can initialize itself in a standard way or by reading" +
                "information from a file. You need two constructors, the default constructor and one that" +
                "takes a String as an argument, which is the name of the file from which to initialize the" +
                "object. Both are constructors, so they must have the same name—the name of the class. Thus," +
                "method overloading is essential to allow the same method name to be used with different" +
                "argument types. And although method overloading is a must for constructors, it’s a general" +
                "convenience and can be used with any method.\n";
        // создаем новую строку с сортировкой по абзацам
        //String ss = sortParagraph(st);
        //System.out.println(ss);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter symbol for sorting: ");
        char symbol = in.next().charAt(0);

        String[] s1 = splitText(st);
        System.out.println("length s1 = " + s1.length);
        String[] s2 = splitSentence(s1[0]);
        System.out.println("length s2 = " + s2.length);
        String[] s3 = splitWord(s2[2]);
        System.out.println("length s3 = " + s3.length);
        s3 = sortShellChar(s3, symbol);
        for (int i = 0; i < s3.length; i++) {
            System.out.print(s3[i] + " ");
        }
        System.out.println();

    }

    // метод разбивки абзацев по признаку переноса строки
    public static String[] splitText(String str){
        String index = "\r?\n";
        Pattern patt= Pattern.compile(index);
        Matcher m = patt.matcher(str);

        CharSequence ch_sec = str.subSequence(0, str.length());
        String[] str_par = patt.split(ch_sec);
        return str_par;
    }

    // метод разбивки абзацев на предложения
    public static String[] splitSentence(String str) {
        String index = "[.!?]";
        Pattern patt= Pattern.compile(index);
        Matcher m = patt.matcher(str);

        CharSequence ch_sec = str.subSequence(0, str.length());
        String[] str_par = patt.split(ch_sec);

        return str_par;
    }

    // метод сортировки абзацев по количеству предложений
    public static String sortParagraph(String str) {
        String index1 = "[.!?]";
        Pattern patt1= Pattern.compile(index1);
        Matcher m1 = patt1.matcher(str);
        int j = 0;
        int temp_int = 0;
        String temp_str = new String();

        // разбиваем строку на массив абзацев по признаку переноса строки
        String[] str_par = splitText(str);

        // массив для подсчета количества предложений в каждом абзаце
        int[] count_sentence = new int[str_par.length];

        // подсчитываем количество предложений в каждом абзаце
        int count = 0;
        for (int i = 0; i < str_par.length; i++) {
            Matcher mi = patt1.matcher(str_par[i]);
            while (mi.find()) {
                count++;
            }
            count_sentence[i] = count;
            count = 0;
        }

        // сортируем массив count_sentence[] вместе с массивом str_par
        // реализация сортировки Шелла
        while (j < count_sentence.length - 1) {
            if (count_sentence[j] > count_sentence[j + 1]) {
                temp_int = count_sentence[j];
                temp_str = str_par[j];
                count_sentence[j] = count_sentence[j + 1];
                str_par[j] = str_par[j + 1];
                count_sentence[j + 1] = temp_int;
                str_par[j + 1] = temp_str;
                if (j > 0)
                    j--;
                else
                    j++;
            }
            else
                j++;
        }

        // сортируем слова в предложениях
        for (int i = 0; i < str_par.length; i++) {
            str_par[i] = sortSentence(str_par[i]);
        }

        // склеиваем
        str = new String();
        for (int i = 0; i < str_par.length; i++) {
            str += str_par[i] + "\n";
        }

        return str;
    }

    // метод разбивки предложения на массив слов
    public static String[] splitWord(String str) {
        String index = "[\\p{Punct}\\p{Space}]*[\\p{Punct}\\p{Space}]";
        Pattern patt= Pattern.compile(index);
        Matcher m1 = patt.matcher(str);

        // разбиваем строку на массив отдельных слов по признаку пробела или знака препинания
        CharSequence ch_sec = str.subSequence(0, str.length());
        String[] str_par = patt.split(ch_sec);

        return str_par;
    }

    // метод сортировки слов в предложениях по длине
    public static String sortSentence(String str) {
        // разбиваем строку на массив отдельных слов по признаку пробела или знака препинания
        String[] str_par = splitWord(str);

        // сортируем слова
        str_par = sortShellLength(str_par);

        // склеиваем
        str = new String();
        for (int i = 0; i < str_par.length; i++) {
            str += str_par[i] + " ";
            // в конце ставим точку
            if (i == str_par.length - 1)
                str += ".";
        }

        return str;
    }

    // метод сортировки Шелла слов по длине слов по возрастанию
    public static String[] sortShellLength(String[] str_par) {
        int j = 0;
        String temp_str = new String();
        while (j < str_par.length - 1) {
            if (str_par[j].length() > str_par[j + 1].length()) {
                temp_str = str_par[j];
                str_par[j] = str_par[j + 1];
                str_par[j + 1] = temp_str;
                if (j > 0)
                    j--;
                else
                    j++;
            } else if (str_par[j].length() == str_par[j + 1].length()) {
                if (str_par[j].charAt(0) > str_par[j + 1].charAt(0)) {
                    temp_str = str_par[j];
                    str_par[j] = str_par[j + 1];
                    str_par[j + 1] = temp_str;
                    if (j > 0)
                        j--;
                    else
                        j++;
                } else {
                    j++;
                }
            } else
                j++;
        }
        return str_par;
    }

    // метод сортировки Шелла слов по количеству вхождений символа и алфавиту
    public static String[] sortShellChar(String[] str_par, char ch) {
        // массив количества вхождений
        int[] count_char = new int[str_par.length];
        int count = 0;

        // считаем количество вхождений ch в каждое слово массива str_par
        for (int i = 0; i < str_par.length; i++) {
            for (int j = 0; j < str_par[i].length(); j++) {
                if (str_par[i].charAt(j) == ch ||
                    str_par[i].charAt(j) == (char)(ch - 32))
                    count++;
            }
            count_char[i] = count;
            count = 0;
        }

        // сортируем массив count_char одновременно с str_par сортировкой Шелла
        int j = 0;
        int temp = 0;
        String temp_str = new String();

        while (j < str_par.length - 1) {
            if (count_char[j] > count_char[j + 1]) {
                temp = count_char[j];
                temp_str = str_par[j];

                count_char[j] = count_char[j + 1];
                str_par[j] = str_par[j + 1];

                count_char[j + 1] = temp;
                str_par[j + 1] = temp_str;
                if (j > 0)
                    j--;
                else
                    j++;
                // если равны, то сортировка по алфавиту
            } else if (count_char[j] == count_char[j + 1]) {
                if (str_par[j].charAt(0) > str_par[j + 1].charAt(0)) {
                    temp = count_char[j];
                    temp_str = str_par[j];

                    count_char[j] = count_char[j + 1];
                    str_par[j] = str_par[j + 1];

                    count_char[j + 1] = temp;
                    str_par[j + 1] = temp_str;
                    if (j > 0)
                        j--;
                    else
                        j++;
                } else if (str_par[j].charAt(0) == str_par[j + 1].charAt(0)) {
                    if (str_par[j].charAt(1) > str_par[j + 1].charAt(1)) {
                        temp = count_char[j];
                        temp_str = str_par[j];

                        count_char[j] = count_char[j + 1];
                        str_par[j] = str_par[j + 1];

                        count_char[j + 1] = temp;
                        str_par[j + 1] = temp_str;
                        if (j > 0)
                            j--;
                        else
                            j++;
                    } else {
                        j++;
                    }
                } else {
                    j++;
                }
            } else
                j++;
        }
        return str_par;
    }
}
