import java.util.Scanner;

public class Main {
    private static int a, b;

    public static void main(String[] args) {
        Scanner str = new Scanner((System.in));
        String inputString = str.nextLine();
        try {
            System.out.println(Output(ParserInputString(inputString)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[] ParserInputString(String inputString) {
        String[] parts = inputString.split(" ");

        if (parts.length > 3) throw new IllegalArgumentException("Two operands and one operator (+, -, /, *)");
        else if (parts.length < 3) throw new IllegalArgumentException("A string is not a mathematical operation");

        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }

        if ((a < 1 || a > 10) || (b < 1 || b > 10))
            throw new IllegalArgumentException("The numbers is less than 1 or more than 10");

        return parts;
    }

    private static int Output(String[] parts) {
        switch (parts[1]) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) throw new IllegalArgumentException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}