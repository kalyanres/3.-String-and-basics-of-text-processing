package by.epam.task3;

/*
 *    2. Дана строка, содержащая следующий текст (xml-документ):
<notes>
  <note id = "1">
    <to>Вася</to>
    <from>Света</from>
    <heading>Напоминание</heading>
    <body>Позвони мне завтра!</body>
  </note>
  <note id = "2">
    <to>Петя</to>
    <from>Маша</from>
    <heading>Важное напоминание</heading>
    <body/>
  </note>
</notes>
    Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
нельзя.
  *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task332 {
  public static void main(String[] args) {
    String string = "<notes>" +
            "  <note id = \"1\">" +
            "    <to>Вася</to>" +
            "    <from>Света</from>" +
            "    <heading>Напоминание</heading>" +
            "    <body>Позвони мне завтра!</body>" +
            "  </note>" +
            "  <note id = \"2\">" +
            "    <to>Петя</to>" +
            "    <from>Маша</from>" +
            "    <heading>Важное напоминание</heading>" +
            "    <body/>" +
            "  </note>" +
            "</notes>";


    String indexHead = "(?<=<[nN][oO][tT][eE][sS]>).*(?=</[nN][oO][tT][eE][sS]>)";
    String indexTo = "(?<=<to>).*(?=</to>)";
    String indexFrom = "(?<=<from>).*(?=</from>)";
    String indexBody = "(?<=<body>).*(?=</body>)";
    String indexHeading = "(?<=<heading>).*(?=</heading>)";
    String indexID = "(?<=<[nN][oO][tT][eE] [iI][dD] = \"\\d\">).+?(?=</[nN][oO][tT][eE]>)";
    Pattern pattern = Pattern.compile(indexHead);
    Matcher matcher = pattern.matcher(string);

    String[] buffer1 = new String[2];

    if (matcher.find()) {
      System.out.println("Приложение заметки открыто: \n");

      String buffer = matcher.group();
      pattern = Pattern.compile(indexID);
      matcher = pattern.matcher(buffer);
      int j = 0;
      while (matcher.find()) {
        buffer1[j] = matcher.group();
        j++;
      }
      for (int i = 0; i < j; i++) {
        System.out.println("  Заметка №" + (i + 1) + ":");
        pattern = Pattern.compile(indexTo);
        matcher = pattern.matcher(buffer1[i]);
        if (matcher.find()) {
          System.out.println("  Кому: " + matcher.group());
        }
        pattern = Pattern.compile(indexFrom);
        matcher = pattern.matcher(buffer1[i]);
        if (matcher.find()) {
          System.out.println("  От кого: " + matcher.group());
        }
        pattern = Pattern.compile(indexHeading);
        matcher = pattern.matcher(buffer1[i]);
        if (matcher.find()) {
          System.out.println("    Название: " + matcher.group());
        }
        pattern = Pattern.compile(indexBody);
        matcher = pattern.matcher(buffer1[i]);
        if (matcher.find()) {
          System.out.println("    Текст: " + matcher.group());
        }
        System.out.println();
      }


    }
  }
}
