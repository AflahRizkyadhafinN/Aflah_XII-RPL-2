import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);
        System.out.print("Masukan nilai celcius : ");

        float celcius = inputData.nextFloat();
        float reamur = celcius * 4 / 5;
        float fahrenheit = celcius * 9 / 5 + 32;
        float kelvin = celcius + 273;

        System.out.println("Reamur : " + String.valueOf(reamur));
        System.out.println("Fahrenheit : " + String.valueOf(fahrenheit));
        System.out.println("Kelvin : " + String.valueOf(kelvin));
    }
}