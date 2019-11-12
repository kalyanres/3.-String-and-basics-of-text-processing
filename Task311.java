package by.epam.task3;

public class Task311 {
    public static void main(String[] args) {
        int count = 0;
        // создаем массив в виде camelCase
        String[] camelCase = {"arrayMass", "callArray", "stringHyper"};
        for (int i = 0; i < camelCase.length; i++){
            System.out.println(camelCase[i]);
            // побуквенно проверяем каждый символ строки на заглавную букву
            // и считаем их количество
            for (int j = 0; j < camelCase[i].length(); j++){
                if (Character.isUpperCase(camelCase[i].charAt(j))){
                    count++;
                }
            }
            // создаем новый массив char с размером size, который больше предыдущей
            // строки на количество заглавных букв, т.к. каждый символ заглавной буквы меняется на
            // два символа (символ "_" и соответствующая строчная буква)
            int size = camelCase[i].length() + count;
            count = 0;
            char[] new_word = new char[size];
            // копируем строку в новый массив, с заменой заглавной буквы и с учетом соответствующий смещений
            for (int j = 0; j < size; j++){
                if (Character.isUpperCase(camelCase[i].charAt(j - count))){
                    new_word[j] = '_';
                    j++;
                    count++;
                    new_word[j] = (char)((int)(camelCase[i].charAt(j - count) + 32));
                    continue;
                }        
                new_word[j] = camelCase[i].charAt(j - count);
            }
            // заменяем старое слово на новое  и печатаем
            camelCase[i] = new String(new_word);
            System.out.println(camelCase[i]);
            count = 0;
        }
    }
}
