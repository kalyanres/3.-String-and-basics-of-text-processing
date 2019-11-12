package by.epam.task3;

public class Task3201 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter text: ");
        String st = "In the  last    article, we     saw   how"; //in.nextLine();
        System.out.println(st);
        int max = 0;
        int count = 0;

        for (int i = 0; i < st.length(); i++) {
            while (st.charAt(i) == ' '){
                count++;
                i++;
            }
            if (max < count) {
                max = count;
            }
            count = 0;
        }
        System.out.println("max = " + max);
    }
}
