import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'calculate' to finish):");

        while (true) {
            String input = sc.next();

            if (input.equalsIgnoreCase("calculate")) {
                break;
            }

            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + input + " — Skipped!");
            }
        }

        try {
            if (numbers.isEmpty()) {
                throw new ArithmeticException("Error: List is empty! Cannot calculate average.");
            }

            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }

            double average = (double) sum / numbers.size();
            System.out.println("Average: " + average);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
