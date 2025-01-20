import java.util.Scanner;

public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Advanced Calculator!");
        
        while (true) {
            System.out.println("Enter the operation (+, -, *, /, pow, log) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equals("exit")) {
                System.out.println("Exiting the calculator.");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            double num2 = 0;

            if (!operation.equals("log")) { // Logarithm only requires one number
                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();
            }

            double result;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                case "pow":
                    result = Math.pow(num1, num2);
                    break;
                case "log":
                    if (num1 <= 0) {
                        System.out.println("Error: Logarithm of non-positive number.");
                        continue;
                    }
                    result = Math.log(num1);
                    break;
                default:
                    System.out.println("Invalid operation. Please try again.");
                    continue;
            }

            System.out.printf("Result: %.2f\n", result);
        }

        scanner.close();
    }
}
