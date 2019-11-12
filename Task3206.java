package by.epam.task3;
import java.util.Scanner;

public class Task3206 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String st = in.nextLine();

        StringBuilder stb = new StringBuilder(st);
        for (int i = 0; i < stb.length(); i+=2) {
            stb = stb.insert(i+1, stb.charAt(i));
        }
        System.out.println(stb);
    }
}
