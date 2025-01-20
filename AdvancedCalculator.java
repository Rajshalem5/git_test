public class AdvancedCalculator {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide an operation as the first argument.");
            return;
        }

        String operation = args[0];
        double num1, num2;

        // Check if the operation is 'exit'
        if (operation.equals("exit")) {
            System.out.println("Exiting the calculator.");
            return;
        }

        // Validate and parse first number
        if (args.length < 2) {
            System.out.println("Please provide the first number.");
            return;
        }
        try {
            num1 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid first number: " + args[1]);
            return;
        }

        // For operations other than 'log', we need a second number
        if (!operation.equals("log")) {
            if (args.length < 3) {
                System.out.println("Please provide the second number.");
                return;
            }
            try {
                num2 = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid second number: " + args[2]);
                return;
            }
        } else {
            num2 = 0; // Not used for log
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
                    return;
                }
                result = num1 / num2;
                break;
            case "pow":
                result = Math.pow(num1, num2);
                break;
            case "log":
                if (num1 <= 0) {
                    System.out.println("Error: Logarithm of non-positive number.");
                    return;
                }
                result = Math.log(num1);
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
                return;
        }

        System.out.printf("Result: %.2f\n", result);
    }
}
