import java.util.Scanner;

public class NearestPrime {

    // Helper method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find the nearest prime number(s)
    public static void findNearestPrime(int n) {
        if (n <= 2) {
            System.out.println("The nearest prime number is: 2");
            return;
        }

        if (isPrime(n)) {
            System.out.println(n + " is already a prime number.");
            return;
        }

        int lower = n - 1;
        int upper = n + 1;

        while (true) {
            boolean lowerPrime = isPrime(lower);
            boolean upperPrime = isPrime(upper);

            if (lowerPrime && upperPrime) {
                System.out.println("Nearest prime numbers are: " + lower + " and " + upper);
                break;
            } else if (lowerPrime) {
                System.out.println("The nearest prime number is: " + lower);
                break;
            } else if (upperPrime) {
                System.out.println("The nearest prime number is: " + upper);
                break;
            }

            lower--;
            upper++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            findNearestPrime(num);
        } else {
            System.out.println("Invalid input! Please enter an integer.");
        }
        scanner.close();
    }
}
