//11. Convert the programs in flow of program, first java, conditionals & loops assignments into functions.
import java.util.Scanner;

public class Main {

    static void greet() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        greet();
    }
}

//12. Write a function to check if a given triplet is a Pythagorean triplet or not. (A Pythagorean triplet is when the sum of the square of two numbers is equal to the square of the third number).
import java.util.Scanner;

public class Main {

    static boolean isPythagoreanTriplet(int a, int b, int c) {
        return (a * a + b * b == c * c) ||
               (a * a + c * c == b * b) ||
               (b * b + c * c == a * a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (isPythagoreanTriplet(a, b, c)) {
            System.out.println("Pythagorean Triplet");
        } else {
            System.out.println("Not a Pythagorean Triplet");
        }

        sc.close();
    }
}
//13. Write a function that returns all prime numbers between two given numbers.
import java.util.Scanner;

public class Main {

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    static void printPrimes(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        printPrimes(start, end);

        sc.close();
    }
}
//14. Write a function that returns the sum of first n natural numbers.
import java.util.Scanner;

public class Main {

    static int sumNatural(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sumNatural(n));

        sc.close();
    }
}
