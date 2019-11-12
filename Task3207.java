package by.epam.task3;
import java.util.Scanner;

public class Task3207 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();

        StringBuilder stb = new StringBuilder(st);
        for (int i = 0; i < stb.length(); i++) {
            if (stb.charAt(i) == ' ') {
                stb.deleteCharAt(i);
                i--;
                continue;
            }
            for (int j = i + 1; j < stb.length(); j++) {
                if (stb.charAt(i) == stb.charAt(j)) {
                    stb.deleteCharAt(j);
                }
            }
        }

        System.out.println(stb);
    }
}
