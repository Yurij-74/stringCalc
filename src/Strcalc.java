import java.util.Scanner;

public class Strcalc {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String vvod = scn.nextLine();
        char peremennaya;
        String[] stroka;
        if (vvod.contains(" + ")) {
            stroka = vvod.split(" \\+ ");
            peremennaya = '+';
        } else if (vvod.contains(" - ")) {
            stroka = vvod.split(" - ");
            peremennaya = '-';
        } else if (vvod.contains(" * ")) {
            stroka = vvod.split(" \\* ");
            peremennaya = '*';
        } else if (vvod.contains(" / ")) {
            stroka = vvod.split(" / ");
            peremennaya = '/';
        }else{
            throw new Exception("Некорректный знак действия");
        }
        if (peremennaya == '*' || peremennaya == '/') {
            if (stroka[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < stroka.length; i++) {
            stroka[i] = stroka[i].replace("\"", "");
        }

        if (peremennaya == '+') {
            printInQuotes(stroka[0] + stroka[1]);
        } else if (peremennaya == '*') {
            int multiplier = Integer.parseInt(stroka[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result+=stroka[0];
            }
            printInQuotes(result);
        } else if (peremennaya == '-') {
            int index = stroka[0].indexOf(stroka[1]);
            if(index == -1){
                printInQuotes(stroka[0]);
            }else{
                String result = stroka[0].substring(0, index);
                result+=stroka[0].substring(index+stroka[1].length());
                printInQuotes(result);
            }
        }else{
            int newLenth = stroka[0].length()/Integer.parseInt(stroka[1]);
            String result = stroka[0].substring(0,newLenth);
            printInQuotes(result);
        }


    }
    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }
}