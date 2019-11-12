package by.epam.task3;

public class Task3202 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter text: ");
        String st = "In the  last    article, we     saw   how"; //in.nextLine();
        System.out.println(st);

        StringBuilder stb = new StringBuilder(st);
        for (int i = 0; i < stb.length(); i++) {
            if (stb.charAt(i) == 'a')
                stb = stb.insert(i + 1, "b");
        }
        System.out.println(stb);
    }
}
