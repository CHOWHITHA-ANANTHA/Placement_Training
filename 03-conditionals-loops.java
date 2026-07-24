//21. Fibonacci Series In Java Programs
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 0;
        int b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }

        sc.close();
    }
}



//22. Subtract the Product and Sum of Digits of an Integer
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        int product = 1;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        System.out.println(product - sum);

        sc.close();
    }
}


//23. Input a number and print all the factors of that number (use loops).
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }
}


//24. Take integer inputs till the user enters 0 and print the sum of all numbers (HINT: while loop)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            sum += n;
        }

        System.out.println(sum);

        sc.close();
    }
}



//25. Take integer inputs till the user enters 0 and print the largest number from all.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int largest = Integer.MIN_VALUE;

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            if (n > largest) {
                largest = n;
            }
        }

        System.out.println(largest);

        sc.close();
    }
}
