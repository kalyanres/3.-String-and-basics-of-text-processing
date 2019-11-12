package by.epam.task3;

public class Task3204 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter text: ");
        //String st = in.nextLine();
        String st = "информатика";

        // запоминаем в st1 "т"
        char[] ch = {st.charAt(7)};
        String st1 = new String(ch);

        // запоминаем в strb "ор"
        char[] ch1 = st.toCharArray();
        StringBuilder strb = new StringBuilder();
        strb = strb.append(ch1, 3, 2);

        // собираем слово
        StringBuilder stb = new StringBuilder(st1 + strb + st1);
        System.out.println(stb);
    }
}
