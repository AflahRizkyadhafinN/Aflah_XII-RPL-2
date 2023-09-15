import java.util.Scanner;

public class App {
    private static void Kalkultor() {
        Scanner scanner = new Scanner(System.in);
        App obj = new App();

        System.out.print("1 : ");
        float number1 = scanner.nextFloat();
        System.out.print("Op : ");
        String operator = scanner.next();
        System.out.print("3u : ");
        float number2 = scanner.nextFloat();
        float result;

        if (operator.equals("+")) {
            result = number1 + number2;
            System.out.println("Hasil dari " + number1 + " " + operator + " " + number2 + " = " + result);
        } else if (operator.equals("-")) {
            result = number1 - number2;
            System.out.println("Hasil dari " + number1 + " " + operator + " " + number2 + " = " + result);
        } else if (operator.equals("*")) {
            result = number1 * number2;
            System.out.println("Hasil dari " + number1 + " " + operator + " " + number2 + " = " + result);
        } else if (operator.equals("/")) {
            result = number1 / number2;
            System.out.println("Hasil dari " + number1 + " " + operator + " " + number2 + " = " + result);
        } else {
            System.out.println("Operator yang diinput salah");
        }
        obj.Lanjut();
    }

    private static void Lanjut() {
        App obj = new App();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gunakan kembali? ");
        System.out.println("1. Yes ");
        System.out.println("2. No ");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            obj.Kalkultor();
        } else {
            System.out.println("Terima kasih sudah menggunakan :D");
        }
    }

    public static void main(String[] args) throws Exception {
        App obj = new App();

        System.out.println("Selamat Datang di Kalkulator Sederhana >_<");
        obj.Kalkultor();
    }

}