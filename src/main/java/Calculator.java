import java.util.Locale;
import java.util.Scanner;

class Calculator {

    static Scanner scanner = new Scanner(System.in);

    public static void request() {
        System.out.println("Do you need calculator? If Yes enter Y or calculator will be close");
        String ask = scanner.next();
        if (ask.toLowerCase(Locale.ROOT).equals("y")) {
            System.out.println(calculate(setFirstNumber(), setSecondNumber(), setOperation()));
            request();
        }
    }

    public static int setFirstNumber() {
        System.out.print("Enter first Number: ");
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        }
        else {
            System.out.print("Try again. ");
            scanner.next();
            number = setFirstNumber();
        }
        return number;
    }

    public static int setSecondNumber() {
        System.out.print("Enter second Number: ");
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            return number;
        } else {
            System.out.print("Try again. ");
            scanner.next();
            number = setSecondNumber();
        }
        return number;
    }

    public static char setOperation() {
        System.out.print("Enter operation (+,-,*,/) : ");
        char operation = 'n';
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.print("Error.Try again ");
            setOperation();
        }
        return operation;
    }

    public static double calculate(int firstNumber, int secondNumber, char operation) {
        double computation;
        switch (operation) {
            case '+':
                computation = firstNumber + secondNumber;
                break;
            case '-':
                computation = firstNumber - secondNumber;
                break;
            case '*':
                computation = firstNumber * secondNumber;
                break;
            case '/':
                computation = firstNumber / secondNumber;
                System.out.println("division without remainder");
                break;
            default:
                System.out.print("Error. ");
                computation = calculate(firstNumber, secondNumber, setOperation());

        }

        return computation;
    }
}